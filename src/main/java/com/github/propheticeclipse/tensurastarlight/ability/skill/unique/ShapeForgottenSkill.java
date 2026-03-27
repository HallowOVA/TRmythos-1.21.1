package com.github.propheticeclipse.tensurastarlight.ability.skill.unique;

import com.github.propheticeclipse.tensurastarlight.config.skills.aspectSeriesSkillConfig;
import com.github.propheticeclipse.tensurastarlight.registry.StarlightEffects;
import com.github.propheticeclipse.tensurastarlight.registry.skills.StarlightUniqueSkills;
import io.github.manasmods.manascore.config.ConfigRegistry;
import io.github.manasmods.manascore.network.api.util.Changeable;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.tensura.ability.SkillUtils;
import io.github.manasmods.tensura.ability.skill.Skill;
import io.github.manasmods.tensura.registry.effect.TensuraMobEffects;
import io.github.manasmods.tensura.registry.skill.CommonSkills;
import io.github.manasmods.tensura.storage.TensuraStorages;
import io.github.manasmods.tensura.storage.ep.IExistence;
import io.github.manasmods.tensura.util.EnergyHelper;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class ShapeForgottenSkill extends Skill {
    public ShapeForgottenSkill() {
        super(SkillType.UNIQUE);
    }
    private static final aspectSeriesSkillConfig.ShapeForgotten CONFIG;

//    # Shape Forgotten
//-# Unique
//-# “Concentrate your body upon fracture, for only broken forms learn to adapt.”
//    Acquisition Conditions:
//    Have Ember Remains
//    Self Regeneration
//75k MP, or Reincarnation
//    Actives
//

    @Override
    public boolean checkAcquiringRequirement(Player entity, double newEP) {
        boolean ember = SkillUtils.isSkillMastered(entity, StarlightUniqueSkills.EMBER_REMAINS.get());
        boolean selfRegen = SkillUtils.hasSkillPermanently(entity, CommonSkills.SELF_REGENERATION.get());
        return ember && selfRegen;
    }

    @Override
    public int getAcquirementMastery(LivingEntity entity) {
        return CONFIG.acquirementMastery;
    }

    @Override
    public double getAcquiringMagiculeCost(ManasSkillInstance instance) {
        return CONFIG.magiculeAcquirementCost;
    }

    @Override
    public boolean canBeToggled(ManasSkillInstance instance, LivingEntity entity) {
        return true;
    }

    public int getModes(ManasSkillInstance instance) {
        return 2;
    }

    public String getModeId(ManasSkillInstance instance, int mode) {
        String var10000;
        if (mode == 0) {
            var10000 = "shape_forgotten.slippery_form";
        } else {
            var10000 = super.getModeId(instance, mode);
        }

        return var10000;
    }

    @Override
    public double getMagiculeCost(LivingEntity entity, ManasSkillInstance instance, int mode) {
        double cost;
        switch (mode) {
            case 0 -> cost = 500.0;
            case 1 -> cost = 200.0;
            default -> cost = 0.0;
        }

        return cost;
    }

    @Override
    public boolean onTakenDamage(ManasSkillInstance instance, LivingEntity owner, DamageSource source, Changeable<Float> amount) {
        //[Passive - True] After taking 10+ damage, temporarily increase armour by 10, up to 100 points over time.
        // Effects will fade over time. Consumes 200 MP / Level
        //[Passive - Toggle] For each level of the above effect, reduce all damage taken by a flat 2 (4 mastered) points.
        // If under 40% HP, increase to 3 (5 mastered) damage reduction.

        double originalDamageNum = amount.get();
        MobEffectInstance buff = owner.getEffect(TensuraMobEffects.getReference(StarlightEffects.SHAPE_FORGOTTEN_ARMOR));

        if (originalDamageNum >= CONFIG.shiftingArmorDamageTrigger) {
            int i = 0;
            int originalDuration = CONFIG.shiftingArmorDurationFirstHit;
            int duration;
            if (buff != null) {
                duration = buff.getDuration() + CONFIG.shiftingArmorDurationConsecutiveHit;
                i = (duration - originalDuration) / (CONFIG.shiftingArmorAmpliDurationScaling);
                addMasteryPoint(instance, owner);
            } else {
                duration = originalDuration;
            }
            if (i > CONFIG.armorBuffMaxAmplifier) {
                i = CONFIG.armorBuffMaxAmplifier;
            }

            if (EnergyHelper.isOutOfEnergy(owner, instance, 1, i)) {
                // This should prevent the skill from adding the effect if you are out of the magicules to apply the amplifier level.
                return true;
            }

            owner.addEffect(new MobEffectInstance((TensuraMobEffects.getReference(StarlightEffects.SHAPE_FORGOTTEN_ARMOR)), duration, i, false, false, false));
        }

        if (instance.isToggled() && buff != null) {

            int i = (buff.getAmplifier() + 1);
            double damageModifier = isMastered(instance, owner) ? CONFIG.damageNegationMastered : CONFIG.damageNegationUnmastered;
            double lowHPDamageModifier = isMastered(instance, owner) ? CONFIG.damageNegationLowHPMastered : CONFIG.damageNegationLowHPUnmastered;
            double totalReduction = 0;
            if (owner.getHealth() <= (owner.getMaxHealth() * CONFIG.damageNegationLowHPThresh)) {
                totalReduction = lowHPDamageModifier * i;
            } else {
                totalReduction = damageModifier * i;
            }
            addMasteryPoint(instance, owner);
            amount.set((float) (originalDamageNum - totalReduction));
            return true;
        }

        return true;
    }

    @Override
    public void onPressed(ManasSkillInstance instance, LivingEntity entity, int keyNumber, int mode) {
        //[Active - Press] Slippery Form: Remove all slowing/stunning debuffs such as Slowness, Paralysis, or similar. 5s CD, 750 MP per level removed. Gain 1 mastery per effect removed.
//
//    Temporarily affects all harmful effects

        if (mode == 0) {
            if (entity instanceof Player player) {
                IExistence existence = TensuraStorages.getExistenceFrom(player);
                int effectsRemoved = 0;
                for (MobEffectInstance effect : player.getActiveEffects()) {
                    if (effect.getEffect().value().getCategory() == MobEffectCategory.HARMFUL) { // Setup whitelist and blacklist config.
                        int levels = (effect.getAmplifier() + 1);
                        player.removeEffect(effect.getEffect());
                        addMasteryPoint(instance, player);
                        effectsRemoved += levels;
                    }
                }
                double removalCost = CONFIG.shiftingFormMPCost;
                double mpCost = (effectsRemoved * removalCost);
                double currentMP = existence.getMagicule();

                existence.setMagicule(currentMP - mpCost);
                instance.setCoolDown(CONFIG.shiftingFormCooldown, 0);
            }

        }
    }

    static {
        CONFIG = ConfigRegistry.getConfig(aspectSeriesSkillConfig.class).ShapeForgotten;
    }
}
