package com.github.hallowova.mythos.registry.skill;


import com.github.hallowova.mythos.ability.mythos.skill.unique.NimueSkill;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.manascore.skill.api.SkillAPI;
import io.github.manasmods.manascore.skill.impl.SkillRegistry;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MythosSkills {
    private static final DeferredRegister<ManasSkill> registery = DeferredRegister.create(SkillAPI.getSkillRegistryKey(), "trmythos");

    public MythosSkills() {
    }

    private static <E extends ManasSkill> RegistrySupplier<E> register(String name, Supplier<E> supplier) {
        return SkillRegistry.SKILLS.register(ResourceLocation.fromNamespaceAndPath("mythos", name), supplier);
    }


    public static void init(IEventBus modEventBus) {
        registery.register(modEventBus);
    }

    public static final RegistrySupplier<ManasSkill> NIMUE = register("nimue", NimueSkill::new);
}
