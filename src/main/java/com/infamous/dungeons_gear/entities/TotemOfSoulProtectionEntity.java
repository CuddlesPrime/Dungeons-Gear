package com.infamous.dungeons_gear.entities;

import com.infamous.dungeons_gear.registry.MobEffectInit;
import com.infamous.dungeons_libraries.entities.TotemBaseEntity;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import static com.infamous.dungeons_libraries.utils.AreaOfEffectHelper.applyToNearbyEntities;
import static com.infamous.dungeons_libraries.utils.AreaOfEffectHelper.getCanHealPredicate;

public class TotemOfSoulProtectionEntity extends TotemBaseEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public TotemOfSoulProtectionEntity(EntityType<?> p_i48580_1_, Level p_i48580_2_) {
        super(p_i48580_1_, p_i48580_2_, 240, 2);
    }

    @Override
    protected void applyTotemEffect() {
        LivingEntity owner = getOwner();
        if (owner == null) return;
        applyToNearbyEntities(getOwner(), 8,
                getCanHealPredicate(getOwner()), (LivingEntity nearbyEntity) -> {
                    MobEffectInstance MobEffectInstance = new MobEffectInstance(MobEffectInit.SOUL_PROTECTION.get(), 21);
                    nearbyEntity.addEffect(MobEffectInstance);
                }
        );
        MobEffectInstance resistance = new MobEffectInstance(MobEffectInit.SOUL_PROTECTION.get(), 21);
        owner.addEffect(resistance);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

   @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "idle", 5, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    private <P extends GeoAnimatable> PlayState predicate(AnimationState<P> event) {
        event.getController().setAnimation(RawAnimation.begin().then("animation.totem_of_soul_protection.idle", Animation.LoopType.LOOP));

        return PlayState.CONTINUE;
    }
}
