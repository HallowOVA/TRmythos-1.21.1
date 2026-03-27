package com.github.propheticeclipse.tensurastarlight.config.skills;

import com.github.propheticeclipse.tensurastarlight.config.effects.BuffEffectsConfig;
import io.github.manasmods.manascore.config.api.Comment;
import io.github.manasmods.manascore.config.api.ManasConfig;
import io.github.manasmods.manascore.config.api.ManasSubConfig;

public class aspectSeriesSkillConfig extends ManasConfig {
    public LightRemains LightRemains = new LightRemains();
    public EchoEndures EchoEndures = new EchoEndures();
    public LifeReturns LifeReturns = new LifeReturns();
    public EmberRemains EmberRemains = new EmberRemains();
    public ShapeForgotten ShapeForgotten = new ShapeForgotten();
    public CurrentUnbroken CurrentUnbroken = new CurrentUnbroken();

    public VestigesOfEidolons VestigesOfEidolons = new VestigesOfEidolons();
    public RemnantsOfAscension RemnantsOfAscension = new RemnantsOfAscension();

    public String getFileName() {
        return "tensura/tensura-starlight/skills/aspect-series";
    }

    public static class LightRemains extends ManasSubConfig {
        @Comment("What level should the Light/Darkness spirits be to acquire Light Remains for free?\nLevel 2 = Medium Spirit\nLevel 3 = Greater Spirit\nLevel 4 = Spirit Lord\n")
        public int skillFreeSpiritLevel = 4;
        @Comment("What level should the Light/Darkness spirits be to acquire Light Remains at cost?")
        public int skillAcquireSpiritLevel = 3;
        @Comment("How much MP should Light Remains cost to acquire/plunder/copy under normal circumstances?")
        public double magiculeAcquirementCost = 75000.0;
        @Comment("How much mastery should Light Remains have by default?\nAny value above 1 = X Mastery at acquirement\n0 = Must be learned\nAny value below 0 = Requires X Learn Points")
        public int acquirementMastery = 1;

        @Comment("How much aura gain percent should Light Remains grant to its user? 1 = 1%, 100 = 100%")
        public double auraGainPercent = 0.75;
        @Comment("How much mana gain percent should Light Remains grant to its user? 1 = 1%, 100 = 100%")
        public double manaGainPercent = 2.25;

        @Comment("How much mana should Blinding Light cost to activate?")
        public double blindingLightManaCost = 500.0;
        @Comment("How much mana should Overbearing Light cost to activate?")
        public double overbearingLightManaCost = 1200.0;

        @Comment("How much should the damage modifier to Light Damage be?")
        public double damageModMastered = 3.0;
        @Comment("How much should the damage modifier to Light Damage be?")
        public double damageModUnmastered = 1.5;

        @Comment("How much extra MP should the user get when killing a target with Overbearing Light?\n1.0 = 100%, 0.01 = 1%")
        public double overbearingLightManaGain = 0.05;

        @Comment("What should the cone angle of Blinding Light be?")
        public double blindingLightConeAngle = 60.0;
        @Comment("What should the cone length of Blinding Light be?")
        public double blindingLightConeLength = 11.0;
        @Comment("What should the Mastered Damage of Blinding Light be?")
        public float blindingLightDamageMastered = 20;
        @Comment("What should the Unmastered Damage of Blinding Light be?")
        public float blindingLightDamageUnmastered = 10;
        @Comment("How long should the darkness effect applied by Blinding Light last?\nDuration in ticks (20t = 1s)")
        public int blindingLightDarknessDuration = 100;
        @Comment("What should the darkness effect amplifier be?\nAmplifier 0 = Level 1")
        public int blindingLightDarknessAmplifier = 0;
        @Comment("How long should Blinding Light go on cooldown for when used?\nTime in seconds")
        public int blindingLightCooldown = 2;

