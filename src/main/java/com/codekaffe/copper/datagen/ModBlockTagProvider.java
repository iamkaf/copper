package com.codekaffe.copper.datagen;

import com.codekaffe.copper.block.ModBlocks;
import com.codekaffe.copper.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.DEBUG_STICK_DETECTABLE_BLOCKS)
                .add(ModBlocks.KAFERIUM_ORE)
                .add(ModBlocks.DEEPSLATE_KAFERIUM_ORE)
                .forceAddTag(BlockTags.DIAMOND_ORES);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.KAFERIUM_BLOCK)
                .add(ModBlocks.SOUND_BLOCK)
                .add(ModBlocks.KAFUEL_BLOCK)
                .add(ModBlocks.REINFORCED_COPPER_BLOCK)
                .add(ModBlocks.KAFERIUM_ORE)
                .add(ModBlocks.DEEPSLATE_KAFERIUM_ORE)
                .add(ModBlocks.REINFORCED_COPPER_STAIRS)
                .add(ModBlocks.REINFORCED_COPPER_SLAB)
                .add(ModBlocks.REINFORCED_COPPER_BUTTON)
                .add(ModBlocks.REINFORCED_COPPER_PRESSURE_PLATE)
                .add(ModBlocks.REINFORCED_COPPER_FENCE)
                .add(ModBlocks.REINFORCED_COPPER_FENCE_GATE)
                .add(ModBlocks.REINFORCED_COPPER_WALL)
                .add(ModBlocks.REINFORCED_COPPER_DOOR)
                .add(ModBlocks.REINFORCED_COPPER_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.REINFORCED_COPPER_BLOCK)
                .add(ModBlocks.REINFORCED_COPPER_STAIRS)
                .add(ModBlocks.REINFORCED_COPPER_SLAB)
                .add(ModBlocks.REINFORCED_COPPER_BUTTON)
                .add(ModBlocks.REINFORCED_COPPER_PRESSURE_PLATE)
                .add(ModBlocks.REINFORCED_COPPER_FENCE)
                .add(ModBlocks.REINFORCED_COPPER_FENCE_GATE)
                .add(ModBlocks.REINFORCED_COPPER_WALL)
                .add(ModBlocks.REINFORCED_COPPER_DOOR)
                .add(ModBlocks.REINFORCED_COPPER_TRAPDOOR)
                .add(ModBlocks.KAFERIUM_BLOCK)
                .add(ModBlocks.KAFUEL_BLOCK)
                .add(ModBlocks.KAFERIUM_ORE)
                .add(ModBlocks.DEEPSLATE_KAFERIUM_ORE);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4"))).add(ModBlocks.SOUND_BLOCK);

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.REINFORCED_COPPER_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.REINFORCED_COPPER_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.REINFORCED_COPPER_WALL);

    }
}
