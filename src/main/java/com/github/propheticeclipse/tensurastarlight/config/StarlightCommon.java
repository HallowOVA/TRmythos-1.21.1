package com.github.propheticeclipse.tensurastarlight.config;

import io.github.manasmods.manascore.config.api.Comment;
import io.github.manasmods.manascore.config.api.ManasConfig;
import io.github.manasmods.manascore.config.api.ManasSubConfig;
import io.github.manasmods.manascore.config.api.SyncToClient;
import io.github.manasmods.tensura.config.race.RaceConfig;

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

    public abstract static class RaceDefault extends RaceConfig.Default {
        // Tensura Additional Attributes
        public abstract double getAbilityLearnGain();
        public abstract double getAbilityMasterGain();
        public abstract double getAnalysisDistance();
        public abstract double getAnalysisLevel();
        public abstract double getAuraRegenMulti();
        public abstract double getManaRegenMulti();
        public abstract double getShpRegen();
        public abstract double getChantSpeed();
        public abstract double getDarkVision();
        public abstract double getMagicCostMulti();
        public abstract double getPresenceConcealment();
        public abstract double getPresenceSense();
        public abstract double getPresenceSenseRange();
        // Apotheosis Additional Attributes
        public abstract double getArmorPierce();
        public abstract double getArmorShred();
        public abstract double getArrowDamage();
        public abstract double getArrowVelocity();
        public abstract double getCritChance();
        public abstract double getCritDamage();
        public abstract double getHealingRecieved();
        public abstract double getOverHeal();
        public abstract double getLifeSteal();
        public abstract double getCurrentHealthDamage();
        public abstract double getDodgeChance();
        public abstract double getDrawSpeed();
        public abstract double getExperienceGained();
        public abstract double getProjDamage();
        public abstract double getProtPierce();
        public abstract double getProtShred();
        // Minecraft Additional Attributes
        public abstract double getArmor();
        public abstract double getArmorToughness();
        public abstract double getAttackKnockback();
        public abstract double getBlockBreakSpeed();
        public abstract double getBlockInteractionRange();
        public abstract double getEntityInteractionRange();
        public abstract double getExplosionKnockbackResistance();
        public abstract double getStepHeight();
        public abstract double getMiningEfficiency();
        public abstract double getMovementEfficiency();
        public abstract double getWaterMovementEfficiency();
        public abstract double getSubmergedMiningSpeed();
        public abstract double getFallDamageMultiplier();
        public abstract double getLuck();
        public abstract double getGravity();
        public abstract double getOxygenBonus();
        public abstract double getSneakingSpeed();
        public abstract double getSweepingDamageRatio();
        public abstract double getSafeFallDistance();
        // Ars Nouveau Additional Attributes
        public abstract double getDrygmyLootingModifier();
        public abstract double getWixiePotionDuration();
        public abstract double getWhirlsprigSaturationModifier();
        public abstract double getSpellDamageBonus();
        public abstract double getMaxMana();
        public abstract double getManaRegen();
        public abstract double getFeather();
        public abstract double getWarding();
        public abstract double getWeight();

        public abstract double getFireSpellDamage();
        public abstract double getFireSpellResistance();
        public abstract double getWaterSpellDamage();
        public abstract double getWaterSpellResistance();
        public abstract double getEarthSpellDamage();
        public abstract double getEarthSpellResistance();
        public abstract double getAirSpellDamage();
        public abstract double getAirSpellResistance();
        public abstract double getAbjurationSpellPower();
        public abstract double getAbjurationSpellResistance();
        public abstract double getManipulationSpellPower();
        public abstract double getManipulationSpellResistance();
        public abstract double getNecromancySpellPower();
        public abstract double getNecromancySpellResistance();
        public abstract double getSummonSpellPower();
        public abstract double getConjurationSpellResistance();
        public abstract double getElementalSpellPower();
        public abstract double getElementalSpellResistance();
        public abstract double getManaDiscount();
        public abstract double getSpellCriticalChance();
        public abstract double getSpellCriticalDamage();
        // Malum Additional Attributes
        public abstract double getArcaneResonance();
        public abstract double getChargeCapacity();
        public abstract double getChargeDuration();
        public abstract double getChargeRecoveryRate();
        public abstract double getGeasLimit();
        public abstract double getMalignantAegisCapacity();
        public abstract double getMalignantAegisRecoveryGain();
        public abstract double getMalignantAegisRecoveryRate();
        public abstract double getMalignantConversion();
        public abstract double getScytheProficiency();
        public abstract double getSoulWardCapacity();
        public abstract double getSoulWardIntegrity();
        public abstract double getSoulWardRecoveryGain();
        public abstract double getSoulWardRecoveryRate();
        public abstract double getSpiritSpoils();
        public abstract double getMagicDamage();
        public abstract double getMagicProficiency();
        public abstract double getMagicResistance();
    }
}
