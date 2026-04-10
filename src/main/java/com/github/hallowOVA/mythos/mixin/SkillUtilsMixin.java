package com.github.hallowOVA.mythos.mixin;

import com.github.hallowOVA.mythos.registry.skill.MythosSkills;
import io.github.manasmods.tensura.ability.SkillUtils;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin({SkillUtils.class})
public class SkillUtilsMixin {

    @ModifyVariable(
            method = {"canBlockSoundDetect(Lnet/minecraft/world/entity/LivingEntity;)Z"},
            at = @At("HEAD"),
            ordinal = 1,
            argsOnly = true
    )
    private static boolean isBlockingSoundDetect(LivingEntity target) {
        boolean canBlockSoundDetect = false;

        if (SkillUtils.hasSkill(target, MythosSkills.NIMUE.get())) canBlockSoundDetect = true;

        return  canBlockSoundDetect;
    }
}