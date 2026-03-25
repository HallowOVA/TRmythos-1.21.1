package com.github.propheticeclipse.tensurastarlight.ability.skill.unique;

import com.github.propheticeclipse.tensurastarlight.config.effects.BuffEffectsConfig;
import com.github.propheticeclipse.tensurastarlight.config.skills.aspectSeriesSkillConfig;
import com.github.propheticeclipse.tensurastarlight.registry.skills.StarlightUniqueSkills;
import com.github.propheticeclipse.tensurastarlight.utils.ConeProjection;
import io.github.manasmods.manascore.config.ConfigRegistry;
import io.github.manasmods.manascore.network.api.util.Changeable;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.tensura.ability.SkillHelper;
import io.github.manasmods.tensura.ability.SkillUtils;
import io.github.manasmods.tensura.ability.TensuraSkillInstance;
import io.github.manasmods.tensura.ability.magic.Element;
import io.github.manasmods.tensura.ability.skill.Skill;
import io.github.manasmods.tensura.damage.TensuraDamageHelper;
import io.github.manasmods.tensura.damage.TensuraDamageTypes;
import io.github.manasmods.tensura.effect.template.TensuraMobEffect;
import io.github.manasmods.tensura.particle.TensuraParticleHelper;
import io.github.manasmods.tensura.registry.attribute.TensuraAttributes;
import io.github.manasmods.tensura.registry.skill.ExtraSkills;
import io.github.manasmods.tensura.storage.TensuraStorages;
import io.github.manasmods.tensura.util.EnergyHelper;
import io.github.manasmods.tensura.util.ObjectSelectionHelper;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
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

import java.util.List;

public class LightRemainsSkill extends Skill {
    private static final aspectSeriesSkillConfig.LightRemains CONFIG;
    public static final ResourceLocation LIGHT_REMAINS;

    public LightRemainsSkill() {
        super(SkillType.UNIQUE);
    }

    public boolean checkAcquiringRequirement(Player entity, double newEP) {

        boolean LightLord = (TensuraStorages.getSpiritFrom(entity).getSpiritLevelId(Element.LIGHT) >= CONFIG.skillFreeSpiritLevel);
        boolean DarkLord = (TensuraStorages.getSpiritFrom(entity).getSpiritLevelId(Element.DARKNESS) >= CONFIG.skillFreeSpiritLevel);
        boolean LightDarkLord = LightLord || DarkLord;
        boolean greaterLight = (TensuraStorages.getSpiritFrom(entity).getSpiritLevelId(Element.LIGHT) >= CONFIG.skillAcquireSpiritLevel);
        boolean greaterDark = (TensuraStorages.getSpiritFrom(entity).getSpiritLevelId(Element.DARKNESS) >= CONFIG.skillAcquireSpiritLevel);
        boolean greaterAcquire = greaterLight && greaterDark;
        return LightDarkLord || greaterAcquire;
    }

    @Override
    public double getAcquiringMagiculeCost(ManasSkillInstance instance) {
        return CONFIG.magiculeAcquirementCost;
    }

    @Override
    public int getAcquirementMastery(LivingEntity entity) {
        return CONFIG.acquirementMastery;
    }

    @Override
    public void onRespawn(ManasSkillInstance instance, ServerPlayer owner, boolean conqueredEnd) {
        double auraPercent = CONFIG.auraGainPercent;
        double manaPercent = CONFIG.manaGainPercent;
        AttributeInstance aura = owner.getAttribute(TensuraAttributes.AURA_GAIN);
        if (aura != null && !aura.hasModifier(LIGHT_REMAINS)) {
            aura.addOrReplacePermanentModifier(new AttributeModifier(LIGHT_REMAINS, auraPercent, AttributeModifier.Operation.ADD_VALUE));
        }

        AttributeInstance magicule = owner.getAttribute(TensuraAttributes.MAGICULE_GAIN);
        if (magicule != null && !magicule.hasModifier(LIGHT_REMAINS)) {
            magicule.addOrReplacePermanentModifier(new AttributeModifier(LIGHT_REMAINS, manaPercent, AttributeModifier.Operation.ADD_VALUE));
        }
    }

