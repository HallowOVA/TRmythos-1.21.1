package com.github.propheticeclipse.tensurastarlight.config.races;

import com.github.propheticeclipse.tensurastarlight.config.StarlightCommon;
import io.github.manasmods.manascore.config.api.Comment;
import io.github.manasmods.manascore.config.api.ManasConfig;
import io.github.manasmods.tensura.config.race.RaceConfig;

import java.util.List;

public class aspectBornRaceConfig extends ManasConfig {
    public lesserAspectBorn lesserAspectBorn = new lesserAspectBorn();
    public aspectBorn aspectBorn = new aspectBorn();
    public greaterAspectBorn greaterAspectBorn = new greaterAspectBorn();

    public lesserConvergenceBorn lesserConvergenceBorn = new lesserConvergenceBorn();
    public convergenceBorn convergenceBorn = new convergenceBorn();
    public greaterConvergenceBorn greaterConvergenceBorn = new greaterConvergenceBorn();
    public elderConvergenceBorn elderConvergenceBorn = new elderConvergenceBorn();

    public lesserMemoryBorn lesserMemoryBorn = new lesserMemoryBorn();
    public memoryBorn memoryBorn = new memoryBorn();
    public greaterMemoryBorn greaterMemoryBorn = new greaterMemoryBorn();
    public grandMemoryBorn grandMemoryBorn = new grandMemoryBorn();

    public falseAspectOfRegression falseAspectOfRegression = new falseAspectOfRegression();
    public aspectOfRegression aspectOfRegression = new aspectOfRegression();
    public mythos mythos = new mythos();

    public String getFileName() {
        return "tensura/tensura-starlight/races/aspectborn";
    }

    public static class lesserAspectBorn extends StarlightCommon.RaceDefault {
        @Comment("What should the minimum Aura (AP) of this race be?")
        public double minAura = (double)500.0F;
        @Comment("What should the maximum Aura (AP) of this race be?")
        public double maxAura = (double)500.0F;
        @Comment("What should the minimum Mana (MP) of this race be?")
        public double minMagicule = (double)500.0F;
        @Comment("What should the maximum Mana (MP) of this race be?")
        public double maxMagicule = (double)500.0F;


        @Comment("What should the additonal size modifier of this race be?")
        public double size = -0.75;

        @Comment("How much additional Max Health should this race have? (Can be Negative)")
        public double maxHealth = (double)-19.0F;
        @Comment("How much additional Max Spiritual Health should this race have? (Can be Negative)")
        public double maxSpiritualHealth = (double)-55.0F;

        @Comment("How much additional Attack Damage should this race have? (Can be Negative)")
        public double attack = -1.0;
        @Comment("How much additional Attack Speed should this race have? (Can be Negative)")
        public double attackSpeed = -1.0;

        @Comment("How much additional Knockback Resistance should this race have? (Can be Negative)")
        public double knockbackResistance = -1.0;

        @Comment("How much additional Movement Speed should this race have? (Can be Negative), (Default Movement Speed is 0.1)")
        public double movementSpeed = 0.00;
        @Comment("How much additional Swim Speed should this race have? (Can be Negative)")
        public double swimSpeed = 0.0;

        // Additional Tensura Attributes
        public double abilityLearnGain = 0.0;
        public double abilityMasterGain = 0.0;
        public double analysisDistance = 0.0;
        public double analysisLevel = 0.0;
        public double auraRegenMulti = 0.0;
        public double manaRegenMulti = 0.0;
        public double shpRegen = 0.0;
        public double chantSpeed = 0.0;
        public double darkVision = 0.0;
        public double magicCostMulti = 0.0;
        public double presenceConcealment = 0.0;
        public double presenceSense = 0.0;
        public double presenceSenseRange = 0.0;
        // Additional Apotheosis Attributes
        public double armorPierce = 0.0;
        public double armorShred = 0.0;
        public double arrowDamage = 0.0;
        public double arrowVelocity = 0.0;
        public double critChance = 0.0;
        public double critDamage = 0.0;
        public double healingRecieved = 0.0;
        public double overHeal = 0.0;
        public double lifeSteal = 0.0;
        public double currentHealthDamage = 0.0;
        public double dodgeChance = 0.0;
        public double drawSpeed = 0.0;
        public double experienceGained = 0.0;
        public double projDamage = 0.0;
        public double protPierce = 0.0;
        public double protShred = 0.0;
        // Additional Minecraft Attributes
        public double armor = 0.0;
        public double armorToughness = 0.0;
        public double attackKnockback = 0.0;
        public double blockBreakSpeed = 0.0;
        public double blockInteractionRange = 0.0;
        public double entityInteractionRange = 0.0;
        public double explosionKnockbackResistance = 0.0;
        public double stepHeight = 0.4;
        public double miningEfficiency = 0.0;
        public double movementEfficiency = 0.0;
        public double waterMovementEfficiency = 0.0;
        public double submergedMiningSpeed = 0.0;
        public double fallDamageMultiplier = 0.0;
        public double luck = 0.0;
        public double gravity = 0.0;
        public double oxygenBonus = 0.0;
        public double sneakingSpeed = 0.0;
        public double sweepingDamageRatio = 0.0;
        public double safeFallDistance = 2.0;
        // Additional Ars Nouveau Attributes
        public double drygmyLootingModifier = 0.0;
        public double wixiePotionDuration = 0.0;
        public double whirlsprigSaturationModifier = 0.0;
        public double spellDamageBonus = 0.0;
        public double maxMana = 0.0;
        public double manaRegen = 0.0;
        public double feather = 0.0;
        public double warding = 0.0;
        public double weight = 0.0;

        public double fireSpellDamage = 0.0;
        public double fireSpellResistance = 0.0;
        public double waterSpellDamage = 0.0;
        public double waterSpellResistance = 0.0;
        public double earthSpellDamage = 0.0;
        public double earthSpellResistance = 0.0;
        public double airSpellDamage = 0.0;
        public double airSpellResistance = 0.0;
        public double abjurationSpellPower = 0.0;
        public double abjurationSpellResistance = 0.0;
        public double manipulationSpellPower = 0.0;
        public double manipulationSpellResistance = 0.0;
        public double necromancySpellPower = 0.0;
        public double necromancySpellResistance = 0.0;
        public double summonSpellPower = 0.0;
        public double conjurationSpellResistance = 0.0;
        public double elementalSpellPower = 0.0;
        public double elementalSpellResistance = 0.0;
        public double manaDiscount = 0.0;
        public double spellCriticalChance = 0.0;
        public double spellCriticalDamage = 0.0;
        // Additional Malum Attributes
        public double arcaneResonance = 0.0;
        public double chargeCapacity = 0.0;
        public double chargeDuration = 0.0;
        public double chargeRecoveryRate = 0.0;
        public double geasLimit = 0.0;
        public double malignantAegisCapacity = 0.0;
        public double malignantAegisRecoveryGain = 0.0;
        public double malignantAegisRecoveryRate = 0.0;
        public double malignantConversion = 0.0;
        public double scytheProficiency = 0.0;
        public double soulWardCapacity = 0.0;
        public double soulWardIntegrity = 0.0;
        public double soulWardRecoveryGain = 0.0;
        public double soulWardRecoveryRate = 0.0;
        public double spiritSpoils = 0.0;
        public double magicDamage = 0.0;
        public double magicProficiency = 0.0;
        public double magicResistance = 0.0;

        @Comment("What intrinsics should this race have?")
        public List<String> lesserAspectBornIntrinsics = List.of("tensura:possession", "tensura:danger_sense");

        public double getMinAura() {
            return this.minAura;
        }
        public double getMaxAura() {
            return this.maxAura;
        }
        public double getMinMagicule() {
            return this.minMagicule;
        }
        public double getMaxMagicule() {
            return this.maxMagicule;
        }
        public double getSize() {
            return this.size;
        }
        public double getMaxHealth() {
            return this.maxHealth;
        }
        public double getMaxSpiritualHealth() {
            return this.maxSpiritualHealth;
        }
        public double getAttack() {
            return this.attack;
        }
        public double getAttackSpeed() {
            return this.attackSpeed;
        }
        public double getKnockbackResistance() {
            return this.knockbackResistance;
        }
        public double getMovementSpeed() {
            return this.movementSpeed;
        }
        public double getSwimSpeed() {
            return this.swimSpeed;
        }
        // Tensura Additional Attributes
        public double getAbilityLearnGain() {
            return this.abilityLearnGain;
        }
        public double getAbilityMasterGain() {
            return this.abilityMasterGain;
        }
        public double getAnalysisDistance() {
            return this.analysisDistance;
        }
        public double getAnalysisLevel() {
            return this.analysisLevel;
        }
        public double getAuraRegenMulti() {
            return this.auraRegenMulti;
        }
        public double getManaRegenMulti() {
            return this.manaRegenMulti;
        }
        public double getShpRegen() {
            return this.shpRegen;
        }
        public double getChantSpeed() {
            return this.chantSpeed;
        }
        public double getDarkVision() {
            return this.darkVision;
        }
        public double getMagicCostMulti() {
            return this.magicCostMulti;
        }
        public double getPresenceConcealment() {
            return this.presenceConcealment;
        }
        public double getPresenceSense() {
            return this.presenceSense;
        }
        public double getPresenceSenseRange() {
            return this.presenceSenseRange;
        }
        // Apotheosis Additional Attributes
        public double getArmorPierce() {
            return this.armorPierce;
        }
        public double getArmorShred() {
            return this.armorShred;
        }
        public double getArrowDamage() {
            return this.arrowDamage;
        }
        public double getArrowVelocity() {
            return this.arrowVelocity;
        }
        public double getCritChance() {
            return this.critChance;
        }
        public double getCritDamage() {
            return this.critDamage;
        }
        public double getHealingRecieved() {
            return this.healingRecieved;
        }
        public double getOverHeal() {
            return this.overHeal;
        }
        public double getLifeSteal() {
            return this.lifeSteal;
        }
        public double getCurrentHealthDamage() {
            return this.currentHealthDamage;
        }
        public double getDodgeChance() {
            return this.dodgeChance;
        }
        public double getDrawSpeed() {
            return this.drawSpeed;
        }
        public double getExperienceGained() {
            return this.experienceGained;
        }
        public double getProjDamage() {
            return this.projDamage;
        }
        public double getProtPierce() {
            return this.protPierce;
        }
        public double getProtShred() {
            return this.protShred;
        }
        // Minecraft Additional Attributes
        public double getArmor() {
            return this.armor;
        }
        public double getArmorToughness() {
            return this.armorToughness;
        }
        public double getAttackKnockback() {
            return this.attackKnockback;
        }
        public double getBlockBreakSpeed() {
            return this.blockBreakSpeed;
        }
        public double getBlockInteractionRange() {
            return this.blockInteractionRange;
        }
        public double getEntityInteractionRange() {
            return this.entityInteractionRange;
        }
        public double getExplosionKnockbackResistance() {
            return this.explosionKnockbackResistance;
        }
        public double getStepHeight() {
            return this.stepHeight;
        }
        public double getMiningEfficiency() {
            return this.miningEfficiency;
        }
        public double getMovementEfficiency() {
            return this.movementEfficiency;
        }
        public double getWaterMovementEfficiency() {
            return this.waterMovementEfficiency;
        }
        public double getSubmergedMiningSpeed() {
            return this.submergedMiningSpeed;
        }
        public double getFallDamageMultiplier() {
            return this.fallDamageMultiplier;
        }
        public double getLuck() {
            return this.luck;
        }
        public double getGravity() {
            return this.gravity;
        }
        public double getOxygenBonus() {
            return this.oxygenBonus;
        }
        public double getSneakingSpeed() {
            return this.sneakingSpeed;
        }
        public double getSweepingDamageRatio() {
            return this.sweepingDamageRatio;
        }
        public double getSafeFallDistance() {
            return this.safeFallDistance;
        }
        // Ars Nouveau Additional Attributes
        public double getDrygmyLootingModifier() {
            return this.drygmyLootingModifier;
        }
        public double getWixiePotionDuration() {
            return this.wixiePotionDuration;
        }
        public double getWhirlsprigSaturationModifier() {
            return this.whirlsprigSaturationModifier;
        }
        public double getSpellDamageBonus() {
            return this.spellDamageBonus;
        }
        public double getMaxMana() {
            return this.maxMana;
        }
        public double getManaRegen() {
            return this.manaRegen;
        }
        public double getFeather() {
            return this.feather;
        }
        public double getWarding() {
            return this.warding;
        }
        public double getWeight() {
            return this.weight;
        }

        public double getFireSpellDamage() {
            return this.fireSpellDamage;
        }
        public double getFireSpellResistance() {
            return this.fireSpellResistance;
        }
        public double getWaterSpellDamage() {
            return this.waterSpellDamage;
        }
        public double getWaterSpellResistance() {
                return this.waterSpellResistance;
        }
        public double getEarthSpellDamage() {
            return this.earthSpellDamage;
        }
        public double getEarthSpellResistance() {
            return this.earthSpellResistance;
        }
        public double getAirSpellDamage() {
            return this.airSpellDamage;
        }
        public double getAirSpellResistance() {
            return this.airSpellResistance;
        }
        public double getAbjurationSpellPower() {
            return this.abjurationSpellPower;
        }
        public double getAbjurationSpellResistance() {
            return this.abjurationSpellResistance;
        }
        public double getManipulationSpellPower() {
            return this.manipulationSpellPower;
        }
        public double getManipulationSpellResistance() {
            return this.manipulationSpellResistance;
        }
        public double getNecromancySpellPower() {
            return this.necromancySpellPower;
        }
        public double getNecromancySpellResistance() {
            return this.necromancySpellResistance;
        }
        public double getSummonSpellPower() {
            return this.summonSpellPower;
        }
        public double getConjurationSpellResistance() {
            return this.conjurationSpellResistance;
        }
        public double getElementalSpellPower() {
            return this.elementalSpellPower;
        }
        public double getElementalSpellResistance() {
            return this.elementalSpellResistance;
        }
        public double getManaDiscount() {
            return this.manaDiscount;
        }
        public double getSpellCriticalChance() {
            return this.spellCriticalChance;
        }
        public double getSpellCriticalDamage() {
            return this.spellCriticalDamage;
        }
        // Malum Additional Attributes
        public double getArcaneResonance() {
            return this.arcaneResonance;
        }
        public double getChargeCapacity() {
            return this.chargeCapacity;
        }
        public double getChargeDuration() {
            return this.chargeDuration;
        }
        public double getChargeRecoveryRate() {
            return this.chargeRecoveryRate;
        }
        public double getGeasLimit() {
            return this.geasLimit;
        }
        public double getMalignantAegisCapacity() {
            return this.malignantAegisCapacity;
        }
        public double getMalignantAegisRecoveryGain() {
            return this.malignantAegisRecoveryGain;
        }
        public double getMalignantAegisRecoveryRate() {
            return this.malignantAegisRecoveryRate;
        }
        public double getMalignantConversion() {
            return this.malignantConversion;
        }
        public double getScytheProficiency() {
            return this.scytheProficiency;
        }
        public double getSoulWardCapacity() {
            return this.soulWardCapacity;
        }
        public double getSoulWardIntegrity() {
            return this.soulWardIntegrity;
        }
        public double getSoulWardRecoveryGain() {
            return this.soulWardRecoveryGain;
        }
        public double getSoulWardRecoveryRate() {
            return this.soulWardRecoveryRate;
        }
        public double getSpiritSpoils() {
            return this.spiritSpoils;
        }
        public double getMagicDamage() {
            return this.magicDamage;
        }
        public double getMagicProficiency() {
            return this.magicProficiency;
        }
        public double getMagicResistance() {
            return this.magicResistance;
        }
    }
    public static class aspectBorn extends StarlightCommon.RaceDefault {
        @Comment("What should the minimum Aura (AP) of this race be?")
        public double minAura = (double)500.0F;
        @Comment("What should the maximum Aura (AP) of this race be?")
        public double maxAura = (double)500.0F;
        @Comment("What should the minimum Mana (MP) of this race be?")
        public double minMagicule = (double)500.0F;
        @Comment("What should the maximum Mana (MP) of this race be?")
        public double maxMagicule = (double)500.0F;


        @Comment("What should the additonal size modifier of this race be?")
        public double size = -0.75;

        @Comment("How much additional Max Health should this race have? (Can be Negative)")
        public double maxHealth = (double)-10.0F;
        @Comment("How much additional Max Spiritual Health should this race have? (Can be Negative)")
        public double maxSpiritualHealth = (double)-10.0F;

        @Comment("How much additional Attack Damage should this race have? (Can be Negative)")
        public double attack = 0.0;
        @Comment("How much additional Attack Speed should this race have? (Can be Negative)")
        public double attackSpeed = -1.0;

        @Comment("How much additional Knockback Resistance should this race have? (Can be Negative)")
        public double knockbackResistance = -1.0;

        @Comment("How much additional Movement Speed should this race have? (Can be Negative), (Default Movement Speed is 0.1)")
        public double movementSpeed = 0.0;
        @Comment("How much additional Swim Speed should this race have? (Can be Negative)")
        public double swimSpeed = 0.0;

        // Additional Tensura Attributes
        public double abilityLearnGain = 0.0;
        public double abilityMasterGain = 0.0;
        public double analysisDistance = 0.0;
        public double analysisLevel = 0.0;
        public double auraRegenMulti = 0.0;
        public double manaRegenMulti = 0.0;
        public double shpRegen = 0.0;
        public double chantSpeed = 0.0;
        public double darkVision = 0.0;
        public double magicCostMulti = 0.0;
        public double presenceConcealment = 0.0;
        public double presenceSense = 0.0;
        public double presenceSenseRange = 0.0;
        // Additional Apotheosis Attributes
        public double armorPierce = 0.0;
        public double armorShred = 0.0;
        public double arrowDamage = 0.0;
        public double arrowVelocity = 0.0;
        public double critChance = 0.0;
        public double critDamage = 0.0;
        public double healingRecieved = 0.0;
        public double overHeal = 0.0;
        public double lifeSteal = 0.0;
        public double currentHealthDamage = 0.0;
        public double dodgeChance = 0.0;
        public double drawSpeed = 0.0;
        public double experienceGained = 0.0;
        public double projDamage = 0.0;
        public double protPierce = 0.0;
        public double protShred = 0.0;
        // Additional Minecraft Attributes
        public double armor = 0.0;
        public double armorToughness = 0.0;
        public double attackKnockback = 0.0;
        public double blockBreakSpeed = 0.0;
        public double blockInteractionRange = 0.0;
        public double entityInteractionRange = 0.0;
        public double explosionKnockbackResistance = 0.0;
        public double stepHeight = 0.4;
        public double miningEfficiency = 0.0;
        public double movementEfficiency = 0.0;
        public double waterMovementEfficiency = 0.0;
        public double submergedMiningSpeed = 0.0;
        public double fallDamageMultiplier = 0.0;
        public double luck = 0.0;
        public double gravity = 0.0;
        public double oxygenBonus = 0.0;
        public double sneakingSpeed = 0.0;
        public double sweepingDamageRatio = 0.0;
        public double safeFallDistance = 2.0;
        // Additional Ars Nouveau Attributes
        public double drygmyLootingModifier = 0.0;
        public double wixiePotionDuration = 0.0;
        public double whirlsprigSaturationModifier = 0.0;
        public double spellDamageBonus = 0.0;
        public double maxMana = 0.0;
        public double manaRegen = 0.0;
        public double feather = 0.0;
        public double warding = 0.0;
        public double weight = 0.0;

        public double fireSpellDamage = 0.0;
        public double fireSpellResistance = 0.0;
        public double waterSpellDamage = 0.0;
        public double waterSpellResistance = 0.0;
        public double earthSpellDamage = 0.0;
        public double earthSpellResistance = 0.0;
        public double airSpellDamage = 0.0;
        public double airSpellResistance = 0.0;
        public double abjurationSpellPower = 0.0;
        public double abjurationSpellResistance = 0.0;
        public double manipulationSpellPower = 0.0;
        public double manipulationSpellResistance = 0.0;
        public double necromancySpellPower = 0.0;
        public double necromancySpellResistance = 0.0;
        public double summonSpellPower = 0.0;
        public double conjurationSpellResistance = 0.0;
        public double elementalSpellPower = 0.0;
        public double elementalSpellResistance = 0.0;
        public double manaDiscount = 0.0;
        public double spellCriticalChance = 0.0;
        public double spellCriticalDamage = 0.0;
        // Additional Malum Attributes
        public double arcaneResonance = 0.0;
        public double chargeCapacity = 0.0;
        public double chargeDuration = 0.0;
        public double chargeRecoveryRate = 0.0;
        public double geasLimit = 0.0;
        public double malignantAegisCapacity = 0.0;
        public double malignantAegisRecoveryGain = 0.0;
        public double malignantAegisRecoveryRate = 0.0;
        public double malignantConversion = 0.0;
        public double scytheProficiency = 0.0;
        public double soulWardCapacity = 0.0;
        public double soulWardIntegrity = 0.0;
        public double soulWardRecoveryGain = 0.0;
        public double soulWardRecoveryRate = 0.0;
        public double spiritSpoils = 0.0;
        public double magicDamage = 0.0;
        public double magicProficiency = 0.0;
        public double magicResistance = 0.0;

        @Comment("What intrinsics should this race have?")
        public List<String> aspectBornIntrinsics = List.of();

        public double getMinAura() {
            return this.minAura;
        }
        public double getMaxAura() {
            return this.maxAura;
        }
        public double getMinMagicule() {
            return this.minMagicule;
        }
        public double getMaxMagicule() {
            return this.maxMagicule;
        }
        public double getSize() {
            return this.size;
        }
        public double getMaxHealth() {
            return this.maxHealth;
        }
        public double getMaxSpiritualHealth() {
            return this.maxSpiritualHealth;
        }
        public double getAttack() {
            return this.attack;
        }
        public double getAttackSpeed() {
            return this.attackSpeed;
        }
        public double getKnockbackResistance() {
            return this.knockbackResistance;
        }
        public double getMovementSpeed() {
            return this.movementSpeed;
        }
        public double getSwimSpeed() {
            return this.swimSpeed;
        }
        // Tensura Additional Attributes
        public double getAbilityLearnGain() {
            return this.abilityLearnGain;
        }
        public double getAbilityMasterGain() {
            return this.abilityMasterGain;
        }
        public double getAnalysisDistance() {
            return this.analysisDistance;
        }
        public double getAnalysisLevel() {
            return this.analysisLevel;
        }
        public double getAuraRegenMulti() {
            return this.auraRegenMulti;
        }
        public double getManaRegenMulti() {
            return this.manaRegenMulti;
        }
        public double getShpRegen() {
            return this.shpRegen;
        }
        public double getChantSpeed() {
            return this.chantSpeed;
        }
        public double getDarkVision() {
            return this.darkVision;
        }
        public double getMagicCostMulti() {
            return this.magicCostMulti;
        }
        public double getPresenceConcealment() {
            return this.presenceConcealment;
        }
        public double getPresenceSense() {
            return this.presenceSense;
        }
        public double getPresenceSenseRange() {
            return this.presenceSenseRange;
        }
        // Apotheosis Additional Attributes
        public double getArmorPierce() {
            return this.armorPierce;
        }
        public double getArmorShred() {
            return this.armorShred;
        }
        public double getArrowDamage() {
            return this.arrowDamage;
        }
        public double getArrowVelocity() {
            return this.arrowVelocity;
        }
        public double getCritChance() {
            return this.critChance;
        }
        public double getCritDamage() {
            return this.critDamage;
        }
        public double getHealingRecieved() {
            return this.healingRecieved;
        }
        public double getOverHeal() {
            return this.overHeal;
        }
        public double getLifeSteal() {
            return this.lifeSteal;
        }
        public double getCurrentHealthDamage() {
            return this.currentHealthDamage;
        }
        public double getDodgeChance() {
            return this.dodgeChance;
        }
        public double getDrawSpeed() {
            return this.drawSpeed;
        }
        public double getExperienceGained() {
            return this.experienceGained;
        }
        public double getProjDamage() {
            return this.projDamage;
        }
        public double getProtPierce() {
            return this.protPierce;
        }
        public double getProtShred() {
            return this.protShred;
        }
        // Minecraft Additional Attributes
        public double getArmor() {
            return this.armor;
        }
        public double getArmorToughness() {
            return this.armorToughness;
        }
        public double getAttackKnockback() {
            return this.attackKnockback;
        }
        public double getBlockBreakSpeed() {
            return this.blockBreakSpeed;
        }
        public double getBlockInteractionRange() {
            return this.blockInteractionRange;
        }
        public double getEntityInteractionRange() {
            return this.entityInteractionRange;
        }
        public double getExplosionKnockbackResistance() {
            return this.explosionKnockbackResistance;
        }
        public double getStepHeight() {
            return this.stepHeight;
        }
        public double getMiningEfficiency() {
            return this.miningEfficiency;
        }
        public double getMovementEfficiency() {
            return this.movementEfficiency;
        }
        public double getWaterMovementEfficiency() {
            return this.waterMovementEfficiency;
        }
        public double getSubmergedMiningSpeed() {
            return this.submergedMiningSpeed;
        }
        public double getFallDamageMultiplier() {
            return this.fallDamageMultiplier;
        }
        public double getLuck() {
            return this.luck;
        }
        public double getGravity() {
            return this.gravity;
        }
        public double getOxygenBonus() {
            return this.oxygenBonus;
        }
        public double getSneakingSpeed() {
            return this.sneakingSpeed;
        }
        public double getSweepingDamageRatio() {
            return this.sweepingDamageRatio;
        }
        public double getSafeFallDistance() {
            return this.safeFallDistance;
        }
        // Ars Nouveau Additional Attributes
        public double getDrygmyLootingModifier() {
            return this.drygmyLootingModifier;
        }
        public double getWixiePotionDuration() {
            return this.wixiePotionDuration;
        }
        public double getWhirlsprigSaturationModifier() {
            return this.whirlsprigSaturationModifier;
        }
        public double getSpellDamageBonus() {
            return this.spellDamageBonus;
        }
        public double getMaxMana() {
            return this.maxMana;
        }
        public double getManaRegen() {
            return this.manaRegen;
        }
        public double getFeather() {
            return this.feather;
        }
        public double getWarding() {
            return this.warding;
        }
        public double getWeight() {
            return this.weight;
        }

