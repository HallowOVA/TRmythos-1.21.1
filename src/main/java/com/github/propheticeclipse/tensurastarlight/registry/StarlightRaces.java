package com.github.propheticeclipse.tensurastarlight.registry;

import com.github.propheticeclipse.tensurastarlight.race.personal.aspectborn.aspectBornRace;
import com.github.propheticeclipse.tensurastarlight.race.personal.aspectborn.greaterAspectBornRace;
import com.github.propheticeclipse.tensurastarlight.race.personal.aspectborn.lesserAspectBornRace;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.manasmods.manascore.race.api.ManasRace;
import io.github.manasmods.manascore.race.impl.RaceRegistry;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public class StarlightRaces {
    public static final RegistrySupplier<ManasRace> LESSER_ASPECT_BORN = register("lesser_aspect_born", lesserAspectBornRace::new);
    public static final RegistrySupplier<ManasRace> ASPECT_BORN = register("aspect_born", aspectBornRace::new);
    public static final RegistrySupplier<ManasRace> GREATER_ASPECT_BORN = register("greater_aspect_born", greaterAspectBornRace::new);

    public static final RegistrySupplier<ManasRace> LESSER_CONVERGENCE_BORN = register("lesser_convergence_born", lesserAspectBornRace::new);
    public static final RegistrySupplier<ManasRace> CONVERGENCE_BORN = register("convergence_born", lesserAspectBornRace::new);
    public static final RegistrySupplier<ManasRace> GREATER_CONVERGENCE_BORN = register("greater_convergence_born", lesserAspectBornRace::new);
    public static final RegistrySupplier<ManasRace> ELDER_CONVERGENCE_BORN = register("elder_convergence_born", lesserAspectBornRace::new);

    public static final RegistrySupplier<ManasRace> LESSER_MEMORY_BORN = register("lesser_memory_born", lesserAspectBornRace::new);
    public static final RegistrySupplier<ManasRace> MEMORY_BORN = register("memory_born", lesserAspectBornRace::new);
    public static final RegistrySupplier<ManasRace> GREATER_MEMORY_BORN = register("greater_memory_born", lesserAspectBornRace::new);
    public static final RegistrySupplier<ManasRace> GRAND_MEMORY_BORN = register("grand_memory_born", lesserAspectBornRace::new);

    public static final RegistrySupplier<ManasRace> FALSE_ASPECT_OF_REGRESSION = register("false_aspect_of_regression", lesserAspectBornRace::new);
    public static final RegistrySupplier<ManasRace> ASPECT_OF_REGRESSION = register("aspect_of_regression", lesserAspectBornRace::new);
    public static final RegistrySupplier<ManasRace> MYTHOS = register("mythos", lesserAspectBornRace::new);

    private static <E extends ManasRace> RegistrySupplier<E> register(String name, Supplier<E> supplier) {
        return RaceRegistry.RACES.register(ResourceLocation.fromNamespaceAndPath("trstarlight", name), supplier);
    }

    public static void init() {
    }
}