    @Override
    public void onLearnSkill(ManasSkillInstance instance, LivingEntity entity) {
        CompoundTag tag = new CompoundTag();
        boolean LightLord = (TensuraStorages.getSpiritFrom(entity).getSpiritLevelId(Element.LIGHT) >= CONFIG.skillFreeSpiritLevel);
        boolean DarkLord = (TensuraStorages.getSpiritFrom(entity).getSpiritLevelId(Element.DARKNESS) >= CONFIG.skillFreeSpiritLevel);
        if (LightLord || DarkLord) {
            double maxMagicule = EnergyHelper.getMaxMagicule(entity);
            double acquireCost = getAcquiringMagiculeCost(instance);
            EnergyHelper.setMaxMagicule(entity, (maxMagicule + acquireCost));
        }

        if (!SkillUtils.hasSkillFully(entity, ExtraSkills.MAGIC_SENSE.get())) {
            TensuraSkillInstance magicSense = new TensuraSkillInstance(ExtraSkills.MAGIC_SENSE.get());
            magicSense.getOrCreateTag().putBoolean("NoMagiculeCost", true);
            SkillHelper.learnSkill(entity, magicSense);
        }

        double auraPercent = CONFIG.auraGainPercent;
        double manaPercent = CONFIG.manaGainPercent;
        AttributeInstance aura = entity.getAttribute(TensuraAttributes.AURA_GAIN);
        if (aura != null && !aura.hasModifier(LIGHT_REMAINS)) {
            aura.addOrReplacePermanentModifier(new AttributeModifier(LIGHT_REMAINS, auraPercent, AttributeModifier.Operation.ADD_VALUE));
        }

        AttributeInstance magicule = entity.getAttribute(TensuraAttributes.MAGICULE_GAIN);
        if (magicule != null && !magicule.hasModifier(LIGHT_REMAINS)) {
            magicule.addOrReplacePermanentModifier(new AttributeModifier(LIGHT_REMAINS, manaPercent, AttributeModifier.Operation.ADD_VALUE));
        }
    }
    // +3% 2.25% MP, 0.75% AP

    @Override
    public void onForgetSkill(ManasSkillInstance instance, LivingEntity entity) {
        AttributeInstance aura = entity.getAttribute(TensuraAttributes.AURA_GAIN);
        if (aura != null) {
            aura.removeModifier(LIGHT_REMAINS);
        }

        AttributeInstance magicule = entity.getAttribute(TensuraAttributes.MAGICULE_GAIN);
        if (magicule != null) {
            magicule.removeModifier(LIGHT_REMAINS);
        }
    }

    public double getMagiculeCost(LivingEntity entity, ManasSkillInstance instance, int mode) {
        double cost;
        switch (mode) {
            case 0 -> cost = CONFIG.blindingLightManaCost;
            case 1 -> cost = CONFIG.overbearingLightManaCost;
            default -> cost = 0.0;
        }

        return cost;
    }

    public int getModes(ManasSkillInstance instance) {
        return 2;
    }

