package com.infamous.dungeons_gear.client.models.totem;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

import com.infamous.dungeons_gear.DungeonsGear;
import com.infamous.dungeons_gear.entities.BuzzyNestEntity;

public class BuzzyNestModel extends DefaultedEntityGeoModel<BuzzyNestEntity> {
    public BuzzyNestModel()
    {
        super(ResourceLocation.fromNamespaceAndPath(DungeonsGear.MODID, "buzzy_nest"));
    }
}

