package com.github.hallowOVA.mythos.registry;

import com.github.hallowOVA.mythos.engravings.VainOfTheWorld;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class MythosEngravings {
    private static final DeferredRegister<Enchantment> registry;
    public static final RegistryObject<Enchantment> VAIN;


    public MythosEngravings() {
    }

    public static void init(IEventBus modEventBus) {
        registry.register(modEventBus);
    }

    static {
        registry = DeferredRegister.create(NeoForgeRegistries.ENCHANTMENTS, "trmythos");
        VAIN = registry.register("vain_of_the_world", VainOfTheWorld::new);
    }
}
