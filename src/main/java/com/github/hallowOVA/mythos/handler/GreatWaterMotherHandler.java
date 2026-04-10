package com.github.hallowOVA.mythos.handler;

import com.github.hallowOVA.mythos.registry.skill.MythosSkills;
import io.github.manasmods.manascore.skill.api.SkillAPI;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = "trmythos")
public class GreatWaterMotherHandler {

    private static final String POINTS_KEY = "CreationElementalPoints";
    private static final int MAX_POINTS = 1000;


    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();

        if (player.level().isClientSide || player.level().getGameTime() % 20 != 0) return;

        SkillAPI.getSkillsFrom(player).getSkill(MythosSkills.NIMUE.get()).ifPresent(instance -> {
            boolean inWater = player.isInWater();
            boolean inRain = player.level().isRainingAt(player.blockPosition());

            if (inWater || inRain) {
                CompoundTag tag = instance.getOrCreateTag();
                int currentPoints = tag.getInt(POINTS_KEY);

                if (currentPoints < MAX_POINTS) {
                    int gain = 5;
                    tag.putInt(POINTS_KEY, Math.min(MAX_POINTS, currentPoints + gain));

                    player.displayClientMessage(
                            Component.literal("Creation Points: " + (currentPoints + gain) + "/" + MAX_POINTS)
                                    .withStyle(net.minecraft.ChatFormatting.AQUA),
                            true
                    );
                }
            }
        });
    }
}
