package com.github.propheticeclipse.tensurastarlight.ability.skill.unique.evolvedUnique;

import com.github.propheticeclipse.tensurastarlight.config.skills.aspectSeriesSkillConfig;
import com.github.propheticeclipse.tensurastarlight.registry.StarlightEffects;
import com.github.propheticeclipse.tensurastarlight.registry.skills.StarlightUniqueSkills;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import dev.shadowsoffire.placebo.color.GradientColor;
import io.github.manasmods.manascore.config.ConfigRegistry;
import io.github.manasmods.manascore.network.api.util.Changeable;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.manascore.skill.api.SkillAPI;
import io.github.manasmods.manascore.skill.impl.SkillStorage;
import io.github.manasmods.tensura.ability.SkillUtils;
import io.github.manasmods.tensura.ability.skill.Skill;
import io.github.manasmods.tensura.damage.TensuraDamageHelper;
import io.github.manasmods.tensura.registry.attribute.TensuraAttributes;
import io.github.manasmods.tensura.registry.effect.TensuraMobEffects;
import io.github.manasmods.tensura.storage.TensuraStorages;
import io.github.manasmods.tensura.storage.ep.IExistence;
import io.github.manasmods.tensura.util.AttributeHelper;
import io.github.manasmods.tensura.util.EnergyHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;

public class RemnantsOfAscensionSkill extends Skill {
    public static final ResourceLocation REMNANTS_OF_ASCENSION;
    private static final aspectSeriesSkillConfig.RemnantsOfAscension CONFIG;
    public RemnantsOfAscensionSkill() {
        super(SkillType.UNIQUE);
    }

    /*Remnants of Ascension
Evolved Unique
“Motion is born from pause. Form is sculpted in collapse. What was power is no longer force — but continuity, shaped through pressure and will.”
Acquisition Conditions:
Mastered Ember Remains (Sacrificed)
Mastered Current Unbroken (Sacrificed)
Mastered Shape Forgotten (Sacrificed)
150k MP
Demon Lord Seed or Hero Egg

Passives

[Passive - True] Shifting Form:
After taking damage, temporarily increase armour by 10 and armour toughness by 2, up to 100/20 points respectively with repeated damage.
Effects will fade over time. Additionally, for every 10 points of armour gained by this effect,
negate 5 (10 Mastered) damage from any incoming damage. Consumes 500 MP per level of buff added.

Improve EP regen by 40 (80 Mastered)/s, additionally, Improve magic damage by 1.5x stacking with other bonuses.
Magicule consumption is reduced by 10%
Gain mastery every 5 seconds.


[Passive - True] Eidolon of Infernos:
Bypass Death, set SHP and HP to 10%, gain resistance 3 for 60s. 600s CD, Costless.
Resist 20% Magic and Elemental damage, up to a limit of 500 (1000 Mastered). Damage resisted by this effect are translated into barrier points

[Passive - Toggle] Fracture the Core:
Increase base attack damage by 1.25x, Increase Crit Damage by +0.5x, Penetrate 8 levels of protection, and Penetrate 5% of armor.

Actives

[Active - Press] Flaring Form: Increase the duration of beneficial effects by 60s and cure negative status effects. Consume 2500 MP/ Minute and 1000 MP/ Level cured. 30s (15s Mastered) CD.

Temporarily affects all beneficial effects and negative status effects.*/

    @Override
    public @Nullable MutableComponent getColoredName() {
        MutableComponent name = super.getColoredName();
        return name == null ? null : name.withStyle(s -> s.withColor(GradientColor.RAINBOW)); //Testing Colouring
    }

    @Override
    public boolean checkAcquiringRequirement(Player entity, double newEP) {
        /*Acquisition Conditions:
        Mastered Ember Remains (Sacrificed)
        Mastered Current Unbroken (Sacrificed)
        Mastered Shape Forgotten (Sacrificed)
        150k MP
        Demon Lord Seed or Hero Egg
        */
        IExistence existence = TensuraStorages.getExistenceFrom(entity);

        boolean masteredEmber = SkillUtils.isSkillMastered(entity, StarlightUniqueSkills.EMBER_REMAINS.get());
        boolean masteredCurrent = SkillUtils.isSkillMastered(entity, StarlightUniqueSkills.CURRENT_UNBROKEN.get());
        boolean masteredShape = SkillUtils.isSkillMastered(entity, StarlightUniqueSkills.SHAPE_FORGOTTEN.get());
        boolean egg = existence.isHeroEgg();
        boolean seed = existence.isDemonLordSeed();
        boolean seedOrEgg = egg || seed;
        return masteredEmber && masteredCurrent && masteredShape && seedOrEgg;
    }