        public double getFireSpellDamage() {
            return this.fireSpellDamage;
        }
        public double getFireSpellResistance() {
            return this.fireSpellResistance;
        }
        public double getWaterSpellDamage() {
            return this.waterSpellDamage;
        }
        public double getWaterSpellResistance() {
            return this.waterSpellResistance;
        }
        public double getEarthSpellDamage() {
            return this.earthSpellDamage;
        }
        public double getEarthSpellResistance() {
            return this.earthSpellResistance;
        }
        public double getAirSpellDamage() {
            return this.airSpellDamage;
        }
        public double getAirSpellResistance() {
            return this.airSpellResistance;
        }
        public double getAbjurationSpellPower() {
            return this.abjurationSpellPower;
        }
        public double getAbjurationSpellResistance() {
            return this.abjurationSpellResistance;
        }
        public double getManipulationSpellPower() {
            return this.manipulationSpellPower;
        }
        public double getManipulationSpellResistance() {
            return this.manipulationSpellResistance;
        }
        public double getNecromancySpellPower() {
            return this.necromancySpellPower;
        }
        public double getNecromancySpellResistance() {
            return this.necromancySpellResistance;
        }
        public double getSummonSpellPower() {
            return this.summonSpellPower;
        }
        public double getConjurationSpellResistance() {
            return this.conjurationSpellResistance;
        }
        public double getElementalSpellPower() {
            return this.elementalSpellPower;
        }
        public double getElementalSpellResistance() {
            return this.elementalSpellResistance;
        }
        public double getManaDiscount() {
            return this.manaDiscount;
        }
        public double getSpellCriticalChance() {
            return this.spellCriticalChance;
        }
        public double getSpellCriticalDamage() {
            return this.spellCriticalDamage;
        }
        // Malum Additional Attributes
        public double getArcaneResonance() {
            return this.arcaneResonance;
        }
        public double getChargeCapacity() {
            return this.chargeCapacity;
        }
        public double getChargeDuration() {
            return this.chargeDuration;
        }
        public double getChargeRecoveryRate() {
            return this.chargeRecoveryRate;
        }
        public double getGeasLimit() {
            return this.geasLimit;
        }
        public double getMalignantAegisCapacity() {
            return this.malignantAegisCapacity;
        }
        public double getMalignantAegisRecoveryGain() {
            return this.malignantAegisRecoveryGain;
        }
        public double getMalignantAegisRecoveryRate() {
            return this.malignantAegisRecoveryRate;
        }
        public double getMalignantConversion() {
            return this.malignantConversion;
        }
        public double getScytheProficiency() {
            return this.scytheProficiency;
        }
        public double getSoulWardCapacity() {
            return this.soulWardCapacity;
        }
        public double getSoulWardIntegrity() {
            return this.soulWardIntegrity;
        }
        public double getSoulWardRecoveryGain() {
            return this.soulWardRecoveryGain;
        }
        public double getSoulWardRecoveryRate() {
            return this.soulWardRecoveryRate;
        }
        public double getSpiritSpoils() {
            return this.spiritSpoils;
        }
        public double getMagicDamage() {
            return this.magicDamage;
        }
        public double getMagicProficiency() {
            return this.magicProficiency;
        }
        public double getMagicResistance() {
            return this.magicResistance;
        }
    }
    public static class greaterAspectBorn extends StarlightCommon.RaceDefault {
        @Comment("What should the minimum Aura (AP) of this race be?")
        public double minAura = (double)500.0F;
        @Comment("What should the maximum Aura (AP) of this race be?")
        public double maxAura = (double)500.0F;
        @Comment("What should the minimum Mana (MP) of this race be?")
        public double minMagicule = (double)500.0F;
        @Comment("What should the maximum Mana (MP) of this race be?")
        public double maxMagicule = (double)500.0F;


        @Comment("What should the additonal size modifier of this race be?")
        public double size = -0.5;

        @Comment("How much additional Max Health should this race have? (Can be Negative)")
        public double maxHealth = (double)25.0F;
        @Comment("How much additional Max Spiritual Health should this race have? (Can be Negative)")
        public double maxSpiritualHealth = (double)165.0F;

        @Comment("How much additional Attack Damage should this race have? (Can be Negative)")
        public double attack = 0.0;
        @Comment("How much additional Attack Speed should this race have? (Can be Negative)")
        public double attackSpeed = -1.0;

        @Comment("How much additional Knockback Resistance should this race have? (Can be Negative)")
        public double knockbackResistance = 0.0;

        @Comment("How much additional Movement Speed should this race have? (Can be Negative), (Default Movement Speed is 0.1)")
        public double movementSpeed = 0.00;
        @Comment("How much additional Swim Speed should this race have? (Can be Negative)")
        public double swimSpeed = 0.0;

        // Additional Tensura Attributes
        public double abilityLearnGain = 0.0;
        public double abilityMasterGain = 0.0;
        public double analysisDistance = 0.0;
        public double analysisLevel = 0.0;
        public double auraRegenMulti = 0.0;
        public double manaRegenMulti = 0.0;
        public double shpRegen = 0.0;
        public double chantSpeed = 0.0;
        public double darkVision = 0.0;
        public double magicCostMulti = 0.0;
        public double presenceConcealment = 0.0;
        public double presenceSense = 0.0;
        public double presenceSenseRange = 0.0;
        // Additional Apotheosis Attributes
        public double armorPierce = 0.0;
        public double armorShred = 0.0;
        public double arrowDamage = 0.0;
        public double arrowVelocity = 0.0;
        public double critChance = 0.0;
        public double critDamage = 0.0;
        public double healingRecieved = 0.0;
        public double overHeal = 0.0;
        public double lifeSteal = 0.0;
        public double currentHealthDamage = 0.0;
        public double dodgeChance = 0.0;
        public double drawSpeed = 0.0;
        public double experienceGained = 0.0;
        public double projDamage = 0.0;
        public double protPierce = 0.0;
        public double protShred = 0.0;
        // Additional Minecraft Attributes
        public double armor = 0.0;
        public double armorToughness = 0.0;
        public double attackKnockback = 0.0;
        public double blockBreakSpeed = 0.0;
        public double blockInteractionRange = 0.0;
        public double entityInteractionRange = 0.0;
        public double explosionKnockbackResistance = 0.0;
        public double stepHeight = 0.4;
        public double miningEfficiency = 0.0;
        public double movementEfficiency = 0.0;
        public double waterMovementEfficiency = 0.0;
        public double submergedMiningSpeed = 0.0;
        public double fallDamageMultiplier = 0.0;
        public double luck = 0.0;
        public double gravity = 0.0;
        public double oxygenBonus = 0.0;
        public double sneakingSpeed = 0.0;
        public double sweepingDamageRatio = 0.0;
        public double safeFallDistance = 2.0;
        // Additional Ars Nouveau Attributes
        public double drygmyLootingModifier = 0.0;
        public double wixiePotionDuration = 0.0;
        public double whirlsprigSaturationModifier = 0.0;
        public double spellDamageBonus = 0.0;
        public double maxMana = 0.0;
        public double manaRegen = 0.0;
        public double feather = 0.0;
        public double warding = 0.0;
        public double weight = 0.0;

        public double fireSpellDamage = 0.0;
        public double fireSpellResistance = 0.0;
        public double waterSpellDamage = 0.0;
        public double waterSpellResistance = 0.0;
        public double earthSpellDamage = 0.0;
        public double earthSpellResistance = 0.0;
        public double airSpellDamage = 0.0;
        public double airSpellResistance = 0.0;
        public double abjurationSpellPower = 0.0;
        public double abjurationSpellResistance = 0.0;
        public double manipulationSpellPower = 0.0;
        public double manipulationSpellResistance = 0.0;
        public double necromancySpellPower = 0.0;
        public double necromancySpellResistance = 0.0;
        public double summonSpellPower = 0.0;
        public double conjurationSpellResistance = 0.0;
        public double elementalSpellPower = 0.0;
        public double elementalSpellResistance = 0.0;
        public double manaDiscount = 0.0;
        public double spellCriticalChance = 0.0;
        public double spellCriticalDamage = 0.0;
        // Additional Malum Attributes
        public double arcaneResonance = 0.0;
        public double chargeCapacity = 0.0;
        public double chargeDuration = 0.0;
        public double chargeRecoveryRate = 0.0;
        public double geasLimit = 0.0;
        public double malignantAegisCapacity = 0.0;
        public double malignantAegisRecoveryGain = 0.0;
        public double malignantAegisRecoveryRate = 0.0;
        public double malignantConversion = 0.0;
        public double scytheProficiency = 0.0;
        public double soulWardCapacity = 0.0;
        public double soulWardIntegrity = 0.0;
        public double soulWardRecoveryGain = 0.0;
        public double soulWardRecoveryRate = 0.0;
        public double spiritSpoils = 0.0;
        public double magicDamage = 0.0;
        public double magicProficiency = 0.0;
        public double magicResistance = 0.0;

        @Comment("What intrinsics should this race have?")
        public List<String> greaterAspectBornIntrinsics = List.of("tensura:self_regeneration");

        public double getMinAura() {
            return this.minAura;
        }
        public double getMaxAura() {
            return this.maxAura;
        }
        public double getMinMagicule() {
            return this.minMagicule;
        }
        public double getMaxMagicule() {
            return this.maxMagicule;
        }
        public double getSize() {
            return this.size;
        }
        public double getMaxHealth() {
            return this.maxHealth;
        }
        public double getMaxSpiritualHealth() {
            return this.maxSpiritualHealth;
        }
        public double getAttack() {
            return this.attack;
        }
        public double getAttackSpeed() {
            return this.attackSpeed;
        }
        public double getKnockbackResistance() {
            return this.knockbackResistance;
        }
        public double getMovementSpeed() {
            return this.movementSpeed;
        }
        public double getSwimSpeed() {
            return this.swimSpeed;
        }
        // Tensura Additional Attributes
        public double getAbilityLearnGain() {
            return this.abilityLearnGain;
        }
        public double getAbilityMasterGain() {
            return this.abilityMasterGain;
        }
        public double getAnalysisDistance() {
            return this.analysisDistance;
        }
        public double getAnalysisLevel() {
            return this.analysisLevel;
        }
        public double getAuraRegenMulti() {
            return this.auraRegenMulti;
        }
        public double getManaRegenMulti() {
            return this.manaRegenMulti;
        }
        public double getShpRegen() {
            return this.shpRegen;
        }
        public double getChantSpeed() {
            return this.chantSpeed;
        }
        public double getDarkVision() {
            return this.darkVision;
        }
        public double getMagicCostMulti() {
            return this.magicCostMulti;
        }
        public double getPresenceConcealment() {
            return this.presenceConcealment;
        }
        public double getPresenceSense() {
            return this.presenceSense;
        }
        public double getPresenceSenseRange() {
            return this.presenceSenseRange;
        }
        // Apotheosis Additional Attributes
        public double getArmorPierce() {
            return this.armorPierce;
        }
        public double getArmorShred() {
            return this.armorShred;
        }
        public double getArrowDamage() {
            return this.arrowDamage;
        }
        public double getArrowVelocity() {
            return this.arrowVelocity;
        }
        public double getCritChance() {
            return this.critChance;
        }
        public double getCritDamage() {
            return this.critDamage;
        }
        public double getHealingRecieved() {
            return this.healingRecieved;
        }
        public double getOverHeal() {
            return this.overHeal;
        }
        public double getLifeSteal() {
            return this.lifeSteal;
        }
        public double getCurrentHealthDamage() {
            return this.currentHealthDamage;
        }
        public double getDodgeChance() {
            return this.dodgeChance;
        }
        public double getDrawSpeed() {
            return this.drawSpeed;
        }
        public double getExperienceGained() {
            return this.experienceGained;
        }
        public double getProjDamage() {
            return this.projDamage;
        }
        public double getProtPierce() {
            return this.protPierce;
        }
        public double getProtShred() {
            return this.protShred;
        }
        // Minecraft Additional Attributes
        public double getArmor() {
            return this.armor;
        }
        public double getArmorToughness() {
            return this.armorToughness;
        }
        public double getAttackKnockback() {
            return this.attackKnockback;
        }
        public double getBlockBreakSpeed() {
            return this.blockBreakSpeed;
        }
        public double getBlockInteractionRange() {
            return this.blockInteractionRange;
        }
        public double getEntityInteractionRange() {
            return this.entityInteractionRange;
        }
        public double getExplosionKnockbackResistance() {
            return this.explosionKnockbackResistance;
        }
        public double getStepHeight() {
            return this.stepHeight;
        }
        public double getMiningEfficiency() {
            return this.miningEfficiency;
        }
        public double getMovementEfficiency() {
            return this.movementEfficiency;
        }
        public double getWaterMovementEfficiency() {
            return this.waterMovementEfficiency;
        }
        public double getSubmergedMiningSpeed() {
            return this.submergedMiningSpeed;
        }
        public double getFallDamageMultiplier() {
            return this.fallDamageMultiplier;
        }
        public double getLuck() {
            return this.luck;
        }
        public double getGravity() {
            return this.gravity;
        }
        public double getOxygenBonus() {
            return this.oxygenBonus;
        }
        public double getSneakingSpeed() {
            return this.sneakingSpeed;
        }
        public double getSweepingDamageRatio() {
            return this.sweepingDamageRatio;
        }
        public double getSafeFallDistance() {
            return this.safeFallDistance;
        }
        // Ars Nouveau Additional Attributes
        public double getDrygmyLootingModifier() {
            return this.drygmyLootingModifier;
        }
        public double getWixiePotionDuration() {
            return this.wixiePotionDuration;
        }
        public double getWhirlsprigSaturationModifier() {
            return this.whirlsprigSaturationModifier;
        }
        public double getSpellDamageBonus() {
            return this.spellDamageBonus;
        }
        public double getMaxMana() {
            return this.maxMana;
        }
        public double getManaRegen() {
            return this.manaRegen;
        }
        public double getFeather() {
            return this.feather;
        }
        public double getWarding() {
            return this.warding;
        }
        public double getWeight() {
            return this.weight;
        }

        public double getFireSpellDamage() {
            return this.fireSpellDamage;
        }
        public double getFireSpellResistance() {
            return this.fireSpellResistance;
        }
        public double getWaterSpellDamage() {
            return this.waterSpellDamage;
        }
        public double getWaterSpellResistance() {
            return this.waterSpellResistance;
        }
        public double getEarthSpellDamage() {
            return this.earthSpellDamage;
        }
        public double getEarthSpellResistance() {
            return this.earthSpellResistance;
        }
        public double getAirSpellDamage() {
            return this.airSpellDamage;
        }
        public double getAirSpellResistance() {
            return this.airSpellResistance;
        }
        public double getAbjurationSpellPower() {
            return this.abjurationSpellPower;
        }
        public double getAbjurationSpellResistance() {
            return this.abjurationSpellResistance;
        }
        public double getManipulationSpellPower() {
            return this.manipulationSpellPower;
        }
        public double getManipulationSpellResistance() {
            return this.manipulationSpellResistance;
        }
        public double getNecromancySpellPower() {
            return this.necromancySpellPower;
        }
        public double getNecromancySpellResistance() {
            return this.necromancySpellResistance;
        }
        public double getSummonSpellPower() {
            return this.summonSpellPower;
        }
        public double getConjurationSpellResistance() {
            return this.conjurationSpellResistance;
        }
        public double getElementalSpellPower() {
            return this.elementalSpellPower;
        }
        public double getElementalSpellResistance() {
            return this.elementalSpellResistance;
        }
        public double getManaDiscount() {
            return this.manaDiscount;
        }
        public double getSpellCriticalChance() {
            return this.spellCriticalChance;
        }
        public double getSpellCriticalDamage() {
            return this.spellCriticalDamage;
        }
        // Malum Additional Attributes
        public double getArcaneResonance() {
            return this.arcaneResonance;
        }
        public double getChargeCapacity() {
            return this.chargeCapacity;
        }
        public double getChargeDuration() {
            return this.chargeDuration;
        }
        public double getChargeRecoveryRate() {
            return this.chargeRecoveryRate;
        }
        public double getGeasLimit() {
            return this.geasLimit;
        }
        public double getMalignantAegisCapacity() {
            return this.malignantAegisCapacity;
        }
        public double getMalignantAegisRecoveryGain() {
            return this.malignantAegisRecoveryGain;
        }
        public double getMalignantAegisRecoveryRate() {
            return this.malignantAegisRecoveryRate;
        }
        public double getMalignantConversion() {
            return this.malignantConversion;
        }
        public double getScytheProficiency() {
            return this.scytheProficiency;
        }
        public double getSoulWardCapacity() {
            return this.soulWardCapacity;
        }
        public double getSoulWardIntegrity() {
            return this.soulWardIntegrity;
        }
        public double getSoulWardRecoveryGain() {
            return this.soulWardRecoveryGain;
        }
        public double getSoulWardRecoveryRate() {
            return this.soulWardRecoveryRate;
        }
        public double getSpiritSpoils() {
            return this.spiritSpoils;
        }
        public double getMagicDamage() {
            return this.magicDamage;
        }
        public double getMagicProficiency() {
            return this.magicProficiency;
        }
        public double getMagicResistance() {
            return this.magicResistance;
        }
    }

    public static class lesserConvergenceBorn extends StarlightCommon.RaceDefault {
        @Comment("What should the minimum Aura (AP) of this race be?")
        public double minAura = (double)500.0F;
        @Comment("What should the maximum Aura (AP) of this race be?")
        public double maxAura = (double)500.0F;
        @Comment("What should the minimum Mana (MP) of this race be?")
        public double minMagicule = (double)500.0F;
        @Comment("What should the maximum Mana (MP) of this race be?")
        public double maxMagicule = (double)500.0F;


        @Comment("What should the additonal size modifier of this race be?")
        public double size = -0.5;

        @Comment("How much additional Max Health should this race have? (Can be Negative)")
        public double maxHealth = (double)90.0F;
        @Comment("How much additional Max Spiritual Health should this race have? (Can be Negative)")
        public double maxSpiritualHealth = (double)490.0F;

        @Comment("How much additional Attack Damage should this race have? (Can be Negative)")
        public double attack = 0.0;
        @Comment("How much additional Attack Speed should this race have? (Can be Negative)")
        public double attackSpeed = 0.0;

        @Comment("How much additional Knockback Resistance should this race have? (Can be Negative)")
        public double knockbackResistance = 0.0;

        @Comment("How much additional Movement Speed should this race have? (Can be Negative), (Default Movement Speed is 0.1)")
        public double movementSpeed = 0.00;
        @Comment("How much additional Swim Speed should this race have? (Can be Negative)")
        public double swimSpeed = 0.0;

        // Additional Tensura Attributes
        public double abilityLearnGain = 0.0;
        public double abilityMasterGain = 0.0;
        public double analysisDistance = 0.0;
        public double analysisLevel = 0.0;
        public double auraRegenMulti = 0.0;
        public double manaRegenMulti = 0.0;
        public double shpRegen = 0.0;
        public double chantSpeed = 0.0;
        public double darkVision = 0.0;
        public double magicCostMulti = 0.0;
        public double presenceConcealment = 0.0;
        public double presenceSense = 0.0;
        public double presenceSenseRange = 0.0;
        // Additional Apotheosis Attributes
        public double armorPierce = 0.0;
        public double armorShred = 0.0;
        public double arrowDamage = 0.0;
        public double arrowVelocity = 0.0;
        public double critChance = 0.0;
        public double critDamage = 0.0;
        public double healingRecieved = 0.0;
        public double overHeal = 0.0;
        public double lifeSteal = 0.0;
        public double currentHealthDamage = 0.0;
        public double dodgeChance = 0.0;
        public double drawSpeed = 0.0;
        public double experienceGained = 0.0;
        public double projDamage = 0.0;
        public double protPierce = 0.0;
        public double protShred = 0.0;
        // Additional Minecraft Attributes
        public double armor = 0.0;
        public double armorToughness = 0.0;
        public double attackKnockback = 0.0;
        public double blockBreakSpeed = 0.0;
        public double blockInteractionRange = 0.0;
        public double entityInteractionRange = 0.0;
        public double explosionKnockbackResistance = 0.0;
        public double stepHeight = 0.4;
        public double miningEfficiency = 0.0;
        public double movementEfficiency = 0.0;
        public double waterMovementEfficiency = 0.0;
        public double submergedMiningSpeed = 0.0;
        public double fallDamageMultiplier = 0.0;
        public double luck = 0.0;
        public double gravity = 0.0;
        public double oxygenBonus = 0.0;
        public double sneakingSpeed = 0.0;
        public double sweepingDamageRatio = 0.0;
        public double safeFallDistance = 2.0;
        // Additional Ars Nouveau Attributes
        public double drygmyLootingModifier = 0.0;
        public double wixiePotionDuration = 0.0;
        public double whirlsprigSaturationModifier = 0.0;
        public double spellDamageBonus = 0.0;
        public double maxMana = 0.0;
        public double manaRegen = 0.0;
        public double feather = 0.0;
        public double warding = 0.0;
        public double weight = 0.0;

        public double fireSpellDamage = 0.0;
        public double fireSpellResistance = 0.0;
        public double waterSpellDamage = 0.0;
        public double waterSpellResistance = 0.0;
        public double earthSpellDamage = 0.0;
        public double earthSpellResistance = 0.0;
        public double airSpellDamage = 0.0;
        public double airSpellResistance = 0.0;
        public double abjurationSpellPower = 0.0;
        public double abjurationSpellResistance = 0.0;
        public double manipulationSpellPower = 0.0;
        public double manipulationSpellResistance = 0.0;
        public double necromancySpellPower = 0.0;
        public double necromancySpellResistance = 0.0;
        public double summonSpellPower = 0.0;
        public double conjurationSpellResistance = 0.0;
        public double elementalSpellPower = 0.0;
        public double elementalSpellResistance = 0.0;
        public double manaDiscount = 0.0;
        public double spellCriticalChance = 0.0;
        public double spellCriticalDamage = 0.0;
        // Additional Malum Attributes
        public double arcaneResonance = 0.0;
        public double chargeCapacity = 0.0;
        public double chargeDuration = 0.0;
        public double chargeRecoveryRate = 0.0;
        public double geasLimit = 0.0;
        public double malignantAegisCapacity = 0.0;
        public double malignantAegisRecoveryGain = 0.0;
        public double malignantAegisRecoveryRate = 0.0;
        public double malignantConversion = 0.0;
        public double scytheProficiency = 0.0;
        public double soulWardCapacity = 0.0;
        public double soulWardIntegrity = 0.0;
        public double soulWardRecoveryGain = 0.0;
        public double soulWardRecoveryRate = 0.0;
        public double spiritSpoils = 0.0;
        public double magicDamage = 0.0;
        public double magicProficiency = 0.0;
        public double magicResistance = 0.0;

        @Comment("What intrinsics should this race have?")
        public List<String> lesserAspectBornIntrinsics = List.of();

