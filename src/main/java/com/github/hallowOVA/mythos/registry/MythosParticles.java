package com.github.hallowOVA.mythos.registry;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class MythosParticles {
    private static final DeferredRegister<ParticleType<?>> registry;
//    public static final RegistryObject<SimpleParticleType> DRAGONFIRE;
    public static final RegistryObject<SimpleParticleType> RED_RUNES;
    public MythosParticles() {
    }

    public static void init(IEventBus modEventBus) {
        registry.register(modEventBus);
    }


    static {
        registry = DeferredRegister.create(NeoForgeRegistries.PARTICLE_TYPES, "trmythos");
//        DRAGONFIRE = registry.register("dragonfire", () -> {
//            return new SimpleParticleType(false);
//        });
        RED_RUNES = registry.register("red_runes", () -> {
            return new SimpleParticleType(false);
        });
    }

}
