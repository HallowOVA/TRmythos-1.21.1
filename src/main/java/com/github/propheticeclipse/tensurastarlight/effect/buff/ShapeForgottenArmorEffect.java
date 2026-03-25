package com.github.propheticeclipse.tensurastarlight.effect.buff;

import com.github.propheticeclipse.tensurastarlight.config.effects.BuffEffectsConfig;
import io.github.manasmods.manascore.config.ConfigRegistry;
import io.github.manasmods.tensura.effect.template.TensuraMobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.awt.*;

public class ShapeForgottenArmorEffect extends TensuraMobEffect {
    public static final ResourceLocation SHAPE_FORGOTTEN_ARMOR;
    private static final BuffEffectsConfig.ShiftingArmor CONFIG;

    public ShapeForgottenArmorEffect() {
        super(MobEffectCategory.BENEFICIAL, (new Color(255, 255, 255)).getRGB());
        this.addAttributeModifier(Attributes.ARMOR, SHAPE_FORGOTTEN_ARMOR, CONFIG.armorMod, AttributeModifier.Operation.ADD_VALUE);
    }

    static {
        SHAPE_FORGOTTEN_ARMOR = ResourceLocation.fromNamespaceAndPath("trstarlight", "shape_forgotten_armor");
        CONFIG = ConfigRegistry.getConfig(BuffEffectsConfig.class).ShapeBuffConf;
    }
}
