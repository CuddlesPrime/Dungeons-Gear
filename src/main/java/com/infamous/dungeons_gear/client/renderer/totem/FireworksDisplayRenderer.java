package com.infamous.dungeons_gear.client.renderer.totem;

import javax.annotation.Nullable;

import com.infamous.dungeons_gear.client.models.totem.FireworksDisplayModel;
import com.infamous.dungeons_gear.entities.FireworksDisplayEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FireworksDisplayRenderer extends GeoEntityRenderer<FireworksDisplayEntity> {
    public FireworksDisplayRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FireworksDisplayModel());
    }

    @Override
    public RenderType getRenderType(FireworksDisplayEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }

    @Override
    public ResourceLocation getTextureLocation(@Nullable FireworksDisplayEntity p_114482_) {
        return this.model.getTextureResource(p_114482_, this);
    }
}
