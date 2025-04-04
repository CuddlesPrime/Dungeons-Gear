package com.infamous.dungeons_gear.client.models.totem;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

import com.infamous.dungeons_gear.DungeonsGear;
import com.infamous.dungeons_gear.entities.TotemOfShieldingEntity;

public class TotemOfShieldingModel extends DefaultedEntityGeoModel<TotemOfShieldingEntity> {
    public TotemOfShieldingModel()
    {
        super(ResourceLocation.fromNamespaceAndPath(DungeonsGear.MODID, "totem_of_shielding"));
    }
}

