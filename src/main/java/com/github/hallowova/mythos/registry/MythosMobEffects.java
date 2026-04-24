package com.github.hallowova.mythos.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import io.github.manasmods.tensura.effect.template.TensuraMobEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

import java.awt.*;

public class MythosMobEffects {

    private static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create("trmythos", Registries.MOB_EFFECT);

    public static final RegistrySupplier<MobEffect> AVALON_REGENERATION = MOB_EFFECTS.register("avalon_regeneration", () -> new TensuraMobEffect(MobEffectCategory.BENEFICIAL, new Color(20, 138, 211).getRGB()));

    public static void init() {
        MOB_EFFECTS.register();
    }
}