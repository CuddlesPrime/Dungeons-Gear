package com.infamous.dungeons_gear.client.models.totem;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

import com.infamous.dungeons_gear.DungeonsGear;
import com.infamous.dungeons_gear.entities.FireworksDisplayEntity;

public class FireworksDisplayModel extends DefaultedEntityGeoModel<FireworksDisplayEntity> {
    public FireworksDisplayModel()
    {
        super(ResourceLocation.fromNamespaceAndPath(DungeonsGear.MODID, "fireworks_box"));
    }
}

