package com.infamous.dungeons_gear.client.renderer.projectiles;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.infamous.dungeons_gear.client.models.projectiles.SoulWizardOrbModel;
import com.infamous.dungeons_gear.entities.SoulWizardOrbEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SoulWizardOrbRenderer extends GeoEntityRenderer<SoulWizardOrbEntity> {

    public SoulWizardOrbRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SoulWizardOrbModel());
    }

    @Override
    public void preRender(PoseStack poseStack, SoulWizardOrbEntity animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        float scaleFactor = 1.0F;

        if (animatable.lifeTime <= 3) {
            scaleFactor = 0.0F;
        } else {
            scaleFactor = 1.0F;
        }

        poseStack.scale(scaleFactor, scaleFactor, scaleFactor);
    }

    @Override
    protected int getBlockLightLevel(@Nullable SoulWizardOrbEntity p_225624_1_, @Nullable BlockPos p_225624_2_) {
        return 15;
    }


    @Override
    public void render(@Nonnull SoulWizardOrbEntity entityIn, float entityYaw, float partialTicks, @Nonnull PoseStack matrixStackIn, @Nonnull MultiBufferSource bufferIn, int packedLightIn) {
        float scaleFactor = 1.0F;
        matrixStackIn.scale(scaleFactor, scaleFactor, scaleFactor);

        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public RenderType getRenderType(SoulWizardOrbEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }

    @Override
    public ResourceLocation getTextureLocation(@Nullable SoulWizardOrbEntity p_114482_) {
        return this.model.getTextureResource(p_114482_, this);
    }
}
