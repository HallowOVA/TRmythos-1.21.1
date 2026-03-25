package com.github.propheticeclipse.tensurastarlight.effect.buff;

import com.github.propheticeclipse.tensurastarlight.config.effects.BuffEffectsConfig;
import io.github.manasmods.manascore.config.ConfigRegistry;
import io.github.manasmods.tensura.effect.template.TensuraMobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.awt.*;

public class EmberAttackImprovementEffect extends TensuraMobEffect {
    public static final ResourceLocation EMBER_ATTACK_IMPROVEMENT;
    private static final BuffEffectsConfig.CombatFlow CONFIG;

    public EmberAttackImprovementEffect() {
        super(MobEffectCategory.BENEFICIAL, (new Color(255, 255, 255)).getRGB());
        this.addAttributeModifier(Attributes.ATTACK_DAMAGE, EMBER_ATTACK_IMPROVEMENT, CONFIG.attackMod, AttributeModifier.Operation.ADD_VALUE);
    }

    static {
        EMBER_ATTACK_IMPROVEMENT = ResourceLocation.fromNamespaceAndPath("trstarlight", "ember_attack_improvement");
        CONFIG = ConfigRegistry.getConfig(BuffEffectsConfig.class).EmberBuffConf;
    }
}
