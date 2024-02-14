package com.codekaffe.copper.datagen;

import com.codekaffe.copper.block.ModBlocks;
import com.codekaffe.copper.block.custom.CornCropBlock;
import com.codekaffe.copper.block.custom.TomatoCropBlock;
import com.codekaffe.copper.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // DEBUG
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);
        // COPPER
        BlockStateModelGenerator.BlockTexturePool reinforcedCopperPool = blockStateModelGenerator.registerCubeAllModelTexturePool(
                ModBlocks.REINFORCED_COPPER_BLOCK);
        reinforcedCopperPool.stairs(ModBlocks.REINFORCED_COPPER_STAIRS);
        reinforcedCopperPool.slab(ModBlocks.REINFORCED_COPPER_SLAB);
        reinforcedCopperPool.button(ModBlocks.REINFORCED_COPPER_BUTTON);
        reinforcedCopperPool.pressurePlate(ModBlocks.REINFORCED_COPPER_PRESSURE_PLATE);
        reinforcedCopperPool.fence(ModBlocks.REINFORCED_COPPER_FENCE);
        reinforcedCopperPool.fenceGate(ModBlocks.REINFORCED_COPPER_FENCE_GATE);
        reinforcedCopperPool.wall(ModBlocks.REINFORCED_COPPER_WALL);
        blockStateModelGenerator.registerDoor(ModBlocks.REINFORCED_COPPER_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.REINFORCED_COPPER_TRAPDOOR);
        // KAFERIUM
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KAFERIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_KAFERIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KAFERIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KAFUEL_BLOCK);

        blockStateModelGenerator.registerCrop(ModBlocks.TOMATO_CROP,
                TomatoCropBlock.AGE,
                0,
                1,
                2,
                3,
                4,
                5
        );
        blockStateModelGenerator.registerCrop(ModBlocks.CORN_CROP,
                CornCropBlock.AGE,
                0,
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8
        );

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.COTTON_CANDY_FLOWER,
                ModBlocks.POTTED_COTTON_CANDY_FLOWER,
                BlockStateModelGenerator.TintType.NOT_TINTED
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // DEBUG
        itemModelGenerator.register(ModItems.DEBUG_STICK, Models.GENERATED);
        // COPPER
        itemModelGenerator.register(ModItems.COPPER_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_IRON_ALLOY, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMERALD_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.REINFORCED_COPPER_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.REINFORCED_COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REINFORCED_COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REINFORCED_COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REINFORCED_COPPER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REINFORCED_COPPER_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.REINFORCED_COPPER_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.REINFORCED_COPPER_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.REINFORCED_COPPER_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.REINFORCED_COPPER_BOOTS);
        // KAFERIUM
        itemModelGenerator.register(ModItems.KAFERIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.KAFUEL, Models.GENERATED);

        itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN, Models.GENERATED);
    }
}
