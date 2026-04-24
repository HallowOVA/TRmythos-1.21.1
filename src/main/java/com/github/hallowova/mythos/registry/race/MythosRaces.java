package com.github.hallowova.mythos.registry.race;

import com.github.hallowova.mythos.race.void_hatchling.VoidHatchlingRace;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.manasmods.manascore.race.api.ManasRace;
import io.github.manasmods.manascore.race.impl.RaceRegistry;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public class MythosRaces {

    private static <E extends ManasRace> RegistrySupplier<E> register(String name, Supplier<E> supplier) {
        return RaceRegistry.RACES.register(ResourceLocation.fromNamespaceAndPath("mythos", name), supplier);
    }

    public static RegistrySupplier<ManasRace> VOID_HATCHLING = register("void_hatchling", VoidHatchlingRace::new);

    public static void init() {
    }
}
