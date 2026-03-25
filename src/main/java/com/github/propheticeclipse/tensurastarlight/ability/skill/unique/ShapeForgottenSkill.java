package com.github.propheticeclipse.tensurastarlight.ability.skill.unique;

import com.github.propheticeclipse.tensurastarlight.registry.StarlightEffects;
import com.github.propheticeclipse.tensurastarlight.registry.skills.StarlightUniqueSkills;
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
        return 1;
    }

    @Override
    public double getAcquiringMagiculeCost(ManasSkillInstance instance) {
        return 75000;
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

        if (originalDamageNum >= 10) {
            int i = 0;
            int originalDuration = 100;
            int duration;
            if (buff != null) {
                duration = buff.getDuration() + 50;
                i = (duration - originalDuration) / (300);
                addMasteryPoint(instance, owner);
            } else {
                duration = originalDuration;
            }
            if (i > 9) {
                i = 9;
            }

            if (EnergyHelper.isOutOfEnergy(owner, instance, 1, i)) {
                // This should prevent the skill from adding the effect if you are out of the magicules to apply the amplifier level.
                return true;
            }

            owner.addEffect(new MobEffectInstance((TensuraMobEffects.getReference(StarlightEffects.SHAPE_FORGOTTEN_ARMOR)), duration, i, false, false, false));
        }

        if (instance.isToggled() && buff != null) {

            int i = (buff.getAmplifier() + 1);
            double damageModifier = isMastered(instance, owner) ? 4 : 2;
            double lowHPDamageModifier = isMastered(instance, owner) ? 5 : 3;
            double totalReduction = 0;
            if (owner.getHealth() <= (owner.getMaxHealth() * 0.4)) {
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
                    if (effect.getEffect().value().getCategory() == MobEffectCategory.HARMFUL) {
                        int levels = (effect.getAmplifier() + 1);
                        player.removeEffect(effect.getEffect());
                        addMasteryPoint(instance, player);
                        effectsRemoved += levels;
                    }
                }
                double removalCost = 750;
                double mpCost = (effectsRemoved * removalCost);
                double currentMP = existence.getMagicule();

                existence.setMagicule(currentMP - mpCost);
                instance.setCoolDown(30, 0);
            }

        }
    }
}
