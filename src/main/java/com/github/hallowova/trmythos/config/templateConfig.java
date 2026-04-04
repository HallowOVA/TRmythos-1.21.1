package com.github.hallowova.trmythos.config;

import io.github.manasmods.manascore.config.api.ManasConfig;
import io.github.manasmods.manascore.config.api.ManasSubConfig;

public class templateConfig extends ManasConfig {
    public templateSkill templateSkill = new templateSkill();

    public String getFileName() {
        return "tensura/tensura-starlight/skills/template-series";
    }

    public static class templateSkill extends ManasSubConfig {

    }

}
