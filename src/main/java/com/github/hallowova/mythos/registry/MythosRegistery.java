package com.github.hallowova.mythos.registry;

import com.github.hallowova.mythos.registry.race.MythosRaces;
import com.github.hallowova.mythos.registry.skill.MythosSkills;
import net.neoforged.bus.api.IEventBus;

public class MythosRegistery {
    public MythosRegistery () {
    }

    public static void register(IEventBus modEventBus) {
        MythosSkills.init(modEventBus);
        MythosMobEffects.register(modEventBus);
        MythosRaces.init();
        //MythosClient.clientSetup((FMLClientSetupEvent) modEventBus);
        //modEventBus.addListener(MythosClient::clientSetup);
    }

}