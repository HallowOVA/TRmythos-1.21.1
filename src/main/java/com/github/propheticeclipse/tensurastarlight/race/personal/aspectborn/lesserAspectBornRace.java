package com.github.propheticeclipse.tensurastarlight.race.personal.aspectborn;

import com.github.propheticeclipse.tensurastarlight.config.StarlightCommon;
import com.github.propheticeclipse.tensurastarlight.config.races.aspectBornRaceConfig;
import com.github.propheticeclipse.tensurastarlight.race.StarlightRace;
import io.github.manasmods.manascore.config.ConfigRegistry;
import io.github.manasmods.manascore.race.api.ManasRace;
import io.github.manasmods.manascore.race.api.ManasRaceInstance;
import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.manascore.skill.api.SkillAPI;
import io.github.manasmods.tensura.config.race.RaceConfig;
import io.github.manasmods.tensura.registry.race.TensuraRaces;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class lesserAspectBornRace extends StarlightRace {
    public lesserAspectBornRace(Difficulty difficulty) {
        super(difficulty);
    }

    public lesserAspectBornRace() {
        this(Difficulty.EXTREME);
        this.applyDefaultAttributeModifiers();
    }

    public RaceConfig.Default getDefaultConfig() {
        return (ConfigRegistry.getConfig(aspectBornRaceConfig.class)).lesserAspectBorn;
    }
    
    public StarlightCommon.RaceDefault getAttributeDefaultConfig() {
        return (ConfigRegistry.getConfig(aspectBornRaceConfig.class)).lesserAspectBorn;
    }

    public @Nullable ManasRace getDefaultEvolution(ManasRaceInstance instance, LivingEntity entity) {
        return (ManasRace) TensuraRaces.BEAST_LORD.get();
    }

    public @Nullable ManasRace getAwakeningEvolution(ManasRaceInstance instance, LivingEntity entity) {
        return (ManasRace)TensuraRaces.SPIRIT_BEAST.get();
    }

    public @Nullable ManasRace getHarvestFestivalEvolution(ManasRaceInstance instance, LivingEntity entity) {
        return (ManasRace)TensuraRaces.BEAST_LORD.get();
    }

    public List<ManasRace> getNextEvolutions(ManasRaceInstance instance, LivingEntity entity) {
        return List.of((ManasRace)TensuraRaces.BEAST_LORD.get());
    }

    public List<ManasSkill> getIntrinsicSkills(ManasRaceInstance instance, LivingEntity entity) {
        return ConfigRegistry.getConfig(aspectBornRaceConfig.class)
                .lesserAspectBorn.lesserAspectBornIntrinsics.stream()
                .map(id -> (ManasSkill) SkillAPI.getSkillRegistry().get(ResourceLocation.parse(id)))
                .filter(Objects::nonNull)
                .toList();
    }
}
