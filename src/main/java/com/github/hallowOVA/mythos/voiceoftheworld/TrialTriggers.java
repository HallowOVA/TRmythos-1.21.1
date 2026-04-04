package com.github.hallowOVA.mythos.voiceoftheworld;

import com.github.hallowOVA.mythos.config.MythosSkillsConfig;
import dev.architectury.event.events.common.TickEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = "mythos")
public class TrialTriggers {

    @SubscribeEvent
    public static void onEntityKill(LivingDeathEvent event) {
        if (!MythosSkillsConfig.voice_of_the_world.get()) return;
        if (event.getSource().getEntity() instanceof ServerPlayer player) {
            LivingEntity victim = event.getEntity();

            if (victim.getMaxHealth() >= (player.getMaxHealth() * 10)) {
                WorldTrialRegistry.TRIALS.get("giant_slayer").checkProgress(player, 1);
            }

            if (victim instanceof ServerPlayer || victim.getType().toString().contains("villager")) {
                player.getPersistentData().putInt("Trial_Progress_pacifist", 0);
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Pre event) {
        if (!MythosSkillsConfig.voice_of_the_world.get()) return;
        if (event.getEntity() instanceof ServerPlayer player) {

            if (player.getY() <= -100000) {
                if (WorldTrialRegistry.TRIALS.containsKey("void_walker")) {
                    WorldTrialRegistry.TRIALS.get("void_walker").checkProgress(player, 1);
                }
            }

        }
    }
}
