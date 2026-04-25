package com.github.hallowova.mythos.ability.mythos.skill.unique;

import com.github.hallowova.mythos.config.FakerConfig;
import com.github.hallowova.mythos.registry.MythosMobEffects;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.manascore.skill.api.SkillAPI;
import io.github.manasmods.manascore.skill.impl.SkillStorage;
import io.github.manasmods.tensura.ability.skill.Skill;
import io.github.manasmods.tensura.registry.skill.UniqueSkills;
import io.github.manasmods.tensura.util.AttributeHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.CustomData;

import java.util.UUID;

public class FakerSkill extends Skill {

    private static final FakerConfig CONFIG = new FakerConfig();

    protected static final UUID ACCELERATION =
            UUID.fromString("0147c153-32a2-4524-8ba3-ba4c2f449d7c");
    private static final String TAG_ANALYSIS_MODE = "AnalysisMode";
    private static final String TAG_ANALYSIS_ACTIVE = "AnalysisActive";

    public FakerSkill() {
        super(SkillType.UNIQUE);
    }

    public double getObtainingEpCost() {
        return 100000.0;
    }

    public double learningCost() {
        return 1000.0;
    }

    public int getMaxMastery() {
        return 3000;
    }

    /* ================= TOGGLE ================= */

    public void onToggleOn(ManasSkillInstance instance, LivingEntity entity) {
        entity.addEffect(new MobEffectInstance(
                MythosMobEffects.AVALON_REGENERATION,
                220, 1, false, false, false
        ));
    }

    public void onToggleOff(ManasSkillInstance instance, LivingEntity entity) {
        entity.removeEffect(MythosMobEffects.AVALON_REGENERATION);
    }

    /* ================= TICK ================= */

    public void onTick(ManasSkillInstance instance, LivingEntity entity) {

        grantSevererIfMastered(instance, entity);

        if (instance.isToggled()) {
            entity.addEffect(new MobEffectInstance(
                    MythosMobEffects.AVALON_REGENERATION,
                    220, 1, false, false, false
            ));
        }
    }

    /* ================= SEVERER ================= */

    private void grantSevererIfMastered(ManasSkillInstance instance, LivingEntity entity) {

        if (!(entity instanceof Player player)) return;
        if (entity.level().isClientSide()) return;
        if (!this.isMastered(instance, entity)) return;

        SkillStorage storage = SkillAPI.getSkillsFrom(player);

        if (storage.getSkill(UniqueSkills.SEVERER.get()).isPresent()) return;

        storage.learnSkill(UniqueSkills.SEVERER.get());

        player.displayClientMessage(
                Component.literal("You have acquired Severer!")
                        .withStyle(ChatFormatting.GOLD),
                false
        );

        player.level().playSound(
                null,
                player.getX(), player.getY(), player.getZ(),
                SoundEvents.PLAYER_LEVELUP,
                SoundSource.PLAYERS,
                1.0F, 1.2F
        );
    }

    /* ================= MODES ================= */

    public int getMode(ManasSkillInstance instance) {
        CompoundTag tag = instance.getOrCreateTag();
        if (!tag.contains("Mode")) tag.putInt("Mode", 1);
        return tag.getInt("Mode");
    }

    public void nextMode(ManasSkillInstance instance) {
        int mode = getMode(instance);
        mode = mode >= 3 ? 1 : mode + 1;
        instance.getOrCreateTag().putInt("Mode", mode);
    }

    /* ================= PRESS ================= */

