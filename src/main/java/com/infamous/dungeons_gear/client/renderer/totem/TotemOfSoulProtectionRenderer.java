package com.infamous.dungeons_gear.client.renderer.totem;

import javax.annotation.Nullable;

import com.infamous.dungeons_gear.client.models.totem.TotemOfSoulProtectionModel;
import com.infamous.dungeons_gear.entities.TotemOfSoulProtectionEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TotemOfSoulProtectionRenderer extends GeoEntityRenderer<TotemOfSoulProtectionEntity> {
    public TotemOfSoulProtectionRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TotemOfSoulProtectionModel());
    }

    @Override
    public RenderType getRenderType(TotemOfSoulProtectionEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }

    @Override
    public ResourceLocation getTextureLocation(@Nullable TotemOfSoulProtectionEntity p_114482_) {
        return this.model.getTextureResource(p_114482_, this);
    }
}
