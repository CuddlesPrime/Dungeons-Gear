package com.infamous.dungeons_gear.client.models.totem;

import com.infamous.dungeons_gear.DungeonsGear;
import com.infamous.dungeons_gear.entities.TotemOfSoulProtectionEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class TotemOfSoulProtectionModel extends DefaultedEntityGeoModel<TotemOfSoulProtectionEntity> {
    public TotemOfSoulProtectionModel()
    {
        super(ResourceLocation.fromNamespaceAndPath(DungeonsGear.MODID, "totem_of_soul_protection"));
    }
}

