package com.infamous.dungeons_gear.client.renderer;

import javax.annotation.Nullable;

import com.infamous.dungeons_gear.client.models.summonables.IceCloudModel;
import com.infamous.dungeons_gear.entities.IceCloudEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

@OnlyIn(Dist.CLIENT)
public class IceCloudRenderer extends GeoEntityRenderer<IceCloudEntity> {
    public IceCloudRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new IceCloudModel());
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