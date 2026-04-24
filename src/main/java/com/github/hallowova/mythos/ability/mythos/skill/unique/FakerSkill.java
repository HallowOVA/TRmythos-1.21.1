//package com.github.hallowova.mythos.ability.mythos.skill.unique;
//
//
//import com.github.hallowova.mythos.registry.MythosMobEffects;
//import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
//import io.github.manasmods.tensura.ability.skill.Skill;
//import io.github.manasmods.tensura.ability.skill.extra.ThoughtAccelerationSkill;
//import net.minecraft.ChatFormatting;
//import net.minecraft.core.Registry;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.network.chat.Component;
//import net.minecraft.network.chat.MutableComponent;
//import net.minecraft.network.chat.Style;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.sounds.SoundSource;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.effect.MobEffectInstance;
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//
//import java.util.Optional;
//import java.util.UUID;
//
//public class FakerSkill extends Skill {
//    public FakerSkill() {
//        super(SkillType.UNIQUE);
//    }
//
//    protected static final UUID ACCELERATION =
//            UUID.fromString("0147c153-32a2-4524-8ba3-ba4c2f449d7c");
//
//
//    public double getObtainingEpCost() {
//        return 100000.0;
//    }
//
//    public double learningCost() {
//        return 1000.0;
//    }
//
//    @Override
//    public int getMaxMastery() {
//        return 3000;
//    }
//
//
//
//    /* =========================================================
//     * TOGGLE ON
//     * ========================================================= */
//    @Override
//    public void onToggleOn(ManasSkillInstance instance, LivingEntity entity) {
//
//        if (!entity.hasEffect(MythosMobEffects.AVALON_REGENERATION)) {
//
//            entity.addEffect(
//                    new MobEffectInstance(
//                            MythosMobEffects.AVALON_REGENERATION,
//                            220,
//                            1,
//                            false,
//                            false,
//                            false
//                    )
//            );
//        }
//    }
//
//
//    @Override
//    public void onToggleOff(ManasSkillInstance instance, LivingEntity entity) {
//
//        MobEffectInstance effect =
//                entity.getEffect(MythosMobEffects.AVALON_REGENERATION);
//
//        if (effect != null && effect.getAmplifier() < 1) {
//            entity.removeEffect(MythosMobEffects.AVALON_REGENERATION);
//        }
//    }
//
//    /* =========================================================
//     * TICK
//     * ========================================================= */
//    @Override
//    public void onTick(ManasSkillInstance instance, LivingEntity entity) {
//
//        grantSevererIfMastered(instance, entity);
//
//        if (instance.isToggled()) {
//
//            if (!entity.hasEffect(MythosMobEffects.AVALON_REGENERATION)) {
//
//                entity.addEffect(
//                        new MobEffectInstance(
//                                MythosMobEffects.AVALON_REGENERATION,
//                                220,
//                                1,
//                                false,
//                                false,
//                                false
//                        )
//                );
//            }
//        }
//    }
//
//    /* =========================================================
//     * SEVERER GRANT
//     * ========================================================= */
//    private void grantSevererIfMastered(ManasSkillInstance instance, LivingEntity entity) {
//
//        if (!(entity instanceof Player player)) return;
//        if (entity.level().isClientSide()) return;
//        if (!this.isMastered(instance, entity)) return;
//
//        SkillStorage storage = SkillAPI.getSkillsFrom(player);
//
//        if (storage.getSkill(UniqueSkills.SEVERER.get()).isPresent()) return;
//
//        storage.learnSkill(UniqueSkills.SEVERER.get());
//
//        player.displayClientMessage(
//                Component.translatable("trmythos.skill.faker.mastered.grant.severer")
//                        .withStyle(ChatFormatting.GOLD),
//                false
//        );
//
//        player.level().playSound(
//                null,
//                player.getX(),
//                player.getY(),
//                player.getZ(),
//                SoundEvents.PLAYER_LEVELUP,
//                SoundSource.PLAYERS,
//                1.0F,
//                1.2F
//        );
//
//        TensuraSkillCapability.sync(player);
//    }
//
//    /* =========================================================
//     * MODES
//     * ========================================================= */
//    public int modes() {
//        return 3;
//    }
//
//    public int nextMode(LivingEntity entity, TensuraSkillInstance instance, boolean reverse) {
//
//        if (reverse) {
//            return (instance.getMode() == 1) ? 3 : instance.getMode() - 1;
//        } else {
//            return (instance.getMode() == 3) ? 1 : instance.getMode() + 1;
//        }
//    }
//
//    public Component getModeName(int mode) {
//
//        return switch (mode) {
//            case 1 -> Component.translatable("trmythos.skill.mode.faker.analytical_appraisal");
//            case 2 -> Component.translatable("trmythos.skill.mode.faker.reinforcement");
//            case 3 -> Component.translatable("trmythos.skill.mode.faker.projection");
//            default -> Component.empty();
//        };
//    }
//
//    /* =========================================================
//     * PRESS ACTION
//     * ========================================================= */
//    @Override
//    public void onPressed(ManasSkillInstance instance, LivingEntity entity) {
//
//        switch (instance.getMode()) {
//
//            /* =======================
//             * MODE 1: ANALYSIS
//             * ======================= */
//            case 1 -> {
//
//                if (!(entity instanceof Player player)) return;
//                if (SkillHelper.outOfMagicule(entity, instance)) return;
//
//                TensuraSkillCapability.getFrom(player).ifPresent(cap -> {
//
//                    if (player.isCrouching()) {
//
//                        int mode = cap.getAnalysisMode();
//
//                        switch (mode) {
//                            case 1 -> {
//                                cap.setAnalysisMode(2);
//                                player.displayClientMessage(
//                                        Component.translatable("tensura.skill.analytical.analyzing_mode.block")
//                                                .withStyle(ChatFormatting.DARK_AQUA),
//                                        true
//                                );
//                            }
//                            case 2 -> {
//                                cap.setAnalysisMode(0);
//                                player.displayClientMessage(
//                                        Component.translatable("tensura.skill.analytical.analyzing_mode.both")
//                                                .withStyle(ChatFormatting.DARK_AQUA),
//                                        true
//                                );
//                            }
//                            default -> {
//                                cap.setAnalysisMode(1);
//                                player.displayClientMessage(
//                                        Component.translatable("tensura.skill.analytical.analyzing_mode.entity")
//                                                .withStyle(ChatFormatting.DARK_AQUA),
//                                        true
//                                );
//                            }
//                        }
//
//                        player.playNotifySound(
//                                SoundEvents.ENCHANTMENT_TABLE_USE,
//                                SoundSource.PLAYERS,
//                                1.0F,
//                                1.0F
//                        );
//
//                        TensuraSkillCapability.sync(player);
//
//                    } else {
//
//                        int level = this.isMastered(instance, entity) ? 18 : 8;
//
//                        if (cap.getAnalysisLevel() != level) {
//
//                            cap.setAnalysisLevel(level);
//                            cap.setAnalysisDistance(this.isMastered(instance, entity) ? 30 : 20);
//
//                        } else {
//                            cap.setAnalysisLevel(0);
//                        }
//
//                        player.level().playSound(
//                                null,
//                                player.blockPosition(),
//                                SoundEvents.ENCHANTMENT_TABLE_USE,
//                                SoundSource.PLAYERS,
//                                1.0F,
//                                1.0F
//                        );
//
//                        TensuraSkillCapability.sync(player);
//                    }
//                });
//            }
//
//            /* =======================
//             * MODE 2: REINFORCE
//             * ======================= */
//            case 2 -> {
//
//                if (!(entity instanceof Player player)) return;
//                if (SkillHelper.outOfMagicule(entity, instance)) return;
//
//                ItemStack mainHand = entity.getMainHandItem();
//                if (mainHand.isEmpty()) return;
//
//                reinforce(instance, entity, InteractionHand.MAIN_HAND);
//
//                instance.setCoolDown(this.isMastered(instance, entity) ? 60 : 120);
//                addMasteryPoint(instance, entity);
//            }
//
//            /* =======================
//             * MODE 3: PROJECTION
//             * ======================= */
//            case 3 -> {
//
//                if (!(entity instanceof Player player)) return;
//                if (SkillHelper.outOfMagicule(entity, instance)) return;
//
//                performProjection(instance, player);
//            }
//        }
//    }
//
//    /* =========================================================
//     * PROJECTION (unchanged logic, API-safe)
//     * ========================================================= */
//    private void performProjection(ManasSkillInstance instance, Player caster) {
//
//        if (caster.level().isClientSide()) return;
//
//        double range = 30;
//
//        var eye = caster.getEyePosition();
//        var look = caster.getViewVector(1.0F);
//
//        var end = eye.add(look.scale(range));
//
//        var box = caster.getBoundingBox().inflate(range);
//
//        var hit = caster.level().getNearestEntity(
//                caster.level().getEntitiesOfClass(LivingEntity.class, box,
//                        e -> e != caster && !e.getMainHandItem().isEmpty()),
//                caster
//        );
//
//        if (hit == null) {
//            caster.displayClientMessage(
//                    Component.translatable("trmythos.skill.faker.projection.no_target")
//                            .withStyle(ChatFormatting.RED),
//                    true
//            );
//            return;
//        }
//
//        ItemStack targetItem = hit.getMainHandItem();
//        if (targetItem.isEmpty()) return;
//
//        ItemStack copy = targetItem.copy();
//        copy.setCount(1);
//
//        CompoundTag tag = copy.getOrCreateTag();
//        tag.putBoolean("IsProjection", true);
//        tag.putUUID("ProjectedBy", caster.getUUID());
//
//        if (caster.getMainHandItem().isEmpty()) {
//            caster.setItemInHand(InteractionHand.MAIN_HAND, copy);
//        } else {
//            caster.getInventory().add(copy);
//        }
//
//        caster.displayClientMessage(
//                Component.translatable("trmythos.skill.faker.projection.success")
//                        .withStyle(ChatFormatting.GOLD),
//                true
//        );
//
//        instance.setCoolDown(120);
//        addMasteryPoint(instance, caster);
//    }
//
//    /* =========================================================
//     * REINFORCEMENT (kept simplified but safe)
//     * ========================================================= */
//    private void reinforce(ManasSkillInstance instance, LivingEntity entity, InteractionHand hand) {
//
//        ItemStack item = entity.getItemInHand(hand);
//        if (item.isEmpty()) return;
//
//        item.getOrCreateTag().putBoolean("Unbreakable", true);
//
//        entity.setItemInHand(hand, item);
//        entity.swing(hand);
//
//        entity.level().playSound(
//                null,
//                entity.blockPosition(),
//                SoundEvents.ENCHANTMENT_TABLE_USE,
//                SoundSource.PLAYERS,
//                1.0F,
//                1.0F
//        );
//    }
//
//    @Override
//    public boolean canBeToggled(ManasSkillInstance instance, LivingEntity living) {
//        return instance.isMastered(living);
//    }
//}