        public double getMinAura() {
            return this.minAura;
        }
        public double getMaxAura() {
            return this.maxAura;
        }
        public double getMinMagicule() {
            return this.minMagicule;
        }
        public double getMaxMagicule() {
            return this.maxMagicule;
        }
        public double getSize() {
            return this.size;
        }
        public double getMaxHealth() {
            return this.maxHealth;
        }
        public double getMaxSpiritualHealth() {
            return this.maxSpiritualHealth;
        }
        public double getAttack() {
            return this.attack;
        }
        public double getAttackSpeed() {
            return this.attackSpeed;
        }
        public double getKnockbackResistance() {
            return this.knockbackResistance;
        }
        public double getMovementSpeed() {
            return this.movementSpeed;
        }
        public double getSwimSpeed() {
            return this.swimSpeed;
        }
        // Tensura Additional Attributes
        public double getAbilityLearnGain() {
            return this.abilityLearnGain;
        }
        public double getAbilityMasterGain() {
            return this.abilityMasterGain;
        }
        public double getAnalysisDistance() {
            return this.analysisDistance;
        }
        public double getAnalysisLevel() {
            return this.analysisLevel;
        }
        public double getAuraRegenMulti() {
            return this.auraRegenMulti;
        }
        public double getManaRegenMulti() {
            return this.manaRegenMulti;
        }
        public double getShpRegen() {
            return this.shpRegen;
        }
        public double getChantSpeed() {
            return this.chantSpeed;
        }
        public double getDarkVision() {
            return this.darkVision;
        }
        public double getMagicCostMulti() {
            return this.magicCostMulti;
        }
        public double getPresenceConcealment() {
            return this.presenceConcealment;
        }
        public double getPresenceSense() {
            return this.presenceSense;
        }
        public double getPresenceSenseRange() {
            return this.presenceSenseRange;
        }
        // Apotheosis Additional Attributes
        public double getArmorPierce() {
            return this.armorPierce;
        }
        public double getArmorShred() {
            return this.armorShred;
        }
        public double getArrowDamage() {
            return this.arrowDamage;
        }
        public double getArrowVelocity() {
            return this.arrowVelocity;
        }
        public double getCritChance() {
            return this.critChance;
        }
        public double getCritDamage() {
            return this.critDamage;
        }
        public double getHealingRecieved() {
            return this.healingRecieved;
        }
        public double getOverHeal() {
            return this.overHeal;
        }
        public double getLifeSteal() {
            return this.lifeSteal;
        }
        public double getCurrentHealthDamage() {
            return this.currentHealthDamage;
        }
        public double getDodgeChance() {
            return this.dodgeChance;
        }
        public double getDrawSpeed() {
            return this.drawSpeed;
        }
        public double getExperienceGained() {
            return this.experienceGained;
        }
        public double getProjDamage() {
            return this.projDamage;
        }
        public double getProtPierce() {
            return this.protPierce;
        }
        public double getProtShred() {
            return this.protShred;
        }
        // Minecraft Additional Attributes
        public double getArmor() {
            return this.armor;
        }
        public double getArmorToughness() {
            return this.armorToughness;
        }
        public double getAttackKnockback() {
            return this.attackKnockback;
        }
        public double getBlockBreakSpeed() {
            return this.blockBreakSpeed;
        }
        public double getBlockInteractionRange() {
            return this.blockInteractionRange;
        }
        public double getEntityInteractionRange() {
            return this.entityInteractionRange;
        }
        public double getExplosionKnockbackResistance() {
            return this.explosionKnockbackResistance;
        }
        public double getStepHeight() {
            return this.stepHeight;
        }
        public double getMiningEfficiency() {
            return this.miningEfficiency;
        }
        public double getMovementEfficiency() {
            return this.movementEfficiency;
        }
        public double getWaterMovementEfficiency() {
            return this.waterMovementEfficiency;
        }
        public double getSubmergedMiningSpeed() {
            return this.submergedMiningSpeed;
        }
        public double getFallDamageMultiplier() {
            return this.fallDamageMultiplier;
        }
        public double getLuck() {
            return this.luck;
        }
        public double getGravity() {
            return this.gravity;
        }
        public double getOxygenBonus() {
            return this.oxygenBonus;
        }
        public double getSneakingSpeed() {
            return this.sneakingSpeed;
        }
        public double getSweepingDamageRatio() {
            return this.sweepingDamageRatio;
        }
        public double getSafeFallDistance() {
            return this.safeFallDistance;
        }
        // Ars Nouveau Additional Attributes
        public double getDrygmyLootingModifier() {
            return this.drygmyLootingModifier;
        }
        public double getWixiePotionDuration() {
            return this.wixiePotionDuration;
        }
        public double getWhirlsprigSaturationModifier() {
            return this.whirlsprigSaturationModifier;
        }
        public double getSpellDamageBonus() {
            return this.spellDamageBonus;
        }
        public double getMaxMana() {
            return this.maxMana;
        }
        public double getManaRegen() {
            return this.manaRegen;
        }
        public double getFeather() {
            return this.feather;
        }
        public double getWarding() {
            return this.warding;
        }
        public double getWeight() {
            return this.weight;
        }

        public double getFireSpellDamage() {
            return this.fireSpellDamage;
        }
        public double getFireSpellResistance() {
            return this.fireSpellResistance;
        }
        public double getWaterSpellDamage() {
            return this.waterSpellDamage;
        }
        public double getWaterSpellResistance() {
            return this.waterSpellResistance;
        }
        public double getEarthSpellDamage() {
            return this.earthSpellDamage;
        }
        public double getEarthSpellResistance() {
            return this.earthSpellResistance;
        }
        public double getAirSpellDamage() {
            return this.airSpellDamage;
        }
        public double getAirSpellResistance() {
            return this.airSpellResistance;
        }
        public double getAbjurationSpellPower() {
            return this.abjurationSpellPower;
        }
        public double getAbjurationSpellResistance() {
            return this.abjurationSpellResistance;
        }
        public double getManipulationSpellPower() {
            return this.manipulationSpellPower;
        }
        public double getManipulationSpellResistance() {
            return this.manipulationSpellResistance;
        }
        public double getNecromancySpellPower() {
            return this.necromancySpellPower;
        }
        public double getNecromancySpellResistance() {
            return this.necromancySpellResistance;
        }
        public double getSummonSpellPower() {
            return this.summonSpellPower;
        }
        public double getConjurationSpellResistance() {
            return this.conjurationSpellResistance;
        }
        public double getElementalSpellPower() {
            return this.elementalSpellPower;
        }
        public double getElementalSpellResistance() {
            return this.elementalSpellResistance;
        }
        public double getManaDiscount() {
            return this.manaDiscount;
        }
        public double getSpellCriticalChance() {
            return this.spellCriticalChance;
        }
        public double getSpellCriticalDamage() {
            return this.spellCriticalDamage;
        }
        // Malum Additional Attributes
        public double getArcaneResonance() {
            return this.arcaneResonance;
        }
        public double getChargeCapacity() {
            return this.chargeCapacity;
        }
        public double getChargeDuration() {
            return this.chargeDuration;
        }
        public double getChargeRecoveryRate() {
            return this.chargeRecoveryRate;
        }
        public double getGeasLimit() {
            return this.geasLimit;
        }
        public double getMalignantAegisCapacity() {
            return this.malignantAegisCapacity;
        }
        public double getMalignantAegisRecoveryGain() {
            return this.malignantAegisRecoveryGain;
        }
        public double getMalignantAegisRecoveryRate() {
            return this.malignantAegisRecoveryRate;
        }
        public double getMalignantConversion() {
            return this.malignantConversion;
        }
        public double getScytheProficiency() {
            return this.scytheProficiency;
        }
        public double getSoulWardCapacity() {
            return this.soulWardCapacity;
        }
        public double getSoulWardIntegrity() {
            return this.soulWardIntegrity;
        }
        public double getSoulWardRecoveryGain() {
            return this.soulWardRecoveryGain;
        }
        public double getSoulWardRecoveryRate() {
            return this.soulWardRecoveryRate;
        }
        public double getSpiritSpoils() {
            return this.spiritSpoils;
        }
        public double getMagicDamage() {
            return this.magicDamage;
        }
        public double getMagicProficiency() {
            return this.magicProficiency;
        }
        public double getMagicResistance() {
            return this.magicResistance;
        }
    }
    public static class convergenceBorn extends StarlightCommon.RaceDefault {
        @Comment("What should the minimum Aura (AP) of this race be?")
        public double minAura = (double)500.0F;
        @Comment("What should the maximum Aura (AP) of this race be?")
        public double maxAura = (double)500.0F;
        @Comment("What should the minimum Mana (MP) of this race be?")
        public double minMagicule = (double)500.0F;
        @Comment("What should the maximum Mana (MP) of this race be?")
        public double maxMagicule = (double)500.0F;


        @Comment("What should the additonal size modifier of this race be?")
        public double size = -0.5;

        @Comment("How much additional Max Health should this race have? (Can be Negative)")
        public double maxHealth = (double)235.0F;
        @Comment("How much additional Max Spiritual Health should this race have? (Can be Negative)")
        public double maxSpiritualHealth = (double)1215.0F;

        @Comment("How much additional Attack Damage should this race have? (Can be Negative)")
        public double attack = 0.0;
        @Comment("How much additional Attack Speed should this race have? (Can be Negative)")
        public double attackSpeed = 0.0;

        @Comment("How much additional Knockback Resistance should this race have? (Can be Negative)")
        public double knockbackResistance = 0.0;

        @Comment("How much additional Movement Speed should this race have? (Can be Negative), (Default Movement Speed is 0.1)")
        public double movementSpeed = 0.0;
        @Comment("How much additional Swim Speed should this race have? (Can be Negative)")
        public double swimSpeed = 0.0;

        // Additional Tensura Attributes
        public double abilityLearnGain = 0.0;
        public double abilityMasterGain = 0.0;
        public double analysisDistance = 0.0;
        public double analysisLevel = 0.0;
        public double auraRegenMulti = 0.0;
        public double manaRegenMulti = 0.0;
        public double shpRegen = 0.0;
        public double chantSpeed = 0.0;
        public double darkVision = 0.0;
        public double magicCostMulti = 0.0;
        public double presenceConcealment = 0.0;
        public double presenceSense = 0.0;
        public double presenceSenseRange = 0.0;
        // Additional Apotheosis Attributes
        public double armorPierce = 0.0;
        public double armorShred = 0.0;
        public double arrowDamage = 0.0;
        public double arrowVelocity = 0.0;
        public double critChance = 0.0;
        public double critDamage = 0.0;
        public double healingRecieved = 0.0;
        public double overHeal = 0.0;
        public double lifeSteal = 0.0;
        public double currentHealthDamage = 0.0;
        public double dodgeChance = 0.0;
        public double drawSpeed = 0.0;
        public double experienceGained = 0.0;
        public double projDamage = 0.0;
        public double protPierce = 0.0;
        public double protShred = 0.0;
        // Additional Minecraft Attributes
        public double armor = 0.0;
        public double armorToughness = 0.0;
        public double attackKnockback = 0.0;
        public double blockBreakSpeed = 0.0;
        public double blockInteractionRange = 0.0;
        public double entityInteractionRange = 0.0;
        public double explosionKnockbackResistance = 0.0;
        public double stepHeight = 0.4;
        public double miningEfficiency = 0.0;
        public double movementEfficiency = 0.0;
        public double waterMovementEfficiency = 0.0;
        public double submergedMiningSpeed = 0.0;
        public double fallDamageMultiplier = 0.0;
        public double luck = 0.0;
        public double gravity = 0.0;
        public double oxygenBonus = 0.0;
        public double sneakingSpeed = 0.0;
        public double sweepingDamageRatio = 0.0;
        public double safeFallDistance = 2.0;
        // Additional Ars Nouveau Attributes
        public double drygmyLootingModifier = 0.0;
        public double wixiePotionDuration = 0.0;
        public double whirlsprigSaturationModifier = 0.0;
        public double spellDamageBonus = 0.0;
        public double maxMana = 0.0;
        public double manaRegen = 0.0;
        public double feather = 0.0;
        public double warding = 0.0;
        public double weight = 0.0;

        public double fireSpellDamage = 0.0;
        public double fireSpellResistance = 0.0;
        public double waterSpellDamage = 0.0;
        public double waterSpellResistance = 0.0;
        public double earthSpellDamage = 0.0;
        public double earthSpellResistance = 0.0;
        public double airSpellDamage = 0.0;
        public double airSpellResistance = 0.0;
        public double abjurationSpellPower = 0.0;
        public double abjurationSpellResistance = 0.0;
        public double manipulationSpellPower = 0.0;
        public double manipulationSpellResistance = 0.0;
        public double necromancySpellPower = 0.0;
        public double necromancySpellResistance = 0.0;
        public double summonSpellPower = 0.0;
        public double conjurationSpellResistance = 0.0;
        public double elementalSpellPower = 0.0;
        public double elementalSpellResistance = 0.0;
        public double manaDiscount = 0.0;
        public double spellCriticalChance = 0.0;
        public double spellCriticalDamage = 0.0;
        // Additional Malum Attributes
        public double arcaneResonance = 0.0;
        public double chargeCapacity = 0.0;
        public double chargeDuration = 0.0;
        public double chargeRecoveryRate = 0.0;
        public double geasLimit = 0.0;
        public double malignantAegisCapacity = 0.0;
        public double malignantAegisRecoveryGain = 0.0;
        public double malignantAegisRecoveryRate = 0.0;
        public double malignantConversion = 0.0;
        public double scytheProficiency = 0.0;
        public double soulWardCapacity = 0.0;
        public double soulWardIntegrity = 0.0;
        public double soulWardRecoveryGain = 0.0;
        public double soulWardRecoveryRate = 0.0;
        public double spiritSpoils = 0.0;
        public double magicDamage = 0.0;
        public double magicProficiency = 0.0;
        public double magicResistance = 0.0;

        @Comment("What intrinsics should this race have?")
        public List<String> convergenceBornIntrinsics = List.of();

        public double getMinAura() {
            return this.minAura;
        }
        public double getMaxAura() {
            return this.maxAura;
        }
        public double getMinMagicule() {
            return this.minMagicule;
        }
        public double getMaxMagicule() {
            return this.maxMagicule;
        }
        public double getSize() {
            return this.size;
        }
        public double getMaxHealth() {
            return this.maxHealth;
        }
        public double getMaxSpiritualHealth() {
            return this.maxSpiritualHealth;
        }
        public double getAttack() {
            return this.attack;
        }
        public double getAttackSpeed() {
            return this.attackSpeed;
        }
        public double getKnockbackResistance() {
            return this.knockbackResistance;
        }
        public double getMovementSpeed() {
            return this.movementSpeed;
        }
        public double getSwimSpeed() {
            return this.swimSpeed;
        }
        // Tensura Additional Attributes
        public double getAbilityLearnGain() {
            return this.abilityLearnGain;
        }
        public double getAbilityMasterGain() {
            return this.abilityMasterGain;
        }
        public double getAnalysisDistance() {
            return this.analysisDistance;
        }
        public double getAnalysisLevel() {
            return this.analysisLevel;
        }
        public double getAuraRegenMulti() {
            return this.auraRegenMulti;
        }
        public double getManaRegenMulti() {
            return this.manaRegenMulti;
        }
        public double getShpRegen() {
            return this.shpRegen;
        }
        public double getChantSpeed() {
            return this.chantSpeed;
        }
        public double getDarkVision() {
            return this.darkVision;
        }
        public double getMagicCostMulti() {
            return this.magicCostMulti;
        }
        public double getPresenceConcealment() {
            return this.presenceConcealment;
        }
        public double getPresenceSense() {
            return this.presenceSense;
        }
        public double getPresenceSenseRange() {
            return this.presenceSenseRange;
        }
        // Apotheosis Additional Attributes
        public double getArmorPierce() {
            return this.armorPierce;
        }
        public double getArmorShred() {
            return this.armorShred;
        }
        public double getArrowDamage() {
            return this.arrowDamage;
        }
        public double getArrowVelocity() {
            return this.arrowVelocity;
        }
        public double getCritChance() {
            return this.critChance;
        }
        public double getCritDamage() {
            return this.critDamage;
        }
        public double getHealingRecieved() {
            return this.healingRecieved;
        }
        public double getOverHeal() {
            return this.overHeal;
        }
        public double getLifeSteal() {
            return this.lifeSteal;
        }
        public double getCurrentHealthDamage() {
            return this.currentHealthDamage;
        }
        public double getDodgeChance() {
            return this.dodgeChance;
        }
        public double getDrawSpeed() {
            return this.drawSpeed;
        }
        public double getExperienceGained() {
            return this.experienceGained;
        }
        public double getProjDamage() {
            return this.projDamage;
        }
        public double getProtPierce() {
            return this.protPierce;
        }
        public double getProtShred() {
            return this.protShred;
        }
        // Minecraft Additional Attributes
        public double getArmor() {
            return this.armor;
        }
        public double getArmorToughness() {
            return this.armorToughness;
        }
        public double getAttackKnockback() {
            return this.attackKnockback;
        }
        public double getBlockBreakSpeed() {
            return this.blockBreakSpeed;
        }
        public double getBlockInteractionRange() {
            return this.blockInteractionRange;
        }
        public double getEntityInteractionRange() {
            return this.entityInteractionRange;
        }
        public double getExplosionKnockbackResistance() {
            return this.explosionKnockbackResistance;
        }
        public double getStepHeight() {
            return this.stepHeight;
        }
        public double getMiningEfficiency() {
            return this.miningEfficiency;
        }
        public double getMovementEfficiency() {
            return this.movementEfficiency;
        }
        public double getWaterMovementEfficiency() {
            return this.waterMovementEfficiency;
        }
        public double getSubmergedMiningSpeed() {
            return this.submergedMiningSpeed;
        }
        public double getFallDamageMultiplier() {
            return this.fallDamageMultiplier;
        }
        public double getLuck() {
            return this.luck;
        }
        public double getGravity() {
            return this.gravity;
        }
        public double getOxygenBonus() {
            return this.oxygenBonus;
        }
        public double getSneakingSpeed() {
            return this.sneakingSpeed;
        }
        public double getSweepingDamageRatio() {
            return this.sweepingDamageRatio;
        }
        public double getSafeFallDistance() {
            return this.safeFallDistance;
        }
        // Ars Nouveau Additional Attributes
        public double getDrygmyLootingModifier() {
            return this.drygmyLootingModifier;
        }
        public double getWixiePotionDuration() {
            return this.wixiePotionDuration;
        }
        public double getWhirlsprigSaturationModifier() {
            return this.whirlsprigSaturationModifier;
        }
        public double getSpellDamageBonus() {
            return this.spellDamageBonus;
        }
        public double getMaxMana() {
            return this.maxMana;
        }
        public double getManaRegen() {
            return this.manaRegen;
        }
        public double getFeather() {
            return this.feather;
        }
        public double getWarding() {
            return this.warding;
        }
        public double getWeight() {
            return this.weight;
        }

        public double getFireSpellDamage() {
            return this.fireSpellDamage;
        }
        public double getFireSpellResistance() {
            return this.fireSpellResistance;
        }
        public double getWaterSpellDamage() {
            return this.waterSpellDamage;
        }
        public double getWaterSpellResistance() {
            return this.waterSpellResistance;
        }
        public double getEarthSpellDamage() {
            return this.earthSpellDamage;
        }
        public double getEarthSpellResistance() {
            return this.earthSpellResistance;
        }
        public double getAirSpellDamage() {
            return this.airSpellDamage;
        }
        public double getAirSpellResistance() {
            return this.airSpellResistance;
        }
        public double getAbjurationSpellPower() {
            return this.abjurationSpellPower;
        }
        public double getAbjurationSpellResistance() {
            return this.abjurationSpellResistance;
        }
        public double getManipulationSpellPower() {
            return this.manipulationSpellPower;
        }
        public double getManipulationSpellResistance() {
            return this.manipulationSpellResistance;
        }
        public double getNecromancySpellPower() {
            return this.necromancySpellPower;
        }
        public double getNecromancySpellResistance() {
            return this.necromancySpellResistance;
        }
        public double getSummonSpellPower() {
            return this.summonSpellPower;
        }
        public double getConjurationSpellResistance() {
            return this.conjurationSpellResistance;
        }
        public double getElementalSpellPower() {
            return this.elementalSpellPower;
        }
        public double getElementalSpellResistance() {
            return this.elementalSpellResistance;
        }
        public double getManaDiscount() {
            return this.manaDiscount;
        }
        public double getSpellCriticalChance() {
            return this.spellCriticalChance;
        }
        public double getSpellCriticalDamage() {
            return this.spellCriticalDamage;
        }
        // Malum Additional Attributes
        public double getArcaneResonance() {
            return this.arcaneResonance;
        }
        public double getChargeCapacity() {
            return this.chargeCapacity;
        }
        public double getChargeDuration() {
            return this.chargeDuration;
        }
        public double getChargeRecoveryRate() {
            return this.chargeRecoveryRate;
        }
        public double getGeasLimit() {
            return this.geasLimit;
        }
        public double getMalignantAegisCapacity() {
            return this.malignantAegisCapacity;
        }
        public double getMalignantAegisRecoveryGain() {
            return this.malignantAegisRecoveryGain;
        }
        public double getMalignantAegisRecoveryRate() {
            return this.malignantAegisRecoveryRate;
        }
        public double getMalignantConversion() {
            return this.malignantConversion;
        }
        public double getScytheProficiency() {
            return this.scytheProficiency;
        }
        public double getSoulWardCapacity() {
            return this.soulWardCapacity;
        }
        public double getSoulWardIntegrity() {
            return this.soulWardIntegrity;
        }
        public double getSoulWardRecoveryGain() {
            return this.soulWardRecoveryGain;
        }
        public double getSoulWardRecoveryRate() {
            return this.soulWardRecoveryRate;
        }
        public double getSpiritSpoils() {
            return this.spiritSpoils;
        }
        public double getMagicDamage() {
            return this.magicDamage;
        }
        public double getMagicProficiency() {
            return this.magicProficiency;
        }
        public double getMagicResistance() {
            return this.magicResistance;
        }
    }
    public static class greaterConvergenceBorn extends StarlightCommon.RaceDefault {
        @Comment("What should the minimum Aura (AP) of this race be?")
        public double minAura = (double)500.0F;
        @Comment("What should the maximum Aura (AP) of this race be?")
        public double maxAura = (double)500.0F;
        @Comment("What should the minimum Mana (MP) of this race be?")
        public double minMagicule = (double)500.0F;
        @Comment("What should the maximum Mana (MP) of this race be?")
        public double maxMagicule = (double)500.0F;


        @Comment("What should the additonal size modifier of this race be?")
        public double size = -0.5;

        @Comment("How much additional Max Health should this race have? (Can be Negative)")
        public double maxHealth = (double)525.0F;
        @Comment("How much additional Max Spiritual Health should this race have? (Can be Negative)")
        public double maxSpiritualHealth = (double)2665.0F;

        @Comment("How much additional Attack Damage should this race have? (Can be Negative)")
        public double attack = 0.0;
        @Comment("How much additional Attack Speed should this race have? (Can be Negative)")
        public double attackSpeed = 0.0;

        @Comment("How much additional Knockback Resistance should this race have? (Can be Negative)")
        public double knockbackResistance = 0.0;

        @Comment("How much additional Movement Speed should this race have? (Can be Negative), (Default Movement Speed is 0.1)")
        public double movementSpeed = 0.0;
        @Comment("How much additional Swim Speed should this race have? (Can be Negative)")
        public double swimSpeed = 0.0;

