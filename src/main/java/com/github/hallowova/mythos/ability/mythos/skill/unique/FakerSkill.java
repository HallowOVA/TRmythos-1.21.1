package com.github.hallowova.mythos.ability.mythos.skill.unique;

import com.github.hallowova.mythos.config.FakerConfig;
import com.github.hallowova.mythos.registry.MythosMobEffects;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.tensura.ability.SkillHelper;
import io.github.manasmods.tensura.ability.TensuraSkillInstance;
import io.github.manasmods.tensura.ability.skill.Skill;
import io.github.manasmods.tensura.enchantment.TensuraEnchantments;
import io.github.manasmods.tensura.registry.skill.UniqueSkills;
import io.github.manasmods.tensura.util.AttributeHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.UnknownNullability;

import java.util.function.Predicate;

public class FakerSkill extends Skill {

    private static final FakerConfig CONFIG = new FakerConfig();

    private static final String TAG_ANALYSIS_MODE = "AnalysisMode";
    private static final String TAG_ANALYSIS_ACTIVE = "AnalysisActive";

    public FakerSkill() {
        super(SkillType.UNIQUE);
    }

    @Override
    public int getModes(ManasSkillInstance instance) {
        return 3;
    }

    @Override
    public String getModeId(ManasSkillInstance instance, int mode) {
        return switch (mode) {
            case 1 -> "faker.analytical_appraisal";
            case 2 -> "faker.reinforcement";
            case 3 -> "faker.projection";
            default -> super.getModeId(instance, mode);
        };
    }

    @Override
    public int nextMode(LivingEntity entity, ManasSkillInstance instance, int mode, boolean reverse) {
        int max = getModes(instance);
        int newMode = reverse ? (mode <= 1 ? max : mode - 1) : (mode >= max ? 1 : mode + 1);

        instance.getOrCreateTag().putInt("CurrentMode", newMode);
        return newMode;
    }

    @Override
    public void onToggleOn(ManasSkillInstance instance, LivingEntity entity) {
        entity.addEffect(new MobEffectInstance(MythosMobEffects.AVALON_REGENERATION, 220, 1, false, false, false));
    }

    @Override
    public void onToggleOff(ManasSkillInstance instance, LivingEntity entity) {
        entity.removeEffect(MythosMobEffects.AVALON_REGENERATION);
    }

    @Override
    public void onTick(ManasSkillInstance instance, LivingEntity entity) {
        if (instance.isToggled()) {
            entity.addEffect(new MobEffectInstance(MythosMobEffects.AVALON_REGENERATION, 220, 1, false, false, false));
        }
    }


    @Override
    public void onSkillMastered(ManasSkillInstance instance, LivingEntity entity) {
        if (instance.isSubInstance()) return;

        TensuraSkillInstance skill = new TensuraSkillInstance(UniqueSkills.SEVERER.get());

        skill.setMastery(UniqueSkills.SEVERER.get().getAcquirementMastery(entity));

        SkillHelper.learnSkill(entity, skill);
    }


    @Override
    public void onPressed(ManasSkillInstance instance, LivingEntity entity, int keyNumber, int mode) {

        if (entity.level().isClientSide()) return;

        if (!(entity instanceof ServerPlayer player)) return;

        instance.getOrCreateTag().putInt("CurrentMode", mode);

        player.displayClientMessage(Component.literal("Mode: " + mode), true);

        switch (mode) {

            case 1 -> {

                CompoundTag data = instance.getOrCreateTag();

                if (player.isShiftKeyDown()) {
                    int analysisMode = data.getInt("AnalysisMode");

                    analysisMode = switch (analysisMode) {
                        case 1 -> 2;
                        case 2 -> 3;
                        default -> 1;
                    };

                    data.putInt("AnalysisMode", analysisMode);

                    player.displayClientMessage(Component.literal("Analysis Mode: " + analysisMode), true);

                } else {

                    boolean active = data.getBoolean("AnalysisActive");

                    if (active) {
                        AttributeHelper.removeAnalysisAttributes(player, true, true, false);
                        data.putBoolean("AnalysisActive", false);

                        player.displayClientMessage(Component.literal("Trace, Off."), true);
                    } else {

                        int level = isMastered(instance, entity) ? CONFIG.analysisLevelMastered : CONFIG.analysisLevel;

                        AttributeHelper.addAnalysisAttributes(player, level, 30);

                        data.putBoolean("AnalysisActive", true);

                        player.displayClientMessage(Component.literal("Trace, On."), true);
                    }
                }
            }

            case 2 -> reinforce(instance, player);
            case 3 -> performProjection(instance, player);
        }
    }

