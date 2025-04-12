package com.infamous.dungeons_gear.registry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.infamous.dungeons_gear.DungeonsGear;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

@Mod.EventBusSubscriber(modid = DungeonsGear.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabInit {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DungeonsGear.MODID);
    public static final List<Supplier<? extends ItemLike>> ARMOR_TAB_ITEMS = new ArrayList<>();
    public static final List<Supplier<? extends ItemLike>> MELEE_WEAPONS_TAB_ITEMS = new ArrayList<>();
    public static final List<Supplier<? extends ItemLike>> RANGED_WEAPONS_TAB_ITEMS = new ArrayList<>();

    public static final RegistryObject<CreativeModeTab> ARMOR_TAB = TABS.register("armor",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.armor"))
            .icon(() -> new ItemStack(ItemInit.FULL_METAL_ARMOR.getChest().get()))
            .displayItems((parameters, output) ->
                ARMOR_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get())))
            .build()
    );

    public static final RegistryObject<CreativeModeTab> MELEE_WEAPONS_TAB = TABS.register("melee_weapons",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.melee_weapons"))
            .icon(() -> new ItemStack(ItemInit.BROADSWORD.get()))
            .displayItems((parameters, output) ->
                MELEE_WEAPONS_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get())))
            .build()
    );

    public static final RegistryObject<CreativeModeTab> RANGED_WEAPONS_TAB = TABS.register("ranged_weapons",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.ranged_weapons"))
            .icon(() -> new ItemStack(ItemInit.AUTO_CROSSBOW.get()))
            .displayItems((parameters, output) ->
                RANGED_WEAPONS_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get())))
            .build()
    );
}
