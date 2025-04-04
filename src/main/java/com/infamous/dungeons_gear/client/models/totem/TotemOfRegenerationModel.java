package com.infamous.dungeons_gear.client.models.totem;

import com.infamous.dungeons_gear.entities.TotemOfRegenerationEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

import com.infamous.dungeons_gear.DungeonsGear;

public class TotemOfRegenerationModel extends DefaultedEntityGeoModel<TotemOfRegenerationEntity> {
    public TotemOfRegenerationModel()
    {
        super(ResourceLocation.fromNamespaceAndPath(DungeonsGear.MODID, "totem_of_regeneration"));
    }
}

