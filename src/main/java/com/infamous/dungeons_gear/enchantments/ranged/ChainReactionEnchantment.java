package com.infamous.dungeons_gear.enchantments.ranged;

import com.infamous.dungeons_gear.enchantments.ModEnchantmentTypes;
import com.infamous.dungeons_gear.enchantments.types.DungeonsEnchantment;
import com.infamous.dungeons_gear.registry.EnchantmentInit;
import com.infamous.dungeons_gear.utilties.ProjectileEffectHelper;
import com.infamous.dungeons_libraries.utils.ArrowHelper;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.infamous.dungeons_gear.DungeonsGear.MODID;

@Mod.EventBusSubscriber(modid = MODID)
public class ChainReactionEnchantment extends DungeonsEnchantment {

    public static final String INTRINSIC_CHAIN_REACTION_TAG = "IntrinsicChainReaction";

    public ChainReactionEnchantment() {
        super(Rarity.RARE, ModEnchantmentTypes.RANGED, new EquipmentSlot[]{
                EquipmentSlot.MAINHAND});
    }

    @SubscribeEvent
    public static void onChainReactionDamage(LivingDamageEvent event) {
        DamageSource source = event.getSource();
        Entity trueSource = source.getEntity();
        Entity directSource = source.getDirectEntity();

        // Always guard against nulls
        if (trueSource == null || directSource == null) return;
        if (trueSource.equals(directSource)) return;

        if (!(directSource instanceof AbstractArrow arrowEntity)) return;
        if (!(trueSource instanceof LivingEntity attacker)) return;

        LivingEntity victim = event.getEntity();
        int chainReactionLevel = ArrowHelper.enchantmentTagToLevel(arrowEntity, EnchantmentInit.CHAIN_REACTION.get());

        if (chainReactionLevel > 0) {
            float chance = chainReactionLevel * 0.1f;
            if (attacker.getRandom().nextFloat() <= chance) {
                ProjectileEffectHelper.fireChainReactionProjectiles(victim.getCommandSenderWorld(), attacker, victim, 3.15F, 1.0F, arrowEntity);
            }
        }

        if (arrowEntity.getTags().contains(INTRINSIC_CHAIN_REACTION_TAG)) {
            if (attacker.getRandom().nextFloat() <= 0.1F) {
                ProjectileEffectHelper.fireChainReactionProjectiles(victim.getCommandSenderWorld(), attacker, victim, 3.15F, 1.0F, arrowEntity);
            }
        }
    }

    public int getMaxLevel() {
        return 3;
    }
}