        // Additional Tensura Attributes
        public double abilityLearnGain = 0.0;
        public double abilityMasterGain = 0.0;
        public double analysisDistance = 0.0;
        public double analysisLevel = 0.0;
        public double auraRegenMulti = 0.0;
        public double manaRegenMulti = 0.0;
        public double shpRegen = 0.0;
        public double chantSpeed = 0.0;
        public double darkVision = 0.0;
        public double magicCostMulti = 0.0;
        public double presenceConcealment = 0.0;
        public double presenceSense = 0.0;
        public double presenceSenseRange = 0.0;
        // Additional Apotheosis Attributes
        public double armorPierce = 0.0;
        public double armorShred = 0.0;
        public double arrowDamage = 0.0;
        public double arrowVelocity = 0.0;
        public double critChance = 0.0;
        public double critDamage = 0.0;
        public double healingRecieved = 0.0;
        public double overHeal = 0.0;
        public double lifeSteal = 0.0;
        public double currentHealthDamage = 0.0;
        public double dodgeChance = 0.0;
        public double drawSpeed = 0.0;
        public double experienceGained = 0.0;
        public double projDamage = 0.0;
        public double protPierce = 0.0;
        public double protShred = 0.0;
        // Additional Minecraft Attributes
        public double armor = 0.0;
        public double armorToughness = 0.0;
        public double attackKnockback = 0.0;
        public double blockBreakSpeed = 0.0;
        public double blockInteractionRange = 0.0;
        public double entityInteractionRange = 0.0;
        public double explosionKnockbackResistance = 0.0;
        public double stepHeight = 0.4;
        public double miningEfficiency = 0.0;
        public double movementEfficiency = 0.0;
        public double waterMovementEfficiency = 0.0;
        public double submergedMiningSpeed = 0.0;
        public double fallDamageMultiplier = 0.0;
        public double luck = 0.0;
        public double gravity = 0.0;
        public double oxygenBonus = 0.0;
        public double sneakingSpeed = 0.0;
        public double sweepingDamageRatio = 0.0;
        public double safeFallDistance = 2.0;
        // Additional Ars Nouveau Attributes
        public double drygmyLootingModifier = 0.0;
        public double wixiePotionDuration = 0.0;
        public double whirlsprigSaturationModifier = 0.0;
        public double spellDamageBonus = 0.0;
        public double maxMana = 0.0;
        public double manaRegen = 0.0;
        public double feather = 0.0;
        public double warding = 0.0;
        public double weight = 0.0;

        public double fireSpellDamage = 0.0;
        public double fireSpellResistance = 0.0;
        public double waterSpellDamage = 0.0;
        public double waterSpellResistance = 0.0;
        public double earthSpellDamage = 0.0;
        public double earthSpellResistance = 0.0;
        public double airSpellDamage = 0.0;
        public double airSpellResistance = 0.0;
        public double abjurationSpellPower = 0.0;
        public double abjurationSpellResistance = 0.0;
        public double manipulationSpellPower = 0.0;
        public double manipulationSpellResistance = 0.0;
        public double necromancySpellPower = 0.0;
        public double necromancySpellResistance = 0.0;
        public double summonSpellPower = 0.0;
        public double conjurationSpellResistance = 0.0;
        public double elementalSpellPower = 0.0;
        public double elementalSpellResistance = 0.0;
        public double manaDiscount = 0.0;
        public double spellCriticalChance = 0.0;
        public double spellCriticalDamage = 0.0;
        // Additional Malum Attributes
        public double arcaneResonance = 0.0;
        public double chargeCapacity = 0.0;
        public double chargeDuration = 0.0;
        public double chargeRecoveryRate = 0.0;
        public double geasLimit = 0.0;
        public double malignantAegisCapacity = 0.0;
        public double malignantAegisRecoveryGain = 0.0;
        public double malignantAegisRecoveryRate = 0.0;
        public double malignantConversion = 0.0;
        public double scytheProficiency = 0.0;
        public double soulWardCapacity = 0.0;
        public double soulWardIntegrity = 0.0;
        public double soulWardRecoveryGain = 0.0;
        public double soulWardRecoveryRate = 0.0;
        public double spiritSpoils = 0.0;
        public double magicDamage = 0.0;
        public double magicProficiency = 0.0;
        public double magicResistance = 0.0;

        @Comment("What intrinsics should this race have?")
        public List<String> greaterConvergenceBornIntrinsics = List.of();

        public double getMinAura() {
            return this.minAura;
        }
        public double getMaxAura() {
            return this.maxAura;
        }
        public double getMinMagicule() {
            return this.minMagicule;
        }
        public double getMaxMagicule() {
            return this.maxMagicule;
        }
        public double getSize() {
            return this.size;
        }
        public double getMaxHealth() {
            return this.maxHealth;
        }
        public double getMaxSpiritualHealth() {
            return this.maxSpiritualHealth;
        }
        public double getAttack() {
            return this.attack;
        }
        public double getAttackSpeed() {
            return this.attackSpeed;
        }
        public double getKnockbackResistance() {
            return this.knockbackResistance;
        }
        public double getMovementSpeed() {
            return this.movementSpeed;
        }
        public double getSwimSpeed() {
            return this.swimSpeed;
        }
        // Tensura Additional Attributes
        public double getAbilityLearnGain() {
            return this.abilityLearnGain;
        }
        public double getAbilityMasterGain() {
            return this.abilityMasterGain;
        }
        public double getAnalysisDistance() {
            return this.analysisDistance;
        }
        public double getAnalysisLevel() {
            return this.analysisLevel;
        }
        public double getAuraRegenMulti() {
            return this.auraRegenMulti;
        }
        public double getManaRegenMulti() {
            return this.manaRegenMulti;
        }
        public double getShpRegen() {
            return this.shpRegen;
        }
        public double getChantSpeed() {
            return this.chantSpeed;
        }
        public double getDarkVision() {
            return this.darkVision;
        }
        public double getMagicCostMulti() {
            return this.magicCostMulti;
        }
        public double getPresenceConcealment() {
            return this.presenceConcealment;
        }
        public double getPresenceSense() {
            return this.presenceSense;
        }
        public double getPresenceSenseRange() {
            return this.presenceSenseRange;
        }
        // Apotheosis Additional Attributes
        public double getArmorPierce() {
            return this.armorPierce;
        }
        public double getArmorShred() {
            return this.armorShred;
        }
        public double getArrowDamage() {
            return this.arrowDamage;
        }
        public double getArrowVelocity() {
            return this.arrowVelocity;
        }
        public double getCritChance() {
            return this.critChance;
        }
        public double getCritDamage() {
            return this.critDamage;
        }
        public double getHealingRecieved() {
            return this.healingRecieved;
        }
        public double getOverHeal() {
            return this.overHeal;
        }
        public double getLifeSteal() {
            return this.lifeSteal;
        }
        public double getCurrentHealthDamage() {
            return this.currentHealthDamage;
        }
        public double getDodgeChance() {
            return this.dodgeChance;
        }
        public double getDrawSpeed() {
            return this.drawSpeed;
        }
        public double getExperienceGained() {
            return this.experienceGained;
        }
        public double getProjDamage() {
            return this.projDamage;
        }
        public double getProtPierce() {
            return this.protPierce;
        }
        public double getProtShred() {
            return this.protShred;
        }
        // Minecraft Additional Attributes
        public double getArmor() {
            return this.armor;
        }
        public double getArmorToughness() {
            return this.armorToughness;
        }
        public double getAttackKnockback() {
            return this.attackKnockback;
        }
        public double getBlockBreakSpeed() {
            return this.blockBreakSpeed;
        }
        public double getBlockInteractionRange() {
            return this.blockInteractionRange;
        }
        public double getEntityInteractionRange() {
            return this.entityInteractionRange;
        }
        public double getExplosionKnockbackResistance() {
            return this.explosionKnockbackResistance;
        }
        public double getStepHeight() {
            return this.stepHeight;
        }
        public double getMiningEfficiency() {
            return this.miningEfficiency;
        }
        public double getMovementEfficiency() {
            return this.movementEfficiency;
        }
        public double getWaterMovementEfficiency() {
            return this.waterMovementEfficiency;
        }
        public double getSubmergedMiningSpeed() {
            return this.submergedMiningSpeed;
        }
        public double getFallDamageMultiplier() {
            return this.fallDamageMultiplier;
        }
        public double getLuck() {
            return this.luck;
        }
        public double getGravity() {
            return this.gravity;
        }
        public double getOxygenBonus() {
            return this.oxygenBonus;
        }
        public double getSneakingSpeed() {
            return this.sneakingSpeed;
        }
        public double getSweepingDamageRatio() {
            return this.sweepingDamageRatio;
        }
        public double getSafeFallDistance() {
            return this.safeFallDistance;
        }
        // Ars Nouveau Additional Attributes
        public double getDrygmyLootingModifier() {
            return this.drygmyLootingModifier;
        }
        public double getWixiePotionDuration() {
            return this.wixiePotionDuration;
        }
        public double getWhirlsprigSaturationModifier() {
            return this.whirlsprigSaturationModifier;
        }
        public double getSpellDamageBonus() {
            return this.spellDamageBonus;
        }
        public double getMaxMana() {
            return this.maxMana;
        }
        public double getManaRegen() {
            return this.manaRegen;
        }
        public double getFeather() {
            return this.feather;
        }
        public double getWarding() {
            return this.warding;
        }
        public double getWeight() {
            return this.weight;
        }

        public double getFireSpellDamage() {
            return this.fireSpellDamage;
        }
        public double getFireSpellResistance() {
            return this.fireSpellResistance;
        }
        public double getWaterSpellDamage() {
            return this.waterSpellDamage;
        }
        public double getWaterSpellResistance() {
            return this.waterSpellResistance;
        }
        public double getEarthSpellDamage() {
            return this.earthSpellDamage;
        }
        public double getEarthSpellResistance() {
            return this.earthSpellResistance;
        }
        public double getAirSpellDamage() {
            return this.airSpellDamage;
        }
        public double getAirSpellResistance() {
            return this.airSpellResistance;
        }
        public double getAbjurationSpellPower() {
            return this.abjurationSpellPower;
        }
        public double getAbjurationSpellResistance() {
            return this.abjurationSpellResistance;
        }
        public double getManipulationSpellPower() {
            return this.manipulationSpellPower;
        }
        public double getManipulationSpellResistance() {
            return this.manipulationSpellResistance;
        }
        public double getNecromancySpellPower() {
            return this.necromancySpellPower;
        }
        public double getNecromancySpellResistance() {
            return this.necromancySpellResistance;
        }
        public double getSummonSpellPower() {
            return this.summonSpellPower;
        }
        public double getConjurationSpellResistance() {
            return this.conjurationSpellResistance;
        }
        public double getElementalSpellPower() {
            return this.elementalSpellPower;
        }
        public double getElementalSpellResistance() {
            return this.elementalSpellResistance;
        }
        public double getManaDiscount() {
            return this.manaDiscount;
        }
        public double getSpellCriticalChance() {
            return this.spellCriticalChance;
        }
        public double getSpellCriticalDamage() {
            return this.spellCriticalDamage;
        }
        // Malum Additional Attributes
        public double getArcaneResonance() {
            return this.arcaneResonance;
        }
        public double getChargeCapacity() {
            return this.chargeCapacity;
        }
        public double getChargeDuration() {
            return this.chargeDuration;
        }
        public double getChargeRecoveryRate() {
            return this.chargeRecoveryRate;
        }
        public double getGeasLimit() {
            return this.geasLimit;
        }
        public double getMalignantAegisCapacity() {
            return this.malignantAegisCapacity;
        }
        public double getMalignantAegisRecoveryGain() {
            return this.malignantAegisRecoveryGain;
        }
        public double getMalignantAegisRecoveryRate() {
            return this.malignantAegisRecoveryRate;
        }
        public double getMalignantConversion() {
            return this.malignantConversion;
        }
        public double getScytheProficiency() {
            return this.scytheProficiency;
        }
        public double getSoulWardCapacity() {
            return this.soulWardCapacity;
        }
        public double getSoulWardIntegrity() {
            return this.soulWardIntegrity;
        }
        public double getSoulWardRecoveryGain() {
            return this.soulWardRecoveryGain;
        }
        public double getSoulWardRecoveryRate() {
            return this.soulWardRecoveryRate;
        }
        public double getSpiritSpoils() {
            return this.spiritSpoils;
        }
        public double getMagicDamage() {
            return this.magicDamage;
        }
        public double getMagicProficiency() {
            return this.magicProficiency;
        }
        public double getMagicResistance() {
            return this.magicResistance;
        }
    }
    public static class elderConvergenceBorn extends StarlightCommon.RaceDefault {
        @Comment("What should the minimum Aura (AP) of this race be?")
        public double minAura = (double)500.0F;
        @Comment("What should the maximum Aura (AP) of this race be?")
        public double maxAura = (double)500.0F;
        @Comment("What should the minimum Mana (MP) of this race be?")
        public double minMagicule = (double)500.0F;
        @Comment("What should the maximum Mana (MP) of this race be?")
        public double maxMagicule = (double)500.0F;


        @Comment("What should the additonal size modifier of this race be?")
        public double size = -0.25;

        @Comment("How much additional Max Health should this race have? (Can be Negative)")
        public double maxHealth = (double)1020.0F;
        @Comment("How much additional Max Spiritual Health should this race have? (Can be Negative)")
        public double maxSpiritualHealth = (double)5140.0F;

        @Comment("How much additional Attack Damage should this race have? (Can be Negative)")
        public double attack = 0.0;
        @Comment("How much additional Attack Speed should this race have? (Can be Negative)")
        public double attackSpeed = 0.0;

        @Comment("How much additional Knockback Resistance should this race have? (Can be Negative)")
        public double knockbackResistance = 0.0;

        @Comment("How much additional Movement Speed should this race have? (Can be Negative), (Default Movement Speed is 0.1)")
        public double movementSpeed = 0.0;
        @Comment("How much additional Swim Speed should this race have? (Can be Negative)")
        public double swimSpeed = 0.0;

        // Additional Tensura Attributes
        public double abilityLearnGain = 0.0;
        public double abilityMasterGain = 0.0;
        public double analysisDistance = 0.0;
        public double analysisLevel = 0.0;
        public double auraRegenMulti = 0.0;
        public double manaRegenMulti = 0.0;
        public double shpRegen = 0.0;
        public double chantSpeed = 0.0;
        public double darkVision = 0.0;
        public double magicCostMulti = 0.0;
        public double presenceConcealment = 0.0;
        public double presenceSense = 0.0;
        public double presenceSenseRange = 0.0;
        // Additional Apotheosis Attributes
        public double armorPierce = 0.0;
        public double armorShred = 0.0;
        public double arrowDamage = 0.0;
        public double arrowVelocity = 0.0;
        public double critChance = 0.0;
        public double critDamage = 0.0;
        public double healingRecieved = 0.0;
        public double overHeal = 0.0;
        public double lifeSteal = 0.0;
        public double currentHealthDamage = 0.0;
        public double dodgeChance = 0.0;
        public double drawSpeed = 0.0;
        public double experienceGained = 0.0;
        public double projDamage = 0.0;
        public double protPierce = 0.0;
        public double protShred = 0.0;
        // Additional Minecraft Attributes
        public double armor = 0.0;
        public double armorToughness = 0.0;
        public double attackKnockback = 0.0;
        public double blockBreakSpeed = 0.0;
        public double blockInteractionRange = 0.0;
        public double entityInteractionRange = 0.0;
        public double explosionKnockbackResistance = 0.0;
        public double stepHeight = 0.4;
        public double miningEfficiency = 0.0;
        public double movementEfficiency = 0.0;
        public double waterMovementEfficiency = 0.0;
        public double submergedMiningSpeed = 0.0;
        public double fallDamageMultiplier = 0.0;
        public double luck = 0.0;
        public double gravity = 0.0;
        public double oxygenBonus = 0.0;
        public double sneakingSpeed = 0.0;
        public double sweepingDamageRatio = 0.0;
        public double safeFallDistance = 2.0;
        // Additional Ars Nouveau Attributes
        public double drygmyLootingModifier = 0.0;
        public double wixiePotionDuration = 0.0;
        public double whirlsprigSaturationModifier = 0.0;
        public double spellDamageBonus = 0.0;
        public double maxMana = 0.0;
        public double manaRegen = 0.0;
        public double feather = 0.0;
        public double warding = 0.0;
        public double weight = 0.0;

        public double fireSpellDamage = 0.0;
        public double fireSpellResistance = 0.0;
        public double waterSpellDamage = 0.0;
        public double waterSpellResistance = 0.0;
        public double earthSpellDamage = 0.0;
        public double earthSpellResistance = 0.0;
        public double airSpellDamage = 0.0;
        public double airSpellResistance = 0.0;
        public double abjurationSpellPower = 0.0;
        public double abjurationSpellResistance = 0.0;
        public double manipulationSpellPower = 0.0;
        public double manipulationSpellResistance = 0.0;
        public double necromancySpellPower = 0.0;
        public double necromancySpellResistance = 0.0;
        public double summonSpellPower = 0.0;
        public double conjurationSpellResistance = 0.0;
        public double elementalSpellPower = 0.0;
        public double elementalSpellResistance = 0.0;
        public double manaDiscount = 0.0;
        public double spellCriticalChance = 0.0;
        public double spellCriticalDamage = 0.0;
        // Additional Malum Attributes
        public double arcaneResonance = 0.0;
        public double chargeCapacity = 0.0;
        public double chargeDuration = 0.0;
        public double chargeRecoveryRate = 0.0;
        public double geasLimit = 0.0;
        public double malignantAegisCapacity = 0.0;
        public double malignantAegisRecoveryGain = 0.0;
        public double malignantAegisRecoveryRate = 0.0;
        public double malignantConversion = 0.0;
        public double scytheProficiency = 0.0;
        public double soulWardCapacity = 0.0;
        public double soulWardIntegrity = 0.0;
        public double soulWardRecoveryGain = 0.0;
        public double soulWardRecoveryRate = 0.0;
        public double spiritSpoils = 0.0;
        public double magicDamage = 0.0;
        public double magicProficiency = 0.0;
        public double magicResistance = 0.0;

        @Comment("What intrinsics should this race have?")
        public List<String> elderConvergenceBornIntrinsics = List.of();

        public double getMinAura() {
            return this.minAura;
        }
        public double getMaxAura() {
            return this.maxAura;
        }
        public double getMinMagicule() {
            return this.minMagicule;
        }
        public double getMaxMagicule() {
            return this.maxMagicule;
        }
        public double getSize() {
            return this.size;
        }
        public double getMaxHealth() {
            return this.maxHealth;
        }
        public double getMaxSpiritualHealth() {
            return this.maxSpiritualHealth;
        }
        public double getAttack() {
            return this.attack;
        }
        public double getAttackSpeed() {
            return this.attackSpeed;
        }
        public double getKnockbackResistance() {
            return this.knockbackResistance;
        }
        public double getMovementSpeed() {
            return this.movementSpeed;
        }
        public double getSwimSpeed() {
            return this.swimSpeed;
        }
        // Tensura Additional Attributes
        public double getAbilityLearnGain() {
            return this.abilityLearnGain;
        }
        public double getAbilityMasterGain() {
            return this.abilityMasterGain;
        }
        public double getAnalysisDistance() {
            return this.analysisDistance;
        }
        public double getAnalysisLevel() {
            return this.analysisLevel;
        }
        public double getAuraRegenMulti() {
            return this.auraRegenMulti;
        }
        public double getManaRegenMulti() {
            return this.manaRegenMulti;
        }
        public double getShpRegen() {
            return this.shpRegen;
        }
        public double getChantSpeed() {
            return this.chantSpeed;
        }
        public double getDarkVision() {
            return this.darkVision;
        }
        public double getMagicCostMulti() {
            return this.magicCostMulti;
        }
        public double getPresenceConcealment() {
            return this.presenceConcealment;
        }
        public double getPresenceSense() {
            return this.presenceSense;
        }
        public double getPresenceSenseRange() {
            return this.presenceSenseRange;
        }
        // Apotheosis Additional Attributes
        public double getArmorPierce() {
            return this.armorPierce;
        }
        public double getArmorShred() {
            return this.armorShred;
        }
        public double getArrowDamage() {
            return this.arrowDamage;
        }
        public double getArrowVelocity() {
            return this.arrowVelocity;
        }
        public double getCritChance() {
            return this.critChance;
        }
        public double getCritDamage() {
            return this.critDamage;
        }
        public double getHealingRecieved() {
            return this.healingRecieved;
        }
        public double getOverHeal() {
            return this.overHeal;
        }
        public double getLifeSteal() {
            return this.lifeSteal;
        }
        public double getCurrentHealthDamage() {
            return this.currentHealthDamage;
        }
        public double getDodgeChance() {
            return this.dodgeChance;
        }
        public double getDrawSpeed() {
            return this.drawSpeed;
        }
        public double getExperienceGained() {
            return this.experienceGained;
        }
        public double getProjDamage() {
            return this.projDamage;
        }
        public double getProtPierce() {
            return this.protPierce;
        }
        public double getProtShred() {
            return this.protShred;
        }
        // Minecraft Additional Attributes
        public double getArmor() {
            return this.armor;
        }
        public double getArmorToughness() {
            return this.armorToughness;
        }
        public double getAttackKnockback() {
            return this.attackKnockback;
        }
        public double getBlockBreakSpeed() {
            return this.blockBreakSpeed;
        }
        public double getBlockInteractionRange() {
            return this.blockInteractionRange;
        }
        public double getEntityInteractionRange() {
            return this.entityInteractionRange;
        }
        public double getExplosionKnockbackResistance() {
            return this.explosionKnockbackResistance;
        }
        public double getStepHeight() {
            return this.stepHeight;
        }
        public double getMiningEfficiency() {
            return this.miningEfficiency;
        }
        public double getMovementEfficiency() {
            return this.movementEfficiency;
        }
        public double getWaterMovementEfficiency() {
            return this.waterMovementEfficiency;
        }
        public double getSubmergedMiningSpeed() {
            return this.submergedMiningSpeed;
        }
        public double getFallDamageMultiplier() {
            return this.fallDamageMultiplier;
        }
        public double getLuck() {
            return this.luck;
        }
        public double getGravity() {
            return this.gravity;
        }
        public double getOxygenBonus() {
            return this.oxygenBonus;
        }
        public double getSneakingSpeed() {
            return this.sneakingSpeed;
        }
        public double getSweepingDamageRatio() {
            return this.sweepingDamageRatio;
        }
        public double getSafeFallDistance() {
            return this.safeFallDistance;
        }
        // Ars Nouveau Additional Attributes
        public double getDrygmyLootingModifier() {
            return this.drygmyLootingModifier;
        }
        public double getWixiePotionDuration() {
            return this.wixiePotionDuration;
        }
        public double getWhirlsprigSaturationModifier() {
            return this.whirlsprigSaturationModifier;
        }
        public double getSpellDamageBonus() {
            return this.spellDamageBonus;
        }
        public double getMaxMana() {
            return this.maxMana;
        }
        public double getManaRegen() {
            return this.manaRegen;
        }
        public double getFeather() {
            return this.feather;
        }
        public double getWarding() {
            return this.warding;
        }
        public double getWeight() {
            return this.weight;
        }

        public double getFireSpellDamage() {
            return this.fireSpellDamage;
        }
        public double getFireSpellResistance() {
            return this.fireSpellResistance;
        }
        public double getWaterSpellDamage() {
            return this.waterSpellDamage;
        }
        public double getWaterSpellResistance() {
            return this.waterSpellResistance;
        }
        public double getEarthSpellDamage() {
            return this.earthSpellDamage;
        }
        public double getEarthSpellResistance() {
            return this.earthSpellResistance;
        }
        public double getAirSpellDamage() {
            return this.airSpellDamage;
        }
        public double getAirSpellResistance() {
            return this.airSpellResistance;
        }
        public double getAbjurationSpellPower() {
            return this.abjurationSpellPower;
        }
        public double getAbjurationSpellResistance() {
            return this.abjurationSpellResistance;
        }
        public double getManipulationSpellPower() {
            return this.manipulationSpellPower;
        }
        public double getManipulationSpellResistance() {
            return this.manipulationSpellResistance;
        }
        public double getNecromancySpellPower() {
            return this.necromancySpellPower;
        }
        public double getNecromancySpellResistance() {
            return this.necromancySpellResistance;
        }
        public double getSummonSpellPower() {
            return this.summonSpellPower;
        }
        public double getConjurationSpellResistance() {
            return this.conjurationSpellResistance;
        }
        public double getElementalSpellPower() {
            return this.elementalSpellPower;
        }
        public double getElementalSpellResistance() {
            return this.elementalSpellResistance;
        }
        public double getManaDiscount() {
            return this.manaDiscount;
        }
        public double getSpellCriticalChance() {
            return this.spellCriticalChance;
        }
        public double getSpellCriticalDamage() {
            return this.spellCriticalDamage;
        }
        // Malum Additional Attributes
        public double getArcaneResonance() {
            return this.arcaneResonance;
        }
        public double getChargeCapacity() {
            return this.chargeCapacity;
        }
        public double getChargeDuration() {
            return this.chargeDuration;
        }
        public double getChargeRecoveryRate() {
            return this.chargeRecoveryRate;
        }
        public double getGeasLimit() {
            return this.geasLimit;
        }
        public double getMalignantAegisCapacity() {
            return this.malignantAegisCapacity;
        }
        public double getMalignantAegisRecoveryGain() {
            return this.malignantAegisRecoveryGain;
        }
        public double getMalignantAegisRecoveryRate() {
            return this.malignantAegisRecoveryRate;
        }
        public double getMalignantConversion() {
            return this.malignantConversion;
        }
        public double getScytheProficiency() {
            return this.scytheProficiency;
        }
        public double getSoulWardCapacity() {
            return this.soulWardCapacity;
        }
        public double getSoulWardIntegrity() {
            return this.soulWardIntegrity;
        }
        public double getSoulWardRecoveryGain() {
            return this.soulWardRecoveryGain;
        }
        public double getSoulWardRecoveryRate() {
            return this.soulWardRecoveryRate;
        }
        public double getSpiritSpoils() {
            return this.spiritSpoils;
        }
        public double getMagicDamage() {
            return this.magicDamage;
        }
        public double getMagicProficiency() {
            return this.magicProficiency;
        }
        public double getMagicResistance() {
            return this.magicResistance;
        }
    }