        @Comment("What should the Mastered Damage of Overbearing Light be?")
        public float overbearingLightDamageMastered = 80;
        @Comment("What should the Unmastered Damage of Overbearing Light be?")
        public float overbearingLightDamageUnmastered = 40;
        @Comment("What should the range of Overbearing Light be?")
        public double overbearingLightRange = 10.0;
        @Comment("How long should Overbearing Light go on cooldown for when used?\nTime in seconds")
        public int overbearingLightCooldown = 6;
    }
    public static class EchoEndures extends ManasSubConfig {
        @Comment("How much MP should Echo Endures cost to acquire/plunder/copy under normal circumstances?")
        public double magiculeAcquirementCost = 100000.0;
        @Comment("How much mastery should Echo Endures have by default?\nAny value above 1 = X Mastery at acquirement\n0 = Must be learned\nAny value below 0 = Requires X Learn Points")
        public int acquirementMastery = 1;

        @Comment("What should the silence effect amplifier be?\nAmplifier 0 = Level 1")
        public int silenceAmplifier = 0;
        @Comment("How long should the silence effect last mastered?\nDuration in ticks (20t = 1s)")
        public int silenceDurationMastered = 120;
        @Comment("How long should the silence effect last unmastered?\nDuration in ticks (20t = 1s)")
        public int silenceDurationUnmastered = 60;

        @Comment("How much mana should Sound Burst cost to activate?")
        public double soundBurstManaCost = 750.0;
        @Comment("What should be the cone angle of Sound Burst be?")
        public double soundBurstConeAngle = 160.0;
        @Comment("What should be the cone length of Sound Burst be?")
        public double soundBurstConeLength = 8.0;
        @Comment("How much damage should Sound Burst do mastered?")
        public float soundBurstMasteredDamage = 10;
        @Comment("How much damage should Sound Burst do unmastered?")
        public float soundBurstUnmasteredDamage = 5;
        @Comment("How long should Sound Burst go on cooldown when activated?\nTime in seconds.")
        public int soundBurstCooldown = 2;

    }
    public static class LifeReturns extends ManasSubConfig {
        @Comment("How much MP should Life Returns cost to acquire/plunder/copy under normal circumstances?")
        public double magiculeAcquirementCost = 100000.0;
        @Comment("How many times more MP should Life Returns need to acquire without Death Count or Magicule Poisoning")
        public double overCostAcquirementMod = 2.0;
        @Comment("How much mastery should Life Returns have by default?\nAny value above 1 = X Mastery at acquirement\n0 = Must be learned\nAny value below 0 = Requires X Learn Points")
        public int acquirementMastery = 1;
        @Comment("How many deaths should be required to unlock this instead of by OverCostAcquirement, or Magicule Poisoning?")
        public int deathCount = 10;

        @Comment("How much MP should be necessary to regenerate health when Life Returns is mastered?")
        public int regenMPCostMastered = 50;
        @Comment("How much MP should be necessary to regenerate health when Life Returns is unmastered?")
        public int regenMPCostUnmastered = 100;
        @Comment("How much health should be regenerated when Life Returns is mastered?")
        public int regenHPAmountMastered = 10;
        @Comment("How much health should be regenerated when Life Returns is unmastered?")
        public int regenHPAmountUnmastered = 5;
        @Comment("How much spiritual health should be regenerated when Life Returns is mastered?")
        public int regenSHPAmountMastered = 2;
        @Comment("How much spiritual health should be regenerated when Life Returns is unmastered?")
        public int regenSHPAmountUnmastered = 1;

        @Comment("How much health should the player revive with when bypassing death with Life Returns?\n1.0 = 100% of Health")
        public double deathBypassHealthReturn = 0.01;
        @Comment("How long should Life Returns go on cooldown after bypassing death?\nTime in seconds.")
        public int deathBypassCooldown = 1200;
    }
    public static class EmberRemains extends ManasSubConfig {
        @Comment("How much MP should Ember Remains cost to acquire/plunder/copy under normal circumstances?")
        public double magiculeAcquirementCost = 100000.0;
        @Comment("How much mastery should Ember Remains have by default?\nAny value above 1 = X Mastery at acquirement\n0 = Must be learned\nAny value below 0 = Requires X Learn Points")
        public int acquirementMastery = 1;
        @Comment("How many totems should be necessary to be used to unlock Ember Remains?")
        public int defyFateCount = 3;

