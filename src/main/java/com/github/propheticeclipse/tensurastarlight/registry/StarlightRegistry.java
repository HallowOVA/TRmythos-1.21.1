package com.github.propheticeclipse.tensurastarlight.registry;

import com.github.propheticeclipse.tensurastarlight.config.StarlightConfigs;
import com.github.propheticeclipse.tensurastarlight.registry.skills.StarlightUniqueSkills;

public class StarlightRegistry {
    public static void init() {
        StarlightUniqueSkills.init();
        StarlightEffects.init();
        StarlightConfigs.init();
    }
}
