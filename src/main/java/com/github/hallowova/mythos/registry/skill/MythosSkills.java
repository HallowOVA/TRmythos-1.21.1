package com.github.hallowova.mythos.registry.skill;


import com.github.hallowova.mythos.ability.mythos.skill.unique.CrimsonSkill;
import com.github.hallowova.mythos.ability.mythos.skill.unique.NimueSkill;
import com.github.hallowova.mythos.ability.mythos.skill.unique.FakerSkill;
import com.github.hallowova.mythos.ability.mythos.skill.unique.TricksterSkill;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.manasmods.manascore.skill.api.ManasSkill;
import io.github.manasmods.manascore.skill.api.SkillAPI;
import io.github.manasmods.manascore.skill.impl.SkillRegistry;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MythosSkills {
    private static final DeferredRegister<ManasSkill> registry = DeferredRegister.create(SkillAPI.getSkillRegistryKey(), "trmythos");

    public MythosSkills() {
    }

    private static <E extends ManasSkill> RegistrySupplier<E> register(String name, Supplier<E> supplier) {
        return SkillRegistry.SKILLS.register(ResourceLocation.fromNamespaceAndPath("mythos", name), supplier);
    }


    public static void init(IEventBus modEventBus) {
        registry.register(modEventBus);
    }

    public static final RegistrySupplier<ManasSkill> NIMUE = register("nimue", NimueSkill::new);
    public static final RegistrySupplier<ManasSkill> CRIMSON = register("crimson", CrimsonSkill::new);
    public static final RegistrySupplier<ManasSkill> FAKER = register("faker", FakerSkill::new);
    public static final RegistrySupplier<ManasSkill> TRICKSTER = register("trickster", TricksterSkill::new);
}