    public void onPressed(ManasSkillInstance instance, LivingEntity entity) {

        int mode = getMode(instance);

        switch (mode) {

            /* ================= ANALYSIS ================= */
            case 1 -> {

                if (!(entity instanceof ServerPlayer player)) return;

                CompoundTag data = instance.getOrCreateTag();

                // SHIFT = change mode
                if (player.isShiftKeyDown()) {

                    int analysisMode = data.getInt(TAG_ANALYSIS_MODE);

                    analysisMode = switch (analysisMode) {
                        case 1 -> 2;
                        case 2 -> 3;
                        default -> 1;
                    };

                    data.putInt(TAG_ANALYSIS_MODE, analysisMode);

                    Component msg = switch (analysisMode) {
                        case 1 -> Component.literal("Analysis Mode: Entity").withStyle(ChatFormatting.AQUA);
                        case 2 -> Component.literal("Analysis Mode: Block").withStyle(ChatFormatting.AQUA);
                        case 3 -> Component.literal("Analysis Mode: Both").withStyle(ChatFormatting.AQUA);
                        default -> Component.literal("Analysis Mode: Unknown").withStyle(ChatFormatting.AQUA);
                    };

                    player.displayClientMessage(msg, true);
                    player.playNotifySound(
                            SoundEvents.EXPERIENCE_ORB_PICKUP,
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                    );

                    return;
                }

                // NORMAL PRESS = toggle analysis
                boolean active = data.getBoolean(TAG_ANALYSIS_ACTIVE);

                if (active) {
                    AttributeHelper.removeAnalysisAttributes(player, true, true, false);
                    data.putBoolean(TAG_ANALYSIS_ACTIVE, false);

                    player.displayClientMessage(
                            Component.literal("Analysis Disabled").withStyle(ChatFormatting.RED),
                            true
                    );
                } else {
                    int level = isMastered(instance, entity)
                            ? CONFIG.analysisLevelMastered
                            : CONFIG.analysisLevel;

                    AttributeHelper.addAnalysisAttributes(player, level, 30);

                    data.putBoolean(TAG_ANALYSIS_ACTIVE, true);

                    player.displayClientMessage(
                            Component.literal("Analysis Enabled").withStyle(ChatFormatting.GREEN),
                            true
                    );
                }

                player.playNotifySound(
                        SoundEvents.EXPERIENCE_ORB_PICKUP,
                        SoundSource.PLAYERS,
                        1.0F,
                        1.0F
                );
            }

            /* ================= REINFORCEMENT ================= */
            case 2 -> reinforce(instance, entity);

            /* ================= PROJECTION ================= */
            case 3 -> {
                if (entity instanceof Player player) {
                    project(instance, player);
                }
            }
        }
    }

    /* ================= REINFORCE ================= */

    private void reinforce(ManasSkillInstance instance, LivingEntity entity) {

        if (!(entity instanceof Player player)) return;

        ItemStack item = player.getMainHandItem();
        if (item.isEmpty()) return;

        CompoundTag tag = new CompoundTag();
        tag.putBoolean("Unbreakable", true);

        item.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
        instance.setCoolDown(1, 100);
    }

    /* ================= PROJECTION ================= */

    private void project(ManasSkillInstance instance, Player caster) {

        double range = 30;

        Vec3 eye = caster.getEyePosition();
        Vec3 look = caster.getViewVector(1.0F);
        Vec3 end = eye.add(look.scale(range));

        AABB box = caster.getBoundingBox().inflate(range);

        EntityHitResult hit = ProjectileUtil.getEntityHitResult(
                caster,
                eye,
                end,
                box,
                e -> e instanceof LivingEntity living &&
                        living != caster &&
                        !living.getMainHandItem().isEmpty(),
                range * range
        );

        if (hit == null || !(hit.getEntity() instanceof LivingEntity target)) {
            caster.displayClientMessage(Component.literal("No target!").withStyle(ChatFormatting.RED), true);
            return;
        }

        ItemStack copy = target.getMainHandItem().copy();
        copy.setCount(1);

        CompoundTag tag = new CompoundTag();
        tag.putBoolean("Projection", true);

        copy.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));

        caster.getInventory().add(copy);

        caster.displayClientMessage(Component.literal("Projected item!").withStyle(ChatFormatting.GOLD), true);

        instance.setCoolDown(2, 120);
    }

    public boolean canBeToggled(ManasSkillInstance instance, LivingEntity living) {
        return this.isMastered(instance, living);
    }
}