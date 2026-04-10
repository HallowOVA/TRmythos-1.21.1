package com.github.hallowOVA.mythos.registry;

import com.github.hallowOVA.mythos.registry.skill.MythosSkills;
import net.neoforged.bus.api.IEventBus;

public class MythosRegistery {
    public MythosRegistery () {
    }

    public static void register(IEventBus modEventBus) {
        MythosSkills.init(modEventBus);
        MythosMobEffects.register(modEventBus);
        //MythosClient.clientSetup((FMLClientSetupEvent) modEventBus);
        //modEventBus.addListener(MythosClient::clientSetup);
    }

}