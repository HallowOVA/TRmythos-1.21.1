package com.github.propheticeclipse.tensurastarlight.registry;

import com.github.propheticeclipse.tensurastarlight.effect.buff.EmberAttackImprovementEffect;
import com.github.propheticeclipse.tensurastarlight.effect.buff.RemnantsOfAscensionArmorEffect;
import com.github.propheticeclipse.tensurastarlight.effect.buff.ShapeForgottenArmorEffect;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;

public class StarlightEffects {
    public static void init() {
        MOB_EFFECTS.register();
    }

    private static final DeferredRegister<MobEffect> MOB_EFFECTS;
    public static final RegistrySupplier<MobEffect> EMBER_ATTACK_IMPROVEMENT;
    public static final RegistrySupplier<MobEffect> SHAPE_FORGOTTEN_ARMOR;
    public static final RegistrySupplier<MobEffect> REMNANT_ASCENSION_ARMOR;

    static {
        MOB_EFFECTS = DeferredRegister.create("trstarlight", Registries.MOB_EFFECT);
        EMBER_ATTACK_IMPROVEMENT = MOB_EFFECTS.register("ember_attack_improvement", EmberAttackImprovementEffect::new);
        SHAPE_FORGOTTEN_ARMOR = MOB_EFFECTS.register("shape_forgotten_armor", ShapeForgottenArmorEffect::new);
        REMNANT_ASCENSION_ARMOR = MOB_EFFECTS.register("remnant_ascension_armor", RemnantsOfAscensionArmorEffect::new);
    }
}