        @Comment("How much health should the player revive with when bypassing death with Ember Remains?\n1.0 = 100% of Health")
        public double deathBypassHealthReturn = 0.1;
        @Comment("How long should Ember Remains go on cooldown after bypassing death?\nTime in seconds.")
        public int deathBypassCooldown = 600;
        @Comment("What should the Strengthen effect amplifier be?\nAmplifier 0 = Level 1")
        public int deathBypassStrengthenAmplifier = 1;
        @Comment("What should the Resistance effect amplifier be?\nAmplifier 0 = Level 1")
        public int deathBypassResistanceAmplifier = 1;
        @Comment("How long should the Strengthen effect last?\nDuration in ticks (20t = 1s)")
        public int deathBypassStrengthenDuration = 1200;
        @Comment("How long should the Resistance effect last?\nDuration in ticks (20t = 1s)")
        public int deathBypassResistanceDuration = 1200;

        @Comment("How long should you get Combat Flow on the first hit?\nDuration in ticks (20t = 1s)")
        public int combatFlowDurationFirstHit = 100;
        @Comment("How long should you get Combat Flow on consecutive hits?\nDuration in ticks (20t = 1s)")
        public int combatFlowDurationConsecutiveHit = 50;
        @Comment("How long of a duration is needed for each consecutive level of Combat Flow?\nDuration in ticks (20t = 1s)")
        public int combatFlowAmpliDurationScaling = 200;
        @Comment("What should the max level of Combat Flow be when obtained from Ember Remains?\nAmplifier 0 = Level 1")
        public int combatFlowMaxAmplifier = 9;

        @Comment("How much MP should Kindle Flames cost per effect's duration extended.")
        public int kindleFlamesManaCost = 2000;
        @Comment("How long should Kindle Flames go on cooldown after activation?\nTime in seconds.")
        public int kindleFlamesCooldown = 30;
        @Comment("How long of a duration should Kindle Flames increase effects by?\nDuration in ticks (20t = 1s)")
        public int kindleFlamesDurationIncrease = 1200;

    }
    public static class ShapeForgotten extends ManasSubConfig {
        @Comment("How much MP should Shape Forgotten cost to acquire/plunder/copy under normal circumstances?")
        public double magiculeAcquirementCost = 100000.0;
        @Comment("How much mastery should Shape Forgotten have by default?\nAny value above 1 = X Mastery at acquirement\n0 = Must be learned\nAny value below 0 = Requires X Learn Points")
        public int acquirementMastery = 1;

        @Comment("How much damage is needed to trigger Shifting Armor?")
        public int shiftingArmorDamageTrigger = 10;
        @Comment("How long should you get Shifting Armor on the first hit?\nDuration in ticks (20t = 1s)")
        public int shiftingArmorDurationFirstHit = 100;
        @Comment("How long should you get Shifting Armor on consecutive hits?\nDuration in ticks (20t = 1s)")
        public int shiftingArmorDurationConsecutiveHit = 50;
        @Comment("How long of a duration is needed for each consecutive level of Shifting Armor?\nDuration in ticks (20t = 1s)")
        public int shiftingArmorAmpliDurationScaling = 300;
        @Comment("What should the max level of Shifting Armor be when obtained from Shape Forgotten?\nAmplifier 0 = Level 1")
        public int armorBuffMaxAmplifier = 9;

        @Comment("How much damage should be negated per level of Shifting Armor while mastered.")
        public double damageNegationMastered = 4.0;
        @Comment("How much damage should be negated per level of Shifting Armor while unmastered.")
        public double damageNegationUnmastered = 2.0;
        @Comment("How much damage while at low HP should be negated per level of Shifting Armor while mastered.")
        public double damageNegationLowHPMastered = 5.0;
        @Comment("How much damage while at low HP should be negated per level of Shifting Armor while unmastered.")
        public double damageNegationLowHPUnmastered = 3.0;
        @Comment("How at what point should your health be considered low HP?\n0.1 = 10% of Health.")
        public double damageNegationLowHPThresh = 0.4;

