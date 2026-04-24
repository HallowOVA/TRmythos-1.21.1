package com.github.hallowova.mythos.mob_effect;

import com.github.hallowova.mythos.registry.MythosMobEffects;
import io.github.manasmods.manascore.skill.api.ManasSkillInstance;
import io.github.manasmods.manascore.skill.api.SkillAPI;
import io.github.manasmods.manascore.skill.impl.SkillStorage;
import io.github.manasmods.tensura.ability.SkillUtils;
import io.github.manasmods.tensura.ability.skill.extra.InfiniteRegenerationSkill;
import io.github.manasmods.tensura.effect.template.TensuraMobEffect;
import io.github.manasmods.tensura.registry.attribute.TensuraAttributes;
import io.github.manasmods.tensura.registry.skill.ExtraSkills;
import io.github.manasmods.tensura.storage.TensuraStorages;
import io.github.manasmods.tensura.storage.effect.EffectStorage;
import io.github.manasmods.tensura.storage.ep.IExistence;
import io.github.manasmods.tensura.util.EnergyHelper;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.awt.Color;
import java.util.Optional;

public class AvalonRegenerationEffect extends TensuraMobEffect {

    public AvalonRegenerationEffect() {
        super(MobEffectCategory.BENEFICIAL, new Color(120, 255, 200).getRGB());
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {

        if (SkillUtils.shouldCancelInteraction(entity) || !entity.isAlive()) {
            return false;
        }

        double maxHealth = EffectStorage.getSeveranceMaxHealth(entity);

        if (maxHealth <= 0.0D) {
            return false;
        }

        float missingHealth = (float) maxHealth - entity.getHealth();

        if (missingHealth <= 0.0F) {
            return false;
        }

        if (SkillUtils.shouldCancelHealing(entity)) {
            return false;
        }

        SkillStorage skillStorage = SkillAPI.getSkillsFrom(entity);

        Optional<ManasSkillInstance> instance =
                skillStorage.getSkill(ExtraSkills.INFINITE_REGENERATION.get());

        /*
         * =========================================================
         * HEAL AMOUNT
         * =========================================================
         */

        float healAmount = Math.min(
                missingHealth,
                2.0F + (amplifier * 2.0F)
        );

        /*
         * =========================================================
         * MAGICULE COST
         * Avalon = 2x Infinite Regen cost
         * =========================================================
         */

        double baseCost;

        if (instance.isPresent() && instance.get().isMastered(entity)) {
            baseCost = InfiniteRegenerationSkill.CONFIG.magiculeCostMastered;
        } else {
            baseCost = InfiniteRegenerationSkill.CONFIG.magiculeCost;
        }

        double cost = baseCost * 2.0D;

        int totalCost = (int) (healAmount * cost);

        double lackedMagicule = EnergyHelper.isOutOfMagiculeConsuming(
                entity,
                totalCost,
                entity.getType().equals(EntityType.PLAYER)
                        ? 0.0D
                        : 10.0D
        );

        if (lackedMagicule > 0.0D) {

            healAmount -= (float) (lackedMagicule / cost);

            if (healAmount <= 0.0F) {

                if (entity instanceof Player player) {

                    if (instance.isPresent() && instance.get().isToggled()) {

                        instance.get().setToggled(false);

                        skillStorage.markDirty();

                        player.sendSystemMessage(
                                Component.translatable(
                                        "tensura.skill.lack_magicule.toggled_off",
                                        instance.get().getChatDisplayName(true)
                                ).withStyle(ChatFormatting.RED)
                        );
                    }
                }

                return false;
            }
        }

        /*
         * =========================================================
         * APPLY HP HEAL
         * =========================================================
         */

        entity.heal(healAmount);

        /*
         * =========================================================
         * SPIRITUAL HEALTH REGEN
         * amplifier >= 1
         * =========================================================
         */

        if (amplifier >= 1) {

            IExistence existence = TensuraStorages.getExistenceFrom(entity);

            double currentSHP = existence.getSpiritualHealth();

            double maxSHP = entity.getAttributeValue(
                    TensuraAttributes.MAX_SPIRITUAL_HEALTH
            );

            double missingSHP = maxSHP - currentSHP;

            if (missingSHP > 0.0D) {

                double shpHeal = Math.min(
                        missingSHP,
                        1.5D + amplifier
                );

                double shpBaseCost;

                if (instance.isPresent() && instance.get().isMastered(entity)) {
                    shpBaseCost =
                            InfiniteRegenerationSkill.CONFIG.shpMagiculeCostMastered;
                } else {
                    shpBaseCost =
                            InfiniteRegenerationSkill.CONFIG.shpMagiculeCost;
                }

                double shpCost = shpBaseCost * 2.0D;

                int shpTotalCost = (int) (shpHeal * shpCost);

                double lackedShpMagicule =
                        EnergyHelper.isOutOfMagiculeConsuming(
                                entity,
                                shpTotalCost,
                                entity.getType().equals(EntityType.PLAYER)
                                        ? 0.0D
                                        : 10.0D
                        );

                if (lackedShpMagicule > 0.0D) {
                    shpHeal -= lackedShpMagicule / shpCost;
                }

                if (shpHeal > 0.0D) {

                    existence.setSpiritualHealth(
                            Math.min(currentSHP + shpHeal, maxSHP)
                    );
                }
            }
        }

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(
            int duration,
            int amplifier
    ) {
        return duration % 10 == 0;
    }

    public static boolean canStopDeath(
            DamageSource source,
            LivingEntity entity
    ) {

        if (source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return false;
        }


        if (EffectStorage.getSeveranceMaxHealth(entity) <= 0.0D) {
            return false;
        }

        MobEffectInstance regeneration =
                entity.getEffect(MythosMobEffects.AVALON_REGENERATION);

        if (regeneration == null) {
            return false;
        }

        return regeneration.getAmplifier() >= 1;
    }
}