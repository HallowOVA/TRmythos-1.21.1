package com.github.propheticeclipse.tensurastarlight.config.skills;

import com.github.propheticeclipse.tensurastarlight.config.effects.BuffEffectsConfig;
import io.github.manasmods.manascore.config.api.Comment;
import io.github.manasmods.manascore.config.api.ManasConfig;
import io.github.manasmods.manascore.config.api.ManasSubConfig;

public class aspectSeriesSkillConfig extends ManasConfig {
    public LightRemains LightRemainsConf = new LightRemains();
    public EchoEndures EchoEnduresConf = new EchoEndures();
    public LifeReturns LifeReturnsConf = new LifeReturns();
    public EmberRemains EmberRemainsConf = new EmberRemains();
    public ShapeForgotten ShapeForgottenConf = new ShapeForgotten();
    public CurrentUnbroken CurrentUnbrokenConf = new CurrentUnbroken();

    public VestigesOfEidolons VestigesOfEidolonsConf = new VestigesOfEidolons();
    public RemnantsOfAscension RemnantsOfAscensionConf = new RemnantsOfAscension();

    public String getFileName() {
        return "tensura/tensura-starlight/skills/aspect-series";
    }

    public static class LightRemains extends ManasSubConfig {
        @Comment("What level should the Light/Darkness spirits be to acquire Light Remains for free?\nLevel 2 = Medium Spirit\nLevel 3 = Greater Spirit\nLevel 4 = Spirit Lord\n")
        public int skillFreeSpiritLevel = 4;
        @Comment("What level should the Light/Darkness spirits be to acquire Light Remains at cost?")
        public int skillAcquireSpiritLevel = 3;
        @Comment("How much MP should Light Remains cost to acquire/plunder/copy under normal circumstances?")
        public double magiculeAcquirementCost = 75000;
        @Comment("How much mastery should Light Remains have by default?\nAny value above 1 = X Mastery at acquirement\n0 = Must be learned\n Any value below 0 = Requires X Learn Points")
        public int acquirementMastery = 1;
        @Comment("How much aura/mana gain percent should Light Remains grant to its user? 1 = 1%, 100 = 100%")
        public double auraGainPercent = 0.75;
        public double manaGainPercent = 2.25;
        @Comment("How much mana should Blinding Light and Overbearing Light cost to activate?")
        public double blindingLightManaCost = 500.0;
        public double overbearingLightManaCost = 1200.0;
        @Comment("How much should the damage modifier to Light Damage be?")
        public double damageModMastered = 3.0;
        public double damageModUnmastered = 1.5;
        @Comment("How much extra MP should the user get when killing a target with Overbearing Light?\n1.0 = 100%, 0.01 = 1%")
        public double overbearingLightManaGain = 0.05;
        @Comment("What should the specifications of Blinding Light be?")
        public double blindingLightConeAngle = 60.0;
        public double blindingLightConeLength = 11.0;
        public float blindingLightDamageMastered = 20;
        public float blindingLightDamageUnmastered = 10;
        @Comment("Duration in ticks, 20 ticks is 1 second.")
        public int blindingLightDarknessDuration = 100;
        @Comment("Amplifiers are 1 less than level, A level 1 effectis amplifier 0.")
        public int blindingLightDarknessAmplifier = 0;
        public int blindingLightCooldown = 2;

        @Comment("What should the specifications of Overbearing Light be?")
        public float overbearingLightDamageMastered = 80;
        public float overbearingLightDamageUnmastered = 40;
        public double overbearingLightRange = 10.0;
        public int overbearingLightCooldown = 6;
    }
    public static class EchoEndures extends ManasSubConfig {
        @Comment("How much attack should a entity gain with this effect?")
        public int attackMod = 4;
    }
    public static class LifeReturns extends ManasSubConfig {
        @Comment("How much attack should a entity gain with this effect?")
        public int attackMod = 4;
    }
    public static class EmberRemains extends ManasSubConfig {
        @Comment("How much attack should a entity gain with this effect?")
        public int attackMod = 4;
    }
    public static class ShapeForgotten extends ManasSubConfig {
        @Comment("How much attack should a entity gain with this effect?")
        public int attackMod = 4;
    }
    public static class CurrentUnbroken extends ManasSubConfig {
        @Comment("How much attack should a entity gain with this effect?")
        public int attackMod = 4;
    }

    public static class VestigesOfEidolons extends ManasSubConfig {
        @Comment("How much attack should a entity gain with this effect?")
        public int attackMod = 4;
    }
    public static class RemnantsOfAscension extends ManasSubConfig {
        @Comment("How much attack should a entity gain with this effect?")
        public int attackMod = 4;
    }
}
