package com.github.propheticeclipse.tensurastarlight.ability.skill.unique.evolvedUnique;

import com.github.propheticeclipse.tensurastarlight.registry.skills.StarlightUniqueSkills;
import com.github.propheticeclipse.tensurastarlight.utils.ConeProjection;
import com.github.propheticeclipse.tensurastarlight.utils.StarlightUtils;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import dev.shadowsoffire.placebo.color.GradientColor;
import io.github.manasmods.manascore.network.api.util.Changeable;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.manascore.skill.api.SkillAPI;
import io.github.manasmods.manascore.skill.impl.SkillStorage;
import io.github.manasmods.tensura.ability.SkillUtils;
import io.github.manasmods.tensura.ability.skill.Skill;
import io.github.manasmods.tensura.ability.skill.extra.SenseHeatSourceSkill;
import io.github.manasmods.tensura.ability.skill.extra.SenseSoundwaveSkill;
import io.github.manasmods.tensura.damage.TensuraDamageHelper;
import io.github.manasmods.tensura.damage.TensuraDamageTypes;
import io.github.manasmods.tensura.effect.template.TensuraMobEffect;
import io.github.manasmods.tensura.registry.attribute.TensuraAttributes;
import io.github.manasmods.tensura.registry.effect.TensuraMobEffects;
import io.github.manasmods.tensura.storage.TensuraStorages;
import io.github.manasmods.tensura.storage.ep.IExistence;
import io.github.manasmods.tensura.util.AttributeHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VestigesOfEidolonsSkill extends Skill {

    public static final ResourceLocation VESTIGES_OF_EIDOLONS;
    public VestigesOfEidolonsSkill() {
        super(SkillType.UNIQUE);
    }

    //    # Vestiges of Eidolons
//-# Evolved Unique
//-# “What fades does not vanish. What is gone still lingers. It listens to silence, and weaves truth from what remains.”
//    Acquisition Conditions:
//    Mastered Life Returns (Sacrificed)
//    Mastered Echo Endures (Sacrificed)
//    Mastered Light Remains (Sacrificed)
//150k MP
//
//    Passives
//
//
//[Passive - True] Existence Improvement: Increase EP gain from 3% to 6%, with 3/4 going to MP and 1/4 going to AP. Additionally, you are treated as Blessed.
//[Passive - Toggle] Magicule Observation: See through all forms of lesser concealment, costless universal perception.
//
//[Passive - True] Strike The Vestige: +20% Crit Chance and Crit Damage, and Bypass Resistances, Treating Nullifications as Resistances.
// Additionally, passively increase damage dealt to creatures with a concealment ability active by 1.5x.
//
//[Passive - Toggle] Immutable Being: Passively regenerate 25 (50 Mastered) HP, 5 (10 Mastered) SHP, and 0.25% MP/AP per second.
// Additionally, Bypass Death once per day (800s Mastered). When bypassing, recover to 10% of maximum HP and Teleport to your last spawn point.
//
//            [Passive - Toggle] Lumen Optimization: 1.5x (3x) Light and Dark Damage.
//            Stacking (Overwrites Light Remains if obtained again.)
//
//    Actives
//
//[Active - Press] Solar Echo: Speak a word of doom, in a 160° cone 15 blocks long, deal 125 (250 Mastered)
// Fire Damage and 125 (250 Mastered) Light Damage to all creatures within the cone. Inflict Silence 2, Darkness 2, and
// Fragility for 5s upon hit to any non-allied creature. Doesn’t penetrate walls. 2s CD, 8000 MP. Gains mastery for each target hit.
//
//[Active - Charge] Judgement of Past: Send out a wave of darkness in a 90° cone 15 blocks long, deal 100 (200 Mastered)
// Darkness Damage and shortly after strike targets hit with a pillar of light from above dealing 500 (750 Mastered) Light Damage.
// Doesn’t penetrate walls. 20s CD, 12000 MP. Gains 7 mastery.
    @Override
    public @Nullable MutableComponent getColoredName() {
        MutableComponent name = super.getColoredName();
        return name == null ? null : name.withStyle(s -> s.withColor(GradientColor.RAINBOW)); //Testing Colouring
    }

    public boolean checkAcquiringRequirement(Player entity, double newEP) {

        boolean lightRemains = SkillUtils.isSkillMastered(entity, StarlightUniqueSkills.LIGHT_REMAINS.get());
        boolean echoEndures = SkillUtils.isSkillMastered(entity, StarlightUniqueSkills.ECHO_ENDURES.get());
        boolean lifeReturns = SkillUtils.isSkillMastered(entity, StarlightUniqueSkills.LIFE_RETURNS.get());
        return lightRemains && echoEndures && lifeReturns;
    }

    @Override
    public void onRespawn(ManasSkillInstance instance, ServerPlayer owner, boolean conqueredEnd) {
        double auraPercent = 0.75; // 100 == 100% of EP, 1 == 1% of EP
        double manaPercent = 2.25;
        AttributeInstance aura = owner.getAttribute(TensuraAttributes.AURA_GAIN);
        if (aura != null && !aura.hasModifier(VESTIGES_OF_EIDOLONS)) {
            aura.addOrReplacePermanentModifier(new AttributeModifier(VESTIGES_OF_EIDOLONS, auraPercent, AttributeModifier.Operation.ADD_VALUE));
        }

        AttributeInstance magicule = owner.getAttribute(TensuraAttributes.MAGICULE_GAIN);
        if (magicule != null && !magicule.hasModifier(VESTIGES_OF_EIDOLONS)) {
            magicule.addOrReplacePermanentModifier(new AttributeModifier(VESTIGES_OF_EIDOLONS, manaPercent, AttributeModifier.Operation.ADD_VALUE));
        }
        double critRateMod = 0.1;
        double critDamMod = 0.15;
        AttributeInstance critRate = owner.getAttribute(ALObjects.Attributes.CRIT_CHANCE);
        if (critRate != null && !critRate.hasModifier(VESTIGES_OF_EIDOLONS)) {
            critRate.addOrReplacePermanentModifier(new AttributeModifier(VESTIGES_OF_EIDOLONS, critRateMod, AttributeModifier.Operation.ADD_VALUE));
        }

        AttributeInstance critDam = owner.getAttribute(ALObjects.Attributes.CRIT_DAMAGE);
        if (critDam != null && !critDam.hasModifier(VESTIGES_OF_EIDOLONS)) {
            critDam.addOrReplacePermanentModifier(new AttributeModifier(VESTIGES_OF_EIDOLONS, critDamMod, AttributeModifier.Operation.ADD_VALUE));
        }
        double degradeMod = 1;
        AttributeInstance degrade = owner.getAttribute(TensuraAttributes.RESISTANCE_DEGRADATION);
        if (degrade != null && !degrade.hasModifier(VESTIGES_OF_EIDOLONS)) {
            degrade.addOrReplacePermanentModifier(new AttributeModifier(VESTIGES_OF_EIDOLONS, degradeMod, AttributeModifier.Operation.ADD_VALUE));
        }
    }

    public void onLearnSkill(ManasSkillInstance instance, LivingEntity entity) {
        IExistence existence = TensuraStorages.getExistenceFrom(entity);
        SkillStorage storage = SkillAPI.getSkillsFrom(entity);

        Skill vestiges = (Skill) StarlightUniqueSkills.VESTIGES_OF_EIDOLONS.get();
        Skill lightRemains = (Skill) StarlightUniqueSkills.LIGHT_REMAINS.get();
        Skill echoEndures = (Skill) StarlightUniqueSkills.ECHO_ENDURES.get();
        Skill lifeReturns = (Skill) StarlightUniqueSkills.LIFE_RETURNS.get();
        if (entity instanceof Player player) {
            if (SkillUtils.hasSkill(entity, StarlightUniqueSkills.LIGHT_REMAINS.get())) {
                storage.forgetSkill(StarlightUniqueSkills.LIGHT_REMAINS.get());
                player.displayClientMessage(
                        Component.translatable(
                                "trstarlight.generic.skill.single_skill.sacrifice",
                                lightRemains.getChatDisplayName(true)
                        ).withStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)),
                        false
                );
            }

            if (SkillUtils.hasSkill(entity, StarlightUniqueSkills.ECHO_ENDURES.get())) {
                storage.forgetSkill(StarlightUniqueSkills.ECHO_ENDURES.get());
                player.displayClientMessage(
                        Component.translatable(
                                "trstarlight.generic.skill.single_skill.sacrifice",
                                echoEndures.getChatDisplayName(true)
                        ).withStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)),
                        false
                );
            }

            if (SkillUtils.hasSkill(entity, StarlightUniqueSkills.LIFE_RETURNS.get())) {
                storage.forgetSkill(StarlightUniqueSkills.LIFE_RETURNS.get());
                player.displayClientMessage(
                        Component.translatable(
                                "trstarlight.generic.skill.single_skill.sacrifice",
                                lifeReturns.getChatDisplayName(true)
                        ).withStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)),
                        false
                );
            }

            player.displayClientMessage(
                    Component.translatable(
                            "trstarlight.generic.skill.unique.evolution",
                            lightRemains.getChatDisplayName(true)
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
                            vestiges.getChatDisplayName(true)
                    ).withStyle(Style.EMPTY.withColor(ChatFormatting.WHITE)),
                    false
            );
            existence.setBlessed(true);
        } else {
            storage.forgetSkill(StarlightUniqueSkills.LIGHT_REMAINS.get());
            storage.forgetSkill(StarlightUniqueSkills.ECHO_ENDURES.get());
            storage.forgetSkill(StarlightUniqueSkills.LIFE_RETURNS.get());
        }

        double auraPercent = 0.75; // 100 == 100% of EP, 1 == 1% of EP
        double manaPercent = 2.25;
        AttributeInstance aura = entity.getAttribute(TensuraAttributes.AURA_GAIN);
        if (aura != null && !aura.hasModifier(VESTIGES_OF_EIDOLONS)) {
            aura.addOrReplacePermanentModifier(new AttributeModifier(VESTIGES_OF_EIDOLONS, auraPercent, AttributeModifier.Operation.ADD_VALUE));
        }

        AttributeInstance magicule = entity.getAttribute(TensuraAttributes.MAGICULE_GAIN);
        if (magicule != null && !magicule.hasModifier(VESTIGES_OF_EIDOLONS)) {
            magicule.addOrReplacePermanentModifier(new AttributeModifier(VESTIGES_OF_EIDOLONS, manaPercent, AttributeModifier.Operation.ADD_VALUE));
        }
        double critRateMod = 0.1;
        double critDamMod = 0.15;
        AttributeInstance critRate = entity.getAttribute(ALObjects.Attributes.CRIT_CHANCE);
        if (critRate != null && !critRate.hasModifier(VESTIGES_OF_EIDOLONS)) {
            critRate.addOrReplacePermanentModifier(new AttributeModifier(VESTIGES_OF_EIDOLONS, critRateMod, AttributeModifier.Operation.ADD_VALUE));
        }

        AttributeInstance critDam = entity.getAttribute(ALObjects.Attributes.CRIT_DAMAGE);
        if (critDam != null && !critDam.hasModifier(VESTIGES_OF_EIDOLONS)) {
            critDam.addOrReplacePermanentModifier(new AttributeModifier(VESTIGES_OF_EIDOLONS, critDamMod, AttributeModifier.Operation.ADD_VALUE));
        }
        double degradeMod = 1;
        AttributeInstance degrade = entity.getAttribute(TensuraAttributes.RESISTANCE_DEGRADATION);
        if (degrade != null && !degrade.hasModifier(VESTIGES_OF_EIDOLONS)) {
            degrade.addOrReplacePermanentModifier(new AttributeModifier(VESTIGES_OF_EIDOLONS, degradeMod, AttributeModifier.Operation.ADD_VALUE));
        }
    }

    public void onForgetSkill(ManasSkillInstance instance, LivingEntity entity) {
        AttributeInstance aura = entity.getAttribute(TensuraAttributes.AURA_GAIN);
        if (aura != null) {
            aura.removeModifier(VESTIGES_OF_EIDOLONS);
        }

        AttributeInstance magicule = entity.getAttribute(TensuraAttributes.MAGICULE_GAIN);
        if (magicule != null) {
            magicule.removeModifier(VESTIGES_OF_EIDOLONS);
        }

        AttributeInstance critRate = entity.getAttribute(ALObjects.Attributes.CRIT_CHANCE);
        if (critRate != null) {
            critRate.removeModifier(VESTIGES_OF_EIDOLONS);
        }

        AttributeInstance critDam = entity.getAttribute(ALObjects.Attributes.CRIT_DAMAGE);
        if (critDam != null) {
            critDam.removeModifier(VESTIGES_OF_EIDOLONS);
        }

        AttributeInstance degrade = entity.getAttribute(TensuraAttributes.RESISTANCE_DEGRADATION);
        if (degrade != null) {
            degrade.removeModifier(VESTIGES_OF_EIDOLONS);
        }
    }

    @Override
    public double getAcquiringMagiculeCost(ManasSkillInstance instance) {
        return 150000;
    }

    @Override
    public int getAcquirementMastery(LivingEntity entity) {
        return 1;
    }

    @Override
    public int getMaxMastery() {
        return 2500;
    }

    public double getMagiculeCost(LivingEntity entity, ManasSkillInstance instance, int mode) {
        double cost;
        switch (mode) {
            case 0 -> cost = 8000.0;
            case 1 -> cost = 12000.0;
            default -> cost = 0.0;
        }

        return cost;
    }

    public int getModes(ManasSkillInstance instance) {
        return 3;
    }

    public String getModeId(ManasSkillInstance instance, int mode) {
        String var10000;
        switch (mode) {
            case 0 -> var10000 = "vestiges_of_eidolons.solar_echo";
            case 1 -> var10000 = "vestiges_of_eidolons.judgement_of_past";
            case 2 -> var10000 = "vestiges_of_eidolons.death_bypass";
            default -> var10000 = super.getModeId(instance, mode);
        }

        return var10000;
    }

    public int nextMode(LivingEntity entity, ManasSkillInstance instance, int mode, boolean reverse) {
        if (reverse) {
            return mode == 0 ? 1 : mode - 1;
        } else {
            return mode == 1 ? 0 : mode + 1; // (0 - 1) total is 2
        }
    }

    public boolean canBeToggled(ManasSkillInstance instance, LivingEntity entity) {
        return true;
    }

    public boolean canTick(ManasSkillInstance instance, LivingEntity entity) {
        return instance.isToggled();
    }

    @Override
    public void onTick(ManasSkillInstance instance, LivingEntity entity) {
        // Immutable Being: Passively regenerate 50 (100 Mastered) HP, 25 (50 Mastered) SHP, and 0.25% MP/AP per second. (Toggle)
        // Magicule Observation: See through all forms of lesser concealment, costless universal perception. (Toggle)
        IExistence existence = TensuraStorages.getExistenceFrom(entity);

        float healthRegen = isMastered(instance, entity) ? 50 : 25; // Replace with Configured options later
        float spiritHealthRegen = isMastered(instance, entity) ? 10 : 5;
        double maxSHP = entity.getAttributeValue(TensuraAttributes.MAX_SPIRITUAL_HEALTH);
        double curSHP = existence.getSpiritualHealth();

        if (!SkillUtils.shouldCancelHealing(entity)) {
            if (entity.isAlive() && (entity.getHealth() < entity.getMaxHealth() || curSHP < maxSHP)) {
                entity.heal(healthRegen);
                existence.setSpiritualHealth(curSHP + spiritHealthRegen);
                addMasteryPoint(instance, entity);
            }
        }

        if (existence.getMagicule() < (entity.getAttributeValue(TensuraAttributes.MAX_MAGICULE) * 1.24)) {
            ExistenceRegeneration(entity);
        }

        CompoundTag tag = instance.getOrCreateTag();
        int time = tag.getInt("activatedTimes");
        if (time % 20 == 0) {
            this.addMasteryPoint(instance, entity);
        }

        tag.putInt("activatedTimes", time + 1);
        // apply uni perception here
    }

    private void ExistenceRegeneration(LivingEntity entity) {
        IExistence existence = TensuraStorages.getExistenceFrom(entity);
        double maxMP = entity.getAttributeValue(TensuraAttributes.MAX_MAGICULE);
        double maxAP = entity.getAttributeValue(TensuraAttributes.MAX_AURA);

        existence.setMagicule(existence.getMagicule() + maxMP * 0.0025);
        existence.setAura(existence.getAura() + maxAP * 0.0025);
        existence.markDirty();
    }

    @Override
    public void onToggleOn(ManasSkillInstance instance, LivingEntity entity) {
        AttributeHelper.addPresenceSense(entity, 3);
        AttributeHelper.addPermanentAttributeIfHigher(entity, TensuraAttributes.PRESENCE_SENSE_RADIUS, SenseHeatSourceSkill.HEAT_SENSE, (double)10.0F, AttributeModifier.Operation.ADD_VALUE);
        AttributeHelper.addPermanentAttributeIfHigher(entity, TensuraAttributes.PRESENCE_SENSE_RADIUS, SenseSoundwaveSkill.SOUND_SENSE, (double)10.0F, AttributeModifier.Operation.ADD_VALUE);

    }

    @Override
    public void onToggleOff(ManasSkillInstance instance, LivingEntity entity) {
        AttributeHelper.removePresenceSense(entity, 3);
        AttributeHelper.removeAttributeIfCorrect(entity, TensuraAttributes.PRESENCE_SENSE_RADIUS, SenseHeatSourceSkill.HEAT_SENSE, (double)10.0F);
        AttributeHelper.removeAttributeIfCorrect(entity, TensuraAttributes.PRESENCE_SENSE_RADIUS, SenseSoundwaveSkill.SOUND_SENSE, (double)10.0F);
    }

    @Override
    public boolean onDeath(ManasSkillInstance instance, LivingEntity owner, DamageSource source) {
        int cooldown = isMastered(instance, owner) ? 800 : 1200;
        //Additionally, Bypass Death once per day (800s Mastered). When bypassing, recover to 10% of maximum HP and Teleport to your last spawn point.
        if (owner instanceof Player player) {
            double maxHP = player.getMaxHealth();
            // Place anti-resurrection skill flag here!
            if ((instance.getCoolDown(2) == 0) && instance.isToggled()) {
                player.removeAllEffects();
                player.invulnerableTime = 60;

                player.setHealth(((float) ((maxHP * 0.1) + 1)));

                StarlightUtils.TeleportToSpawnpoint(player);

                player.level().playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);
                instance.setCoolDown(cooldown, 2);
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
        // Returning true continues the event, returning false CANCELS the event.
    }

    @Override
    public boolean onDamageEntity(ManasSkillInstance instance, LivingEntity owner, LivingEntity target, DamageSource source, Changeable<Float> amount) {
        double concealedMod = isMastered(instance, owner) ? 1.5 : 1.25;
        double damageBonus = isMastered(instance, owner) ? 3.0 : 1.5; // Mastered : Unmastered
        if (instance.isToggled()) {
            if (TensuraDamageHelper.isLightDamage(source) || TensuraDamageHelper.isDarkDamage(source)) {
//                [Passive - Toggle] Lumen Optimization: 1.5x (3x) Light and Dark Damage.
//                Stacking (Overwrites Light Remains if obtained again.)
// Additionally, passively increase damage dealt to creatures with a concealment ability active by 1.5x.
                if (target.getAttributeValue(TensuraAttributes.PRESENCE_CONCEALMENT) > 0) {
                    Float initDamage = amount.get();
                    if (initDamage != null) {
                        amount.set((float) (initDamage * concealedMod));
                    }
                }

                Float initDamage = amount.get();
                if (initDamage != null) {
                    amount.set((float) (initDamage * damageBonus));
                }
            }
        }

        return true;
    }

    public final class DelayedTask {

        private DelayedTask() {}

        public static void run(int delayTicks, Runnable task) {
            NeoForge.EVENT_BUS.register(new Object() {

                private int ticks = 0;

                @SubscribeEvent
                public void onServerTick(ServerTickEvent.Post event) {
                    ticks++;
                    if (ticks >= delayTicks) {
                        task.run();
                        NeoForge.EVENT_BUS.unregister(this);
                    }
                }
            });
        }
    }

    public void onPressed(ManasSkillInstance instance, LivingEntity entity, int keyNumber, int mode) {
        //[Active - Press] Solar Echo: Speak a word of doom, in a 160° cone 12 blocks long, deal 125 (250 Mastered)
// Fire Damage and 125 (250 Mastered) Light Damage to all creatures within the cone. Inflict Silence 2, Darkness 2, and
// Fragility for 5s upon hit to any non-allied creature. Doesn’t penetrate walls. 2s CD, 8000 MP. Gains mastery for each target hit.
        if (mode == 0) {
            Level level = entity.level();
            double coneAngleDeg = 160; // 60 degrees cone
            double range = 13.0;
            float damage = this.isMastered(instance, entity) ? 100 : 50; // M:UM // 37.5% : 30%

            List<LivingEntity> targets = level.getEntitiesOfClass(LivingEntity.class,
                    entity.getBoundingBox().inflate(range),
                    e -> e != entity && entity.hasLineOfSight(e) && ConeProjection.isInFrontCone(entity, e, coneAngleDeg, range));

            int targetHitCount = 0;

            for (LivingEntity target : targets) {
                if (target != null) {
                    // Replace with split damage
                    TensuraDamageHelper.hurtSplit(
                            target,
                            (this.createSource(instance, entity, TensuraDamageTypes.LIGHT_ELEMENTAL, mode)),
                            50,
                            (this.createSource(instance, entity, TensuraDamageTypes.FIRE_ELEMENTAL, mode)),
                            damage
                    );

                    level.playSound((Player) null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.CAMPFIRE_CRACKLE, SoundSource.PLAYERS, 1.5F, 0.3F);
                    // Replace Sound
                    int amplifier = 1; // 0 = Level 1 Effect
                    int duration = 100; // Mastered : Unmastered Duration is in Ticks (100 = ~5s
                    MobEffectInstance darkness = new MobEffectInstance(MobEffects.DARKNESS, duration, amplifier, false, false, false);
                    MobEffectInstance fragility = new MobEffectInstance(TensuraMobEffects.FRAGILITY, duration, amplifier, false, false, false);
                    MobEffectInstance silence = new MobEffectInstance(TensuraMobEffects.SILENCE, duration, 0, false, false, false);

                    TensuraMobEffect.addEffect(target, darkness, entity, this, mode);
                    TensuraMobEffect.addEffect(target, fragility, entity, this, mode);
                    TensuraMobEffect.addEffect(target, silence, entity, this, mode);
                    targetHitCount++;
                }
            }
            this.addMasteryPoint(instance, entity, targetHitCount);
            this.addMasteryPoint(instance, entity);
            instance.setCoolDown(2, 0);
        }
        if (mode == 1) {
            //[Active - Charge] Judgement of Past: Send out a wave of darkness in a 90° cone 15 blocks long, deal 100 (200 Mastered)
// Darkness Damage and shortly after strike targets hit with a pillar of light from above dealing 500 (750 Mastered) Light Damage.
// Doesn’t penetrate walls. 20s CD, 12000 MP. Gains 7 mastery.
            Level level = entity.level();
            double coneAngleDeg = 90; // 60 degrees cone
            double range = 16.0;
            float damage = this.isMastered(instance, entity) ? 40 : 20; // M:UM // 37.5% : 30%
            float damageAfter = this.isMastered(instance, entity) ? 200 : 80; // M:UM // 37.5% : 30%

            List<LivingEntity> targets = level.getEntitiesOfClass(LivingEntity.class,
                    entity.getBoundingBox().inflate(range),
                    e -> e != entity && entity.hasLineOfSight(e) && ConeProjection.isInFrontCone(entity, e, coneAngleDeg, range));

            for (LivingEntity target : targets) {
                if (target != null) {
                    target.hurt(this.createSource(instance, entity, TensuraDamageTypes.DARKNESS_ELEMENTAL, mode), damage); // replace with split damage

                    DelayedTask.run(20, () -> {
                        // After Damage goes here
                        target.hurt(this.createSource(instance, entity, TensuraDamageTypes.LIGHT_ELEMENTAL, mode), damageAfter);
                    });

                    level.playSound((Player) null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.CAMPFIRE_CRACKLE, SoundSource.PLAYERS, 1.5F, 1.0F);
                    // replace sound
                }
            }
            this.addMasteryPoint(instance, entity);
            instance.setCoolDown(20, 1);
        }
    }

    static {
        VESTIGES_OF_EIDOLONS = ResourceLocation.fromNamespaceAndPath("trstarlight", "vestiges_of_eidolons");
    }
}