    public static class lesserMemoryBorn extends StarlightCommon.RaceDefault {
        @Comment("What should the minimum Aura (AP) of this race be?")
        public double minAura = (double)500.0F;
        @Comment("What should the maximum Aura (AP) of this race be?")
        public double maxAura = (double)500.0F;
        @Comment("What should the minimum Mana (MP) of this race be?")
        public double minMagicule = (double)500.0F;
        @Comment("What should the maximum Mana (MP) of this race be?")
        public double maxMagicule = (double)500.0F;


        @Comment("What should the additonal size modifier of this race be?")
        public double size = 0.0;

        @Comment("How much additional Max Health should this race have? (Can be Negative)")
        public double maxHealth = (double)90.0F;
        @Comment("How much additional Max Spiritual Health should this race have? (Can be Negative)")
        public double maxSpiritualHealth = (double)490.0F;

        @Comment("How much additional Attack Damage should this race have? (Can be Negative)")
        public double attack = 0.0;
        @Comment("How much additional Attack Speed should this race have? (Can be Negative)")
        public double attackSpeed = 0.0;

        @Comment("How much additional Knockback Resistance should this race have? (Can be Negative)")
        public double knockbackResistance = 0.0;

        @Comment("How much additional Movement Speed should this race have? (Can be Negative), (Default Movement Speed is 0.1)")
        public double movementSpeed = 0.0;
        @Comment("How much additional Swim Speed should this race have? (Can be Negative)")
        public double swimSpeed = 0.0;

        // Additional Tensura Attributes
        public double abilityLearnGain = 0.0;
        public double abilityMasterGain = 0.0;
        public double analysisDistance = 0.0;
        public double analysisLevel = 0.0;
        public double auraRegenMulti = 0.0;
        public double manaRegenMulti = 0.0;
        public double shpRegen = 0.0;
        public double chantSpeed = 0.0;
        public double darkVision = 0.0;
        public double magicCostMulti = 0.0;
        public double presenceConcealment = 0.0;
        public double presenceSense = 0.0;
        public double presenceSenseRange = 0.0;
        // Additional Apotheosis Attributes
        public double armorPierce = 0.0;
        public double armorShred = 0.0;
        public double arrowDamage = 0.0;
        public double arrowVelocity = 0.0;
        public double critChance = 0.0;
        public double critDamage = 0.0;
        public double healingRecieved = 0.0;
        public double overHeal = 0.0;
        public double lifeSteal = 0.0;
        public double currentHealthDamage = 0.0;
        public double dodgeChance = 0.0;
        public double drawSpeed = 0.0;
        public double experienceGained = 0.0;
        public double projDamage = 0.0;
        public double protPierce = 0.0;
        public double protShred = 0.0;
        // Additional Minecraft Attributes
        public double armor = 0.0;
        public double armorToughness = 0.0;
        public double attackKnockback = 0.0;
        public double blockBreakSpeed = 0.0;
        public double blockInteractionRange = 0.0;
        public double entityInteractionRange = 0.0;
        public double explosionKnockbackResistance = 0.0;
        public double stepHeight = 0.4;
        public double miningEfficiency = 0.0;
        public double movementEfficiency = 0.0;
        public double waterMovementEfficiency = 0.0;
        public double submergedMiningSpeed = 0.0;
        public double fallDamageMultiplier = 0.0;
        public double luck = 0.0;
        public double gravity = 0.0;
        public double oxygenBonus = 0.0;
        public double sneakingSpeed = 0.0;
        public double sweepingDamageRatio = 0.0;
        public double safeFallDistance = 2.0;
        // Additional Ars Nouveau Attributes
        public double drygmyLootingModifier = 0.0;
        public double wixiePotionDuration = 0.0;
        public double whirlsprigSaturationModifier = 0.0;
        public double spellDamageBonus = 0.0;
        public double maxMana = 0.0;
        public double manaRegen = 0.0;
        public double feather = 0.0;
        public double warding = 0.0;
        public double weight = 0.0;

        public double fireSpellDamage = 0.0;
        public double fireSpellResistance = 0.0;
        public double waterSpellDamage = 0.0;
        public double waterSpellResistance = 0.0;
        public double earthSpellDamage = 0.0;
        public double earthSpellResistance = 0.0;
        public double airSpellDamage = 0.0;
        public double airSpellResistance = 0.0;
        public double abjurationSpellPower = 0.0;
        public double abjurationSpellResistance = 0.0;
        public double manipulationSpellPower = 0.0;
        public double manipulationSpellResistance = 0.0;
        public double necromancySpellPower = 0.0;
        public double necromancySpellResistance = 0.0;
        public double summonSpellPower = 0.0;
        public double conjurationSpellResistance = 0.0;
        public double elementalSpellPower = 0.0;
        public double elementalSpellResistance = 0.0;
        public double manaDiscount = 0.0;
        public double spellCriticalChance = 0.0;
        public double spellCriticalDamage = 0.0;
        // Additional Malum Attributes
        public double arcaneResonance = 0.0;
        public double chargeCapacity = 0.0;
        public double chargeDuration = 0.0;
        public double chargeRecoveryRate = 0.0;
        public double geasLimit = 0.0;
        public double malignantAegisCapacity = 0.0;
        public double malignantAegisRecoveryGain = 0.0;
        public double malignantAegisRecoveryRate = 0.0;
        public double malignantConversion = 0.0;
        public double scytheProficiency = 0.0;
        public double soulWardCapacity = 0.0;
        public double soulWardIntegrity = 0.0;
        public double soulWardRecoveryGain = 0.0;
        public double soulWardRecoveryRate = 0.0;
        public double spiritSpoils = 0.0;
        public double magicDamage = 0.0;
        public double magicProficiency = 0.0;
        public double magicResistance = 0.0;

        @Comment("What intrinsics should this race have?")
        public List<String> lesserAspectBornIntrinsics = List.of();

        public double getMinAura() {
            return this.minAura;
        }
        public double getMaxAura() {
            return this.maxAura;
        }
        public double getMinMagicule() {
            return this.minMagicule;
        }
        public double getMaxMagicule() {
            return this.maxMagicule;
        }
        public double getSize() {
            return this.size;
        }
        public double getMaxHealth() {
            return this.maxHealth;
        }
        public double getMaxSpiritualHealth() {
            return this.maxSpiritualHealth;
        }
        public double getAttack() {
            return this.attack;
        }
        public double getAttackSpeed() {
            return this.attackSpeed;
        }
        public double getKnockbackResistance() {
            return this.knockbackResistance;
        }
        public double getMovementSpeed() {
            return this.movementSpeed;
        }
        public double getSwimSpeed() {
            return this.swimSpeed;
        }
        // Tensura Additional Attributes
        public double getAbilityLearnGain() {
            return this.abilityLearnGain;
        }
        public double getAbilityMasterGain() {
            return this.abilityMasterGain;
        }
        public double getAnalysisDistance() {
            return this.analysisDistance;
        }
        public double getAnalysisLevel() {
            return this.analysisLevel;
        }
        public double getAuraRegenMulti() {
            return this.auraRegenMulti;
        }
        public double getManaRegenMulti() {
            return this.manaRegenMulti;
        }
        public double getShpRegen() {
            return this.shpRegen;
        }
        public double getChantSpeed() {
            return this.chantSpeed;
        }
        public double getDarkVision() {
            return this.darkVision;
        }
        public double getMagicCostMulti() {
            return this.magicCostMulti;
        }
        public double getPresenceConcealment() {
            return this.presenceConcealment;
        }
        public double getPresenceSense() {
            return this.presenceSense;
        }
        public double getPresenceSenseRange() {
            return this.presenceSenseRange;
        }
        // Apotheosis Additional Attributes
        public double getArmorPierce() {
            return this.armorPierce;
        }
        public double getArmorShred() {
            return this.armorShred;
        }
        public double getArrowDamage() {
            return this.arrowDamage;
        }
        public double getArrowVelocity() {
            return this.arrowVelocity;
        }
        public double getCritChance() {
            return this.critChance;
        }
        public double getCritDamage() {
            return this.critDamage;
        }
        public double getHealingRecieved() {
            return this.healingRecieved;
        }
        public double getOverHeal() {
            return this.overHeal;
        }
        public double getLifeSteal() {
            return this.lifeSteal;
        }
        public double getCurrentHealthDamage() {
            return this.currentHealthDamage;
        }
        public double getDodgeChance() {
            return this.dodgeChance;
        }
        public double getDrawSpeed() {
            return this.drawSpeed;
        }
        public double getExperienceGained() {
            return this.experienceGained;
        }
        public double getProjDamage() {
            return this.projDamage;
        }
        public double getProtPierce() {
            return this.protPierce;
        }
        public double getProtShred() {
            return this.protShred;
        }
        // Minecraft Additional Attributes
        public double getArmor() {
            return this.armor;
        }
        public double getArmorToughness() {
            return this.armorToughness;
        }
        public double getAttackKnockback() {
            return this.attackKnockback;
        }
        public double getBlockBreakSpeed() {
            return this.blockBreakSpeed;
        }
        public double getBlockInteractionRange() {
            return this.blockInteractionRange;
        }
        public double getEntityInteractionRange() {
            return this.entityInteractionRange;
        }
        public double getExplosionKnockbackResistance() {
            return this.explosionKnockbackResistance;
        }
        public double getStepHeight() {
            return this.stepHeight;
        }
        public double getMiningEfficiency() {
            return this.miningEfficiency;
        }
        public double getMovementEfficiency() {
            return this.movementEfficiency;
        }
        public double getWaterMovementEfficiency() {
            return this.waterMovementEfficiency;
        }
        public double getSubmergedMiningSpeed() {
            return this.submergedMiningSpeed;
        }
        public double getFallDamageMultiplier() {
            return this.fallDamageMultiplier;
        }
        public double getLuck() {
            return this.luck;
        }
        public double getGravity() {
            return this.gravity;
        }
        public double getOxygenBonus() {
            return this.oxygenBonus;
        }
        public double getSneakingSpeed() {
            return this.sneakingSpeed;
        }
        public double getSweepingDamageRatio() {
            return this.sweepingDamageRatio;
        }
        public double getSafeFallDistance() {
            return this.safeFallDistance;
        }
        // Ars Nouveau Additional Attributes
        public double getDrygmyLootingModifier() {
            return this.drygmyLootingModifier;
        }
        public double getWixiePotionDuration() {
            return this.wixiePotionDuration;
        }
        public double getWhirlsprigSaturationModifier() {
            return this.whirlsprigSaturationModifier;
        }
        public double getSpellDamageBonus() {
            return this.spellDamageBonus;
        }
        public double getMaxMana() {
            return this.maxMana;
        }
        public double getManaRegen() {
            return this.manaRegen;
        }
        public double getFeather() {
            return this.feather;
        }
        public double getWarding() {
            return this.warding;
        }
        public double getWeight() {
            return this.weight;
        }

        public double getFireSpellDamage() {
            return this.fireSpellDamage;
        }
        public double getFireSpellResistance() {
            return this.fireSpellResistance;
        }
        public double getWaterSpellDamage() {
            return this.waterSpellDamage;
        }
        public double getWaterSpellResistance() {
            return this.waterSpellResistance;
        }
        public double getEarthSpellDamage() {
            return this.earthSpellDamage;
        }
        public double getEarthSpellResistance() {
            return this.earthSpellResistance;
        }
        public double getAirSpellDamage() {
            return this.airSpellDamage;
        }
        public double getAirSpellResistance() {
            return this.airSpellResistance;
        }
        public double getAbjurationSpellPower() {
            return this.abjurationSpellPower;
        }
        public double getAbjurationSpellResistance() {
            return this.abjurationSpellResistance;
        }
        public double getManipulationSpellPower() {
            return this.manipulationSpellPower;
        }
        public double getManipulationSpellResistance() {
            return this.manipulationSpellResistance;
        }
        public double getNecromancySpellPower() {
            return this.necromancySpellPower;
        }
        public double getNecromancySpellResistance() {
            return this.necromancySpellResistance;
        }
        public double getSummonSpellPower() {
            return this.summonSpellPower;
        }
        public double getConjurationSpellResistance() {
            return this.conjurationSpellResistance;
        }
        public double getElementalSpellPower() {
            return this.elementalSpellPower;
        }
        public double getElementalSpellResistance() {
            return this.elementalSpellResistance;
        }
        public double getManaDiscount() {
            return this.manaDiscount;
        }
        public double getSpellCriticalChance() {
            return this.spellCriticalChance;
        }
        public double getSpellCriticalDamage() {
            return this.spellCriticalDamage;
        }
        // Malum Additional Attributes
        public double getArcaneResonance() {
            return this.arcaneResonance;
        }
        public double getChargeCapacity() {
            return this.chargeCapacity;
        }
        public double getChargeDuration() {
            return this.chargeDuration;
        }
        public double getChargeRecoveryRate() {
            return this.chargeRecoveryRate;
        }
        public double getGeasLimit() {
            return this.geasLimit;
        }
        public double getMalignantAegisCapacity() {
            return this.malignantAegisCapacity;
        }
        public double getMalignantAegisRecoveryGain() {
            return this.malignantAegisRecoveryGain;
        }
        public double getMalignantAegisRecoveryRate() {
            return this.malignantAegisRecoveryRate;
        }
        public double getMalignantConversion() {
            return this.malignantConversion;
        }
        public double getScytheProficiency() {
            return this.scytheProficiency;
        }
        public double getSoulWardCapacity() {
            return this.soulWardCapacity;
        }
        public double getSoulWardIntegrity() {
            return this.soulWardIntegrity;
        }
        public double getSoulWardRecoveryGain() {
            return this.soulWardRecoveryGain;
        }
        public double getSoulWardRecoveryRate() {
            return this.soulWardRecoveryRate;
        }
        public double getSpiritSpoils() {
            return this.spiritSpoils;
        }
        public double getMagicDamage() {
            return this.magicDamage;
        }
        public double getMagicProficiency() {
            return this.magicProficiency;
        }
        public double getMagicResistance() {
            return this.magicResistance;
        }
    }
    public static class memoryBorn extends StarlightCommon.RaceDefault {
        @Comment("What should the minimum Aura (AP) of this race be?")
        public double minAura = (double)500.0F;
        @Comment("What should the maximum Aura (AP) of this race be?")
        public double maxAura = (double)500.0F;
        @Comment("What should the minimum Mana (MP) of this race be?")
        public double minMagicule = (double)500.0F;
        @Comment("What should the maximum Mana (MP) of this race be?")
        public double maxMagicule = (double)500.0F;


        @Comment("What should the additonal size modifier of this race be?")
        public double size = -0.5;

        @Comment("How much additional Max Health should this race have? (Can be Negative)")
        public double maxHealth = (double)235.0F;
        @Comment("How much additional Max Spiritual Health should this race have? (Can be Negative)")
        public double maxSpiritualHealth = (double)1215.0F;

        @Comment("How much additional Attack Damage should this race have? (Can be Negative)")
        public double attack = 0.0;
        @Comment("How much additional Attack Speed should this race have? (Can be Negative)")
        public double attackSpeed = 0.0;

        @Comment("How much additional Knockback Resistance should this race have? (Can be Negative)")
        public double knockbackResistance = 0.0;

        @Comment("How much additional Movement Speed should this race have? (Can be Negative), (Default Movement Speed is 0.1)")
        public double movementSpeed = 0.0;
        @Comment("How much additional Swim Speed should this race have? (Can be Negative)")
        public double swimSpeed = 0.0;

        // Additional Tensura Attributes
        public double abilityLearnGain = 0.0;
        public double abilityMasterGain = 0.0;
        public double analysisDistance = 0.0;
        public double analysisLevel = 0.0;
        public double auraRegenMulti = 0.0;
        public double manaRegenMulti = 0.0;
        public double shpRegen = 0.0;
        public double chantSpeed = 0.0;
        public double darkVision = 0.0;
        public double magicCostMulti = 0.0;
        public double presenceConcealment = 0.0;
        public double presenceSense = 0.0;
        public double presenceSenseRange = 0.0;
        // Additional Apotheosis Attributes
        public double armorPierce = 0.0;
        public double armorShred = 0.0;
        public double arrowDamage = 0.0;
        public double arrowVelocity = 0.0;
        public double critChance = 0.0;
        public double critDamage = 0.0;
        public double healingRecieved = 0.0;
        public double overHeal = 0.0;
        public double lifeSteal = 0.0;
        public double currentHealthDamage = 0.0;
        public double dodgeChance = 0.0;
        public double drawSpeed = 0.0;
        public double experienceGained = 0.0;
        public double projDamage = 0.0;
        public double protPierce = 0.0;
        public double protShred = 0.0;
        // Additional Minecraft Attributes
        public double armor = 0.0;
        public double armorToughness = 0.0;
        public double attackKnockback = 0.0;
        public double blockBreakSpeed = 0.0;
        public double blockInteractionRange = 0.0;
        public double entityInteractionRange = 0.0;
        public double explosionKnockbackResistance = 0.0;
        public double stepHeight = 0.4;
        public double miningEfficiency = 0.0;
        public double movementEfficiency = 0.0;
        public double waterMovementEfficiency = 0.0;
        public double submergedMiningSpeed = 0.0;
        public double fallDamageMultiplier = 0.0;
        public double luck = 0.0;
        public double gravity = 0.0;
        public double oxygenBonus = 0.0;
        public double sneakingSpeed = 0.0;
        public double sweepingDamageRatio = 0.0;
        public double safeFallDistance = 2.0;
        // Additional Ars Nouveau Attributes
        public double drygmyLootingModifier = 0.0;
        public double wixiePotionDuration = 0.0;
        public double whirlsprigSaturationModifier = 0.0;
        public double spellDamageBonus = 0.0;
        public double maxMana = 0.0;
        public double manaRegen = 0.0;
        public double feather = 0.0;
        public double warding = 0.0;
        public double weight = 0.0;

        public double fireSpellDamage = 0.0;
        public double fireSpellResistance = 0.0;
        public double waterSpellDamage = 0.0;
        public double waterSpellResistance = 0.0;
        public double earthSpellDamage = 0.0;
        public double earthSpellResistance = 0.0;
        public double airSpellDamage = 0.0;
        public double airSpellResistance = 0.0;
        public double abjurationSpellPower = 0.0;
        public double abjurationSpellResistance = 0.0;
        public double manipulationSpellPower = 0.0;
        public double manipulationSpellResistance = 0.0;
        public double necromancySpellPower = 0.0;
        public double necromancySpellResistance = 0.0;
        public double summonSpellPower = 0.0;
        public double conjurationSpellResistance = 0.0;
        public double elementalSpellPower = 0.0;
        public double elementalSpellResistance = 0.0;
        public double manaDiscount = 0.0;
        public double spellCriticalChance = 0.0;
        public double spellCriticalDamage = 0.0;
        // Additional Malum Attributes
        public double arcaneResonance = 0.0;
        public double chargeCapacity = 0.0;
        public double chargeDuration = 0.0;
        public double chargeRecoveryRate = 0.0;
        public double geasLimit = 0.0;
        public double malignantAegisCapacity = 0.0;
        public double malignantAegisRecoveryGain = 0.0;
        public double malignantAegisRecoveryRate = 0.0;
        public double malignantConversion = 0.0;
        public double scytheProficiency = 0.0;
        public double soulWardCapacity = 0.0;
        public double soulWardIntegrity = 0.0;
        public double soulWardRecoveryGain = 0.0;
        public double soulWardRecoveryRate = 0.0;
        public double spiritSpoils = 0.0;
        public double magicDamage = 0.0;
        public double magicProficiency = 0.0;
        public double magicResistance = 0.0;

        @Comment("What intrinsics should this race have?")
        public List<String> memoryBornIntrinsics = List.of();

        public double getMinAura() {
            return this.minAura;
        }
        public double getMaxAura() {
            return this.maxAura;
        }
        public double getMinMagicule() {
            return this.minMagicule;
        }
        public double getMaxMagicule() {
            return this.maxMagicule;
        }
        public double getSize() {
            return this.size;
        }
        public double getMaxHealth() {
            return this.maxHealth;
        }
        public double getMaxSpiritualHealth() {
            return this.maxSpiritualHealth;
        }
        public double getAttack() {
            return this.attack;
        }
        public double getAttackSpeed() {
            return this.attackSpeed;
        }
        public double getKnockbackResistance() {
            return this.knockbackResistance;
        }
        public double getMovementSpeed() {
            return this.movementSpeed;
        }
        public double getSwimSpeed() {
            return this.swimSpeed;
        }
        // Tensura Additional Attributes
        public double getAbilityLearnGain() {
            return this.abilityLearnGain;
        }
        public double getAbilityMasterGain() {
            return this.abilityMasterGain;
        }
        public double getAnalysisDistance() {
            return this.analysisDistance;
        }
        public double getAnalysisLevel() {
            return this.analysisLevel;
        }
        public double getAuraRegenMulti() {
            return this.auraRegenMulti;
        }
        public double getManaRegenMulti() {
            return this.manaRegenMulti;
        }
        public double getShpRegen() {
            return this.shpRegen;
        }
        public double getChantSpeed() {
            return this.chantSpeed;
        }
        public double getDarkVision() {
            return this.darkVision;
        }
        public double getMagicCostMulti() {
            return this.magicCostMulti;
        }
        public double getPresenceConcealment() {
            return this.presenceConcealment;
        }
        public double getPresenceSense() {
            return this.presenceSense;
        }
        public double getPresenceSenseRange() {
            return this.presenceSenseRange;
        }
        // Apotheosis Additional Attributes
        public double getArmorPierce() {
            return this.armorPierce;
        }
        public double getArmorShred() {
            return this.armorShred;
        }
        public double getArrowDamage() {
            return this.arrowDamage;
        }
        public double getArrowVelocity() {
            return this.arrowVelocity;
        }
        public double getCritChance() {
            return this.critChance;
        }
        public double getCritDamage() {
            return this.critDamage;
        }
        public double getHealingRecieved() {
            return this.healingRecieved;
        }
        public double getOverHeal() {
            return this.overHeal;
        }
        public double getLifeSteal() {
            return this.lifeSteal;
        }
        public double getCurrentHealthDamage() {
            return this.currentHealthDamage;
        }
        public double getDodgeChance() {
            return this.dodgeChance;
        }
        public double getDrawSpeed() {
            return this.drawSpeed;
        }
        public double getExperienceGained() {
            return this.experienceGained;
        }
        public double getProjDamage() {
            return this.projDamage;
        }
        public double getProtPierce() {
            return this.protPierce;
        }
        public double getProtShred() {
            return this.protShred;
        }
        // Minecraft Additional Attributes
        public double getArmor() {
            return this.armor;
        }
        public double getArmorToughness() {
            return this.armorToughness;
        }
        public double getAttackKnockback() {
            return this.attackKnockback;
        }
        public double getBlockBreakSpeed() {
            return this.blockBreakSpeed;
        }
        public double getBlockInteractionRange() {
            return this.blockInteractionRange;
        }
        public double getEntityInteractionRange() {
            return this.entityInteractionRange;
        }
        public double getExplosionKnockbackResistance() {
            return this.explosionKnockbackResistance;
        }
        public double getStepHeight() {
            return this.stepHeight;
        }
        public double getMiningEfficiency() {
            return this.miningEfficiency;
        }
        public double getMovementEfficiency() {
            return this.movementEfficiency;
        }
        public double getWaterMovementEfficiency() {
            return this.waterMovementEfficiency;
        }
        public double getSubmergedMiningSpeed() {
            return this.submergedMiningSpeed;
        }
        public double getFallDamageMultiplier() {
            return this.fallDamageMultiplier;
        }
        public double getLuck() {
            return this.luck;
        }
        public double getGravity() {
            return this.gravity;
        }
        public double getOxygenBonus() {
            return this.oxygenBonus;
        }
        public double getSneakingSpeed() {
            return this.sneakingSpeed;
        }
        public double getSweepingDamageRatio() {
            return this.sweepingDamageRatio;
        }
        public double getSafeFallDistance() {
            return this.safeFallDistance;
        }
        // Ars Nouveau Additional Attributes
        public double getDrygmyLootingModifier() {
            return this.drygmyLootingModifier;
        }
        public double getWixiePotionDuration() {
            return this.wixiePotionDuration;
        }
        public double getWhirlsprigSaturationModifier() {
            return this.whirlsprigSaturationModifier;
        }
        public double getSpellDamageBonus() {
            return this.spellDamageBonus;
        }
        public double getMaxMana() {
            return this.maxMana;
        }
        public double getManaRegen() {
            return this.manaRegen;
        }
        public double getFeather() {
            return this.feather;
        }
        public double getWarding() {
            return this.warding;
        }
        public double getWeight() {
            return this.weight;
        }

