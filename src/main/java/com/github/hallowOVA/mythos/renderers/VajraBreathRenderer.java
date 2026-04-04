package com.github.hallowOVA.mythos.renderers;

import com.github.hallowOVA.mythos.entity.projectile.VajraBreathProjectile;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class VajraBreathRenderer extends EntityRenderer<VajraBreathProjectile> {

    public VajraBreathRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(VajraBreathProjectile vajraBreathProjectile) {
        return null;
    }
}
