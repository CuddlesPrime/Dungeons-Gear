package com.infamous.dungeons_gear.datagen;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Nonnull;

import com.infamous.dungeons_gear.DungeonsGear;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DungeonsGear.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(@Nonnull Provider p_256380_) {
    }
}
