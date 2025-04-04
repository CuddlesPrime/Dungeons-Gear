package com.infamous.dungeons_gear.client.renderer.totem;

import javax.annotation.Nullable;

import com.infamous.dungeons_gear.client.models.totem.TotemOfRegenerationModel;
import com.infamous.dungeons_gear.entities.TotemOfRegenerationEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TotemOfRegenerationRenderer extends GeoEntityRenderer<TotemOfRegenerationEntity> {
    public TotemOfRegenerationRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TotemOfRegenerationModel());
    }

    @Override
    public RenderType getRenderType(TotemOfRegenerationEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }

    @Override
    public ResourceLocation getTextureLocation(@Nullable TotemOfRegenerationEntity p_114482_) {
        return this.model.getTextureResource(p_114482_, this);
    }
}
