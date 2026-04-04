package com.github.hallowOVA.mythos.util;

import com.github.hallowOVA.mythos.client.screen.OrunScreen;
import com.github.hallowOVA.mythos.registry.MythosEntityTypes;
import com.github.hallowOVA.mythos.registry.menu.MythosMenuTypes;
import com.github.hallowOVA.mythos.renderers.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = "trmythos", value = Dist.CLIENT)
public class ClientModEvents {
    public ClientModEvents() {
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(MythosMenuTypes.ORUN_MENU.get(), OrunScreen::new);
        });
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(MythosEntityTypes.STARFALL.get(), StarfallRenderer::new);

        event.registerEntityRenderer(MythosEntityTypes.DRAGONFIRE.get(), DragonfireRenderer::new);
        event.registerEntityRenderer(MythosEntityTypes.VAJRA_BREATH.get(), VajraBreathRenderer::new);

        event.registerEntityRenderer(MythosEntityTypes.THUNDER_STORM.get(), ThunderStormRenderer::new);
        event.registerEntityRenderer(MythosEntityTypes.INTROVERT_BARRIER.get(), IntrovertBarrierRenderer::new);
        event.registerEntityRenderer(MythosEntityTypes.BOREAS_BARRIER.get(), BoreasBarrierRenderer::new);

        event.registerEntityRenderer(MythosEntityTypes.DENDRAHH.get(),context -> new DendrrahRenderer(context, true));

        event.registerEntityRenderer(MythosEntityTypes.BLACK_HOLE.get(), BlackHoleRenderer::new);
    }
}