        public double getFireSpellDamage() {
            return this.fireSpellDamage;
        }
        public double getFireSpellResistance() {
            return this.fireSpellResistance;
        }
        public double getWaterSpellDamage() {
            return this.waterSpellDamage;
        }
        public double getWaterSpellResistance() {
            return this.waterSpellResistance;
        }
        public double getEarthSpellDamage() {
            return this.earthSpellDamage;
        }
        public double getEarthSpellResistance() {
            return this.earthSpellResistance;
        }
        public double getAirSpellDamage() {
            return this.airSpellDamage;
        }
        public double getAirSpellResistance() {
            return this.airSpellResistance;
        }
        public double getAbjurationSpellPower() {
            return this.abjurationSpellPower;
        }
        public double getAbjurationSpellResistance() {
            return this.abjurationSpellResistance;
        }
        public double getManipulationSpellPower() {
            return this.manipulationSpellPower;
        }
        public double getManipulationSpellResistance() {
            return this.manipulationSpellResistance;
        }
        public double getNecromancySpellPower() {
            return this.necromancySpellPower;
        }
        public double getNecromancySpellResistance() {
            return this.necromancySpellResistance;
        }
        public double getSummonSpellPower() {
            return this.summonSpellPower;
        }
        public double getConjurationSpellResistance() {
            return this.conjurationSpellResistance;
        }
        public double getElementalSpellPower() {
            return this.elementalSpellPower;
        }
        public double getElementalSpellResistance() {
            return this.elementalSpellResistance;
        }
        public double getManaDiscount() {
            return this.manaDiscount;
        }
        public double getSpellCriticalChance() {
            return this.spellCriticalChance;
        }
        public double getSpellCriticalDamage() {
            return this.spellCriticalDamage;
        }
        // Malum Additional Attributes
        public double getArcaneResonance() {
            return this.arcaneResonance;
        }
        public double getChargeCapacity() {
            return this.chargeCapacity;
        }
        public double getChargeDuration() {
            return this.chargeDuration;
        }
        public double getChargeRecoveryRate() {
            return this.chargeRecoveryRate;
        }
        public double getGeasLimit() {
            return this.geasLimit;
        }
        public double getMalignantAegisCapacity() {
            return this.malignantAegisCapacity;
        }
        public double getMalignantAegisRecoveryGain() {
            return this.malignantAegisRecoveryGain;
        }
        public double getMalignantAegisRecoveryRate() {
            return this.malignantAegisRecoveryRate;
        }
        public double getMalignantConversion() {
            return this.malignantConversion;
        }
        public double getScytheProficiency() {
            return this.scytheProficiency;
        }
        public double getSoulWardCapacity() {
            return this.soulWardCapacity;
        }
        public double getSoulWardIntegrity() {
            return this.soulWardIntegrity;
        }
        public double getSoulWardRecoveryGain() {
            return this.soulWardRecoveryGain;
        }
        public double getSoulWardRecoveryRate() {
            return this.soulWardRecoveryRate;
        }
        public double getSpiritSpoils() {
            return this.spiritSpoils;
        }
        public double getMagicDamage() {
            return this.magicDamage;
        }
        public double getMagicProficiency() {
            return this.magicProficiency;
        }
        public double getMagicResistance() {
            return this.magicResistance;
        }
    }
    public static class greaterMemoryBorn extends StarlightCommon.RaceDefault {
        @Comment("What should the minimum Aura (AP) of this race be?")
        public double minAura = (double)500.0F;
        @Comment("What should the maximum Aura (AP) of this race be?")
        public double maxAura = (double)500.0F;
        @Comment("What should the minimum Mana (MP) of this race be?")
        public double minMagicule = (double)500.0F;
        @Comment("What should the maximum Mana (MP) of this race be?")
        public double maxMagicule = (double)500.0F;


        @Comment("What should the additonal size modifier of this race be?")
        public double size = -0.5;

        @Comment("How much additional Max Health should this race have? (Can be Negative)")
        public double maxHealth = (double)525.0F;
        @Comment("How much additional Max Spiritual Health should this race have? (Can be Negative)")
        public double maxSpiritualHealth = (double)2665.0F;

        @Comment("How much additional Attack Damage should this race have? (Can be Negative)")
        public double attack = 0.0;
        @Comment("How much additional Attack Speed should this race have? (Can be Negative)")
        public double attackSpeed = 0.0;

        @Comment("How much additional Knockback Resistance should this race have? (Can be Negative)")
        public double knockbackResistance = 0.0;

        @Comment("How much additional Movement Speed should this race have? (Can be Negative), (Default Movement Speed is 0.1)")
        public double movementSpeed = 0.0;
        @Comment("How much additional Swim Speed should this race have? (Can be Negative)")
        public double swimSpeed = 0.0;

        // Additional Tensura Attributes
        public double abilityLearnGain = 0.0;
        public double abilityMasterGain = 0.0;
        public double analysisDistance = 0.0;
        public double analysisLevel = 0.0;
        public double auraRegenMulti = 0.0;
        public double manaRegenMulti = 0.0;
        public double shpRegen = 0.0;
        public double chantSpeed = 0.0;
        public double darkVision = 0.0;
        public double magicCostMulti = 0.0;
        public double presenceConcealment = 0.0;
        public double presenceSense = 0.0;
        public double presenceSenseRange = 0.0;
        // Additional Apotheosis Attributes
        public double armorPierce = 0.0;
        public double armorShred = 0.0;
        public double arrowDamage = 0.0;
        public double arrowVelocity = 0.0;
        public double critChance = 0.0;
        public double critDamage = 0.0;
        public double healingRecieved = 0.0;
        public double overHeal = 0.0;
        public double lifeSteal = 0.0;
        public double currentHealthDamage = 0.0;
        public double dodgeChance = 0.0;
        public double drawSpeed = 0.0;
        public double experienceGained = 0.0;
        public double projDamage = 0.0;
        public double protPierce = 0.0;
        public double protShred = 0.0;
        // Additional Minecraft Attributes
        public double armor = 0.0;
        public double armorToughness = 0.0;
        public double attackKnockback = 0.0;
        public double blockBreakSpeed = 0.0;
        public double blockInteractionRange = 0.0;
        public double entityInteractionRange = 0.0;
        public double explosionKnockbackResistance = 0.0;
        public double stepHeight = 0.4;
        public double miningEfficiency = 0.0;
        public double movementEfficiency = 0.0;
        public double waterMovementEfficiency = 0.0;
        public double submergedMiningSpeed = 0.0;
        public double fallDamageMultiplier = 0.0;
        public double luck = 0.0;
        public double gravity = 0.0;
        public double oxygenBonus = 0.0;
        public double sneakingSpeed = 0.0;
        public double sweepingDamageRatio = 0.0;
        public double safeFallDistance = 2.0;
        // Additional Ars Nouveau Attributes
        public double drygmyLootingModifier = 0.0;
        public double wixiePotionDuration = 0.0;
        public double whirlsprigSaturationModifier = 0.0;
        public double spellDamageBonus = 0.0;
        public double maxMana = 0.0;
        public double manaRegen = 0.0;
        public double feather = 0.0;
        public double warding = 0.0;
        public double weight = 0.0;

        public double fireSpellDamage = 0.0;
        public double fireSpellResistance = 0.0;
        public double waterSpellDamage = 0.0;
        public double waterSpellResistance = 0.0;
        public double earthSpellDamage = 0.0;
        public double earthSpellResistance = 0.0;
        public double airSpellDamage = 0.0;
        public double airSpellResistance = 0.0;
        public double abjurationSpellPower = 0.0;
        public double abjurationSpellResistance = 0.0;
        public double manipulationSpellPower = 0.0;
        public double manipulationSpellResistance = 0.0;
        public double necromancySpellPower = 0.0;
        public double necromancySpellResistance = 0.0;
        public double summonSpellPower = 0.0;
        public double conjurationSpellResistance = 0.0;
        public double elementalSpellPower = 0.0;
        public double elementalSpellResistance = 0.0;
        public double manaDiscount = 0.0;
        public double spellCriticalChance = 0.0;
        public double spellCriticalDamage = 0.0;
        // Additional Malum Attributes
        public double arcaneResonance = 0.0;
        public double chargeCapacity = 0.0;
        public double chargeDuration = 0.0;
        public double chargeRecoveryRate = 0.0;
        public double geasLimit = 0.0;
        public double malignantAegisCapacity = 0.0;
        public double malignantAegisRecoveryGain = 0.0;
        public double malignantAegisRecoveryRate = 0.0;
        public double malignantConversion = 0.0;
        public double scytheProficiency = 0.0;
        public double soulWardCapacity = 0.0;
        public double soulWardIntegrity = 0.0;
        public double soulWardRecoveryGain = 0.0;
        public double soulWardRecoveryRate = 0.0;
        public double spiritSpoils = 0.0;
        public double magicDamage = 0.0;
        public double magicProficiency = 0.0;
        public double magicResistance = 0.0;

        @Comment("What intrinsics should this race have?")
        public List<String> greaterMemoryBornIntrinsics = List.of();

        public double getMinAura() {
            return this.minAura;
        }
        public double getMaxAura() {
            return this.maxAura;
        }
        public double getMinMagicule() {
            return this.minMagicule;
        }
        public double getMaxMagicule() {
            return this.maxMagicule;
        }
        public double getSize() {
            return this.size;
        }
        public double getMaxHealth() {
            return this.maxHealth;
        }
        public double getMaxSpiritualHealth() {
            return this.maxSpiritualHealth;
        }
        public double getAttack() {
            return this.attack;
        }
        public double getAttackSpeed() {
            return this.attackSpeed;
        }
        public double getKnockbackResistance() {
            return this.knockbackResistance;
        }
        public double getMovementSpeed() {
            return this.movementSpeed;
        }
        public double getSwimSpeed() {
            return this.swimSpeed;
        }
        // Tensura Additional Attributes
        public double getAbilityLearnGain() {
            return this.abilityLearnGain;
        }
        public double getAbilityMasterGain() {
            return this.abilityMasterGain;
        }
        public double getAnalysisDistance() {
            return this.analysisDistance;
        }
        public double getAnalysisLevel() {
            return this.analysisLevel;
        }
        public double getAuraRegenMulti() {
            return this.auraRegenMulti;
        }
        public double getManaRegenMulti() {
            return this.manaRegenMulti;
        }
        public double getShpRegen() {
            return this.shpRegen;
        }
        public double getChantSpeed() {
            return this.chantSpeed;
        }
        public double getDarkVision() {
            return this.darkVision;
        }
        public double getMagicCostMulti() {
            return this.magicCostMulti;
        }
        public double getPresenceConcealment() {
            return this.presenceConcealment;
        }
        public double getPresenceSense() {
            return this.presenceSense;
        }
        public double getPresenceSenseRange() {
            return this.presenceSenseRange;
        }
        // Apotheosis Additional Attributes
        public double getArmorPierce() {
            return this.armorPierce;
        }
        public double getArmorShred() {
            return this.armorShred;
        }
        public double getArrowDamage() {
            return this.arrowDamage;
        }
        public double getArrowVelocity() {
            return this.arrowVelocity;
        }
        public double getCritChance() {
            return this.critChance;
        }
        public double getCritDamage() {
            return this.critDamage;
        }
        public double getHealingRecieved() {
            return this.healingRecieved;
        }
        public double getOverHeal() {
            return this.overHeal;
        }
        public double getLifeSteal() {
            return this.lifeSteal;
        }
        public double getCurrentHealthDamage() {
            return this.currentHealthDamage;
        }
        public double getDodgeChance() {
            return this.dodgeChance;
        }
        public double getDrawSpeed() {
            return this.drawSpeed;
        }
        public double getExperienceGained() {
            return this.experienceGained;
        }
        public double getProjDamage() {
            return this.projDamage;
        }
        public double getProtPierce() {
            return this.protPierce;
        }
        public double getProtShred() {
            return this.protShred;
        }
        // Minecraft Additional Attributes
        public double getArmor() {
            return this.armor;
        }
        public double getArmorToughness() {
            return this.armorToughness;
        }
        public double getAttackKnockback() {
            return this.attackKnockback;
        }
        public double getBlockBreakSpeed() {
            return this.blockBreakSpeed;
        }
        public double getBlockInteractionRange() {
            return this.blockInteractionRange;
        }
        public double getEntityInteractionRange() {
            return this.entityInteractionRange;
        }
        public double getExplosionKnockbackResistance() {
            return this.explosionKnockbackResistance;
        }
        public double getStepHeight() {
            return this.stepHeight;
        }
        public double getMiningEfficiency() {
            return this.miningEfficiency;
        }
        public double getMovementEfficiency() {
            return this.movementEfficiency;
        }
        public double getWaterMovementEfficiency() {
            return this.waterMovementEfficiency;
        }
        public double getSubmergedMiningSpeed() {
            return this.submergedMiningSpeed;
        }
        public double getFallDamageMultiplier() {
            return this.fallDamageMultiplier;
        }
        public double getLuck() {
            return this.luck;
        }
        public double getGravity() {
            return this.gravity;
        }
        public double getOxygenBonus() {
            return this.oxygenBonus;
        }
        public double getSneakingSpeed() {
            return this.sneakingSpeed;
        }
        public double getSweepingDamageRatio() {
            return this.sweepingDamageRatio;
        }
        public double getSafeFallDistance() {
            return this.safeFallDistance;
        }
        // Ars Nouveau Additional Attributes
        public double getDrygmyLootingModifier() {
            return this.drygmyLootingModifier;
        }
        public double getWixiePotionDuration() {
            return this.wixiePotionDuration;
        }
        public double getWhirlsprigSaturationModifier() {
            return this.whirlsprigSaturationModifier;
        }
        public double getSpellDamageBonus() {
            return this.spellDamageBonus;
        }
        public double getMaxMana() {
            return this.maxMana;
        }
        public double getManaRegen() {
            return this.manaRegen;
        }
        public double getFeather() {
            return this.feather;
        }
        public double getWarding() {
            return this.warding;
        }
        public double getWeight() {
            return this.weight;
        }

        public double getFireSpellDamage() {
            return this.fireSpellDamage;
        }
        public double getFireSpellResistance() {
            return this.fireSpellResistance;
        }
        public double getWaterSpellDamage() {
            return this.waterSpellDamage;
        }
        public double getWaterSpellResistance() {
            return this.waterSpellResistance;
        }
        public double getEarthSpellDamage() {
            return this.earthSpellDamage;
        }
        public double getEarthSpellResistance() {
            return this.earthSpellResistance;
        }
        public double getAirSpellDamage() {
            return this.airSpellDamage;
        }
        public double getAirSpellResistance() {
            return this.airSpellResistance;
        }
        public double getAbjurationSpellPower() {
            return this.abjurationSpellPower;
        }
        public double getAbjurationSpellResistance() {
            return this.abjurationSpellResistance;
        }
        public double getManipulationSpellPower() {
            return this.manipulationSpellPower;
        }
        public double getManipulationSpellResistance() {
            return this.manipulationSpellResistance;
        }
        public double getNecromancySpellPower() {
            return this.necromancySpellPower;
        }
        public double getNecromancySpellResistance() {
            return this.necromancySpellResistance;
        }
        public double getSummonSpellPower() {
            return this.summonSpellPower;
        }
        public double getConjurationSpellResistance() {
            return this.conjurationSpellResistance;
        }
        public double getElementalSpellPower() {
            return this.elementalSpellPower;
        }
        public double getElementalSpellResistance() {
            return this.elementalSpellResistance;
        }
        public double getManaDiscount() {
            return this.manaDiscount;
        }
        public double getSpellCriticalChance() {
            return this.spellCriticalChance;
        }
        public double getSpellCriticalDamage() {
            return this.spellCriticalDamage;
        }
        // Malum Additional Attributes
        public double getArcaneResonance() {
            return this.arcaneResonance;
        }
        public double getChargeCapacity() {
            return this.chargeCapacity;
        }
        public double getChargeDuration() {
            return this.chargeDuration;
        }
        public double getChargeRecoveryRate() {
            return this.chargeRecoveryRate;
        }
        public double getGeasLimit() {
            return this.geasLimit;
        }
        public double getMalignantAegisCapacity() {
            return this.malignantAegisCapacity;
        }
        public double getMalignantAegisRecoveryGain() {
            return this.malignantAegisRecoveryGain;
        }
        public double getMalignantAegisRecoveryRate() {
            return this.malignantAegisRecoveryRate;
        }
        public double getMalignantConversion() {
            return this.malignantConversion;
        }
        public double getScytheProficiency() {
            return this.scytheProficiency;
        }
        public double getSoulWardCapacity() {
            return this.soulWardCapacity;
        }
        public double getSoulWardIntegrity() {
            return this.soulWardIntegrity;
        }
        public double getSoulWardRecoveryGain() {
            return this.soulWardRecoveryGain;
        }
        public double getSoulWardRecoveryRate() {
            return this.soulWardRecoveryRate;
        }
        public double getSpiritSpoils() {
            return this.spiritSpoils;
        }
        public double getMagicDamage() {
            return this.magicDamage;
        }
        public double getMagicProficiency() {
            return this.magicProficiency;
        }
        public double getMagicResistance() {
            return this.magicResistance;
        }
    }
    public static class grandMemoryBorn extends StarlightCommon.RaceDefault {
        @Comment("What should the minimum Aura (AP) of this race be?")
        public double minAura = (double)500.0F;
        @Comment("What should the maximum Aura (AP) of this race be?")
        public double maxAura = (double)500.0F;
        @Comment("What should the minimum Mana (MP) of this race be?")
        public double minMagicule = (double)500.0F;
        @Comment("What should the maximum Mana (MP) of this race be?")
        public double maxMagicule = (double)500.0F;


        @Comment("What should the additonal size modifier of this race be?")
        public double size = -0.25;

        @Comment("How much additional Max Health should this race have? (Can be Negative)")
        public double maxHealth = (double)1020.0F;
        @Comment("How much additional Max Spiritual Health should this race have? (Can be Negative)")
        public double maxSpiritualHealth = (double)5140.0F;

        @Comment("How much additional Attack Damage should this race have? (Can be Negative)")
        public double attack = 0.0;
        @Comment("How much additional Attack Speed should this race have? (Can be Negative)")
        public double attackSpeed = 0.0;

        @Comment("How much additional Knockback Resistance should this race have? (Can be Negative)")
        public double knockbackResistance = 0.0;

        @Comment("How much additional Movement Speed should this race have? (Can be Negative), (Default Movement Speed is 0.1)")
        public double movementSpeed = 0.0;
        @Comment("How much additional Swim Speed should this race have? (Can be Negative)")
        public double swimSpeed = 0.0;

        // Additional Tensura Attributes
        public double abilityLearnGain = 0.0;
        public double abilityMasterGain = 0.0;
        public double analysisDistance = 0.0;
        public double analysisLevel = 0.0;
        public double auraRegenMulti = 0.0;
        public double manaRegenMulti = 0.0;
        public double shpRegen = 0.0;
        public double chantSpeed = 0.0;
        public double darkVision = 0.0;
        public double magicCostMulti = 0.0;
        public double presenceConcealment = 0.0;
        public double presenceSense = 0.0;
        public double presenceSenseRange = 0.0;
        // Additional Apotheosis Attributes
        public double armorPierce = 0.0;
        public double armorShred = 0.0;
        public double arrowDamage = 0.0;
        public double arrowVelocity = 0.0;
        public double critChance = 0.0;
        public double critDamage = 0.0;
        public double healingRecieved = 0.0;
        public double overHeal = 0.0;
        public double lifeSteal = 0.0;
        public double currentHealthDamage = 0.0;
        public double dodgeChance = 0.0;
        public double drawSpeed = 0.0;
        public double experienceGained = 0.0;
        public double projDamage = 0.0;
        public double protPierce = 0.0;
        public double protShred = 0.0;
        // Additional Minecraft Attributes
        public double armor = 0.0;
        public double armorToughness = 0.0;
        public double attackKnockback = 0.0;
        public double blockBreakSpeed = 0.0;
        public double blockInteractionRange = 0.0;
        public double entityInteractionRange = 0.0;
        public double explosionKnockbackResistance = 0.0;
        public double stepHeight = 0.4;
        public double miningEfficiency = 0.0;
        public double movementEfficiency = 0.0;
        public double waterMovementEfficiency = 0.0;
        public double submergedMiningSpeed = 0.0;
        public double fallDamageMultiplier = 0.0;
        public double luck = 0.0;
        public double gravity = 0.0;
        public double oxygenBonus = 0.0;
        public double sneakingSpeed = 0.0;
        public double sweepingDamageRatio = 0.0;
        public double safeFallDistance = 2.0;
        // Additional Ars Nouveau Attributes
        public double drygmyLootingModifier = 0.0;
        public double wixiePotionDuration = 0.0;
        public double whirlsprigSaturationModifier = 0.0;
        public double spellDamageBonus = 0.0;
        public double maxMana = 0.0;
        public double manaRegen = 0.0;
        public double feather = 0.0;
        public double warding = 0.0;
        public double weight = 0.0;

        public double fireSpellDamage = 0.0;
        public double fireSpellResistance = 0.0;
        public double waterSpellDamage = 0.0;
        public double waterSpellResistance = 0.0;
        public double earthSpellDamage = 0.0;
        public double earthSpellResistance = 0.0;
        public double airSpellDamage = 0.0;
        public double airSpellResistance = 0.0;
        public double abjurationSpellPower = 0.0;
        public double abjurationSpellResistance = 0.0;
        public double manipulationSpellPower = 0.0;
        public double manipulationSpellResistance = 0.0;
        public double necromancySpellPower = 0.0;
        public double necromancySpellResistance = 0.0;
        public double summonSpellPower = 0.0;
        public double conjurationSpellResistance = 0.0;
        public double elementalSpellPower = 0.0;
        public double elementalSpellResistance = 0.0;
        public double manaDiscount = 0.0;
        public double spellCriticalChance = 0.0;
        public double spellCriticalDamage = 0.0;
        // Additional Malum Attributes
        public double arcaneResonance = 0.0;
        public double chargeCapacity = 0.0;
        public double chargeDuration = 0.0;
        public double chargeRecoveryRate = 0.0;
        public double geasLimit = 0.0;
        public double malignantAegisCapacity = 0.0;
        public double malignantAegisRecoveryGain = 0.0;
        public double malignantAegisRecoveryRate = 0.0;
        public double malignantConversion = 0.0;
        public double scytheProficiency = 0.0;
        public double soulWardCapacity = 0.0;
        public double soulWardIntegrity = 0.0;
        public double soulWardRecoveryGain = 0.0;
        public double soulWardRecoveryRate = 0.0;
        public double spiritSpoils = 0.0;
        public double magicDamage = 0.0;
        public double magicProficiency = 0.0;
        public double magicResistance = 0.0;

        @Comment("What intrinsics should this race have?")
        public List<String> grandMemoryBornIntrinsics = List.of();

