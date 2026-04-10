package com.github.hallowOVA.mythos.ability.mythos.skill.unique;

import com.github.hallowOVA.mythos.registry.skill.MythosSkills;
import com.github.hallowOVA.mythos.util.MythosUtils;
import io.github.manasmods.manascore.network.api.util.Changeable;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.manascore.skill.api.SkillAPI;
import io.github.manasmods.tensura.ability.SkillHelper;
import io.github.manasmods.tensura.ability.TensuraSkillInstance;
import io.github.manasmods.tensura.ability.skill.Skill;
import io.github.manasmods.tensura.registry.skill.ResistanceSkills;
import io.github.manasmods.tensura.storage.Alignment;
import io.github.manasmods.tensura.storage.TensuraStorages;
import io.github.manasmods.tensura.storage.ep.IExistence;
import io.github.manasmods.tensura.util.EnergyHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import team.lodestar.lodestone.registry.common.particle.LodestoneParticleTypes;
import team.lodestar.lodestone.systems.easing.Easing;
import team.lodestar.lodestone.systems.particle.builder.WorldParticleBuilder;
import team.lodestar.lodestone.systems.particle.data.GenericParticleData;
import team.lodestar.lodestone.systems.particle.data.color.ColorParticleData;
import team.lodestar.lodestone.systems.particle.data.spin.SpinParticleData;

import java.awt.*;
import java.util.List;




public class NimueSkill extends Skill {
    public NimueSkill() {
        super(SkillType.UNIQUE);
    }

    @Override
    public MutableComponent getSkillDescription() {
        return Component.literal("Fantasy Becomes Reality");
    }

    @Override
    public double getAcquiringMagiculeCost(ManasSkillInstance instance) {
        return 100000;
    }

    @Override
    public boolean canTick(ManasSkillInstance instance, LivingEntity entity) {
        return true;
    }

    @Override
    public void onTick(ManasSkillInstance instance, LivingEntity entity) {
        if (!(entity instanceof Player player)) return;
        if (player.level().isClientSide) return;

        if (player.tickCount % 2 == 0) return;

        if (player.isInWaterOrBubble()) {

            player.forceAddEffect(new MobEffectInstance(
                    MobEffects.WATER_BREATHING, 200, 0, false, false, false
            ), null);

            player.forceAddEffect(new MobEffectInstance(
                    MobEffects.DOLPHINS_GRACE, 200, 2, false, false, false
            ), null);

            player.forceAddEffect(new MobEffectInstance(
                    MobEffects.DAMAGE_RESISTANCE, 200, 1, false, false, false
            ), null);
        }
    }


    public void onLearnSkill(ManasSkillInstance instance, LivingEntity entity) {
        if (!(instance.getMastery() < (double) 0.0F) && !instance.isTemporarySkill()) {
            TensuraSkillInstance eye = new TensuraSkillInstance(ResistanceSkills.WATER_ATTACK_NULLIFICATION.get());
            eye.getOrCreateTag().putBoolean("NoMagiculeCost", true);
            SkillHelper.learnSkill(entity, eye);
        }
    }

    @Override
    public boolean onBeingDamaged(ManasSkillInstance instance, LivingEntity entity, DamageSource source, float amount) {
        if (entity.isInWater()) {
            double dodgeChance = instance.isMastered(entity) ? 0.40 : 0.30;
            if (entity.getRandom().nextDouble() < dodgeChance) {
                if (entity.level() instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.CLOUD, entity.getX(), entity.getY() + 1, entity.getZ(), 10, 0.2, 0.2, 0.2, 0.05);
                }
                return false;
            }
        } else return true;

