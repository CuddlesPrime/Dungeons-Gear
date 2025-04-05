package com.infamous.dungeons_gear.combat;

import com.infamous.dungeons_gear.DungeonsGear;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;

public class DamageSources {
    public static final ResourceLocation ELECTRIC_SHOCK = ResourceLocation.fromNamespaceAndPath(DungeonsGear.MODID, "electric_shock");
    public static final ResourceKey<DamageType> ELECTRIC_SHOCK_KEY = ResourceKey.create(Registries.DAMAGE_TYPE, ELECTRIC_SHOCK);

    public static DamageSource electricShock(Entity attacker) {
        return new DamageSource(attacker.level().registryAccess()
            .registryOrThrow(Registries.DAMAGE_TYPE)
            .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ELECTRIC_SHOCK)), attacker);
    }

    public static final ResourceLocation OFFHAND_ATTACK = ResourceLocation.fromNamespaceAndPath(DungeonsGear.MODID, "offhand_attack");
    public static final ResourceKey<DamageType> OFFHAND_ATTACK_KEY = ResourceKey.create(Registries.DAMAGE_TYPE, OFFHAND_ATTACK);

    public static DamageSource offhandAttack(Entity attacker) {
        return new DamageSource(attacker.level().registryAccess()
            .registryOrThrow(Registries.DAMAGE_TYPE)
            .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, OFFHAND_ATTACK)), attacker);
    }
}
