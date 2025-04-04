package com.infamous.dungeons_gear.client.models.ghosts;

import com.infamous.dungeons_gear.DungeonsGear;
import com.infamous.dungeons_gear.entities.SoulWizardEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class SoulWizardModel extends DefaultedEntityGeoModel<SoulWizardEntity> {

    public SoulWizardModel()
    {
        super(ResourceLocation.fromNamespaceAndPath(DungeonsGear.MODID, "soul_wizard"));
    }
}
