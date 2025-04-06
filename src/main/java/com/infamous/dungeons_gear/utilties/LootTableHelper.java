package com.infamous.dungeons_gear.utilties;

import com.infamous.dungeons_gear.mixin.LootContextAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

public class LootTableHelper {
    public static ItemStack generateItemStack(ServerLevel world, BlockPos pos, ResourceLocation lootTable, RandomSource random) {
        LootParams lootParams = new LootParams.Builder(world)
            .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos))
            .create(LootContextParamSets.CHEST);
        LootTable table = world.getServer().getLootData().getLootTable(lootTable);
        List<ItemStack> stacks = table.getRandomItems(lootParams);

        return !stacks.isEmpty()
                ? stacks.get(0)
                : ItemStack.EMPTY;
    }

    public static List<ItemStack> generateItemStacks(ServerLevel world, BlockPos pos, ResourceLocation lootTable, RandomSource random) {
        LootParams lootParams = new LootParams.Builder(world)
            .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos))
            .create(LootContextParamSets.CHEST);   // chest set requires positional context, has no other mandatory parameters
        LootTable table = world.getServer().getLootData().getLootTable(lootTable);

        return table.getRandomItems(lootParams);
    }

    public static List<ItemStack> generateItemStacks(ServerLevel world, LootContext originContext, ResourceLocation lootTable) {
        if (!isCompleteParameterSet(originContext)) return new ArrayList<>();
        LootContext newContext = copyLootContextWithNewQueryID(originContext, lootTable);
        LootTable table = world.getServer().getLootData().getLootTable(lootTable);

        return table.getRandomItems(newContext.params);
    }

    private static boolean isCompleteParameterSet(LootContext originContext) {
        return originContext.params.hasParam(LootContextParams.ORIGIN);
    }

    public static boolean lootTableExists(ServerLevel world, ResourceLocation lootTable) {
        return !world.getServer()
            .getLootData()
            .getLootTable(lootTable)
            .equals(LootTable.EMPTY);
    }

    protected static LootContext copyLootContextWithNewQueryID(LootContext oldLootContext, ResourceLocation newQueryID) {
        LootContext newContext = new LootContext.Builder(oldLootContext).create(null);
        ((LootContextAccessor) newContext).dungeonsgear_setQueriedLootTableId(newQueryID);
        return newContext;
    }
}
