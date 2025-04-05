package com.infamous.dungeons_gear.registry;

import com.infamous.dungeons_gear.DungeonsGear;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber(modid = DungeonsGear.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabInit {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DungeonsGear.MODID);

    public static final RegistryObject<CreativeModeTab> ARMOR_TAB = TABS.register("armor",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.armor"))
            .icon(() -> new ItemStack(ItemInit.FULL_METAL_ARMOR.getChest().get()))
            .displayItems((parameters, output) -> {
                output.accept(ItemInit.FULL_METAL_ARMOR.getChest().get());
            })
            .build()
    );

    public static final RegistryObject<CreativeModeTab> ARTIFACT_TAB = TABS.register("artifacts",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.artifact"))
            .icon(() -> new ItemStack(ItemInit.TOTEM_OF_REGENERATION.get()))
            .displayItems((parameters, output) -> {
                output.accept(ItemInit.TOTEM_OF_REGENERATION.get());
            })
            .build()
    );

    public static final RegistryObject<CreativeModeTab> MELEE_WEAPONS_TAB = TABS.register("melee_weapons",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.melee_weapons"))
            .icon(() -> new ItemStack(ItemInit.BROADSWORD.get()))
            .displayItems((parameters, output) -> {
                output.accept(ItemInit.BROADSWORD.get());
            })
            .build()
    );

    public static final RegistryObject<CreativeModeTab> RANGED_WEAPONS_TAB = TABS.register("ranged_weapons",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.ranged_weapons"))
            .icon(() -> new ItemStack(ItemInit.AUTO_CROSSBOW.get()))
            .displayItems((parameters, output) -> {
                output.accept(ItemInit.AUTO_CROSSBOW.get());
            })
            .build()
    );
}
