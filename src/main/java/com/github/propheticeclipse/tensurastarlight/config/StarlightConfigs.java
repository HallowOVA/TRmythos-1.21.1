package com.github.propheticeclipse.tensurastarlight.config;

import com.github.propheticeclipse.tensurastarlight.config.effects.BuffEffectsConfig;
import com.github.propheticeclipse.tensurastarlight.config.skills.aspectSeriesSkillConfig;
import io.github.manasmods.manascore.config.ConfigRegistry;

public class StarlightConfigs {
    public static void init() {
        ConfigRegistry.registerConfig(new StarlightCommon());
        // Effects
        ConfigRegistry.registerConfig(new BuffEffectsConfig());
        // Skills
        ConfigRegistry.registerConfig(new aspectSeriesSkillConfig());
        // Races
    }
}
