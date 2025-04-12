package com.infamous.dungeons_gear.items;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static net.minecraftforge.versions.forge.ForgeVersion.MOD_ID;

public class ItemTagWrappers {
    public static final TagKey<Item> FOOD = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "food"));
    public static final TagKey<Item> FOOD_PROCESSED = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "food/processed"));
    public static final TagKey<Item> FOOD_RAW = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "food/raw"));
    public static final TagKey<Item> WEAPONS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "weapons"));
    public static final TagKey<Item> ARMOR = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MOD_ID, "armor"));
}
