package com.github.hallowOVA.mythos.registry;

import com.github.hallowOVA.mythos.ability.confluence.skill.ConfluenceUniques;
import com.github.hallowOVA.mythos.handler.CatharsisHandler;
import com.github.hallowOVA.mythos.networking.MythosNetwork;
import com.github.hallowOVA.mythos.registry.menu.MythosMenuTypes;
import com.github.hallowOVA.mythos.registry.skill.Battlewills;
import com.github.hallowOVA.mythos.registry.skill.FusedSkills;
import com.github.hallowOVA.mythos.registry.skill.Magics;
import com.github.hallowOVA.mythos.registry.skill.Skills;
import com.github.hallowOVA.mythos.voiceoftheworld.TrialManager;
import net.neoforged.bus.api.IEventBus;

public class MythosRegistery {
    public MythosRegistery () {
    }

    public static void register(IEventBus modEventBus) {
        Skills.init(modEventBus);
        Magics.init(modEventBus);
        Battlewills.init(modEventBus);
        ConfluenceUniques.init(modEventBus);
        FusedSkills.init(modEventBus);
        MythosMobEffects.register(modEventBus);
        MythosEntityTypes.register(modEventBus);
        MythosDimensions.register(modEventBus);
        MythosMenuTypes.register(modEventBus);
        MythosItems.register(modEventBus);
        CatharsisHandler.register();
        MythosNetwork.register();
        MythosBlocks.register(modEventBus);
        //MythosClient.clientSetup((FMLClientSetupEvent) modEventBus);
        //modEventBus.addListener(MythosClient::clientSetup);

        // trials and voice of the world
        TrialManager.init();

    }

}