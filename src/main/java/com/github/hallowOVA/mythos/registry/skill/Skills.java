package com.github.hallowOVA.mythos.registry.skill;


import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.manascore.skill.api.SkillAPI;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Skills {
    private static final DeferredRegister<ManasSkill> registery = DeferredRegister.create(SkillAPI.getSkillRegistryKey(), "trmythos");

    public Skills() {
    }

    public static void init(IEventBus modEventBus) {
        registery.register(modEventBus);
    }


    static {

    }
}
