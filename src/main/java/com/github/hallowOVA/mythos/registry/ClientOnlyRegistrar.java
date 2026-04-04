package com.github.hallowOVA.mythos.registry;

import com.github.hallowOVA.mythos.client.screen.OrunScreen;
import com.github.hallowOVA.mythos.handler.HaliShaderHandler;
import com.github.hallowOVA.mythos.handler.YellowSignOverlayHandler;
import com.github.hallowOVA.mythos.networking.play2server.ShaderPacket;
import com.github.hallowOVA.mythos.registry.menu.MythosMenuTypes;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import dev.architectury.event.events.common.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterShadersEvent;
import net.neoforged.neoforge.common.NeoForge;

import java.io.IOException;

public class ClientOnlyRegistrar {
    public static void registerClientOnlyEvents() {
        // Registers the FMLClientSetupEvent
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientOnlyRegistrar::onClientSetup);

        // Manual registration for handlers that DON'T have @Mod.EventBusSubscriber
        NeoForge.EVENT_BUS.register(YellowSignOverlayHandler.class);
        NeoForge.EVENT_BUS.register(HaliShaderHandler.class);
    }

    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(MythosMenuTypes.ORUN_MENU.get(), OrunScreen::new);
        });
    }

    @SubscribeEvent
    public static void onRegisterShaders(RegisterShadersEvent event) throws IOException {
        event.registerShader(new ShaderInstance(event.getResourceManager(),
                new ResourceLocation("trmythos", "mythos_dome"), DefaultVertexFormat.POSITION_TEX), (inst) -> {
            MythosShaders.DOME_SHADER = inst;
        });
    }

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Pre event) {
        Minecraft mc = Minecraft.getInstance();

        if (mc.level != null && MythosWorldVisuals.alpha > 0) {

            if (mc.gameRenderer.currentEffect() == null) {
                mc.gameRenderer.loadEffect(new ResourceLocation("trmythos", "shaders/post/master_sky.json"));
            }

            ShaderPacket.applyColorsToShader(MythosWorldVisuals.r, MythosWorldVisuals.g, MythosWorldVisuals.b);
        }

    }
}