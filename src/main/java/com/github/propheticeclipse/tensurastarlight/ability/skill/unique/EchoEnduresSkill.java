package com.github.propheticeclipse.tensurastarlight.ability.skill.unique;

import com.github.propheticeclipse.tensurastarlight.registry.skills.StarlightUniqueSkills;
import com.github.propheticeclipse.tensurastarlight.utils.ConeProjection;
import io.github.manasmods.manascore.network.api.util.Changeable;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.tensura.ability.SkillHelper;
import io.github.manasmods.tensura.ability.SkillUtils;
import io.github.manasmods.tensura.ability.TensuraSkillInstance;
import io.github.manasmods.tensura.ability.skill.Skill;
import io.github.manasmods.tensura.damage.TensuraDamageTypes;
import io.github.manasmods.tensura.effect.template.TensuraMobEffect;
import io.github.manasmods.tensura.registry.attribute.TensuraAttributes;
import io.github.manasmods.tensura.registry.effect.TensuraMobEffects;
import io.github.manasmods.tensura.registry.skill.ExtraSkills;
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

public class EchoEnduresSkill extends Skill {
    public EchoEnduresSkill() {
        super(SkillType.UNIQUE);
    }

    public static final ResourceLocation ECHO_ENDURES;

    //Acquisition Conditions:
    //Have Light Remains (Mastered) or Life Returns (Mastered), Sense Soundavws
    //Be affected by Darkness (Or Blindness)
    //100k MP, or Reincarnation
    //
    //Passives
    //
    //[Passive - True]: Acquire Sense Soundwaves and Sense Heat Source for free upon acquiring Echo Endures
    //
    //[Passive - Toggle]: Attacks inflict Silence for 3s (6s mastered).
    //
    //[Passive - In Slot && Toggled]: Bypass Resistances, and treat Nullifications as Resistances. Toggled with mastery.
    //
    //Actives
    //
    //[Active - Hold] Sound Burst: Speak a word of destruction, in a 160° cone of sound 7.5 blocks long deal 60 (120 Mastered)
    // Physical Damage to all creatures within the cone. Additionally, creatures hit suffer from Silence for 8s.
    // Doesn’t penetrate walls. 3s CD, 750 MP. Gains 1 mastery.

    public boolean checkAcquiringRequirement(Player entity, double newEP) {

        boolean senseSoundEffect = SkillUtils.hasSkill(entity, ExtraSkills.SENSE_SOUNDWAVE.get());
        boolean darknessEffect = entity.hasEffect(MobEffects.DARKNESS);
        boolean blindnessEffect = entity.hasEffect(MobEffects.BLINDNESS);
        boolean lightRemains = SkillUtils.isSkillMastered(entity, StarlightUniqueSkills.LIGHT_REMAINS.get());

        return (senseSoundEffect && (blindnessEffect || darknessEffect) && lightRemains);
    }

    @Override
    public double getAcquiringMagiculeCost(ManasSkillInstance instance) {
        return 75000;
    }

    @Override
    public int getAcquirementMastery(LivingEntity entity) {
        return 1;
    }

    public double getMagiculeCost(LivingEntity entity, ManasSkillInstance instance, int mode) {
        double cost;
        if (mode == 0) {
            cost = 750.0;
        } else {
            cost = 0.0;
        }

        return cost;
    }

    public int getModes(ManasSkillInstance instance) {
        return 1;
    }

    public String getModeId(ManasSkillInstance instance, int mode) {
        String var10000;
        if (mode == 0) {
            var10000 = "echo_endures.sound_burst";
        } else {
            var10000 = super.getModeId(instance, mode);
        }

        return var10000;
    }

    public void onLearnSkill(ManasSkillInstance instance, LivingEntity entity) {
        CompoundTag tag = new CompoundTag();

        if (!(SkillUtils.hasSkillFully(entity, ExtraSkills.SENSE_SOUNDWAVE.get()) || SkillUtils.hasSkillFully(entity, ExtraSkills.SENSE_HEAT_SOURCE.get()))) {
            TensuraSkillInstance senseSound = new TensuraSkillInstance(ExtraSkills.SENSE_SOUNDWAVE.get());
            TensuraSkillInstance senseHeat = new TensuraSkillInstance(ExtraSkills.SENSE_HEAT_SOURCE.get());
            senseSound.getOrCreateTag().putBoolean("NoMagiculeCost", true);
            senseHeat.getOrCreateTag().putBoolean("NoMagiculeCost", true);
            SkillHelper.learnSkill(entity, senseSound, instance.getRemoveTime());
            SkillHelper.learnSkill(entity, senseHeat, instance.getRemoveTime());
        }
    }

    @Override
    public boolean canBeToggled(ManasSkillInstance instance, LivingEntity entity) {
        return true;
    }