    private void reinforce(ManasSkillInstance instance, ServerPlayer player) {

        ItemStack item = player.getMainHandItem();

        if (item.isEmpty()) {
            player.displayClientMessage(Component.literal("Nothing to enhance...").withStyle(ChatFormatting.RED), true);
            return;
        }

        var enchantments = item.get(DataComponents.ENCHANTMENTS);

        if (enchantments == null || enchantments.isEmpty()) {
            player.displayClientMessage(Component.literal("This item lacks mystical potential.").withStyle(ChatFormatting.RED), true);
            return;
        }

        ItemEnchantments.Mutable mutable = new ItemEnchantments.Mutable(enchantments);

        for (var entry : enchantments.entrySet()) {

            var holder = entry.getKey();
            var enchantment = holder.value();

            int maxLevel = enchantment.getMaxLevel();

            if (CONFIG.allowOvercap) {
                maxLevel = Math.max(maxLevel, CONFIG.reinforceOvercapLevel);
            }

            mutable.set(holder, maxLevel);
        }

        item.set(DataComponents.ENCHANTMENTS, mutable.toImmutable());

        player.displayClientMessage(Component.literal("Reinforcement Complete!").withStyle(ChatFormatting.GOLD), true);

        player.swing(player.getUsedItemHand());

        player.level().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.0F, 1.2F);

        instance.setCoolDown(2, CONFIG.reinforceCooldown);
    }

    private void performProjection(ManasSkillInstance instance, @UnknownNullability ServerPlayer caster) {
        Level level = caster.level();
        if (level.isClientSide()) return;

        double range = 30;
        Vec3 eyePos = caster.getEyePosition(1.0F);
        Vec3 lookVec = caster.getViewVector(1.0F);
        Vec3 end = eyePos.add(lookVec.scale(range));
        AABB searchBox = caster.getBoundingBox().expandTowards(lookVec.scale(range)).inflate(1.0D);

        Predicate<Entity> predicate = target ->
                target instanceof LivingEntity living &&
                        living != caster &&
                        !living.getMainHandItem().isEmpty();

        EntityHitResult hit = ProjectileUtil.getEntityHitResult(
                caster,
                eyePos,
                end,
                searchBox,
                predicate,
                range * range
        );

        if (hit == null || !(hit.getEntity() instanceof LivingEntity targetLiving)) {
            caster.displayClientMessage(Component.translatable("trmythos.skill.faker.projection.no_target").withStyle(ChatFormatting.RED), true);
            level.playSound(null, caster.blockPosition(), SoundEvents.VILLAGER_NO, SoundSource.PLAYERS, 1.0F, 1.0F);
            instance.setCoolDown(10, 3);
            return;
        }

        ItemStack targetItem = targetLiving.getMainHandItem();
        if (targetItem.isEmpty()) {
            caster.displayClientMessage(Component.translatable("trmythos.skill.faker.projection.empty_hand").withStyle(ChatFormatting.RED), true);
            instance.setCoolDown(10, 3);
            return;
        }

        String itemId = BuiltInRegistries.ITEM.getKey(targetItem.getItem()).toString();
        boolean isRestricted = MythosSkillsConfig.getFakerSkillRestrictedItems().contains(itemId);

        int enchantmentLevel =
                targetItem.getEnchantmentLevel(level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(TensuraEnchantments.TSUKUMOGAMI));
        boolean hasTsukumogami = enchantmentLevel > 0;

        if (hasTsukumogami || isRestricted) {
            String translationKey = hasTsukumogami
                    ? "trmythos.skill.faker.projection.fail.tsukumogami"
                    : "trmythos.skill.faker.projection.fail.restricted";

            caster.displayClientMessage(Component.translatable(translationKey).withStyle(ChatFormatting.RED), true);
            level.playSound(null, caster.blockPosition(), SoundEvents.VILLAGER_NO, SoundSource.PLAYERS, 1.0F, 1.0F);

            instance.setCoolDown(10, 3);
            return;
        }

        ItemStack projectedCopy = targetItem.copy();
        projectedCopy.setCount(1);

        if (caster.getMainHandItem().isEmpty()) {
            caster.setItemInHand(InteractionHand.MAIN_HAND, projectedCopy);
        } else if (!caster.getInventory().add(projectedCopy)) {
            caster.drop(projectedCopy, false);
        }

        caster.displayClientMessage(Component.translatable("trmythos.skill.faker.projection.success", targetLiving.getDisplayName()).withStyle(ChatFormatting.GOLD), true);
        level.playSound(null, caster.blockPosition(), SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 1.0F, 1.0F);

        instance.setCoolDown(3, CONFIG.projectionCooldown);

        addMasteryPoint(instance, caster);
    }

    @Override
    public boolean canBeToggled(ManasSkillInstance instance, LivingEntity living) {
        return this.isMastered(instance, living);
    }
}