package com.infamous.dungeons_gear.client.models.totem;

import com.infamous.dungeons_gear.entities.TotemOfSoulProtectionEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import static com.infamous.dungeons_gear.DungeonsGear.MODID;

public class TotemOfSoulProtectionModel extends AnimatedGeoModel<TotemOfSoulProtectionEntity> {

    @Override
    public ResourceLocation getAnimationResource(TotemOfSoulProtectionEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(MODID, "animations/totem_of_soul_protection.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(TotemOfSoulProtectionEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(MODID, "geo/totem_of_soul_protection.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TotemOfSoulProtectionEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/totem_of_soul_protection.png");
    }
}

