package com.github.hallowOVA.mythos.renderers;

import com.github.hallowOVA.mythos.entity.projectile.DragonFireBreathProjectile;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class DragonfireRenderer extends EntityRenderer<DragonFireBreathProjectile> {
    public DragonfireRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(DragonFireBreathProjectile dragonFireBreathProjectile) {
        return null;
    }

//    @Override
//    public ResourceLocation getTextureLocation(DragonFireBreathProjectile entity) {
//        return new ResourceLocation("trmythos", "textures/entity/dragonfire.png");
//    }
}
