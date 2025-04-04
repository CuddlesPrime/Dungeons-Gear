package com.infamous.dungeons_gear.client;

import com.infamous.dungeons_gear.client.particles.ElectricShockParticle;
import com.infamous.dungeons_gear.client.particles.SnowflakeParticle;
import com.infamous.dungeons_gear.client.particles.SoulDustParticle;
import com.infamous.dungeons_gear.registry.ParticleInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.infamous.dungeons_gear.DungeonsGear.MODID;


@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ParticleEventHandler {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onParticleFactory(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ParticleInit.ELECTRIC_SHOCK.get(), ElectricShockParticle.Factory::new);
        event.registerSpriteSet(ParticleInit.SNOWFLAKE.get(), SnowflakeParticle.Factory::new);
        event.registerSpriteSet(ParticleInit.SOUL_DUST.get(), SoulDustParticle.Factory::new);
    }
}