    public String getModeId(ManasSkillInstance instance, int mode) {
        String var10000;
        switch (mode) {
            case 0 -> var10000 = "light_remains.blinding_light";
            case 1 -> var10000 = "light_remains.overbearing_light";
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

    @Override
    public boolean canBeToggled(ManasSkillInstance instance, LivingEntity entity) {
        return instance.isMastered(entity);
    }

    public boolean onDamageEntity(ManasSkillInstance instance, LivingEntity owner, LivingEntity target, DamageSource source, Changeable<Float> amount) {
        // In Slot]: 1.5x (3x Mastered) Light Damage. Unmastered effect is toggleable when mastered.
        CompoundTag tag = instance.getOrCreateTag();
        double damageBonus = isMastered(instance, owner) ? CONFIG.damageModMastered : CONFIG.damageModUnmastered; // Mastered : Unmastered
        if (!SkillUtils.isSkillToggled(owner, StarlightUniqueSkills.VESTIGES_OF_EIDOLONS.get())) {
            if (this.isInSlot(owner, instance)) {
                if (TensuraDamageHelper.isLightDamage(source)) {
                    Float initDamage = amount.get();
                    if (initDamage != null) {
                        amount.set((float) (initDamage * damageBonus));
                    }
                }
            } else if ((instance.isToggled()) && instance.isMastered(owner)) {
                if (TensuraDamageHelper.isLightDamage(source)) {
                    Float initDamage = amount.get();
                    if (initDamage != null) {
                        amount.set((float) (initDamage * CONFIG.damageModUnmastered));
                    }
                }
            }
        }
        if (tag.getBoolean("over")) {
            float damageNum = amount.get();
            TensuraDamageHelper.directSpiritualHurt(target, owner, damageNum);
            amount.set((float) 0);
            if (target.isDeadOrDying()) {
                double targetMP = EnergyHelper.getMaxMagicule(target);
                double currentMP = EnergyHelper.getMaxMagicule(owner);
                double gainedMP = targetMP * CONFIG.overbearingLightManaGain;
                EnergyHelper.setMaxMagicule(owner, (currentMP + gainedMP));
                TensuraParticleHelper.addServerParticlesAroundSelf(target, ParticleTypes.SOUL, 0.5, 50);
                TensuraParticleHelper.addServerParticlesAroundSelf(target, ParticleTypes.SOUL_FIRE_FLAME, 0.2, 20);
            }
            tag.putBoolean("over", false);
        }
        return true;
    }

    public void onPressed(ManasSkillInstance instance, LivingEntity entity, int keyNumber, int mode) {
        if (mode == 0) {
            Level level = entity.level();
            double coneAngleDeg = CONFIG.blindingLightConeAngle; // 60 degrees cone
            double range = CONFIG.blindingLightConeLength;
            float damage = this.isMastered(instance, entity) ? CONFIG.blindingLightDamageMastered : CONFIG.blindingLightDamageUnmastered; // M:UM // 37.5% : 30%

            List<LivingEntity> targets = level.getEntitiesOfClass(LivingEntity.class,
                    entity.getBoundingBox().inflate(range),
                    e -> e != entity && entity.hasLineOfSight(e) && ConeProjection.isInFrontCone(entity, e, coneAngleDeg, range));

            for (LivingEntity target : targets) {
                if (target != null) {
                    target.hurt(this.createSource(instance, entity, TensuraDamageTypes.LIGHT_ELEMENTAL, mode), damage);

                    level.playSound((Player) null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.CAMPFIRE_CRACKLE, SoundSource.PLAYERS, 1.5F, 1.0F);
                    int amplifier = CONFIG.blindingLightDarknessAmplifier; // 0 = Level 1 Effect
                    int duration = CONFIG.blindingLightDarknessDuration; // Mastered : Unmastered Duration is in Ticks (100 = ~5s
                    MobEffectInstance effectInstance = new MobEffectInstance(MobEffects.DARKNESS, duration, amplifier, false, false, false);
                    TensuraMobEffect.addEffect(target, effectInstance, entity, this, mode);
                }
            }
            this.addMasteryPoint(instance, entity);
            instance.setCoolDown(CONFIG.blindingLightCooldown, 0);

        }
        if (mode == 1) {
            CompoundTag tag = instance.getOrCreateTag();
            float DamageAmount = instance.isMastered(entity) ? CONFIG.overbearingLightDamageMastered : CONFIG.overbearingLightDamageUnmastered; //M:UM
            //Grab target looking at, X SHP Unmastered : Mastered, Bonus EP on kill
            LivingEntity target = ObjectSelectionHelper.getTargetingEntity(entity, CONFIG.overbearingLightRange, false);
            if (target != null) {
                tag.putBoolean("over", true);
                TensuraParticleHelper.addServerParticlesAroundSelf(target, ParticleTypes.SOUL, 0.5, 10);
                TensuraParticleHelper.addServerParticlesAroundSelf(target, ParticleTypes.SOUL_FIRE_FLAME, 0.2, 2);
                target.hurt(this.createSource(instance, entity, TensuraDamageTypes.LIGHT_ELEMENTAL, mode), DamageAmount);
                this.addMasteryPoint(instance, entity);
                instance.setCoolDown(CONFIG.overbearingLightCooldown, 1); // X Second CD
            }
        }
    }

    static {
        LIGHT_REMAINS = ResourceLocation.fromNamespaceAndPath("trstarlight", "light_remains");
        CONFIG = ConfigRegistry.getConfig(aspectSeriesSkillConfig.class).LightRemainsConf;
    }
}
