package com.github.propheticeclipse.tensurastarlight.config.effects;

import io.github.manasmods.manascore.config.api.Comment;
import io.github.manasmods.manascore.config.api.ManasConfig;
import io.github.manasmods.manascore.config.api.ManasSubConfig;

public class BuffEffectsConfig extends ManasConfig {
    public CombatFlow EmberBuffConf = new CombatFlow();
    public ShiftingArmor ShapeBuffConf = new ShiftingArmor();
    public FlaringForm RemnantBuffConf = new FlaringForm();

    public String getFileName() {
        return "tensura/tensura-starlight/effects/buffs";
    }

    public static class CombatFlow extends ManasSubConfig {
        @Comment("How much attack should a entity gain with this effect?")
        public int attackMod = 4;
    }

    public static class ShiftingArmor extends ManasSubConfig {
        @Comment("How much armor should a entity gain with this effect?")
        public int armorMod = 5;
    }

    public static class FlaringForm extends ManasSubConfig {
        @Comment("How much armor and armor toughness should a entity gain with this effect?")
        public int armorMod = 10;
        public int armorToughMod = 2;
    }
}
