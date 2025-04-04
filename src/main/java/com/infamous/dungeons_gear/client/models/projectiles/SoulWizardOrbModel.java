package com.infamous.dungeons_gear.client.models.projectiles;


import com.infamous.dungeons_gear.DungeonsGear;
import com.infamous.dungeons_gear.entities.SoulWizardOrbEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class SoulWizardOrbModel extends DefaultedEntityGeoModel<SoulWizardOrbEntity> {
    public SoulWizardOrbModel()
    {
        super(ResourceLocation.fromNamespaceAndPath(DungeonsGear.MODID, "soul_wizard_orb"));
    }

    @Override
    public ResourceLocation getTextureResource(SoulWizardOrbEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(DungeonsGear.MODID, "textures/entity/projectile/soul_wizard_orb_" + entity.textureChange % 2 + ".png");
    }
}