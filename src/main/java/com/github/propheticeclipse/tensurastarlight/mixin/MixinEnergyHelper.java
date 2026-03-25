package com.github.propheticeclipse.tensurastarlight.mixin;

import com.github.propheticeclipse.tensurastarlight.registry.skills.StarlightUniqueSkills;
import io.github.manasmods.tensura.ability.SkillUtils;
import io.github.manasmods.tensura.util.EnergyHelper;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin({EnergyHelper.class})
public class MixinEnergyHelper {
    @ModifyVariable(
            method = {"isOutOfEnergy(Lnet/minecraft/world/entity/LivingEntity;DD)Z"},
            at = @At("HEAD"),
            ordinal = 1,
            argsOnly = true
    )
    private static double modifyMpCost(double original, LivingEntity entity, double apCost, double mpCost) {

        if (SkillUtils.hasSkill(entity, StarlightUniqueSkills.CURRENT_UNBROKEN.get())) {
            original *= 0.95;
        }

        if (SkillUtils.hasSkill(entity, StarlightUniqueSkills.REMNANTS_OF_ASCENSION.get())) {
            original *= 0.90;
        }

        return original;
    }
}
