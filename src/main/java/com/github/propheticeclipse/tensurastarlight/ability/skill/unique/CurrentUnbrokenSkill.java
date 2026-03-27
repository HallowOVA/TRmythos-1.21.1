package com.github.propheticeclipse.tensurastarlight.ability.skill.unique;

import com.github.propheticeclipse.tensurastarlight.config.skills.aspectSeriesSkillConfig;
import com.github.propheticeclipse.tensurastarlight.registry.skills.StarlightUniqueSkills;
import io.github.manasmods.manascore.config.ConfigRegistry;
import io.github.manasmods.manascore.network.api.util.Changeable;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.tensura.ability.SkillUtils;
import io.github.manasmods.tensura.ability.skill.Skill;
import io.github.manasmods.tensura.damage.TensuraDamageHelper;
import io.github.manasmods.tensura.registry.attribute.TensuraAttributes;
import io.github.manasmods.tensura.storage.TensuraStorages;
import io.github.manasmods.tensura.storage.ep.IExistence;
import io.github.manasmods.tensura.util.AttributeHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;

public class CurrentUnbrokenSkill extends Skill {
    protected static final ResourceLocation CURRENT_UNBROKEN;
    private static final aspectSeriesSkillConfig.CurrentUnbroken CONFIG;
    public CurrentUnbrokenSkill() {
        super(Skill.SkillType.UNIQUE);
    }
    /*Current Unbroken
Unique
“Concentrate your potential upon stillness, for only energy that does not act may never be undone.”
Acquisition Conditions:
Have Ember Remains or Shape Forgotten
Obtain a Nether Star
75k MP, or Reincarnation

Passives

[Passive - True] While not moving, Improve MP regen by 25 (50 Mastered) MP/s. Additionally, improve Magic damage by 1.25x (Stacking). Every 5s gain mastery.

[Passive - True] Magicule consumption is reduced by 5%.

[Passive - Toggle] Resist 20% of magical damage, up to 100 (500 Mastered) points of damage. Damage resisted/negated through this directed into Barrier Points.*/

    @Override
    public boolean checkAcquiringRequirement(Player entity, double newEP) {
        boolean emberRemains = SkillUtils.hasSkillFully(entity, StarlightUniqueSkills.EMBER_REMAINS.get());
        int netherStar = 0;
        if (entity instanceof ServerPlayer serverPlayer) {
            netherStar = serverPlayer.getStats().getValue(Stats.ITEM_PICKED_UP.get(Items.NETHER_STAR));
        } else {
            netherStar = 0;
        }
        return netherStar >= CONFIG.netherStars && emberRemains;
    }

    @Override
    public double getAcquiringMagiculeCost(ManasSkillInstance instance) {
        return CONFIG.magiculeAcquirementCost;
    }

    public int getAcquirementMastery(LivingEntity entity) {
        return CONFIG.acquirementMastery;
    }

    public boolean canBeToggled(ManasSkillInstance instance, LivingEntity entity) {
        return true;
    }

    public boolean canTick(ManasSkillInstance instance, LivingEntity entity) {
        return true;
    }

    public boolean onDamageEntity(ManasSkillInstance instance, LivingEntity owner, LivingEntity target, DamageSource source, Changeable<Float> amount) {
        //Additionally, improve Magic damage by 1.25x (Stacking).
        float originalDamageNum = amount.get();
        if (TensuraDamageHelper.isTensuraMagic(source)) {
            double damageModifier = CONFIG.tensuraMagicDamageModifier;
            amount.set((float) (originalDamageNum * damageModifier));
        }

        return true;
    }

    @Override
    public boolean onTakenDamage(ManasSkillInstance instance, LivingEntity owner, DamageSource source, Changeable<Float> amount) {
        // [Passive - Toggle] Resist 20% of magical damage, up to 100 (500 Mastered) points of damage.
        // Damage resisted/negated through this directed into Barrier Points.
        float originalDamageNum = amount.get();
        double damageModifier = CONFIG.magicDamageResistance;
        double reducedDamageTotal = (originalDamageNum * damageModifier);
        double damageDifference = (originalDamageNum - reducedDamageTotal);
        int damageNegation = isMastered(instance, owner) ? CONFIG.magicDamageResistCapMastered : CONFIG.magicDamageResistCapUnmastered;
        if (TensuraDamageHelper.isTensuraMagic(source)) {
            if (instance.isToggled()) {
                if (damageDifference >= damageNegation) {
                    double currentBarrier = owner.getAttributeValue(TensuraAttributes.MULTILAYER_BARRIER);
                    AttributeHelper.addPermanentAttributeIfHigher(owner, TensuraAttributes.MULTILAYER_BARRIER, CURRENT_UNBROKEN, currentBarrier + damageNegation, AttributeModifier.Operation.ADD_VALUE);

                    amount.set(originalDamageNum - damageNegation);
                }

                if (damageDifference <= damageNegation) {
                    double currentBarrier = owner.getAttributeValue(TensuraAttributes.MULTILAYER_BARRIER);
                    AttributeHelper.addPermanentAttributeIfHigher(owner, TensuraAttributes.MULTILAYER_BARRIER, CURRENT_UNBROKEN, currentBarrier + damageDifference, AttributeModifier.Operation.ADD_VALUE);

                    amount.set((float) reducedDamageTotal);
                }
            }
        }

        return true;
    }

    public void onTick(ManasSkillInstance instance, LivingEntity living) {
        if (living instanceof Player player) {
            if (player.getDeltaMovement().lengthSqr() > 0.001) {
                this.ManaRegen(player, instance);
            }
        }
        CompoundTag tag = instance.getOrCreateTag();
        int time = tag.getInt("activatedTimes");
        if (time % 10 == 0) {
            this.addMasteryPoint(instance, living);
        }

        tag.putInt("activatedTimes", time + 1);
    }

    private void ManaRegen(LivingEntity entity, ManasSkillInstance instance) {
        IExistence existence = TensuraStorages.getExistenceFrom(entity);
        double manaGain = isMastered(instance, entity) ? CONFIG.masteredMPRegen : CONFIG.unmasteredMPRegen;

        if (existence.getMagicule() + manaGain <= entity.getAttributeValue(TensuraAttributes.MAX_MAGICULE)) {
            existence.setMagicule(existence.getMagicule() + manaGain);
        }
        existence.markDirty();
    }

    static {
        CURRENT_UNBROKEN = ResourceLocation.fromNamespaceAndPath("trstarlight", "current_unbroken");
        CONFIG = ConfigRegistry.getConfig(aspectSeriesSkillConfig.class).CurrentUnbroken;
    }
}
