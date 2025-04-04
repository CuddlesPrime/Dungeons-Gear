package com.infamous.dungeons_gear.client.models.totem;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import static com.infamous.dungeons_gear.DungeonsGear.MODID;

public class TotemOfShieldingModel extends AnimatedGeoModel {

    @Override
    public ResourceLocation getAnimationResource(Object entity) {
        return ResourceLocation.fromNamespaceAndPath(MODID, "animations/totem_of_shielding.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(Object entity) {
        return ResourceLocation.fromNamespaceAndPath(MODID, "geo/totem_of_shielding.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Object entity) {
        return ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/totem_of_shielding.png");
    }
}

