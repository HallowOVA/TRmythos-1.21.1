package com.github.propheticeclipse.tensurastarlight.ability.skill.unique;

import com.github.propheticeclipse.tensurastarlight.registry.StarlightEffects;
import com.github.propheticeclipse.tensurastarlight.registry.skills.StarlightUniqueSkills;
import io.github.manasmods.manascore.network.api.util.Changeable;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.tensura.ability.SkillUtils;
import io.github.manasmods.tensura.ability.skill.Skill;
import io.github.manasmods.tensura.effect.template.TensuraMobEffect;
import io.github.manasmods.tensura.registry.effect.TensuraMobEffects;
import io.github.manasmods.tensura.storage.TensuraStorages;
import io.github.manasmods.tensura.storage.ep.IExistence;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;

public class EmberRemainsSkill extends Skill {

    public EmberRemainsSkill() {
        super(SkillType.UNIQUE);
    }

//    # Ember Remains
//-# Unique
//-# “Concentrate your will upon smothering, for only unresisting flame may never die.”
//    Acquisition Conditions:
//    Have Light Remains or Vestiges of Eidolons or Current Unbroken or Shape Forgotten
//    Defy Fate 3 times
//100k MP, or Reincarnation
//
//    Temporarily affects all beneficial effects.

    @Override
    public boolean checkAcquiringRequirement(Player entity, double newEP) {
        int defyFateCount = 0;
        if (entity instanceof ServerPlayer serverPlayer) {
            defyFateCount = serverPlayer.getStats().getValue(Stats.ITEM_USED.get(Items.TOTEM_OF_UNDYING));
        } else {
            defyFateCount = 0;
        }

        boolean deniedFate = defyFateCount >= 3;
        boolean hasLightRemains = (SkillUtils.hasSkill(entity, StarlightUniqueSkills.LIGHT_REMAINS.get()) || SkillUtils.hasSkill(entity, StarlightUniqueSkills.VESTIGES_OF_EIDOLONS.get()));
        return hasLightRemains && deniedFate;
    }

    @Override
    public int getAcquirementMastery(LivingEntity entity) {
        return 1;
    }

    @Override
    public double getAcquiringMagiculeCost(ManasSkillInstance instance) {
        return super.getAcquiringMagiculeCost(instance);
    }

    @Override
    public int getModes(ManasSkillInstance instance) {
        return 2;
    }

    public String getModeId(ManasSkillInstance instance, int mode) {
        String var10000;
        if (mode == 0) {
            var10000 = "ember_remains.kindle_flames";
        } else {
            var10000 = super.getModeId(instance, mode);
        }

        return var10000;
    }

    @Override
    public boolean onDeath(ManasSkillInstance instance, LivingEntity owner, DamageSource source) {
        //[Passive - True] Bypass death, set HP to 10% of total and gain Resistance 2, Strengthen 2 for 60s. 600s CD, Costless. Gain 10 Mastery.
        if (owner instanceof Player player) {
            double maxHP = player.getMaxHealth();
            // Place anti-resurrection skill flag here!
            if ((instance.getCoolDown(1) == 0) && instance.isToggled()) {
                player.removeAllEffects();
                player.invulnerableTime = 60;

                player.setHealth(((float) ((maxHP * 0.1) + 1)));

                applyEffects(owner);

                instance.setCoolDown(600, 1);
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    private void applyEffects(LivingEntity owner) {
        if (owner instanceof Player player) {
            MobEffectInstance strengthen = new MobEffectInstance(TensuraMobEffects.getReference(TensuraMobEffects.STRENGTHEN), 1200, 1, false, false, false);
            MobEffectInstance resistance = new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 1, false, false, false);
            TensuraMobEffect.addEffect(owner, strengthen, owner, this, 1);
            player.addEffect(resistance);
        }
    }

    @Override
    public boolean canBeToggled(ManasSkillInstance instance, LivingEntity entity) {
        return true;
    }

    public boolean onDamageEntity(ManasSkillInstance instance, LivingEntity owner, LivingEntity target, DamageSource source, Changeable<Float> amount) {
        MobEffectInstance emberBuff = owner.getEffect(TensuraMobEffects.getReference(StarlightEffects.EMBER_ATTACK_IMPROVEMENT));
        int i = 0;
        int originalDuration = 100;
        int duration;
        if (emberBuff != null) {
            duration = emberBuff.getDuration() + 50;
            i = (duration - originalDuration) / (200);
        } else {
            duration = originalDuration;
        }

        owner.addEffect(new MobEffectInstance((TensuraMobEffects.getReference(StarlightEffects.EMBER_ATTACK_IMPROVEMENT)), duration, i, false, false, false));

        return true;
    }

    @Override
    public void onPressed(ManasSkillInstance instance, LivingEntity entity, int keyNumber, int mode) {
        //[Active - Press] Kindle Flames: If under 50% HP, increase the duration of all buffs by 60s. 30s CD,
        // 2000 MP per minute of increased duration. Gain 1 Mastery.
        if (mode == 0) {
            if (entity instanceof Player player) {
                IExistence existence = TensuraStorages.getExistenceFrom(player);
                int totalDurationExtended = 0;
                for (MobEffectInstance effect : player.getActiveEffects()) {
                    if (effect.getEffect().value().getCategory() == MobEffectCategory.BENEFICIAL) {
                        int newDuration = effect.getDuration() + 1200; // +60s
                        MobEffectInstance extended = new MobEffectInstance(effect.getEffect(), newDuration, effect.getAmplifier(), effect.isAmbient(), effect.isVisible(), effect.showIcon());
                        player.addEffect(extended);
                        addMasteryPoint(instance, player);
                        totalDurationExtended += 1;
                    }
                }
                double extensionCost = 2000;
                double mpCost = (totalDurationExtended * extensionCost);
                double currentMP = existence.getMagicule();

                existence.setMagicule(currentMP - mpCost);
                instance.setCoolDown(30, 0);
            }

        }
    }
}
