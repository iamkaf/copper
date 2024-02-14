package com.codekaffe.copper.block;

import com.codekaffe.copper.KafCopper;
import com.codekaffe.copper.block.custom.CornCropBlock;
import com.codekaffe.copper.block.custom.SoundBlock;
import com.codekaffe.copper.block.custom.TomatoCropBlock;
import com.codekaffe.copper.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    // COPPER ITEMS
    public static final Block REINFORCED_COPPER_BLOCK = registerBlock("reinforced_copper_block",
            new Block(FabricBlockSettings
                    .copyOf(Blocks.COPPER_BLOCK)
                    .hardness(Blocks.IRON_BLOCK.getHardness()))
    );

    // KAFERIUM ITEMS
    public static final Block KAFERIUM_ORE = registerBlock("kaferium_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.LAPIS_ORE),
                    UniformIntProvider.create(5, 9)
            )
    );
    public static final Block DEEPSLATE_KAFERIUM_ORE = registerBlock("deepslate_kaferium_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_LAPIS_ORE),
                    UniformIntProvider.create(5, 9)
            )
    );
    public static final Block KAFERIUM_BLOCK = registerBlock("kaferium_block",
            new Block(FabricBlockSettings
                    .copyOf(Blocks.EMERALD_BLOCK)
                    .hardness(Blocks.IRON_BLOCK.getHardness()))
    );
    public static final Block KAFUEL_BLOCK = registerBlock("kafuel_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK))
    );

    public static final Block SOUND_BLOCK = registerBlock("sound_block",
            new SoundBlock(FabricBlockSettings
                    .copyOf(Blocks.STONE)
                    .sounds(ModSounds.SOUND_BLOCK_SOUNDS))
    );

    public static final Block REINFORCED_COPPER_STAIRS = registerBlock("reinforced_copper_stairs",
            new StairsBlock(ModBlocks.REINFORCED_COPPER_BLOCK.getDefaultState(),
                    FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)
            )
    );
    public static final Block REINFORCED_COPPER_SLAB = registerBlock("reinforced_copper_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK))
    );

    public static final Block REINFORCED_COPPER_BUTTON = registerBlock("reinforced_copper_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.STONE), BlockSetType.IRON, 10, true)
    );
    public static final Block REINFORCED_COPPER_PRESSURE_PLATE = registerBlock("reinforced_copper_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.STONE),
                    BlockSetType.IRON
            )
    );
    public static final Block REINFORCED_COPPER_FENCE = registerBlock("reinforced_copper_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.STONE))
    );
    public static final Block REINFORCED_COPPER_FENCE_GATE = registerBlock(
            "reinforced_copper_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.STONE), WoodType.ACACIA)
    );
    public static final Block REINFORCED_COPPER_WALL = registerBlock("reinforced_copper_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE))
    );
    public static final Block REINFORCED_COPPER_DOOR = registerBlock("reinforced_copper_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_DOOR), BlockSetType.IRON)
    );
    public static final Block REINFORCED_COPPER_TRAPDOOR = registerBlock(
            "reinforced_copper_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_TRAPDOOR), BlockSetType.IRON)
    );

    public static final Block TOMATO_CROP = Registry.register(Registries.BLOCK,
            new Identifier(KafCopper.MOD_ID, "tomato_crop"),
            new TomatoCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT))
    );
    public static final Block CORN_CROP = Registry.register(Registries.BLOCK,
            new Identifier(KafCopper.MOD_ID, "corn_crop"),
            new CornCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT))
    );

    public static final Block COTTON_CANDY_FLOWER = registerBlock("cotton_candy_flower",
            new FlowerBlock(StatusEffects.SPEED,
                    10,
                    FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()
            )
    );
    public static final Block POTTED_COTTON_CANDY_FLOWER = Registry.register(Registries.BLOCK,
            new Identifier(KafCopper.MOD_ID, "potted_cotton_candy_flower"),
            new FlowerPotBlock(COTTON_CANDY_FLOWER,
                    FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()
            )
    );

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(KafCopper.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM,
                new Identifier(KafCopper.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings())
        );
    }

    public static void registerModBlocks() {
        KafCopper.LOGGER.info("Registering Mod Blocks for " + KafCopper.MOD_ID);
    }
}
