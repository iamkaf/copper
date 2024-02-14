package com.codekaffe.copper.datagen;

import com.codekaffe.copper.block.ModBlocks;
import com.codekaffe.copper.block.custom.CornCropBlock;
import com.codekaffe.copper.block.custom.TomatoCropBlock;
import com.codekaffe.copper.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.AnyOfLootCondition;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SOUND_BLOCK);

        addDrop(ModBlocks.KAFERIUM_BLOCK);
        addDrop(ModBlocks.KAFUEL_BLOCK);
        addDrop(ModBlocks.REINFORCED_COPPER_BLOCK);
        addDrop(ModBlocks.REINFORCED_COPPER_FENCE);
        addDrop(ModBlocks.REINFORCED_COPPER_FENCE_GATE);
        addDrop(ModBlocks.REINFORCED_COPPER_BUTTON);
        addDrop(ModBlocks.REINFORCED_COPPER_STAIRS);
        addDrop(ModBlocks.REINFORCED_COPPER_TRAPDOOR);
        addDrop(ModBlocks.REINFORCED_COPPER_WALL);
        addDrop(ModBlocks.REINFORCED_COPPER_PRESSURE_PLATE);

        addDrop(ModBlocks.REINFORCED_COPPER_DOOR, doorDrops(ModBlocks.REINFORCED_COPPER_DOOR));
        addDrop(ModBlocks.REINFORCED_COPPER_SLAB, slabDrops(ModBlocks.REINFORCED_COPPER_SLAB));

        addDrop(
                ModBlocks.KAFERIUM_ORE,
                lapisLikeOreDrops(ModBlocks.KAFERIUM_ORE, ModItems.KAFERIUM)
        );
        addDrop(
                ModBlocks.DEEPSLATE_KAFERIUM_ORE,
                lapisLikeOreDrops(ModBlocks.DEEPSLATE_KAFERIUM_ORE, ModItems.KAFERIUM)
        );

        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition
                .builder(ModBlocks.TOMATO_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(TomatoCropBlock.AGE, 5));
        addDrop(
                ModBlocks.TOMATO_CROP,
                cropDrops(ModBlocks.TOMATO_CROP, ModItems.TOMATO, ModItems.TOMATO_SEEDS, builder)
        );

        AnyOfLootCondition.Builder builder2 = BlockStatePropertyLootCondition
                .builder(ModBlocks.CORN_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(CornCropBlock.AGE, 7))
                .or(BlockStatePropertyLootCondition
                        .builder(ModBlocks.CORN_CROP)
                        .properties(
                                StatePredicate.Builder.create().exactMatch(CornCropBlock.AGE, 8)));
        addDrop(
                ModBlocks.CORN_CROP,
                cropDrops(ModBlocks.CORN_CROP, ModItems.CORN, ModItems.CORN_SEEDS, builder2)
        );

        addDrop(ModBlocks.COTTON_CANDY_FLOWER);
        addPottedPlantDrops(ModBlocks.POTTED_COTTON_CANDY_FLOWER);
    }

    public LootTable.Builder lapisLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(
                drop, (LootPoolEntry.Builder) this.applyExplosionDecay(drop,
                        ((LeafEntry.Builder) ItemEntry
                                .builder(item)
                                .apply(SetCountLootFunction.builder(
                                        UniformLootNumberProvider.create(4.0f, 9.0f)))).apply(
                                ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                ));
    }
}
