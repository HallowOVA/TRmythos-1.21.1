package com.github.propheticeclipse.tensurastarlight.utils;

import io.github.manasmods.manascore.race.api.SpawnPointHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class StarlightUtils {
    public static void TeleportToSpawnpoint(LivingEntity player) {
        if (player instanceof ServerPlayer serverPlayer) {
            ResourceKey<Level> spawnDim = serverPlayer.getRespawnDimension();
            ServerLevel dimLevel = player.getServer().getLevel(spawnDim);

            if (serverPlayer.getRespawnPosition() != null) {
                double spawnX = serverPlayer.getRespawnPosition().getX();
                double spawnY = serverPlayer.getRespawnPosition().getY();
                double spawnZ = serverPlayer.getRespawnPosition().getZ();

                SpawnPointHelper.teleportToAcrossDimensions(serverPlayer, dimLevel, spawnX, spawnY, spawnZ, 0, 0);
            } else {
                serverPlayer.displayClientMessage(Component.translatable("trstarlight.generic.spawnpoint_not_located").setStyle(Style.EMPTY.withColor(ChatFormatting.DARK_PURPLE)), false);
            }
        }
    }
}