        return true;
    }

    @Override
    public boolean onDamageEntity(ManasSkillInstance instance, LivingEntity owner, LivingEntity target, DamageSource source, Changeable<Float> amount) {
        if (owner.isInWater()) {
            float currentAmount = amount.get();
            amount.set(currentAmount * 1.5f);
            return true;
        }
        return true;
    }

    @Override
    public int getModes(ManasSkillInstance instance) {
        return 2; // I believe it just adds 1, idfk why don't ask me
    }

    @Override
    public Component getModeName(ManasSkillInstance instance, int mode) {
        return switch (mode) {
            case 1 -> Component.literal("Purifying Water");
            case 2 -> Component.literal("Mode Name Two");
            case 3 -> Component.literal("Mode Name Three");
            default -> super.getModeName(instance, mode);
        };
    }

    @Override
    public void onPressed(ManasSkillInstance instance, LivingEntity entity, int keyNumber, int mode) {
        if (!EnergyHelper.isOutOfEnergy(entity, instance, mode)) {
            if (!(mode == 0)) return;
            if (!(entity instanceof Player player)) return;

            Level level = player.level();
            if (level.isClientSide) return;

            int elementalPoints = 0;
            elementalPoints = instance.getOrCreateTag().getInt("CreationElementalPoints");

            boolean isCrouching = player.isShiftKeyDown();

            if (isCrouching && elementalPoints >= 50) {
                double radius = 15.0;

                List<LivingEntity> targets = level.getEntitiesOfClass(
                        LivingEntity.class,
                        player.getBoundingBox().inflate(radius),
                        e -> e != player
                );

                for (LivingEntity target : targets) {
                    purify(target);
                    spawnPurifyParticles((ServerLevel) level, target, 2);
                }


                elementalPoints -= 50;
                instance.getOrCreateTag().putInt("CreationElementalPoints", elementalPoints);

                player.displayClientMessage(
                        Component.literal("Cleansing all spirits...").withStyle(ChatFormatting.AQUA),
                        true
                );

            } else {
                Entity target = MythosUtils.getTargetEntity(player, 5);

                if (target instanceof LivingEntity livingTarget) {
                    purify(livingTarget);

                    player.displayClientMessage(
                            Component.literal("Purifying target...").withStyle(ChatFormatting.BLUE),
                            true
                    );

                    spawnPurifyParticles((ServerLevel) level, livingTarget, 2);
                }
            }
        }

    }

    private void purify(LivingEntity entity) {
        if (entity instanceof LivingEntity targetPlayer) {
            IExistence existence = TensuraStorages.getExistenceFrom(targetPlayer);
            if (existence.getAlignment().equals(Alignment.MAJIN)) {
                existence.setAlignment(Alignment.DEFAULT);
            }
        }
    }

    private void spawnPurifyParticles(ServerLevel level, Entity center, double size) {
        WorldParticleBuilder.create(LodestoneParticleTypes.WISP_PARTICLE)
                .setScaleData(GenericParticleData.create(0.5f, 1.5f, 0f).setEasing(Easing.QUARTIC_OUT).build())
                .setTransparencyData(GenericParticleData.create(0.8f, 0f).build())
                .setColorData(ColorParticleData.create(Color.WHITE, new Color(100, 230, 255)).build())
                .setLifetime(20)
                .addMotion(0, 0.1f, 0)
                .enableForcedSpawn()
                .spawn(level, center.getX(), center.getY() + 0.1, center.getZ());

        for (int i = 0; i < 15; i++) {
            double offsetX = (level.random.nextDouble() - 0.5) * size;
            double offsetZ = (level.random.nextDouble() - 0.5) * size;

            WorldParticleBuilder.create(LodestoneParticleTypes.SPARKLE_PARTICLE)
                    .setScaleData(GenericParticleData.create(0.2f, 0.4f, 0f).build())
                    .setTransparencyData(GenericParticleData.create(1.0f, 0f).build())
                    .setColorData(ColorParticleData.create(Color.WHITE, new Color(200, 230, 255)).build())
                    .setLifetime(30 + level.random.nextInt(10))
                    .addMotion(0, 0.05f + level.random.nextFloat() * 0.1f, 0)
                    .setSpinData(SpinParticleData.create(0.1f, 0.4f).build())
                    .enableForcedSpawn()
                    .spawn(level, center.getX() + offsetX, center.getY(), center.getZ() + offsetZ);
        }
    }
}
