package com.github.propheticeclipse.tensurastarlight.race;

import com.alexthw.sauce.registry.ModRegistry;
import com.github.propheticeclipse.tensurastarlight.config.StarlightCommon;
import com.hollingsworth.arsnouveau.api.perk.PerkAttributes;
import com.sammy.malum.registry.common.MalumAttributes;
import dev.shadowsoffire.apothic_attributes.ApothicAttributes;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.github.manasmods.manascore.config.ConfigRegistry;
import io.github.manasmods.manascore.race.api.ManasRace;
import io.github.manasmods.tensura.config.race.RaceConfig;
import io.github.manasmods.tensura.race.template.DefaultRace;
import io.github.manasmods.tensura.registry.attribute.TensuraAttributes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import team.lodestar.lodestone.registry.common.LodestoneAttributes;

public abstract class StarlightRace extends DefaultRace {
    public StarlightRace(ManasRace.Difficulty difficulty) {
        super(difficulty);
    }

    public abstract StarlightCommon.RaceDefault getAttributeDefaultConfig();

    public void applyDefaultAttributeModifiers() {
        //this.addAttributeModifier(Attributes.SCALE, DEFAULT_RACE_ID, this.getDefaultConfig().getSize(), AttributeModifier.Operation.ADD_VALUE);
        // Apotheosis Attributes
        this.addAttributeModifier(ALObjects.Attributes.ARMOR_PIERCE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getArmorPierce(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ALObjects.Attributes.ARMOR_SHRED, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getArmorShred(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ALObjects.Attributes.ARROW_DAMAGE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getArrowDamage(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ALObjects.Attributes.ARROW_VELOCITY, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getArrowVelocity(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ALObjects.Attributes.CRIT_CHANCE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getCritChance(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ALObjects.Attributes.CRIT_DAMAGE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getCritDamage(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ALObjects.Attributes.HEALING_RECEIVED, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getHealingRecieved(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ALObjects.Attributes.OVERHEAL, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getOverHeal(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ALObjects.Attributes.LIFE_STEAL, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getLifeSteal(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ALObjects.Attributes.CURRENT_HP_DAMAGE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getCurrentHealthDamage(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ALObjects.Attributes.DODGE_CHANCE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getDodgeChance(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ALObjects.Attributes.DRAW_SPEED, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getDrawSpeed(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ALObjects.Attributes.EXPERIENCE_GAINED, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getExperienceGained(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ALObjects.Attributes.PROJECTILE_DAMAGE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getProjDamage(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ALObjects.Attributes.PROT_PIERCE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getProtPierce(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ALObjects.Attributes.PROT_SHRED, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getProtShred(), AttributeModifier.Operation.ADD_VALUE);
        // Tensura Attributes
        this.addAttributeModifier(TensuraAttributes.ABILITY_LEARNING_GAIN, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getAbilityLearnGain(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(TensuraAttributes.ABILITY_MASTERY_GAIN, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getAbilityMasterGain(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(TensuraAttributes.ANALYSIS_DISTANCE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getAnalysisDistance(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(TensuraAttributes.ANALYSIS_LEVEL, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getAnalysisLevel(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(TensuraAttributes.AURA_REGENERATION_MULTIPLIER, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getAuraRegenMulti(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(TensuraAttributes.MAGICULE_REGENERATION_MULTIPLIER, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getManaRegenMulti(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(TensuraAttributes.SPIRITUAL_HEALTH_REGENERATION, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getShpRegen(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(TensuraAttributes.CHANT_SPEED, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getChantSpeed(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(TensuraAttributes.DARK_VISION, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getDarkVision(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(TensuraAttributes.MAGIC_COST_MULTIPLIER, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getMagicCostMulti(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(TensuraAttributes.PRESENCE_CONCEALMENT, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getPresenceConcealment(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(TensuraAttributes.PRESENCE_SENSE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getPresenceSense(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(TensuraAttributes.PRESENCE_SENSE_RADIUS, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getPresenceSenseRange(), AttributeModifier.Operation.ADD_VALUE);
        // Minecraft Attributes
        this.addAttributeModifier(Attributes.ARMOR, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getArmor(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getArmorToughness(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.ATTACK_KNOCKBACK, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getAttackKnockback(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.BLOCK_BREAK_SPEED, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getBlockBreakSpeed(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.BLOCK_INTERACTION_RANGE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getBlockInteractionRange(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.ENTITY_INTERACTION_RANGE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getEntityInteractionRange(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getExplosionKnockbackResistance(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.STEP_HEIGHT, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getStepHeight(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.MINING_EFFICIENCY, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getMiningEfficiency(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.MOVEMENT_EFFICIENCY, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getMovementEfficiency(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.WATER_MOVEMENT_EFFICIENCY, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getWaterMovementEfficiency(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.SUBMERGED_MINING_SPEED, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getSubmergedMiningSpeed(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.FALL_DAMAGE_MULTIPLIER, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getFallDamageMultiplier(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.LUCK, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getLuck(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.GRAVITY, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getGravity(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.OXYGEN_BONUS, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getOxygenBonus(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.SNEAKING_SPEED, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getSneakingSpeed(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.SWEEPING_DAMAGE_RATIO, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getSweepingDamageRatio(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.SAFE_FALL_DISTANCE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getSafeFallDistance(), AttributeModifier.Operation.ADD_VALUE);
        // Ars Nouveau Attributes
        this.addAttributeModifier(PerkAttributes.DRYGMY, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getDrygmyLootingModifier(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(PerkAttributes.WIXIE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getWixiePotionDuration(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(PerkAttributes.WHIRLIESPRIG, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getWhirlsprigSaturationModifier(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(PerkAttributes.SPELL_DAMAGE_BONUS, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getSpellDamageBonus(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(PerkAttributes.MAX_MANA, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getMaxMana(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(PerkAttributes.MANA_REGEN_BONUS, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getManaRegen(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(PerkAttributes.FEATHER, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getFeather(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(PerkAttributes.WARDING, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getWarding(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(PerkAttributes.WEIGHT, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getWeight(), AttributeModifier.Operation.ADD_VALUE);
        // Ars Nouveau (Sauce Lib)
        this.addAttributeModifier(ModRegistry.MANA_DISCOUNT, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getManaDiscount(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ModRegistry.ABJURATION_POWER, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getAbjurationSpellPower(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ModRegistry.ABJURATION_RESISTANCE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getAbjurationSpellResistance(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ModRegistry.EARTH_POWER, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getEarthSpellDamage(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ModRegistry.EARTH_RESISTANCE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getEarthSpellResistance(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ModRegistry.FIRE_POWER, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getFireSpellDamage(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ModRegistry.FIRE_RESISTANCE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getFireSpellResistance(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ModRegistry.WATER_POWER, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getWaterSpellDamage(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ModRegistry.WATER_RESISTANCE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getWaterSpellResistance(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ModRegistry.AIR_POWER, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getAirSpellDamage(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ModRegistry.AIR_RESISTANCE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getAirSpellResistance(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ModRegistry.MANIPULATION_POWER, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getManipulationSpellPower(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ModRegistry.NECROMANCY_POWER, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getNecromancySpellPower(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ModRegistry.SUMMON_POWER, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getSummonSpellPower(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ModRegistry.MANIPULATION_RESISTANCE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getManipulationSpellResistance(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ModRegistry.NECROMANCY_RESISTANCE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getNecromancySpellResistance(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ModRegistry.CONJURATION_RESISTANCE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getConjurationSpellResistance(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ModRegistry.ELEMENTAL_POWER, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getElementalSpellPower(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ModRegistry.ELEMENTAL_RESISTANCE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getElementalSpellResistance(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ModRegistry.SPELL_CRIT, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getSpellCriticalChance(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(ModRegistry.SPELL_CRIT_DAMAGE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getSpellCriticalDamage(), AttributeModifier.Operation.ADD_VALUE);
        // Malum + Lodestone Attributes
        this.addAttributeModifier(MalumAttributes.ARCANE_RESONANCE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getArcaneResonance(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(MalumAttributes.CHARGE_CAPACITY, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getChargeCapacity(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(MalumAttributes.CHARGE_DURATION, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getChargeDuration(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(MalumAttributes.CHARGE_RECOVERY_RATE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getChargeRecoveryRate(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(MalumAttributes.GEAS_LIMIT, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getGeasLimit(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(MalumAttributes.MALIGNANT_AEGIS_CAPACITY, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getMalignantAegisCapacity(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(MalumAttributes.MALIGNANT_AEGIS_RECOVERY_GAIN, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getMalignantAegisRecoveryGain(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(MalumAttributes.MALIGNANT_AEGIS_RECOVERY_RATE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getMalignantAegisRecoveryRate(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(MalumAttributes.MALIGNANT_CONVERSION, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getMalignantConversion(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(MalumAttributes.SCYTHE_PROFICIENCY, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getScytheProficiency(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(MalumAttributes.SOUL_WARD_CAPACITY, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getSoulWardCapacity(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(MalumAttributes.SOUL_WARD_INTEGRITY, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getSoulWardIntegrity(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(MalumAttributes.SOUL_WARD_RECOVERY_GAIN, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getSoulWardRecoveryGain(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(MalumAttributes.SOUL_WARD_RECOVERY_RATE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getSoulWardRecoveryRate(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(MalumAttributes.SPIRIT_SPOILS, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getSpiritSpoils(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(LodestoneAttributes.MAGIC_DAMAGE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getMagicDamage(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(LodestoneAttributes.MAGIC_PROFICIENCY, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getMagicProficiency(), AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(LodestoneAttributes.MAGIC_RESISTANCE, DEFAULT_RACE_ID, this.getAttributeDefaultConfig().getMagicResistance(), AttributeModifier.Operation.ADD_VALUE);
    }
}
