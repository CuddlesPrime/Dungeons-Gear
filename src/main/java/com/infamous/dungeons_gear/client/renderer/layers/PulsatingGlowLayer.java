package com.infamous.dungeons_gear.client.renderer.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

@OnlyIn(Dist.CLIENT)
public class PulsatingGlowLayer<T extends LivingEntity & GeoEntity> extends GeoRenderLayer<T> {

    private final ResourceLocation textureLocation;
    private final float pulseSpeed;
    private final float pulseAmount;
    private final float minimumPulseAmount;

    public PulsatingGlowLayer(GeoRenderer<T> renderer, ResourceLocation textureLocation, float pulseSpeed, float pulseAmount, float minimumPulseAmount) {
        super(renderer);
        this.textureLocation = textureLocation;
        this.pulseSpeed = pulseSpeed;
        this.pulseAmount = pulseAmount;
        this.minimumPulseAmount = minimumPulseAmount;
    }

    @Override
    protected ResourceLocation getTextureResource(T animatable) {
		return textureLocation;
	}

    @Override
    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, RenderType renderType,
						MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick,
						int packedLight, int packedOverlay) {
        float ageInTicks = animatable.tickCount + partialTick;
        float glow = Math.max(minimumPulseAmount, Mth.cos(ageInTicks * pulseSpeed) * pulseAmount);
        VertexConsumer vertexConsumer = bufferSource.getBuffer(renderType);

        this.getRenderer().reRender(
            bakedModel,
            poseStack,
            bufferSource,
            animatable,
            renderType,
            vertexConsumer,
            partialTick,
            packedLight,
            packedOverlay,
            1.0F, glow, glow, glow
        );
    }
}