    @Override
    public int getAcquirementMastery(LivingEntity entity) {
        return CONFIG.acquirementMastery;
    }

    @Override
    public void onLearnSkill(ManasSkillInstance instance, LivingEntity entity) {
        SkillStorage storage = SkillAPI.getSkillsFrom(entity);

        Skill remnants = (Skill) StarlightUniqueSkills.REMNANTS_OF_ASCENSION.get();
        Skill emberRemains = (Skill) StarlightUniqueSkills.EMBER_REMAINS.get();
        Skill currentUnbroken = (Skill) StarlightUniqueSkills.CURRENT_UNBROKEN.get();
        Skill shapeForgotten = (Skill) StarlightUniqueSkills.SHAPE_FORGOTTEN.get();
        if (entity instanceof Player player) {
            if (SkillUtils.hasSkill(entity, StarlightUniqueSkills.EMBER_REMAINS.get())) {
                storage.forgetSkill(StarlightUniqueSkills.EMBER_REMAINS.get());
                player.displayClientMessage(
                        Component.translatable(
                                "trstarlight.generic.skill.single_skill.sacrifice",
                                emberRemains.getChatDisplayName(true)
                        ).withStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)),
                        false
                );
            }

            if (SkillUtils.hasSkill(entity, StarlightUniqueSkills.CURRENT_UNBROKEN.get())) {
                storage.forgetSkill(StarlightUniqueSkills.CURRENT_UNBROKEN.get());
                player.displayClientMessage(
                        Component.translatable(
                                "trstarlight.generic.skill.single_skill.sacrifice",
                                currentUnbroken.getChatDisplayName(true)
                        ).withStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)),
                        false
                );
            }

            if (SkillUtils.hasSkill(entity, StarlightUniqueSkills.SHAPE_FORGOTTEN.get())) {
                storage.forgetSkill(StarlightUniqueSkills.SHAPE_FORGOTTEN.get());
                player.displayClientMessage(
                        Component.translatable(
                                "trstarlight.generic.skill.single_skill.sacrifice",
                                shapeForgotten.getChatDisplayName(true)
                        ).withStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)),
                        false
                );
            }

            player.displayClientMessage(
                    Component.translatable(
                            "trstarlight.generic.skill.unique.evolution",
                            emberRemains.getChatDisplayName(true)
                    ).withStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)), //(s -> s.withColor(GradientColor.RAINBOW)
                    false
            );
            player.displayClientMessage(
                    Component.translatable(
                            "trstarlight.generic.skill.success"
                    ).withStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)),
                    false
            );
            player.displayClientMessage(
                    Component.translatable(
                            "trstarlight.generic.skill.unique",
                            remnants.getChatDisplayName(true)
                    ).withStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)),
                    false
            );
        } else {
            storage.forgetSkill(StarlightUniqueSkills.EMBER_REMAINS.get());
            storage.forgetSkill(StarlightUniqueSkills.CURRENT_UNBROKEN.get());
            storage.forgetSkill(StarlightUniqueSkills.SHAPE_FORGOTTEN.get());
        }
    }

    public double getAcquiringMagiculeCost(ManasSkillInstance instance) {
        return CONFIG.magiculeAcquirementCost;
    }

    public int getModes(ManasSkillInstance instance) {
        return 2;
    }

    public String getModeId(ManasSkillInstance instance, int mode) {
        String var10000;
        if (mode == 0) {
            var10000 = "remnants_of_ascension.flaring_form";
        } else {
            var10000 = super.getModeId(instance, mode);
        }

        return var10000;
    }

    public double getMagiculeCost(LivingEntity entity, ManasSkillInstance instance, int mode) {
        double cost;
        switch (mode) {
            case 0 -> cost = 0.0;
            case 1 -> cost = 500.0;
            default -> cost = 0.0;
        }

        return cost;
    }

    public boolean canTick(ManasSkillInstance instance, LivingEntity entity) {
        return true;
    }

    public boolean canBeToggled(ManasSkillInstance instance, LivingEntity entity) {
        return true;
    }

    @Override
    public void onTick(ManasSkillInstance instance, LivingEntity living) {
        /*
        Improve EP regen by 40 (80 Mastered)/s, additionally, Improve magic damage by 1.5x stacking with other bonuses.
        Magicule consumption is reduced by 10%
        Gain mastery every 5 seconds.
         */
        CompoundTag tag = instance.getOrCreateTag();
        int time = tag.getInt("activatedTimes");
        if (time % 10 == 0) {
            this.addMasteryPoint(instance, living);
        }

        ExistenceRegeneration(living, instance);
        tag.putInt("activatedTimes", time + 1);
    }

    private void ExistenceRegeneration(LivingEntity entity, ManasSkillInstance instance) {
        IExistence existence = TensuraStorages.getExistenceFrom(entity);
        double manaIncrease = isMastered(instance, entity) ? CONFIG.existenceMPRegenMastered : CONFIG.existenceMPRegenUnmastered;
        double auraIncrease = isMastered(instance, entity) ? CONFIG.existenceAPRegenMastered : CONFIG.existenceAPRegenUnmastered;

        existence.setMagicule(existence.getMagicule() + manaIncrease);
        existence.setAura(existence.getAura() + auraIncrease);
        existence.markDirty();
    }

    @Override
    public void onToggleOn(ManasSkillInstance instance, LivingEntity entity) {
        /*
        [Passive - Toggle] Fracture the Core:
        Increase base attack damage by 1.25x, Increase Crit Damage by +0.5x, Penetrate 8 levels of protection, and Penetrate 5% of armor.
         */
        double attackModifier = CONFIG.coreFractureAttackMod;
        double critDamageModifier = CONFIG.coreFractureCritDamageMod;
        double armPierceModifier = CONFIG.coreFractureArmorShredMod;
        double protPierceModifier = CONFIG.coreFractureProtPierceMod;
        AttributeInstance attack = entity.getAttribute(Attributes.ATTACK_DAMAGE);
        if (attack != null && !attack.hasModifier(REMNANTS_OF_ASCENSION)) {
            attack.addOrReplacePermanentModifier(new AttributeModifier(REMNANTS_OF_ASCENSION, attackModifier, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
        }

        AttributeInstance critDamage = entity.getAttribute(ALObjects.Attributes.CRIT_DAMAGE);
        if (critDamage != null && !critDamage.hasModifier(REMNANTS_OF_ASCENSION)) {
            critDamage.addOrReplacePermanentModifier(new AttributeModifier(REMNANTS_OF_ASCENSION, critDamageModifier, AttributeModifier.Operation.ADD_VALUE));
        }

        AttributeInstance protPierce = entity.getAttribute(ALObjects.Attributes.PROT_PIERCE);
        if (protPierce != null && !protPierce.hasModifier(REMNANTS_OF_ASCENSION)) {
            protPierce.addOrReplacePermanentModifier(new AttributeModifier(REMNANTS_OF_ASCENSION, protPierceModifier, AttributeModifier.Operation.ADD_VALUE));
        }

        AttributeInstance armPierce = entity.getAttribute(ALObjects.Attributes.ARMOR_SHRED);
        if (armPierce != null && !armPierce.hasModifier(REMNANTS_OF_ASCENSION)) {
            armPierce.addOrReplacePermanentModifier(new AttributeModifier(REMNANTS_OF_ASCENSION, armPierceModifier, AttributeModifier.Operation.ADD_VALUE));
        }
    }

    @Override
    public void onToggleOff(ManasSkillInstance instance, LivingEntity entity) {
        AttributeInstance attack = entity.getAttribute(Attributes.ATTACK_DAMAGE);
        if (attack != null) {
            attack.removeModifier(REMNANTS_OF_ASCENSION);
        }

        AttributeInstance critDam = entity.getAttribute(ALObjects.Attributes.CRIT_DAMAGE);
        if (critDam != null) {
            critDam.removeModifier(REMNANTS_OF_ASCENSION);
        }

        AttributeInstance pierce = entity.getAttribute(ALObjects.Attributes.PROT_PIERCE);
        if (pierce != null) {
            pierce.removeModifier(REMNANTS_OF_ASCENSION);
        }

        AttributeInstance shred = entity.getAttribute(ALObjects.Attributes.ARMOR_SHRED);
        if (shred != null) {
            shred.removeModifier(REMNANTS_OF_ASCENSION);
        }
    }

    @Override
    public void onRespawn(ManasSkillInstance instance, ServerPlayer owner, boolean conqueredEnd) {
        double attackModifier = CONFIG.coreFractureAttackMod;
        double critDamageModifier = CONFIG.coreFractureCritDamageMod;
        double armPierceModifier = CONFIG.coreFractureArmorShredMod;
        double protPierceModifier = CONFIG.coreFractureProtPierceMod;
        AttributeInstance attack = owner.getAttribute(TensuraAttributes.AURA_GAIN);
        if (attack != null && !attack.hasModifier(REMNANTS_OF_ASCENSION)) {
            attack.addOrReplacePermanentModifier(new AttributeModifier(REMNANTS_OF_ASCENSION, attackModifier, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
        }

        AttributeInstance critDamage = owner.getAttribute(ALObjects.Attributes.CRIT_DAMAGE);
        if (critDamage != null && !critDamage.hasModifier(REMNANTS_OF_ASCENSION)) {
            critDamage.addOrReplacePermanentModifier(new AttributeModifier(REMNANTS_OF_ASCENSION, critDamageModifier, AttributeModifier.Operation.ADD_VALUE));
        }

        AttributeInstance protPierce = owner.getAttribute(ALObjects.Attributes.PROT_PIERCE);
        if (protPierce != null && !protPierce.hasModifier(REMNANTS_OF_ASCENSION)) {
            protPierce.addOrReplacePermanentModifier(new AttributeModifier(REMNANTS_OF_ASCENSION, protPierceModifier, AttributeModifier.Operation.ADD_VALUE));
        }

        AttributeInstance armPierce = owner.getAttribute(ALObjects.Attributes.ARMOR_SHRED);
        if (armPierce != null && !armPierce.hasModifier(REMNANTS_OF_ASCENSION)) {
            armPierce.addOrReplacePermanentModifier(new AttributeModifier(REMNANTS_OF_ASCENSION, armPierceModifier, AttributeModifier.Operation.ADD_VALUE));
        }
    }

    @Override
    public boolean onTakenDamage(ManasSkillInstance instance, LivingEntity owner, DamageSource source, Changeable<Float> amount) {
        /*After taking damage, temporarily increase armour by 10 and armour toughness by 2, up to 100/20 points respectively with repeated damage.
        Effects will fade over time. Additionally, for every 10 points of armour gained by this effect,
        negate 5 (10 Mastered) damage from any incoming damage. Consumes 500 MP per level of buff added.*/

        double originalDamageNum = amount.get();
        MobEffectInstance buff = owner.getEffect(TensuraMobEffects.getReference(StarlightEffects.REMNANT_ASCENSION_ARMOR));

        if (originalDamageNum >= CONFIG.shiftingFormDamageTrigger) {
            int i = 0;
            int originalDuration = CONFIG.shiftingFormDurationFirstHit;
            int duration;
            if (buff != null) {
                duration = buff.getDuration() + CONFIG.shiftingFormDurationConsecutiveHit;
                i = (duration - originalDuration) / (CONFIG.shiftingFormAmpliDurationScaling);
                addMasteryPoint(instance, owner);
            } else {
                duration = originalDuration;
            }
            if (i > CONFIG.shiftingFormBuffMaxAmplifier) {
                i = CONFIG.shiftingFormBuffMaxAmplifier;
            }

            if (EnergyHelper.isOutOfEnergy(owner, instance, 1, i)) {
                // This should prevent the skill from adding the effect if you are out of the magicules to apply the amplifier level.
                return true;
            }

            owner.addEffect(new MobEffectInstance((TensuraMobEffects.getReference(StarlightEffects.REMNANT_ASCENSION_ARMOR)), duration, i, false, false, false));

            if (buff != null) {
                int j = (buff.getAmplifier() + 1);
                double damageModifier = isMastered(instance, owner) ? CONFIG.damageNegationMastered : CONFIG.damageNegationUnmastered;
                double totalReduction = damageModifier * j;


                amount.set((float) (originalDamageNum - totalReduction));
            }
        }
        // Resist 20% Magic and Elemental damage, up to a limit of 500 (1000 Mastered). Damage resisted by this effect are translated into barrier points

        double damageModifier = CONFIG.elementalDamageResistanceMod;
        double reducedDamageTotal = (originalDamageNum * damageModifier);
        double damageDifference = (originalDamageNum - reducedDamageTotal);
        int damageNegation = isMastered(instance, owner) ? CONFIG.elementalDamageNegationCapMastered : CONFIG.elementalDamageNegationCapUnmastered;
        if (TensuraDamageHelper.isTensuraMagic(source) || TensuraDamageHelper.isNaturalEffects(source)) {
            if (instance.isToggled()) {
                if (damageDifference >= damageNegation) {
                    double currentBarrier = owner.getAttributeValue(TensuraAttributes.MULTILAYER_BARRIER);
                    AttributeHelper.addPermanentAttributeIfHigher(owner, TensuraAttributes.MULTILAYER_BARRIER, REMNANTS_OF_ASCENSION, currentBarrier + damageNegation, AttributeModifier.Operation.ADD_VALUE);

                    amount.set((float) (originalDamageNum - damageNegation));
                }

                if (damageDifference <= damageNegation) {
                    double currentBarrier = owner.getAttributeValue(TensuraAttributes.MULTILAYER_BARRIER);
                    AttributeHelper.addPermanentAttributeIfHigher(owner, TensuraAttributes.MULTILAYER_BARRIER, REMNANTS_OF_ASCENSION, currentBarrier + damageDifference, AttributeModifier.Operation.ADD_VALUE);

                    amount.set((float) reducedDamageTotal);
                }
            }
        }

        return true;
    }

    @Override
    public boolean onDeath(ManasSkillInstance instance, LivingEntity owner, DamageSource source) {
        if (owner instanceof Player player) {
            IExistence existence = TensuraStorages.getExistenceFrom(player);
            double maxSHP = player.getAttributeValue(TensuraAttributes.MAX_SPIRITUAL_HEALTH);
            double maxHP = player.getMaxHealth();
            // Place anti-resurrection skill flag here!
            if ((instance.getCoolDown(1) == 0) && instance.isToggled()) {
                player.removeAllEffects();
                player.invulnerableTime = 60;

                player.setHealth(((float) ((maxHP * CONFIG.deathBypassHealthReturn) + 1)));
                if (maxSHP <= (existence.getSpiritualHealth() * CONFIG.deathBypassSpiritualHealthReturnThresh)) {
                    existence.setSpiritualHealth((maxSHP * CONFIG.deathBypassSpiritualHealthReturn) + 1);
                }

                applyEffects(owner);

                instance.setCoolDown(CONFIG.deathBypassCooldown, 1);
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    private void applyEffects(LivingEntity owner) {
        if (owner instanceof Player player) {
            MobEffectInstance resistance = new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, CONFIG.deathBypassResistanceDuration, CONFIG.deathBypassResistanceAmplifier, false, false, false);
            player.addEffect(resistance);
        }
    }

    @Override
    public void onPressed(ManasSkillInstance instance, LivingEntity entity, int keyNumber, int mode) {
       //[Active - Press] Flaring Form: Increase the duration of beneficial effects by 60s and cure negative status effects.
        // Consume 2500 MP/ Minute and 1000 MP/ Level cured. 30s (15s Mastered) CD.
        int cooldown = isMastered(instance, entity) ? CONFIG.flaringFormCooldownMastered : CONFIG.flaringFormCooldownUnmastered;
        if (mode == 0) {
            if (entity instanceof Player player) {
                IExistence existence = TensuraStorages.getExistenceFrom(player);
                int effectsRemoved = 0;
                int totalDurationExtended = 0;
                for (MobEffectInstance effect : player.getActiveEffects()) {
                    if (effect.getEffect().value().getCategory() == MobEffectCategory.BENEFICIAL) {
                        int newDuration = effect.getDuration() + CONFIG.flaringFormBuffDurationBonus; // +60s
                        MobEffectInstance extended = new MobEffectInstance(effect.getEffect(), newDuration, effect.getAmplifier(), effect.isAmbient(), effect.isVisible(), effect.showIcon());
                        player.addEffect(extended);
                        totalDurationExtended += 1;
                    }
                    if (effect.getEffect().value().getCategory() == MobEffectCategory.HARMFUL) {
                        int levels = (effect.getAmplifier() + 1);
                        player.removeEffect(effect.getEffect());
                        effectsRemoved += levels;
                    }
                }
                double extensionCost = CONFIG.flaringFormBuffMPCostPerDurationBonus;
                double removalCost = CONFIG.flaringFormDebuffMPCostPerLevel;
                double mpRemovalCost = (effectsRemoved * removalCost);
                double mpExtensionCost = (totalDurationExtended * extensionCost);
                double currentMP = existence.getMagicule();

                existence.setMagicule(currentMP - (mpRemovalCost + mpExtensionCost));
                addMasteryPoint(instance, entity);
                instance.setCoolDown(cooldown, 0);
            }

        }
    }

    static {
        REMNANTS_OF_ASCENSION = ResourceLocation.fromNamespaceAndPath("trstarlight", "remnants_of_ascension");
        CONFIG = ConfigRegistry.getConfig(aspectSeriesSkillConfig.class).RemnantsOfAscension;
    }
}
