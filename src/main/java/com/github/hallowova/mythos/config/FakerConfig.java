package com.github.hallowova.mythos.config;

import io.github.manasmods.manascore.config.api.Comment;
import io.github.manasmods.manascore.config.api.ManasConfig;

public class FakerConfig extends ManasConfig {

    @Override
    public String getFileName() {
        return "faker";
    }

    @Comment("Magicule Acquirement Cost.")
    public double mpAcquirement = 75000.0D;

    @Comment("Analysis Level")
    public int analysisLevel = 8;

    @Comment("Analysis Level Mastered")
    public int analysisLevelMastered = 18;

    @Comment("Modification limits")
    public int reinforceOvercapLevel = 10;
    public boolean allowOvercap = true;

    @Comment("Reinforce Cooldown")
    public int reinforceCooldown = 10;

    @Comment("Projection Cooldown")
    public int projectionCooldown = 10;
}