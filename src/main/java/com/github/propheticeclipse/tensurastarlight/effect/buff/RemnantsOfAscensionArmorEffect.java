package com.github.propheticeclipse.tensurastarlight.effect.buff;

import com.github.propheticeclipse.tensurastarlight.config.effects.BuffEffectsConfig;
import io.github.manasmods.manascore.config.ConfigRegistry;
import io.github.manasmods.tensura.effect.template.TensuraMobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.awt.*;

public class RemnantsOfAscensionArmorEffect extends TensuraMobEffect {
    public static final ResourceLocation REMNANT_ASCENSION_ARMOR;
    private static final BuffEffectsConfig.FlaringForm CONFIG;

    public RemnantsOfAscensionArmorEffect() {
        super(MobEffectCategory.BENEFICIAL, (new Color(255, 255, 255)).getRGB());
        this.addAttributeModifier(Attributes.ARMOR, REMNANT_ASCENSION_ARMOR, CONFIG.armorMod, AttributeModifier.Operation.ADD_VALUE);
        this.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, REMNANT_ASCENSION_ARMOR, CONFIG.armorToughMod, AttributeModifier.Operation.ADD_VALUE);
    }

    static {
        REMNANT_ASCENSION_ARMOR = ResourceLocation.fromNamespaceAndPath("trstarlight", "remnant_ascension_armor");
        CONFIG = ConfigRegistry.getConfig(BuffEffectsConfig.class).RemnantBuffConf;
    }
}