        public double getMinAura() {
            return this.minAura;
        }
        public double getMaxAura() {
            return this.maxAura;
        }
        public double getMinMagicule() {
            return this.minMagicule;
        }
        public double getMaxMagicule() {
            return this.maxMagicule;
        }
        public double getSize() {
            return this.size;
        }
        public double getMaxHealth() {
            return this.maxHealth;
        }
        public double getMaxSpiritualHealth() {
            return this.maxSpiritualHealth;
        }
        public double getAttack() {
            return this.attack;
        }
        public double getAttackSpeed() {
            return this.attackSpeed;
        }
        public double getKnockbackResistance() {
            return this.knockbackResistance;
        }
        public double getMovementSpeed() {
            return this.movementSpeed;
        }
        public double getSwimSpeed() {
            return this.swimSpeed;
        }
        // Tensura Additional Attributes
        public double getAbilityLearnGain() {
            return this.abilityLearnGain;
        }
        public double getAbilityMasterGain() {
            return this.abilityMasterGain;
        }
        public double getAnalysisDistance() {
            return this.analysisDistance;
        }
        public double getAnalysisLevel() {
            return this.analysisLevel;
        }
        public double getAuraRegenMulti() {
            return this.auraRegenMulti;
        }
        public double getManaRegenMulti() {
            return this.manaRegenMulti;
        }
        public double getShpRegen() {
            return this.shpRegen;
        }
        public double getChantSpeed() {
            return this.chantSpeed;
        }
        public double getDarkVision() {
            return this.darkVision;
        }
        public double getMagicCostMulti() {
            return this.magicCostMulti;
        }
        public double getPresenceConcealment() {
            return this.presenceConcealment;
        }
        public double getPresenceSense() {
            return this.presenceSense;
        }
        public double getPresenceSenseRange() {
            return this.presenceSenseRange;
        }
        // Apotheosis Additional Attributes
        public double getArmorPierce() {
            return this.armorPierce;
        }
        public double getArmorShred() {
            return this.armorShred;
        }
        public double getArrowDamage() {
            return this.arrowDamage;
        }
        public double getArrowVelocity() {
            return this.arrowVelocity;
        }
        public double getCritChance() {
            return this.critChance;
        }
        public double getCritDamage() {
            return this.critDamage;
        }
        public double getHealingRecieved() {
            return this.healingRecieved;
        }
        public double getOverHeal() {
            return this.overHeal;
        }
        public double getLifeSteal() {
            return this.lifeSteal;
        }
        public double getCurrentHealthDamage() {
            return this.currentHealthDamage;
        }
        public double getDodgeChance() {
            return this.dodgeChance;
        }
        public double getDrawSpeed() {
            return this.drawSpeed;
        }
        public double getExperienceGained() {
            return this.experienceGained;
        }
        public double getProjDamage() {
            return this.projDamage;
        }
        public double getProtPierce() {
            return this.protPierce;
        }
        public double getProtShred() {
            return this.protShred;
        }
        // Minecraft Additional Attributes
        public double getArmor() {
            return this.armor;
        }
        public double getArmorToughness() {
            return this.armorToughness;
        }
        public double getAttackKnockback() {
            return this.attackKnockback;
        }
        public double getBlockBreakSpeed() {
            return this.blockBreakSpeed;
        }
        public double getBlockInteractionRange() {
            return this.blockInteractionRange;
        }
        public double getEntityInteractionRange() {
            return this.entityInteractionRange;
        }
        public double getExplosionKnockbackResistance() {
            return this.explosionKnockbackResistance;
        }
        public double getStepHeight() {
            return this.stepHeight;
        }
        public double getMiningEfficiency() {
            return this.miningEfficiency;
        }
        public double getMovementEfficiency() {
            return this.movementEfficiency;
        }
        public double getWaterMovementEfficiency() {
            return this.waterMovementEfficiency;
        }
        public double getSubmergedMiningSpeed() {
            return this.submergedMiningSpeed;
        }
        public double getFallDamageMultiplier() {
            return this.fallDamageMultiplier;
        }
        public double getLuck() {
            return this.luck;
        }
        public double getGravity() {
            return this.gravity;
        }
        public double getOxygenBonus() {
            return this.oxygenBonus;
        }
        public double getSneakingSpeed() {
            return this.sneakingSpeed;
        }
        public double getSweepingDamageRatio() {
            return this.sweepingDamageRatio;
        }
        public double getSafeFallDistance() {
            return this.safeFallDistance;
        }
        // Ars Nouveau Additional Attributes
        public double getDrygmyLootingModifier() {
            return this.drygmyLootingModifier;
        }
        public double getWixiePotionDuration() {
            return this.wixiePotionDuration;
        }
        public double getWhirlsprigSaturationModifier() {
            return this.whirlsprigSaturationModifier;
        }
        public double getSpellDamageBonus() {
            return this.spellDamageBonus;
        }
        public double getMaxMana() {
            return this.maxMana;
        }
        public double getManaRegen() {
            return this.manaRegen;
        }
        public double getFeather() {
            return this.feather;
        }
        public double getWarding() {
            return this.warding;
        }
        public double getWeight() {
            return this.weight;
        }

        public double getFireSpellDamage() {
            return this.fireSpellDamage;
        }
        public double getFireSpellResistance() {
            return this.fireSpellResistance;
        }
        public double getWaterSpellDamage() {
            return this.waterSpellDamage;
        }
        public double getWaterSpellResistance() {
            return this.waterSpellResistance;
        }
        public double getEarthSpellDamage() {
            return this.earthSpellDamage;
        }
        public double getEarthSpellResistance() {
            return this.earthSpellResistance;
        }
        public double getAirSpellDamage() {
            return this.airSpellDamage;
        }
        public double getAirSpellResistance() {
            return this.airSpellResistance;
        }
        public double getAbjurationSpellPower() {
            return this.abjurationSpellPower;
        }
        public double getAbjurationSpellResistance() {
            return this.abjurationSpellResistance;
        }
        public double getManipulationSpellPower() {
            return this.manipulationSpellPower;
        }
        public double getManipulationSpellResistance() {
            return this.manipulationSpellResistance;
        }
        public double getNecromancySpellPower() {
            return this.necromancySpellPower;
        }
        public double getNecromancySpellResistance() {
            return this.necromancySpellResistance;
        }
        public double getSummonSpellPower() {
            return this.summonSpellPower;
        }
        public double getConjurationSpellResistance() {
            return this.conjurationSpellResistance;
        }
        public double getElementalSpellPower() {
            return this.elementalSpellPower;
        }
        public double getElementalSpellResistance() {
            return this.elementalSpellResistance;
        }
        public double getManaDiscount() {
            return this.manaDiscount;
        }
        public double getSpellCriticalChance() {
            return this.spellCriticalChance;
        }
        public double getSpellCriticalDamage() {
            return this.spellCriticalDamage;
        }
        // Malum Additional Attributes
        public double getArcaneResonance() {
            return this.arcaneResonance;
        }
        public double getChargeCapacity() {
            return this.chargeCapacity;
        }
        public double getChargeDuration() {
            return this.chargeDuration;
        }
        public double getChargeRecoveryRate() {
            return this.chargeRecoveryRate;
        }
        public double getGeasLimit() {
            return this.geasLimit;
        }
        public double getMalignantAegisCapacity() {
            return this.malignantAegisCapacity;
        }
        public double getMalignantAegisRecoveryGain() {
            return this.malignantAegisRecoveryGain;
        }
        public double getMalignantAegisRecoveryRate() {
            return this.malignantAegisRecoveryRate;
        }
        public double getMalignantConversion() {
            return this.malignantConversion;
        }
        public double getScytheProficiency() {
            return this.scytheProficiency;
        }
        public double getSoulWardCapacity() {
            return this.soulWardCapacity;
        }
        public double getSoulWardIntegrity() {
            return this.soulWardIntegrity;
        }
        public double getSoulWardRecoveryGain() {
            return this.soulWardRecoveryGain;
        }
        public double getSoulWardRecoveryRate() {
            return this.soulWardRecoveryRate;
        }
        public double getSpiritSpoils() {
            return this.spiritSpoils;
        }
        public double getMagicDamage() {
            return this.magicDamage;
        }
        public double getMagicProficiency() {
            return this.magicProficiency;
        }
        public double getMagicResistance() {
            return this.magicResistance;
        }
    }

    public static class falseAspectOfRegression extends StarlightCommon.RaceDefault {
        @Comment("What should the minimum Aura (AP) of this race be?")
        public double minAura = (double)500.0F;
        @Comment("What should the maximum Aura (AP) of this race be?")
        public double maxAura = (double)500.0F;
        @Comment("What should the minimum Mana (MP) of this race be?")
        public double minMagicule = (double)500.0F;
        @Comment("What should the maximum Mana (MP) of this race be?")
        public double maxMagicule = (double)500.0F;


        @Comment("What should the additonal size modifier of this race be?")
        public double size = 0.0;

        @Comment("How much additional Max Health should this race have? (Can be Negative)")
        public double maxHealth = (double)2.0F;
        @Comment("How much additional Max Spiritual Health should this race have? (Can be Negative)")
        public double maxSpiritualHealth = (double)10.0F;

        @Comment("How much additional Attack Damage should this race have? (Can be Negative)")
        public double attack = 0.0;
        @Comment("How much additional Attack Speed should this race have? (Can be Negative)")
        public double attackSpeed = 0.1;

        @Comment("How much additional Knockback Resistance should this race have? (Can be Negative)")
        public double knockbackResistance = 0.0;

        @Comment("How much additional Movement Speed should this race have? (Can be Negative), (Default Movement Speed is 0.1)")
        public double movementSpeed = 0.05;
        @Comment("How much additional Swim Speed should this race have? (Can be Negative)")
        public double swimSpeed = 0.5;

        // Additional Tensura Attributes
        public double abilityLearnGain = 0.0;
        public double abilityMasterGain = 0.0;
        public double analysisDistance = 0.0;
        public double analysisLevel = 0.0;
        public double auraRegenMulti = 0.0;
        public double manaRegenMulti = 0.0;
        public double shpRegen = 0.0;
        public double chantSpeed = 0.0;
        public double darkVision = 0.0;
        public double magicCostMulti = 0.0;
        public double presenceConcealment = 0.0;
        public double presenceSense = 0.0;
        public double presenceSenseRange = 0.0;
        // Additional Apotheosis Attributes
        public double armorPierce = 0.0;
        public double armorShred = 0.0;
        public double arrowDamage = 0.0;
        public double arrowVelocity = 0.0;
        public double critChance = 0.0;
        public double critDamage = 0.0;
        public double healingRecieved = 0.0;
        public double overHeal = 0.0;
        public double lifeSteal = 0.0;
        public double currentHealthDamage = 0.0;
        public double dodgeChance = 0.0;
        public double drawSpeed = 0.0;
        public double experienceGained = 0.0;
        public double projDamage = 0.0;
        public double protPierce = 0.0;
        public double protShred = 0.0;
        // Additional Minecraft Attributes
        public double armor = 0.0;
        public double armorToughness = 0.0;
        public double attackKnockback = 0.0;
        public double blockBreakSpeed = 0.0;
        public double blockInteractionRange = 0.0;
        public double entityInteractionRange = 0.0;
        public double explosionKnockbackResistance = 0.0;
        public double stepHeight = 0.0;
        public double miningEfficiency = 0.0;
        public double movementEfficiency = 0.0;
        public double waterMovementEfficiency = 0.0;
        public double submergedMiningSpeed = 0.0;
        public double fallDamageMultiplier = 0.0;
        public double luck = 0.0;
        public double gravity = 0.0;
        public double oxygenBonus = 0.0;
        public double sneakingSpeed = 0.0;
        public double sweepingDamageRatio = 0.0;
        public double safeFallDistance = 0.0;
        // Additional Ars Nouveau Attributes
        public double drygmyLootingModifier = 0.0;
        public double wixiePotionDuration = 0.0;
        public double whirlsprigSaturationModifier = 0.0;
        public double spellDamageBonus = 0.0;
        public double maxMana = 0.0;
        public double manaRegen = 0.0;
        public double feather = 0.0;
        public double warding = 0.0;
        public double weight = 0.0;

        public double fireSpellDamage = 0.0;
        public double fireSpellResistance = 0.0;
        public double waterSpellDamage = 0.0;
        public double waterSpellResistance = 0.0;
        public double earthSpellDamage = 0.0;
        public double earthSpellResistance = 0.0;
        public double airSpellDamage = 0.0;
        public double airSpellResistance = 0.0;
        public double abjurationSpellPower = 0.0;
        public double abjurationSpellResistance = 0.0;
        public double manipulationSpellPower = 0.0;
        public double manipulationSpellResistance = 0.0;
        public double necromancySpellPower = 0.0;
        public double necromancySpellResistance = 0.0;
        public double summonSpellPower = 0.0;
        public double conjurationSpellResistance = 0.0;
        public double elementalSpellPower = 0.0;
        public double elementalSpellResistance = 0.0;
        public double manaDiscount = 0.0;
        public double spellCriticalChance = 0.0;
        public double spellCriticalDamage = 0.0;
        // Additional Malum Attributes
        public double arcaneResonance = 0.0;
        public double chargeCapacity = 0.0;
        public double chargeDuration = 0.0;
        public double chargeRecoveryRate = 0.0;
        public double geasLimit = 0.0;
        public double malignantAegisCapacity = 0.0;
        public double malignantAegisRecoveryGain = 0.0;
        public double malignantAegisRecoveryRate = 0.0;
        public double malignantConversion = 0.0;
        public double scytheProficiency = 0.0;
        public double soulWardCapacity = 0.0;
        public double soulWardIntegrity = 0.0;
        public double soulWardRecoveryGain = 0.0;
        public double soulWardRecoveryRate = 0.0;
        public double spiritSpoils = 0.0;
        public double magicDamage = 0.0;
        public double magicProficiency = 0.0;
        public double magicResistance = 0.0;

        @Comment("What intrinsics should this race have?")
        public List<String> lesserAspectBornIntrinsics = List.of();

        public double getMinAura() {
            return this.minAura;
        }
        public double getMaxAura() {
            return this.maxAura;
        }
        public double getMinMagicule() {
            return this.minMagicule;
        }
        public double getMaxMagicule() {
            return this.maxMagicule;
        }
        public double getSize() {
            return this.size;
        }
        public double getMaxHealth() {
            return this.maxHealth;
        }
        public double getMaxSpiritualHealth() {
            return this.maxSpiritualHealth;
        }
        public double getAttack() {
            return this.attack;
        }
        public double getAttackSpeed() {
            return this.attackSpeed;
        }
        public double getKnockbackResistance() {
            return this.knockbackResistance;
        }
        public double getMovementSpeed() {
            return this.movementSpeed;
        }
        public double getSwimSpeed() {
            return this.swimSpeed;
        }
        // Tensura Additional Attributes
        public double getAbilityLearnGain() {
            return this.abilityLearnGain;
        }
        public double getAbilityMasterGain() {
            return this.abilityMasterGain;
        }
        public double getAnalysisDistance() {
            return this.analysisDistance;
        }
        public double getAnalysisLevel() {
            return this.analysisLevel;
        }
        public double getAuraRegenMulti() {
            return this.auraRegenMulti;
        }
        public double getManaRegenMulti() {
            return this.manaRegenMulti;
        }
        public double getShpRegen() {
            return this.shpRegen;
        }
        public double getChantSpeed() {
            return this.chantSpeed;
        }
        public double getDarkVision() {
            return this.darkVision;
        }
        public double getMagicCostMulti() {
            return this.magicCostMulti;
        }
        public double getPresenceConcealment() {
            return this.presenceConcealment;
        }
        public double getPresenceSense() {
            return this.presenceSense;
        }
        public double getPresenceSenseRange() {
            return this.presenceSenseRange;
        }
        // Apotheosis Additional Attributes
        public double getArmorPierce() {
            return this.armorPierce;
        }
        public double getArmorShred() {
            return this.armorShred;
        }
        public double getArrowDamage() {
            return this.arrowDamage;
        }
        public double getArrowVelocity() {
            return this.arrowVelocity;
        }
        public double getCritChance() {
            return this.critChance;
        }
        public double getCritDamage() {
            return this.critDamage;
        }
        public double getHealingRecieved() {
            return this.healingRecieved;
        }
        public double getOverHeal() {
            return this.overHeal;
        }
        public double getLifeSteal() {
            return this.lifeSteal;
        }
        public double getCurrentHealthDamage() {
            return this.currentHealthDamage;
        }
        public double getDodgeChance() {
            return this.dodgeChance;
        }
        public double getDrawSpeed() {
            return this.drawSpeed;
        }
        public double getExperienceGained() {
            return this.experienceGained;
        }
        public double getProjDamage() {
            return this.projDamage;
        }
        public double getProtPierce() {
            return this.protPierce;
        }
        public double getProtShred() {
            return this.protShred;
        }
        // Minecraft Additional Attributes
        public double getArmor() {
            return this.armor;
        }
        public double getArmorToughness() {
            return this.armorToughness;
        }
        public double getAttackKnockback() {
            return this.attackKnockback;
        }
        public double getBlockBreakSpeed() {
            return this.blockBreakSpeed;
        }
        public double getBlockInteractionRange() {
            return this.blockInteractionRange;
        }
        public double getEntityInteractionRange() {
            return this.entityInteractionRange;
        }
        public double getExplosionKnockbackResistance() {
            return this.explosionKnockbackResistance;
        }
        public double getStepHeight() {
            return this.stepHeight;
        }
        public double getMiningEfficiency() {
            return this.miningEfficiency;
        }
        public double getMovementEfficiency() {
            return this.movementEfficiency;
        }
        public double getWaterMovementEfficiency() {
            return this.waterMovementEfficiency;
        }
        public double getSubmergedMiningSpeed() {
            return this.submergedMiningSpeed;
        }
        public double getFallDamageMultiplier() {
            return this.fallDamageMultiplier;
        }
        public double getLuck() {
            return this.luck;
        }
        public double getGravity() {
            return this.gravity;
        }
        public double getOxygenBonus() {
            return this.oxygenBonus;
        }
        public double getSneakingSpeed() {
            return this.sneakingSpeed;
        }
        public double getSweepingDamageRatio() {
            return this.sweepingDamageRatio;
        }
        public double getSafeFallDistance() {
            return this.safeFallDistance;
        }
        // Ars Nouveau Additional Attributes
        public double getDrygmyLootingModifier() {
            return this.drygmyLootingModifier;
        }
        public double getWixiePotionDuration() {
            return this.wixiePotionDuration;
        }
        public double getWhirlsprigSaturationModifier() {
            return this.whirlsprigSaturationModifier;
        }
        public double getSpellDamageBonus() {
            return this.spellDamageBonus;
        }
        public double getMaxMana() {
            return this.maxMana;
        }
        public double getManaRegen() {
            return this.manaRegen;
        }
        public double getFeather() {
            return this.feather;
        }
        public double getWarding() {
            return this.warding;
        }
        public double getWeight() {
            return this.weight;
        }

        public double getFireSpellDamage() {
            return this.fireSpellDamage;
        }
        public double getFireSpellResistance() {
            return this.fireSpellResistance;
        }
        public double getWaterSpellDamage() {
            return this.waterSpellDamage;
        }
        public double getWaterSpellResistance() {
            return this.waterSpellResistance;
        }
        public double getEarthSpellDamage() {
            return this.earthSpellDamage;
        }
        public double getEarthSpellResistance() {
            return this.earthSpellResistance;
        }
        public double getAirSpellDamage() {
            return this.airSpellDamage;
        }
        public double getAirSpellResistance() {
            return this.airSpellResistance;
        }
        public double getAbjurationSpellPower() {
            return this.abjurationSpellPower;
        }
        public double getAbjurationSpellResistance() {
            return this.abjurationSpellResistance;
        }
        public double getManipulationSpellPower() {
            return this.manipulationSpellPower;
        }
        public double getManipulationSpellResistance() {
            return this.manipulationSpellResistance;
        }
        public double getNecromancySpellPower() {
            return this.necromancySpellPower;
        }
        public double getNecromancySpellResistance() {
            return this.necromancySpellResistance;
        }
        public double getSummonSpellPower() {
            return this.summonSpellPower;
        }
        public double getConjurationSpellResistance() {
            return this.conjurationSpellResistance;
        }
        public double getElementalSpellPower() {
            return this.elementalSpellPower;
        }
        public double getElementalSpellResistance() {
            return this.elementalSpellResistance;
        }
        public double getManaDiscount() {
            return this.manaDiscount;
        }
        public double getSpellCriticalChance() {
            return this.spellCriticalChance;
        }
        public double getSpellCriticalDamage() {
            return this.spellCriticalDamage;
        }
        // Malum Additional Attributes
        public double getArcaneResonance() {
            return this.arcaneResonance;
        }
        public double getChargeCapacity() {
            return this.chargeCapacity;
        }
        public double getChargeDuration() {
            return this.chargeDuration;
        }
        public double getChargeRecoveryRate() {
            return this.chargeRecoveryRate;
        }
        public double getGeasLimit() {
            return this.geasLimit;
        }
        public double getMalignantAegisCapacity() {
            return this.malignantAegisCapacity;
        }
        public double getMalignantAegisRecoveryGain() {
            return this.malignantAegisRecoveryGain;
        }
        public double getMalignantAegisRecoveryRate() {
            return this.malignantAegisRecoveryRate;
        }
        public double getMalignantConversion() {
            return this.malignantConversion;
        }
        public double getScytheProficiency() {
            return this.scytheProficiency;
        }
        public double getSoulWardCapacity() {
            return this.soulWardCapacity;
        }
        public double getSoulWardIntegrity() {
            return this.soulWardIntegrity;
        }
        public double getSoulWardRecoveryGain() {
            return this.soulWardRecoveryGain;
        }
        public double getSoulWardRecoveryRate() {
            return this.soulWardRecoveryRate;
        }
        public double getSpiritSpoils() {
            return this.spiritSpoils;
        }
        public double getMagicDamage() {
            return this.magicDamage;
        }
        public double getMagicProficiency() {
            return this.magicProficiency;
        }
        public double getMagicResistance() {
            return this.magicResistance;
        }
    }
    public static class aspectOfRegression extends StarlightCommon.RaceDefault {
        @Comment("What should the minimum Aura (AP) of this race be?")
        public double minAura = (double)500.0F;
        @Comment("What should the maximum Aura (AP) of this race be?")
        public double maxAura = (double)500.0F;
        @Comment("What should the minimum Mana (MP) of this race be?")
        public double minMagicule = (double)500.0F;
        @Comment("What should the maximum Mana (MP) of this race be?")
        public double maxMagicule = (double)500.0F;


        @Comment("What should the additonal size modifier of this race be?")
        public double size = 0.0;

        @Comment("How much additional Max Health should this race have? (Can be Negative)")
        public double maxHealth = (double)2.0F;
        @Comment("How much additional Max Spiritual Health should this race have? (Can be Negative)")
        public double maxSpiritualHealth = (double)10.0F;

        @Comment("How much additional Attack Damage should this race have? (Can be Negative)")
        public double attack = 0.0;
        @Comment("How much additional Attack Speed should this race have? (Can be Negative)")
        public double attackSpeed = 0.1;

        @Comment("How much additional Knockback Resistance should this race have? (Can be Negative)")
        public double knockbackResistance = 0.0;

        @Comment("How much additional Movement Speed should this race have? (Can be Negative), (Default Movement Speed is 0.1)")
        public double movementSpeed = 0.05;
        @Comment("How much additional Swim Speed should this race have? (Can be Negative)")
        public double swimSpeed = 0.5;

        // Additional Tensura Attributes
        public double abilityLearnGain = 0.0;
        public double abilityMasterGain = 0.0;
        public double analysisDistance = 0.0;
        public double analysisLevel = 0.0;
        public double auraRegenMulti = 0.0;
        public double manaRegenMulti = 0.0;
        public double shpRegen = 0.0;
        public double chantSpeed = 0.0;
        public double darkVision = 0.0;
        public double magicCostMulti = 0.0;
        public double presenceConcealment = 0.0;
        public double presenceSense = 0.0;
        public double presenceSenseRange = 0.0;
        // Additional Apotheosis Attributes
        public double armorPierce = 0.0;
        public double armorShred = 0.0;
        public double arrowDamage = 0.0;
        public double arrowVelocity = 0.0;
        public double critChance = 0.0;
        public double critDamage = 0.0;
        public double healingRecieved = 0.0;
        public double overHeal = 0.0;
        public double lifeSteal = 0.0;
        public double currentHealthDamage = 0.0;
        public double dodgeChance = 0.0;
        public double drawSpeed = 0.0;
        public double experienceGained = 0.0;
        public double projDamage = 0.0;
        public double protPierce = 0.0;
        public double protShred = 0.0;
        // Additional Minecraft Attributes
        public double armor = 0.0;
        public double armorToughness = 0.0;
        public double attackKnockback = 0.0;
        public double blockBreakSpeed = 0.0;
        public double blockInteractionRange = 0.0;
        public double entityInteractionRange = 0.0;
        public double explosionKnockbackResistance = 0.0;
        public double stepHeight = 0.0;
        public double miningEfficiency = 0.0;
        public double movementEfficiency = 0.0;
        public double waterMovementEfficiency = 0.0;
        public double submergedMiningSpeed = 0.0;
        public double fallDamageMultiplier = 0.0;
        public double luck = 0.0;
        public double gravity = 0.0;
        public double oxygenBonus = 0.0;
        public double sneakingSpeed = 0.0;
        public double sweepingDamageRatio = 0.0;
        public double safeFallDistance = 0.0;
        // Additional Ars Nouveau Attributes
        public double drygmyLootingModifier = 0.0;
        public double wixiePotionDuration = 0.0;
        public double whirlsprigSaturationModifier = 0.0;
        public double spellDamageBonus = 0.0;
        public double maxMana = 0.0;
        public double manaRegen = 0.0;
        public double feather = 0.0;
        public double warding = 0.0;
        public double weight = 0.0;