        @Comment("How much MP should each level removed by Shifting Form cost?")
        public double shiftingFormMPCost = 750.0;
        @Comment("How long should Shifting Form go on cooldown after activation?\nTime in seconds.")
        public int shiftingFormCooldown = 30;
    }
    public static class CurrentUnbroken extends ManasSubConfig {
        @Comment("How much MP should Current Unbroken cost to acquire/plunder/copy under normal circumstances?")
        public double magiculeAcquirementCost = 100000.0;
        @Comment("How much mastery should Current Unbroken have by default?\nAny value above 1 = X Mastery at acquirement\n0 = Must be learned\nAny value below 0 = Requires X Learn Points")
        public int acquirementMastery = 1;
        @Comment("How many nether stars need to be picked up to Acquire Current Unbroken?")
        public int netherStars = 1;
        @Comment("How much more damage should Tensura Magic do with Current Unbroken?\n1.25 = 25% Boost")
        public double tensuraMagicDamageModifier = 1.25;
        @Comment("How much magic damage should Current Unbroken resist?\n0.8 = 20% reduction")
        public double magicDamageResistance = 0.8;
        @Comment("How much magic damage should be resisted at max mastered?")
        public int magicDamageResistCapMastered = 500;
        @Comment("How much magic damage should be resisted at max unmastered?")
        public int magicDamageResistCapUnmastered = 100;
        @Comment("How much MP should be regenerated while standing still mastered?")
        public double masteredMPRegen = 50;
        @Comment("How much MP should be regenerated while standing still unmastered?")
        public double unmasteredMPRegen = 25;
    }

    public static class VestigesOfEidolons extends ManasSubConfig {
        @Comment("How much MP should Vestiges of Eidolons cost to acquire/plunder/copy under normal circumstances?")
        public double magiculeAcquirementCost = 150000.0;
        @Comment("How much mastery should Vestiges of Eidolons have by default?\nAny value above 1 = X Mastery at acquirement\n0 = Must be learned\nAny value below 0 = Requires X Learn Points")
        public int acquirementMastery = 1;
        @Comment("How much crit rate should Strike the Vestige grant?\n0.1 = 10%")
        public double strikeCritRate = 0.1;
        @Comment("How much crit damage should Strike the Vestige grant?\n0.1 = 10%")
        public double strikeCritDamage = 0.15;
        @Comment("How much MP should Solar Echo cost to activate?")
        public double solarEchoMPCost = 8000;
        @Comment("How much MP should Judgement of Past cost to activate?")
        public double judgementMPCost = 12000;

        @Comment("How much HP should Immutable Being regenerate mastered?")
        public float immutableBeingHPRegenMastered = 50;
        @Comment("How much HP should Immutable Being regenerate unmastered?")
        public float immutableBeingHPRegenUnmastered = 25;
        @Comment("How much SHP should Immutable Being regenerate mastered?")
        public float immutableBeingSHPRegenMastered = 10;
        @Comment("How much SHP should Immutable Being regenerate unmastered?")
        public float immutableBeingSHPRegenUnmastered = 5;
        @Comment("How much MP% should Immutable Being regenerate?\n0.1 = 10%")
        public double immutableBeingMPRegenPercent = 0.0025;
        @Comment("How much AP% should Immutable Being regenerate?\n0.1 = 10%")
        public double immutableBeingAPRegenPercent = 0.0025;

        @Comment("How much Presence Sense should Magicule Observation grant?")
        public int presenceSenseLevel = 3;
        @Comment("How much Heat Sense Radius should Magicule Observation grant?")
        public double heatSenseRadius = 10.0F;
        @Comment("How much Soundwave Sense Radius should Magicule Observation grant?")
        public double soundSenseRadius = 10.0F;

        @Comment("How often should Vestiges of Eidolons allow bypassing death?\nTime in seconds.")
        public int deathBypassCooldownMastered = 800;
        @Comment("How often should Vestiges of Eidolons allow bypassing death?\nTime in seconds.")
        public int deathBypassCooldownUnmastered = 1200;
        @Comment("How much health should you return to after Bypassing Death?\n0.1 = 10%")
        public double deathBypassHealthReturn = 0.1;

