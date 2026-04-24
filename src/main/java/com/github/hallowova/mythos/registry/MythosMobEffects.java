package com.github.hallowova.mythos.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MythosMobEffects {

    public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, "trmythos");

    public static void register(IEventBus modEventBus) {
        REGISTRY.register(modEventBus);
    }
}