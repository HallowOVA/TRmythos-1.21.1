package com.github.hallowOVA.mythos.util;

import com.github.hallowOVA.mythos.registry.MythosWorldVisuals;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ViewportEvent;

@EventBusSubscriber(modid = "trmythos",  value = Dist.CLIENT)
public class MythosSkyRenderer {

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onFogColor(ViewportEvent.ComputeFogColor event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || mc.level == null) return;

        if (MythosWorldVisuals.alpha > 0) {
            event.setRed(MythosWorldVisuals.r);
            event.setGreen(MythosWorldVisuals.g);
            event.setBlue(MythosWorldVisuals.b);
        }

    }


    @SubscribeEvent
    public static void onFogRender(ViewportEvent.RenderFog event) {
        if (MythosWorldVisuals.alpha > 0) {
            event.setCanceled(true);
        }
    }
}