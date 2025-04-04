package com.infamous.dungeons_gear.client.models.summonables;

import com.infamous.dungeons_gear.DungeonsGear;
import com.infamous.dungeons_gear.entities.IceCloudEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class IceCloudModel extends DefaultedEntityGeoModel<IceCloudEntity> {
    public IceCloudModel()
    {
        super(ResourceLocation.fromNamespaceAndPath(DungeonsGear.MODID, "ice_chunk"));
    }
}