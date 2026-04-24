package com.github.hallowova.mythos.race.void_hatchling;

import com.mojang.datafixers.util.Pair;
import io.github.manasmods.manascore.race.api.ManasRaceInstance;
import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.tensura.config.race.RaceConfig;
import io.github.manasmods.tensura.race.template.DefaultRace;
import io.github.manasmods.tensura.storage.Alignment;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class VoidHatchlingRace extends DefaultRace {
    public VoidHatchlingRace() {
        super(Difficulty.INTERMEDIATE);
    }

    @Override
    public RaceConfig.Default getDefaultConfig() {
        return null;
    }

    @Override
    public Alignment getAlignment() {
        return Alignment.DEFAULT;
    }

    @Override
    public double getMinBaseAura() {
        return super.getMinBaseAura();
    }

    @Override
    public double getMinBaseMagicule() {
        return super.getMinBaseMagicule();
    }

    @Override
    public double getMaxBaseAura() {
        return super.getMaxBaseAura();
    }

    @Override
    public double getMaxBaseMagicule() {
        return super.getMaxBaseMagicule();
    }

    @Override
    public Pair<Double, Double> getBaseAuraRange() {
        return super.getBaseAuraRange();
    }

    @Override
    public Pair<Double, Double> getBaseMagiculeRange() {
        return super.getBaseMagiculeRange();
    }

    @Override
    public List<ManasSkill> getIntrinsicSkills(ManasRaceInstance instance, LivingEntity entity) {
        return super.getIntrinsicSkills(instance, entity);
    }

}
