package com.infamous.dungeons_gear.client.renderer.summonables;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.infamous.dungeons_gear.client.models.summonables.IceCloudModel;
import com.infamous.dungeons_gear.entities.IceCloudEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LightLayer;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class IceCloudRenderer extends GeoEntityRenderer<IceCloudEntity> {
    public IceCloudRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new IceCloudModel());
    }

    @Override
    protected int getBlockLightLevel(@Nonnull IceCloudEntity p_114496_, @Nonnull BlockPos p_114497_) {
        return p_114496_.level().getBrightness(LightLayer.BLOCK, p_114497_) > 10
                ? p_114496_.level().getBrightness(LightLayer.BLOCK, p_114497_)
                : 5;
    }

    @Override
    public RenderType getRenderType(IceCloudEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }

    @Override
    public ResourceLocation getTextureLocation(@Nullable IceCloudEntity p_114482_) {
        return this.model.getTextureResource(p_114482_, this);
    }
}