        @Comment("What should be the damage modifier with Light and Dark elements mastered?")
        public double lightDarkElementModMastered = 3.0;
        @Comment("What should be the damage modifier with Light and Dark elements unmastered?")
        public double lightDarkElementModUnmastered = 1.5;
        @Comment("What should be the damage modifier against concealed targets mastered?")
        public double concealedTargetDamageModMastered = 1.5;
        @Comment("What should be the damage modifier against concealed targets unmastered?")
        public double concealedTargetDamageModUnmastered = 1.25;

        @Comment("What should the cone angle of Solar Echo be?")
        public double solarEchoConeAngle = 160.0;
        @Comment("What should the cone length of Solar Echo be?")
        public double solarEchoConeLength = 13.0;
        @Comment("What should the damage of Solar Echo be mastered?")
        public float solarEchoDamageMastered = 100;
        @Comment("What should the damage of Solar Echo be unmastered?")
        public float solarEchoDamageUnmastered = 50;

        @Comment("I will add good comments later, fuck off.")
        public int solarEchoDarknessDuration = 100;
        public int solarEchoDarknessAmplifier = 1;
        public int solarEchoFragilityDuration = 100;
        public int solarEchoFragilityAmplifier = 1;
        public int solarEchoSilenceDuration = 100;
        public int solarEchoSilenceAmplifier = 0;
        public int solarEchoCooldown = 2;

        public double judgementConeAngle = 90.0;
        public double judgementConeLength =16.0;
        public float judgementFirstDamageMastered = 40;
        public float judgementFirstDamageUnmastered = 20;
        public float judgementSecondDamageMastered = 200;
        public float judgementSecondDamageUnmastered = 80;
        public int judgementCooldown = 20;
    }
    public static class RemnantsOfAscension extends ManasSubConfig {
        @Comment("How much MP should Remnants of Ascension cost to acquire/plunder/copy under normal circumstances?")
        public double magiculeAcquirementCost = 150000.0;
        @Comment("How much mastery should Remnants of Ascension have by default?\nAny value above 1 = X Mastery at acquirement\n0 = Must be learned\nAny value below 0 = Requires X Learn Points")
        public int acquirementMastery = 1;

        public double existenceMPRegenMastered = 40.0;
        public double existenceMPRegenUnmastered = 20.0;
        public double existenceAPRegenMastered = 40.0;
        public double existenceAPRegenUnmastered = 20.0;

        public double coreFractureAttackMod = 0.25;
        public double coreFractureCritDamageMod = 0.5;
        public double coreFractureArmorShredMod = 0.05;
        public double coreFractureProtPierceMod = 8.0;

        public float damageNegationMastered = 10;
        public float damageNegationUnmastered = 5;

        public int shiftingFormDamageTrigger = 10;
        public int shiftingFormDurationFirstHit = 100;
        public int shiftingFormDurationConsecutiveHit = 50;
        public int shiftingFormAmpliDurationScaling = 300;
        public int shiftingFormBuffMaxAmplifier = 9;

        public double elementalDamageResistanceMod = 0.8;
        public int elementalDamageNegationCapMastered = 1000;
        public int elementalDamageNegationCapUnmastered = 500;

        public double deathBypassHealthReturn = 0.1;
        public double deathBypassSpiritualHealthReturnThresh = 0.1;
        public double deathBypassSpiritualHealthReturn = 0.1;
        public int deathBypassCooldown = 600;
        public int deathBypassResistanceDuration = 1200;
        public int deathBypassResistanceAmplifier = 2;

        public int flaringFormCooldownMastered = 15;
        public int flaringFormCooldownUnmastered = 30;

        public int flaringFormBuffDurationBonus = 1200;
        public int flaringFormBuffMPCostPerDurationBonus = 2500;
        public int flaringFormDebuffMPCostPerLevel = 1000;
    }
}