        public double fireSpellDamage = 0.0;
        public double fireSpellResistance = 0.0;
        public double waterSpellDamage = 0.0;
        public double waterSpellResistance = 0.0;
        public double earthSpellDamage = 0.0;
        public double earthSpellResistance = 0.0;
        public double airSpellDamage = 0.0;
        public double airSpellResistance = 0.0;
        public double abjurationSpellPower = 0.0;
        public double abjurationSpellResistance = 0.0;
        public double manipulationSpellPower = 0.0;
        public double manipulationSpellResistance = 0.0;
        public double necromancySpellPower = 0.0;
        public double necromancySpellResistance = 0.0;
        public double summonSpellPower = 0.0;
        public double conjurationSpellResistance = 0.0;
        public double elementalSpellPower = 0.0;
        public double elementalSpellResistance = 0.0;
        public double manaDiscount = 0.0;
        public double spellCriticalChance = 0.0;
        public double spellCriticalDamage = 0.0;
        // Additional Malum Attributes
        public double arcaneResonance = 0.0;
        public double chargeCapacity = 0.0;
        public double chargeDuration = 0.0;
        public double chargeRecoveryRate = 0.0;
        public double geasLimit = 0.0;
        public double malignantAegisCapacity = 0.0;
        public double malignantAegisRecoveryGain = 0.0;
        public double malignantAegisRecoveryRate = 0.0;
        public double malignantConversion = 0.0;
        public double scytheProficiency = 0.0;
        public double soulWardCapacity = 0.0;
        public double soulWardIntegrity = 0.0;
        public double soulWardRecoveryGain = 0.0;
        public double soulWardRecoveryRate = 0.0;
        public double spiritSpoils = 0.0;
        public double magicDamage = 0.0;
        public double magicProficiency = 0.0;
        public double magicResistance = 0.0;

        @Comment("What intrinsics should this race have?")
        public List<String> lesserAspectBornIntrinsics = List.of();

        public double getMinAura() {
            return this.minAura;
        }
        public double getMaxAura() {
            return this.maxAura;
        }
        public double getMinMagicule() {
            return this.minMagicule;
        }
        public double getMaxMagicule() {
            return this.maxMagicule;
        }
        public double getSize() {
            return this.size;
        }
        public double getMaxHealth() {
            return this.maxHealth;
        }
        public double getMaxSpiritualHealth() {
            return this.maxSpiritualHealth;
        }
        public double getAttack() {
            return this.attack;
        }
        public double getAttackSpeed() {
            return this.attackSpeed;
        }
        public double getKnockbackResistance() {
            return this.knockbackResistance;
        }
        public double getMovementSpeed() {
            return this.movementSpeed;
        }
        public double getSwimSpeed() {
            return this.swimSpeed;
        }
        // Tensura Additional Attributes
        public double getAbilityLearnGain() {
            return this.abilityLearnGain;
        }
        public double getAbilityMasterGain() {
            return this.abilityMasterGain;
        }
        public double getAnalysisDistance() {
            return this.analysisDistance;
        }
        public double getAnalysisLevel() {
            return this.analysisLevel;
        }
        public double getAuraRegenMulti() {
            return this.auraRegenMulti;
        }
        public double getManaRegenMulti() {
            return this.manaRegenMulti;
        }
        public double getShpRegen() {
            return this.shpRegen;
        }
        public double getChantSpeed() {
            return this.chantSpeed;
        }
        public double getDarkVision() {
            return this.darkVision;
        }
        public double getMagicCostMulti() {
            return this.magicCostMulti;
        }
        public double getPresenceConcealment() {
            return this.presenceConcealment;
        }
        public double getPresenceSense() {
            return this.presenceSense;
        }
        public double getPresenceSenseRange() {
            return this.presenceSenseRange;
        }
        // Apotheosis Additional Attributes
        public double getArmorPierce() {
            return this.armorPierce;
        }
        public double getArmorShred() {
            return this.armorShred;
        }
        public double getArrowDamage() {
            return this.arrowDamage;
        }
        public double getArrowVelocity() {
            return this.arrowVelocity;
        }
        public double getCritChance() {
            return this.critChance;
        }
        public double getCritDamage() {
            return this.critDamage;
        }
        public double getHealingRecieved() {
            return this.healingRecieved;
        }
        public double getOverHeal() {
            return this.overHeal;
        }
        public double getLifeSteal() {
            return this.lifeSteal;
        }
        public double getCurrentHealthDamage() {
            return this.currentHealthDamage;
        }
        public double getDodgeChance() {
            return this.dodgeChance;
        }
        public double getDrawSpeed() {
            return this.drawSpeed;
        }
        public double getExperienceGained() {
            return this.experienceGained;
        }
        public double getProjDamage() {
            return this.projDamage;
        }
        public double getProtPierce() {
            return this.protPierce;
        }
        public double getProtShred() {
            return this.protShred;
        }
        // Minecraft Additional Attributes
        public double getArmor() {
            return this.armor;
        }
        public double getArmorToughness() {
            return this.armorToughness;
        }
        public double getAttackKnockback() {
            return this.attackKnockback;
        }
        public double getBlockBreakSpeed() {
            return this.blockBreakSpeed;
        }
        public double getBlockInteractionRange() {
            return this.blockInteractionRange;
        }
        public double getEntityInteractionRange() {
            return this.entityInteractionRange;
        }
        public double getExplosionKnockbackResistance() {
            return this.explosionKnockbackResistance;
        }
        public double getStepHeight() {
            return this.stepHeight;
        }
        public double getMiningEfficiency() {
            return this.miningEfficiency;
        }
        public double getMovementEfficiency() {
            return this.movementEfficiency;
        }
        public double getWaterMovementEfficiency() {
            return this.waterMovementEfficiency;
        }
        public double getSubmergedMiningSpeed() {
            return this.submergedMiningSpeed;
        }
        public double getFallDamageMultiplier() {
            return this.fallDamageMultiplier;
        }
        public double getLuck() {
            return this.luck;
        }
        public double getGravity() {
            return this.gravity;
        }
        public double getOxygenBonus() {
            return this.oxygenBonus;
        }
        public double getSneakingSpeed() {
            return this.sneakingSpeed;
        }
        public double getSweepingDamageRatio() {
            return this.sweepingDamageRatio;
        }
        public double getSafeFallDistance() {
            return this.safeFallDistance;
        }
        // Ars Nouveau Additional Attributes
        public double getDrygmyLootingModifier() {
            return this.drygmyLootingModifier;
        }
        public double getWixiePotionDuration() {
            return this.wixiePotionDuration;
        }
        public double getWhirlsprigSaturationModifier() {
            return this.whirlsprigSaturationModifier;
        }
        public double getSpellDamageBonus() {
            return this.spellDamageBonus;
        }
        public double getMaxMana() {
            return this.maxMana;
        }
        public double getManaRegen() {
            return this.manaRegen;
        }
        public double getFeather() {
            return this.feather;
        }
        public double getWarding() {
            return this.warding;
        }
        public double getWeight() {
            return this.weight;
        }

        public double getFireSpellDamage() {
            return this.fireSpellDamage;
        }
        public double getFireSpellResistance() {
            return this.fireSpellResistance;
        }
        public double getWaterSpellDamage() {
            return this.waterSpellDamage;
        }
        public double getWaterSpellResistance() {
            return this.waterSpellResistance;
        }
        public double getEarthSpellDamage() {
            return this.earthSpellDamage;
        }
        public double getEarthSpellResistance() {
            return this.earthSpellResistance;
        }
        public double getAirSpellDamage() {
            return this.airSpellDamage;
        }
        public double getAirSpellResistance() {
            return this.airSpellResistance;
        }
        public double getAbjurationSpellPower() {
            return this.abjurationSpellPower;
        }
        public double getAbjurationSpellResistance() {
            return this.abjurationSpellResistance;
        }
        public double getManipulationSpellPower() {
            return this.manipulationSpellPower;
        }
        public double getManipulationSpellResistance() {
            return this.manipulationSpellResistance;
        }
        public double getNecromancySpellPower() {
            return this.necromancySpellPower;
        }
        public double getNecromancySpellResistance() {
            return this.necromancySpellResistance;
        }
        public double getSummonSpellPower() {
            return this.summonSpellPower;
        }
        public double getConjurationSpellResistance() {
            return this.conjurationSpellResistance;
        }
        public double getElementalSpellPower() {
            return this.elementalSpellPower;
        }
        public double getElementalSpellResistance() {
            return this.elementalSpellResistance;
        }
        public double getManaDiscount() {
            return this.manaDiscount;
        }
        public double getSpellCriticalChance() {
            return this.spellCriticalChance;
        }
        public double getSpellCriticalDamage() {
            return this.spellCriticalDamage;
        }
        // Malum Additional Attributes
        public double getArcaneResonance() {
            return this.arcaneResonance;
        }
        public double getChargeCapacity() {
            return this.chargeCapacity;
        }
        public double getChargeDuration() {
            return this.chargeDuration;
        }
        public double getChargeRecoveryRate() {
            return this.chargeRecoveryRate;
        }
        public double getGeasLimit() {
            return this.geasLimit;
        }
        public double getMalignantAegisCapacity() {
            return this.malignantAegisCapacity;
        }
        public double getMalignantAegisRecoveryGain() {
            return this.malignantAegisRecoveryGain;
        }
        public double getMalignantAegisRecoveryRate() {
            return this.malignantAegisRecoveryRate;
        }
        public double getMalignantConversion() {
            return this.malignantConversion;
        }
        public double getScytheProficiency() {
            return this.scytheProficiency;
        }
        public double getSoulWardCapacity() {
            return this.soulWardCapacity;
        }
        public double getSoulWardIntegrity() {
            return this.soulWardIntegrity;
        }
        public double getSoulWardRecoveryGain() {
            return this.soulWardRecoveryGain;
        }
        public double getSoulWardRecoveryRate() {
            return this.soulWardRecoveryRate;
        }
        public double getSpiritSpoils() {
            return this.spiritSpoils;
        }
        public double getMagicDamage() {
            return this.magicDamage;
        }
        public double getMagicProficiency() {
            return this.magicProficiency;
        }
        public double getMagicResistance() {
            return this.magicResistance;
        }
    }
    public static class mythos extends StarlightCommon.RaceDefault {
        @Comment("What should the minimum Aura (AP) of this race be?")
        public double minAura = (double)500.0F;
        @Comment("What should the maximum Aura (AP) of this race be?")
        public double maxAura = (double)500.0F;
        @Comment("What should the minimum Mana (MP) of this race be?")
        public double minMagicule = (double)500.0F;
        @Comment("What should the maximum Mana (MP) of this race be?")
        public double maxMagicule = (double)500.0F;


        @Comment("What should the additonal size modifier of this race be?")
        public double size = 0.0;

        @Comment("How much additional Max Health should this race have? (Can be Negative)")
        public double maxHealth = (double)2.0F;
        @Comment("How much additional Max Spiritual Health should this race have? (Can be Negative)")
        public double maxSpiritualHealth = (double)10.0F;

        @Comment("How much additional Attack Damage should this race have? (Can be Negative)")
        public double attack = 0.0;
        @Comment("How much additional Attack Speed should this race have? (Can be Negative)")
        public double attackSpeed = 0.1;

        @Comment("How much additional Knockback Resistance should this race have? (Can be Negative)")
        public double knockbackResistance = 0.0;

        @Comment("How much additional Movement Speed should this race have? (Can be Negative), (Default Movement Speed is 0.1)")
        public double movementSpeed = 0.05;
        @Comment("How much additional Swim Speed should this race have? (Can be Negative)")
        public double swimSpeed = 0.5;

        // Additional Tensura Attributes
        public double abilityLearnGain = 0.0;
        public double abilityMasterGain = 0.0;
        public double analysisDistance = 0.0;
        public double analysisLevel = 0.0;
        public double auraRegenMulti = 0.0;
        public double manaRegenMulti = 0.0;
        public double shpRegen = 0.0;
        public double chantSpeed = 0.0;
        public double darkVision = 0.0;
        public double magicCostMulti = 0.0;
        public double presenceConcealment = 0.0;
        public double presenceSense = 0.0;
        public double presenceSenseRange = 0.0;
        // Additional Apotheosis Attributes
        public double armorPierce = 0.0;
        public double armorShred = 0.0;
        public double arrowDamage = 0.0;
        public double arrowVelocity = 0.0;
        public double critChance = 0.0;
        public double critDamage = 0.0;
        public double healingRecieved = 0.0;
        public double overHeal = 0.0;
        public double lifeSteal = 0.0;
        public double currentHealthDamage = 0.0;
        public double dodgeChance = 0.0;
        public double drawSpeed = 0.0;
        public double experienceGained = 0.0;
        public double projDamage = 0.0;
        public double protPierce = 0.0;
        public double protShred = 0.0;
        // Additional Minecraft Attributes
        public double armor = 0.0;
        public double armorToughness = 0.0;
        public double attackKnockback = 0.0;
        public double blockBreakSpeed = 0.0;
        public double blockInteractionRange = 0.0;
        public double entityInteractionRange = 0.0;
        public double explosionKnockbackResistance = 0.0;
        public double stepHeight = 0.0;
        public double miningEfficiency = 0.0;
        public double movementEfficiency = 0.0;
        public double waterMovementEfficiency = 0.0;
        public double submergedMiningSpeed = 0.0;
        public double fallDamageMultiplier = 0.0;
        public double luck = 0.0;
        public double gravity = 0.0;
        public double oxygenBonus = 0.0;
        public double sneakingSpeed = 0.0;
        public double sweepingDamageRatio = 0.0;
        public double safeFallDistance = 0.0;
        // Additional Ars Nouveau Attributes
        public double drygmyLootingModifier = 0.0;
        public double wixiePotionDuration = 0.0;
        public double whirlsprigSaturationModifier = 0.0;
        public double spellDamageBonus = 0.0;
        public double maxMana = 0.0;
        public double manaRegen = 0.0;
        public double feather = 0.0;
        public double warding = 0.0;
        public double weight = 0.0;

        public double fireSpellDamage = 0.0;
        public double fireSpellResistance = 0.0;
        public double waterSpellDamage = 0.0;
        public double waterSpellResistance = 0.0;
        public double earthSpellDamage = 0.0;
        public double earthSpellResistance = 0.0;
        public double airSpellDamage = 0.0;
        public double airSpellResistance = 0.0;
        public double abjurationSpellPower = 0.0;
        public double abjurationSpellResistance = 0.0;
        public double manipulationSpellPower = 0.0;
        public double manipulationSpellResistance = 0.0;
        public double necromancySpellPower = 0.0;
        public double necromancySpellResistance = 0.0;
        public double summonSpellPower = 0.0;
        public double conjurationSpellResistance = 0.0;
        public double elementalSpellPower = 0.0;
        public double elementalSpellResistance = 0.0;
        public double manaDiscount = 0.0;
        public double spellCriticalChance = 0.0;
        public double spellCriticalDamage = 0.0;
        // Additional Malum Attributes
        public double arcaneResonance = 0.0;
        public double chargeCapacity = 0.0;
        public double chargeDuration = 0.0;
        public double chargeRecoveryRate = 0.0;
        public double geasLimit = 0.0;
        public double malignantAegisCapacity = 0.0;
        public double malignantAegisRecoveryGain = 0.0;
        public double malignantAegisRecoveryRate = 0.0;
        public double malignantConversion = 0.0;
        public double scytheProficiency = 0.0;
        public double soulWardCapacity = 0.0;
        public double soulWardIntegrity = 0.0;
        public double soulWardRecoveryGain = 0.0;
        public double soulWardRecoveryRate = 0.0;
        public double spiritSpoils = 0.0;
        public double magicDamage = 0.0;
        public double magicProficiency = 0.0;
        public double magicResistance = 0.0;

        @Comment("What intrinsics should this race have?")
        public List<String> lesserAspectBornIntrinsics = List.of();

        public double getMinAura() {
            return this.minAura;
        }
        public double getMaxAura() {
            return this.maxAura;
        }
        public double getMinMagicule() {
            return this.minMagicule;
        }
        public double getMaxMagicule() {
            return this.maxMagicule;
        }
        public double getSize() {
            return this.size;
        }
        public double getMaxHealth() {
            return this.maxHealth;
        }
        public double getMaxSpiritualHealth() {
            return this.maxSpiritualHealth;
        }
        public double getAttack() {
            return this.attack;
        }
        public double getAttackSpeed() {
            return this.attackSpeed;
        }
        public double getKnockbackResistance() {
            return this.knockbackResistance;
        }
        public double getMovementSpeed() {
            return this.movementSpeed;
        }
        public double getSwimSpeed() {
            return this.swimSpeed;
        }
        // Tensura Additional Attributes
        public double getAbilityLearnGain() {
            return this.abilityLearnGain;
        }
        public double getAbilityMasterGain() {
            return this.abilityMasterGain;
        }
        public double getAnalysisDistance() {
            return this.analysisDistance;
        }
        public double getAnalysisLevel() {
            return this.analysisLevel;
        }
        public double getAuraRegenMulti() {
            return this.auraRegenMulti;
        }
        public double getManaRegenMulti() {
            return this.manaRegenMulti;
        }
        public double getShpRegen() {
            return this.shpRegen;
        }
        public double getChantSpeed() {
            return this.chantSpeed;
        }
        public double getDarkVision() {
            return this.darkVision;
        }
        public double getMagicCostMulti() {
            return this.magicCostMulti;
        }
        public double getPresenceConcealment() {
            return this.presenceConcealment;
        }
        public double getPresenceSense() {
            return this.presenceSense;
        }
        public double getPresenceSenseRange() {
            return this.presenceSenseRange;
        }
        // Apotheosis Additional Attributes
        public double getArmorPierce() {
            return this.armorPierce;
        }
        public double getArmorShred() {
            return this.armorShred;
        }
        public double getArrowDamage() {
            return this.arrowDamage;
        }
        public double getArrowVelocity() {
            return this.arrowVelocity;
        }
        public double getCritChance() {
            return this.critChance;
        }
        public double getCritDamage() {
            return this.critDamage;
        }
        public double getHealingRecieved() {
            return this.healingRecieved;
        }
        public double getOverHeal() {
            return this.overHeal;
        }
        public double getLifeSteal() {
            return this.lifeSteal;
        }
        public double getCurrentHealthDamage() {
            return this.currentHealthDamage;
        }
        public double getDodgeChance() {
            return this.dodgeChance;
        }
        public double getDrawSpeed() {
            return this.drawSpeed;
        }
        public double getExperienceGained() {
            return this.experienceGained;
        }
        public double getProjDamage() {
            return this.projDamage;
        }
        public double getProtPierce() {
            return this.protPierce;
        }
        public double getProtShred() {
            return this.protShred;
        }
        // Minecraft Additional Attributes
        public double getArmor() {
            return this.armor;
        }
        public double getArmorToughness() {
            return this.armorToughness;
        }
        public double getAttackKnockback() {
            return this.attackKnockback;
        }
        public double getBlockBreakSpeed() {
            return this.blockBreakSpeed;
        }
        public double getBlockInteractionRange() {
            return this.blockInteractionRange;
        }
        public double getEntityInteractionRange() {
            return this.entityInteractionRange;
        }
        public double getExplosionKnockbackResistance() {
            return this.explosionKnockbackResistance;
        }
        public double getStepHeight() {
            return this.stepHeight;
        }
        public double getMiningEfficiency() {
            return this.miningEfficiency;
        }
        public double getMovementEfficiency() {
            return this.movementEfficiency;
        }
        public double getWaterMovementEfficiency() {
            return this.waterMovementEfficiency;
        }
        public double getSubmergedMiningSpeed() {
            return this.submergedMiningSpeed;
        }
        public double getFallDamageMultiplier() {
            return this.fallDamageMultiplier;
        }
        public double getLuck() {
            return this.luck;
        }
        public double getGravity() {
            return this.gravity;
        }
        public double getOxygenBonus() {
            return this.oxygenBonus;
        }
        public double getSneakingSpeed() {
            return this.sneakingSpeed;
        }
        public double getSweepingDamageRatio() {
            return this.sweepingDamageRatio;
        }
        public double getSafeFallDistance() {
            return this.safeFallDistance;
        }
        // Ars Nouveau Additional Attributes
        public double getDrygmyLootingModifier() {
            return this.drygmyLootingModifier;
        }
        public double getWixiePotionDuration() {
            return this.wixiePotionDuration;
        }
        public double getWhirlsprigSaturationModifier() {
            return this.whirlsprigSaturationModifier;
        }
        public double getSpellDamageBonus() {
            return this.spellDamageBonus;
        }
        public double getMaxMana() {
            return this.maxMana;
        }
        public double getManaRegen() {
            return this.manaRegen;
        }
        public double getFeather() {
            return this.feather;
        }
        public double getWarding() {
            return this.warding;
        }
        public double getWeight() {
            return this.weight;
        }

        public double getFireSpellDamage() {
            return this.fireSpellDamage;
        }
        public double getFireSpellResistance() {
            return this.fireSpellResistance;
        }
        public double getWaterSpellDamage() {
            return this.waterSpellDamage;
        }
        public double getWaterSpellResistance() {
            return this.waterSpellResistance;
        }
        public double getEarthSpellDamage() {
            return this.earthSpellDamage;
        }
        public double getEarthSpellResistance() {
            return this.earthSpellResistance;
        }
        public double getAirSpellDamage() {
            return this.airSpellDamage;
        }
        public double getAirSpellResistance() {
            return this.airSpellResistance;
        }
        public double getAbjurationSpellPower() {
            return this.abjurationSpellPower;
        }
        public double getAbjurationSpellResistance() {
            return this.abjurationSpellResistance;
        }
        public double getManipulationSpellPower() {
            return this.manipulationSpellPower;
        }
        public double getManipulationSpellResistance() {
            return this.manipulationSpellResistance;
        }
        public double getNecromancySpellPower() {
            return this.necromancySpellPower;
        }
        public double getNecromancySpellResistance() {
            return this.necromancySpellResistance;
        }
        public double getSummonSpellPower() {
            return this.summonSpellPower;
        }
        public double getConjurationSpellResistance() {
            return this.conjurationSpellResistance;
        }
        public double getElementalSpellPower() {
            return this.elementalSpellPower;
        }
        public double getElementalSpellResistance() {
            return this.elementalSpellResistance;
        }
        public double getManaDiscount() {
            return this.manaDiscount;
        }
        public double getSpellCriticalChance() {
            return this.spellCriticalChance;
        }
        public double getSpellCriticalDamage() {
            return this.spellCriticalDamage;
        }
        // Malum Additional Attributes
        public double getArcaneResonance() {
            return this.arcaneResonance;
        }
        public double getChargeCapacity() {
            return this.chargeCapacity;
        }
        public double getChargeDuration() {
            return this.chargeDuration;
        }
        public double getChargeRecoveryRate() {
            return this.chargeRecoveryRate;
        }
        public double getGeasLimit() {
            return this.geasLimit;
        }
        public double getMalignantAegisCapacity() {
            return this.malignantAegisCapacity;
        }
        public double getMalignantAegisRecoveryGain() {
            return this.malignantAegisRecoveryGain;
        }
        public double getMalignantAegisRecoveryRate() {
            return this.malignantAegisRecoveryRate;
        }
        public double getMalignantConversion() {
            return this.malignantConversion;
        }
        public double getScytheProficiency() {
            return this.scytheProficiency;
        }
        public double getSoulWardCapacity() {
            return this.soulWardCapacity;
        }
        public double getSoulWardIntegrity() {
            return this.soulWardIntegrity;
        }
        public double getSoulWardRecoveryGain() {
            return this.soulWardRecoveryGain;
        }
        public double getSoulWardRecoveryRate() {
            return this.soulWardRecoveryRate;
        }
        public double getSpiritSpoils() {
            return this.spiritSpoils;
        }
        public double getMagicDamage() {
            return this.magicDamage;
        }
        public double getMagicProficiency() {
            return this.magicProficiency;
        }
        public double getMagicResistance() {
            return this.magicResistance;
        }
    }
}
