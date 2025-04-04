package com.infamous.dungeons_gear.client.renderer.totem;

import javax.annotation.Nullable;

import com.infamous.dungeons_gear.client.models.totem.TotemOfShieldingModel;
import com.infamous.dungeons_gear.entities.TotemOfShieldingEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TotemOfShieldingRenderer extends GeoEntityRenderer<TotemOfShieldingEntity> {
    public TotemOfShieldingRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TotemOfShieldingModel());
    }

    @Override
    public RenderType getRenderType(TotemOfShieldingEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }

    @Override
    public ResourceLocation getTextureLocation(@Nullable TotemOfShieldingEntity p_114482_) {
        return this.model.getTextureResource(p_114482_, this);
    }
}
