package com.github.propheticeclipse.tensurastarlight.race.personal.aspectborn.trueAspect.memoryAspect;

import com.github.propheticeclipse.tensurastarlight.config.StarlightCommon;
import com.github.propheticeclipse.tensurastarlight.config.races.aspectBornRaceConfig;
import com.github.propheticeclipse.tensurastarlight.race.personal.aspectborn.aspectBornRace;
import com.github.propheticeclipse.tensurastarlight.registry.StarlightRaces;
import io.github.manasmods.manascore.config.ConfigRegistry;
import io.github.manasmods.manascore.race.api.ManasRace;
import io.github.manasmods.manascore.race.api.ManasRaceInstance;
import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.manascore.skill.api.SkillAPI;
import io.github.manasmods.tensura.config.race.RaceConfig;
import io.github.manasmods.tensura.race.template.EvolutionRequirement;
import io.github.manasmods.tensura.storage.Alignment;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class lesserMemoryBornRace extends aspectBornRace {
    public lesserMemoryBornRace(Difficulty difficulty) {
        super(difficulty);
    }

    public lesserMemoryBornRace() {
        this(Difficulty.EXTREME);
        this.applyDefaultAttributeModifiers();
    }

    public RaceConfig.Default getDefaultConfig() {
        return (ConfigRegistry.getConfig(aspectBornRaceConfig.class)).greaterAspectBorn;
    }
    
    public StarlightCommon.RaceDefault getAttributeDefaultConfig() {
        return (ConfigRegistry.getConfig(aspectBornRaceConfig.class)).greaterAspectBorn;
    }

    public Alignment getAlignment() {
        return Alignment.MAJIN;
    }

    public @Nullable ManasRace getDefaultEvolution(ManasRaceInstance instance, LivingEntity entity) {
        return StarlightRaces.LESSER_CONVERGENCE_BORN.get();
    }

    public @Nullable ManasRace getAwakeningEvolution(ManasRaceInstance instance, LivingEntity entity) {
        return StarlightRaces.CONVERGENCE_BORN.get();
    }

    public @Nullable ManasRace getHarvestFestivalEvolution(ManasRaceInstance instance, LivingEntity entity) {
        return StarlightRaces.LESSER_CONVERGENCE_BORN.get();
    }

    public List<ManasRace> getNextEvolutions(ManasRaceInstance instance, LivingEntity entity) {
        return List.of(StarlightRaces.LESSER_CONVERGENCE_BORN.get());
    }

    @Override
    public float getEvolutionProgress(ManasRaceInstance instance, LivingEntity entity, ManasRace evolution) {
        return super.getEvolutionProgress(instance, entity, evolution);
    }

    @Override
    public Map<EvolutionRequirement, Float> getEvolutionRequirements(ManasRaceInstance previous, LivingEntity entity) {
        return super.getEvolutionRequirements(previous, entity);
    }

    public List<ManasSkill> getIntrinsicSkills(ManasRaceInstance instance, LivingEntity entity) {
        return ConfigRegistry.getConfig(aspectBornRaceConfig.class)
                .greaterAspectBorn.greaterAspectBornIntrinsics.stream()
                .map(id -> (ManasSkill) SkillAPI.getSkillRegistry().get(ResourceLocation.parse(id)))
                .filter(Objects::nonNull)
                .toList();
    }
}