    @Override
    public boolean onDamageEntity(ManasSkillInstance instance, LivingEntity owner, LivingEntity target, DamageSource source, Changeable<Float> amount) {
        // Apply Silence on hit here, 6s mastered, 3s unmastered, amp 0
        if (instance.isToggled()) {
            int amplifier = 0; // 0 = Level 1 Effect
            int duration = isMastered(instance, owner) ? 120 : 60; // Mastered : Unmastered Duration is in Ticks (100 = ~5s
            MobEffectInstance effectInstance = new MobEffectInstance(TensuraMobEffects.SILENCE, duration, amplifier, false, false, false);
            target.addEffect(effectInstance);
        }
        return true;
    }

    @Override
    public void onRespawn(ManasSkillInstance instance, ServerPlayer owner, boolean conqueredEnd) {
        if (instance.isToggled()) {
            if (instance.isMastered(owner)) {
                AttributeInstance aura = owner.getAttribute(TensuraAttributes.RESISTANCE_DEGRADATION);
                if (aura != null && !aura.hasModifier(ECHO_ENDURES)) {
                    aura.addOrReplacePermanentModifier(new AttributeModifier(ECHO_ENDURES, 1, AttributeModifier.Operation.ADD_VALUE));
                }
            } else if (this.isInSlot(owner)) {
                AttributeInstance aura = owner.getAttribute(TensuraAttributes.RESISTANCE_DEGRADATION);
                if (aura != null && !aura.hasModifier(ECHO_ENDURES)) {
                    aura.addOrReplacePermanentModifier(new AttributeModifier(ECHO_ENDURES, 1, AttributeModifier.Operation.ADD_VALUE));
                }
            }
        }
    }

    @Override
    public void onToggleOn(ManasSkillInstance instance, LivingEntity entity) {
        //[Passive - In Slot && Toggled]: Bypass Resistances, and treat Nullifications as Resistances. Toggled with mastery.
        if (instance.isToggled()) {
            if (instance.isMastered(entity)) {
                AttributeInstance aura = entity.getAttribute(TensuraAttributes.RESISTANCE_DEGRADATION);
                if (aura != null && !aura.hasModifier(ECHO_ENDURES)) {
                    aura.addOrReplacePermanentModifier(new AttributeModifier(ECHO_ENDURES, 1, AttributeModifier.Operation.ADD_VALUE));
                }
            } else if (this.isInSlot(entity)) {
                AttributeInstance aura = entity.getAttribute(TensuraAttributes.RESISTANCE_DEGRADATION);
                if (aura != null && !aura.hasModifier(ECHO_ENDURES)) {
                    aura.addOrReplacePermanentModifier(new AttributeModifier(ECHO_ENDURES, 1, AttributeModifier.Operation.ADD_VALUE));
                }
            }
        }
    }

    @Override
    public void onToggleOff(ManasSkillInstance instance, LivingEntity entity) {
        AttributeInstance aura = entity.getAttribute(TensuraAttributes.RESISTANCE_DEGRADATION);
        if (aura != null) {
            aura.removeModifier(ECHO_ENDURES);
        }
    }

    @Override
    public void onPressed(ManasSkillInstance instance, LivingEntity entity, int keyNumber, int mode) {
        //[Active - Hold] Sound Burst: Speak a word of destruction, in a 160° cone of sound 7.5 blocks long deal 60 (120 Mastered)
        // Physical Damage to all creatures within the cone. Additionally, creatures hit suffer from Silence for 8s.
        // Doesn’t penetrate walls. 3s CD, 750 MP. Gains 1 mastery.
        if (mode == 0) {
            Level level = entity.level();
            double coneAngleDeg = 160; // 60 degrees cone
            double range = 8;
            float damage = this.isMastered(instance, entity) ? 10 : 5; // M:UM // 37.5% : 30%

            List<LivingEntity> targets = level.getEntitiesOfClass(LivingEntity.class,
                    entity.getBoundingBox().inflate(range),
                    e -> e != entity && entity.hasLineOfSight(e) && ConeProjection.isInFrontCone(entity, e, coneAngleDeg, range));

            for (LivingEntity target : targets) {
                if (target != null) {
                    target.hurt(this.createSource(instance, entity, TensuraDamageTypes.SOUND_BLAST, mode), damage);

                    level.playSound((Player) null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ENDERMAN_SCREAM, SoundSource.PLAYERS, 2.0F, 0.1F);
                    int amplifier = 0; // 0 = Level 1 Effect
                    int duration = 160; // Mastered : Unmastered Duration is in Ticks (100 = ~5s
                    MobEffectInstance effectInstance = new MobEffectInstance(TensuraMobEffects.SILENCE, duration, amplifier, false, false, false);
                    TensuraMobEffect.addEffect(target, effectInstance, entity, this, mode);
                }
            }
            this.addMasteryPoint(instance, entity);
            instance.setCoolDown(3, 0);
        }
    }

    static {
        ECHO_ENDURES = ResourceLocation.fromNamespaceAndPath("trstarlight", "echo_endures");
    }
}
