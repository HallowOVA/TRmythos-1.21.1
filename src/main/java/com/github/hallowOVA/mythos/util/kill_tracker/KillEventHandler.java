package com.github.hallowOVA.mythos.util.kill_tracker;

import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

@EventBusSubscriber(modid = "trmythos")
public class KillEventHandler {

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (event.getSource().getEntity() instanceof Player killer && event.getEntity() instanceof Player victim) {
            boolean isAwakened = TensuraPlayerCapability.isTrueDemonLord(victim) || TensuraPlayerCapability.isTrueHero(victim);

            if (isAwakened) {
                killer.getCapability(KillTrackerProvider.CAPABILITY).ifPresent(IKillTracker::addAwakenedKills);
            }

        }
    }
}
