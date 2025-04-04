package com.infamous.dungeons_gear.client.renderer.ghosts;

import javax.annotation.Nullable;

import com.infamous.dungeons_gear.DungeonsGear;
import com.infamous.dungeons_gear.client.models.ghosts.SoulWizardModel;
import com.infamous.dungeons_gear.client.renderer.layers.PulsatingGlowLayer;
import com.infamous.dungeons_gear.entities.SoulWizardEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SoulWizardRenderer extends GeoEntityRenderer<SoulWizardEntity> {
    public SoulWizardRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SoulWizardModel());
        this.addRenderLayer(new PulsatingGlowLayer<SoulWizardEntity>(this, ResourceLocation.fromNamespaceAndPath(DungeonsGear.MODID, "textures/entity/ghosts/soul_wizard_glow.png"), 0.2F, 1.0F, 0.25F));
    }

    @Override
    protected void applyRotations(SoulWizardEntity entityLiving, PoseStack matrixStackIn, float ageInTicks,
                                  float rotationYaw, float partialTicks) {
        float scaleFactor = 0.0F;
        if (entityLiving.appearAnimationTick < entityLiving.appearAnimationLength - 2) {
            scaleFactor = 1.0F;
        } else {
            scaleFactor = 0.0F;
        }
        matrixStackIn.scale(scaleFactor, scaleFactor, scaleFactor);
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
    }

    @Override
    public RenderType getRenderType(SoulWizardEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }

    @Override
    public ResourceLocation getTextureLocation(@Nullable SoulWizardEntity p_114482_) {
        return this.model.getTextureResource(p_114482_, this);
    }
}