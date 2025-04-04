package com.infamous.dungeons_gear.client.models.totem;

import com.infamous.dungeons_gear.entities.TotemOfRegenerationEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import static com.infamous.dungeons_gear.DungeonsGear.MODID;

public class TotemOfRegenerationModel extends AnimatedGeoModel<TotemOfRegenerationEntity> {

    @Override
    public ResourceLocation getAnimationResource(TotemOfRegenerationEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(MODID, "animations/totem_of_regeneration.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(TotemOfRegenerationEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(MODID, "geo/totem_of_regeneration.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TotemOfRegenerationEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/totem_of_regeneration.png");
    }
}

