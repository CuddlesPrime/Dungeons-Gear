package com.infamous.dungeons_gear.entities;

import com.google.common.collect.Lists;
import com.infamous.dungeons_libraries.entities.TotemBaseEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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

import java.util.Arrays;
import java.util.List;

public class FireworksDisplayEntity extends TotemBaseEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public FireworksDisplayEntity(EntityType<?> p_i48580_1_, Level p_i48580_2_) {
        super(p_i48580_1_, p_i48580_2_, 240, 2);
    }

    @Override
    protected void applyTotemEffect() {
        LivingEntity owner = getOwner();
        if (owner == null) return;
        if (this.lifeTicks % 20 == 0) {
            for (int i = 0; i < 3; i++) {
                double x = this.getX() + (random.nextFloat() - 0.5) * 8;
                double z = this.getZ() + (random.nextFloat() - 0.5) * 8;
                FireworkRocketEntity firework = new FireworkRocketEntity(level(), x, this.getY(), z, generateRandomFireworksRocket());
                level().addFreshEntity(firework);
            }
        }
    }

    private ItemStack generateRandomFireworksRocket() {
        ItemStack fireworksRocket = new ItemStack(Items.FIREWORK_ROCKET);
        CompoundTag fireworkNbt = fireworksRocket.getOrCreateTagElement("Fireworks");

        ListTag listnbt = new ListTag();
        for (int i = 0; i < random.nextInt(3); i++) {
            CompoundTag starNbt = generateRandomStarNbt();
            listnbt.add(starNbt);
            if (!listnbt.isEmpty()) {
                fireworkNbt.put("Explosions", listnbt);
            }
        }
        fireworkNbt.putByte("Flight", (byte) (random.nextInt(3) + 1));
        return fireworksRocket;
    }

    private CompoundTag generateRandomStarNbt() {
        ItemStack fireworksStar = new ItemStack(Items.FIREWORK_STAR);
        CompoundTag starNbt = fireworksStar.getOrCreateTagElement("Explosion");
        starNbt.putByte("Type", (byte) random.nextInt(5));
        starNbt.putBoolean("Flicker", random.nextBoolean());
        starNbt.putBoolean("Trail", random.nextBoolean());
        List<Integer> list = Lists.newArrayList();
        DyeColor[] values = Arrays.stream(DyeColor.values()).filter(color -> color != DyeColor.BLACK && color != DyeColor.GRAY).toArray(DyeColor[]::new);
        for (int i = 0; i < random.nextInt(4); i++) {
            DyeColor dyeColor = values[random.nextInt(values.length)];
            list.add(dyeColor.getFireworkColor());
        }
        starNbt.putIntArray("Colors", list);
        list = Lists.newArrayList();
        for (int i = 0; i < random.nextInt(3); i++) {
            DyeColor dyeColor = values[random.nextInt(values.length)];
            list.add(dyeColor.getFireworkColor());
        }
        starNbt.putIntArray("FadeColors", list);

        return starNbt;
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
        event.getController().setAnimation(RawAnimation.begin().then("animation.firework_box.idle", Animation.LoopType.LOOP));

        return PlayState.CONTINUE;
    }
}
