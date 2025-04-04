package com.infamous.dungeons_gear.entities;

import com.infamous.dungeons_libraries.entities.TotemBaseEntity;
import com.infamous.dungeons_libraries.summon.SummonHelper;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
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

public class BuzzyNestEntity extends TotemBaseEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public BuzzyNestEntity(EntityType<?> p_i48580_1_, Level p_i48580_2_) {
        super(p_i48580_1_, p_i48580_2_, 200, 20);
    }

    @Override
    protected void applyTotemEffect() {
        if (!this.level().isClientSide() && this.lifeTicks % 20 == 0 && this.getOwner() != null) {
            SummonHelper.summonEntity(this.getOwner(), this.blockPosition(), EntityType.BEE);
            this.level().playSound(null, this.blockPosition(), SoundEvents.BEEHIVE_EXIT, SoundSource.BLOCKS, 1.0F, 1.0F);
        }
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 5, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    private <P extends GeoAnimatable> PlayState predicate(AnimationState<P> event) {
        AnimationController<?> controller = event.getController(); // Get the animation controller

        if (this.lifeTicks > 0 && this.lifeTicks % 20 == 0) {
            controller.setAnimation(RawAnimation.begin().then("animation.buzzy_nest.spawn", Animation.LoopType.PLAY_ONCE));
        } else if (this.lifeTicks > 0) {
            controller.setAnimation(RawAnimation.begin().then("animation.buzzy_nest.activate", Animation.LoopType.PLAY_ONCE));
        } else {
            controller.setAnimation(RawAnimation.begin().then("animation.buzzy_nest.deactivate", Animation.LoopType.LOOP));
        }

        return PlayState.CONTINUE;
    }
}
