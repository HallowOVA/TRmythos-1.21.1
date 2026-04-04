package com.github.hallowova.trmythos.ability.skill;

import com.github.hallowova.trmythos.config.skills.aspectSeriesSkillConfig;
import io.github.manasmods.manascore.config.ConfigRegistry;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.tensura.ability.skill.Skill;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class templateSkill extends Skill {

    private static final aspectSeriesSkillConfig.MemoryRecreation CONFIG;
    public static final ResourceLocation MEMORY_RECREATION;

    public templateSkill() {
        super(SkillType.UNIQUE);
    }

    public double getAcquiringMagiculeCost(ManasSkillInstance instance) {
        return CONFIG.acquirementCost;
    }

    public int getAcquirementMastery(LivingEntity entity) {
        return CONFIG.acquirementMastery;
    }

    public int getModes(ManasSkillInstance instance) {
        return 1;
    }

    public String getModeId(ManasSkillInstance instance, int mode) {
        String var10000;
        switch (mode) {
            case 0 -> var10000 = "memory_recreation.block_memory";
            default -> var10000 = super.getModeId(instance, mode);
        }

        return var10000;
    }

    static {
        MEMORY_RECREATION = ResourceLocation.fromNamespaceAndPath("trstarlight", "skill_id");
        CONFIG = ConfigRegistry.getConfig(aspectSeriesSkillConfig.class).MemoryRecreation;
    }
}