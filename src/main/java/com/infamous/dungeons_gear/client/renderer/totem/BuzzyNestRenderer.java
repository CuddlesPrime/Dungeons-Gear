package com.infamous.dungeons_gear.client.renderer.totem;

import javax.annotation.Nullable;

import com.infamous.dungeons_gear.client.models.totem.BuzzyNestModel;
import com.infamous.dungeons_gear.entities.BuzzyNestEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class BuzzyNestRenderer extends GeoEntityRenderer<BuzzyNestEntity> {
    public BuzzyNestRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BuzzyNestModel());
    }

    @Override
    public RenderType getRenderType(BuzzyNestEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }

    @Override
    public ResourceLocation getTextureLocation(@Nullable BuzzyNestEntity p_114482_) {
        return this.model.getTextureResource(p_114482_, this);
    }
}
