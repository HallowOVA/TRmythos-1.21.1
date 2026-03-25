package com.github.propheticeclipse.tensurastarlight.config;

import io.github.manasmods.manascore.config.api.Comment;
import io.github.manasmods.manascore.config.api.ManasConfig;
import io.github.manasmods.manascore.config.api.ManasSubConfig;
import io.github.manasmods.manascore.config.api.SyncToClient;

import java.util.List;

@SyncToClient
public class StarlightCommon extends ManasConfig {
    public SkillClassification SkillClassification = new SkillClassification();

    public String getFileName() {
        return "tensura/starlight-common";
    }

    public static class SkillClassification extends ManasSubConfig {
        @Comment("List of skills that are considered Eldritch-Series for the purposes of Tensura: Starlight")
        public List<String> eldritchSkills = List.of();
    }
}
