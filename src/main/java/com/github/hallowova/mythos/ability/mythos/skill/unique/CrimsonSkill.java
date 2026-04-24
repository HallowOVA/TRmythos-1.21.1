package com.github.hallowova.mythos.ability.mythos.skill.unique;

import io.github.manasmods.manascore.network.api.util.Changeable;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.tensura.ability.skill.Skill;
import io.github.manasmods.tensura.damage.TensuraDamageHelper;
import io.github.manasmods.tensura.registry.attribute.TensuraAttributes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

public class CrimsonSkill extends Skill {
    protected static final ResourceLocation ACCELERATION2;
    protected static final ResourceLocation FIGHTER2;

    public CrimsonSkill() {
        super(SkillType.UNIQUE);
    }

    @Override
    public double getAcquiringMagiculeCost(ManasSkillInstance instance) {
        return 66666;
    }

    @Override
    public boolean canBeToggled(ManasSkillInstance instance, LivingEntity entity) {
        return true;
    }

    @Override
    public void onToggleOn(ManasSkillInstance instance, LivingEntity entity) {
        super.onToggleOn(instance, entity);

        AttributeInstance chantSpeed = entity.getAttribute(TensuraAttributes.CHANT_SPEED);
        if (chantSpeed != null && !chantSpeed.hasModifier(ACCELERATION2)) {
            chantSpeed.addOrReplacePermanentModifier(new AttributeModifier(ACCELERATION2, 2, AttributeModifier.Operation.ADD_VALUE));
        }

        AttributeInstance mastery = entity.getAttribute(TensuraAttributes.ABILITY_MASTERY_GAIN);
        if (mastery != null) {
            mastery.addOrReplacePermanentModifier(new AttributeModifier(FIGHTER2, 4, AttributeModifier.Operation.ADD_VALUE));
        }
    }

    @Override
    public void onToggleOff(ManasSkillInstance instance, LivingEntity entity) {
        super.onToggleOff(instance, entity);

        AttributeInstance chantSpeed = entity.getAttribute(TensuraAttributes.CHANT_SPEED);
        if (chantSpeed != null) {
            chantSpeed.removeModifier(ACCELERATION2);
        }

        AttributeInstance mastery = entity.getAttribute(TensuraAttributes.ABILITY_MASTERY_GAIN);
        if (mastery != null) {
            mastery.removeModifier(FIGHTER2);
        }
    }

    @Override
    public boolean onDamageEntity(ManasSkillInstance instance, LivingEntity attacker, LivingEntity target, DamageSource source, Changeable<Float> amount) {
        if (instance.isToggled()) {
            float heatDmg = 50.0f;
            DamageSource heatSource = attacker.level().damageSources().onFire();
            target.hurt(heatSource, heatDmg);
        }

        if (!this.isInSlot(attacker, instance)) {
            return true;
        } else if (source.getDirectEntity() != attacker) {
            return true;
        } else if (!TensuraDamageHelper.isPhysicalAttack(source)) {
            return true;
        } else {
            float damage = instance.getTag() != null && instance.getTag().contains("scale") ? instance.getTag().getFloat("scale") : (instance.isMastered(attacker) ? 180 : 90);
            amount.set(amount.get() + damage);
            if (!instance.onCoolDown(0)) {
                instance.addMasteryPoint(attacker);
                instance.setCoolDown(3, 0);
            }

            return true;
        }
    }

    static {
        FIGHTER2 = ResourceLocation.fromNamespaceAndPath("mythos", "crimson");
        ACCELERATION2 = ResourceLocation.fromNamespaceAndPath("mythos", "crimson");
    }
}
