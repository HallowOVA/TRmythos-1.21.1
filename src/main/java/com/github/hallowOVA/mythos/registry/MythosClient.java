package com.github.hallowOVA.mythos.registry;

import com.github.hallowOVA.mythos.client.screen.OrunScreen;
import com.github.hallowOVA.mythos.particles.RedRunesParticles;
import com.github.hallowOVA.mythos.registry.menu.MythosMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = "trmythos", value = Dist.CLIENT)
public class MythosClient {

    public static void clientSetup(final FMLClientSetupEvent event) {
       // FMLJavaModLoadingContext.get().getModEventBus().addListener(MythosClient::clientSetup);
        MenuScreens.register(MythosMenuTypes.ORUN_MENU.get(), OrunScreen::new);;
    }

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        event.register(MythosParticles.RED_RUNES.get(), RedRunesParticles.Provider::new);
    }
}

