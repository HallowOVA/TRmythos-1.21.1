package com.github.hallowOVA.mythos.registry;

import com.github.hallowOVA.mythos.registry.skill.Skills;
import net.neoforged.bus.api.IEventBus;

public class MythosRegistery {
    public MythosRegistery () {
    }

    public static void register(IEventBus modEventBus) {
        Skills.init(modEventBus);
        MythosMobEffects.register(modEventBus);
        //MythosClient.clientSetup((FMLClientSetupEvent) modEventBus);
        //modEventBus.addListener(MythosClient::clientSetup);

        // trials and voice of the world
        TrialManager.init();

    }

}