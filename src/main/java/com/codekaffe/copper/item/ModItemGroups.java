package com.codekaffe.copper.item;

import com.codekaffe.copper.block.ModBlocks;
import com.codekaffe.copper.KafCopper;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup COPPER_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(KafCopper.MOD_ID, "copper"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.copper")).icon(() -> new ItemStack(ModItems.COPPER_IRON_ALLOY)).entries(((displayContext, entries) -> {

        // DEBUG
        entries.add(ModItems.DEBUG_STICK);
        entries.add(ModBlocks.SOUND_BLOCK);

        // COPPER ITEMS
        entries.add(ModItems.COPPER_APPLE);
        entries.add(ModItems.TOMATO);
        entries.add(ModItems.TOMATO_SEEDS);
        entries.add(ModItems.CORN);
        entries.add(ModItems.CORN_SEEDS);
        entries.add(ModBlocks.COTTON_CANDY_FLOWER);
        entries.add(ModItems.EMERALD_DISC);
        entries.add(ModItems.COPPER_IRON_ALLOY);
        entries.add(ModItems.REINFORCED_COPPER_INGOT);
        entries.add(ModBlocks.REINFORCED_COPPER_BLOCK);
        entries.add(ModBlocks.REINFORCED_COPPER_STAIRS);
        entries.add(ModBlocks.REINFORCED_COPPER_SLAB);
        entries.add(ModBlocks.REINFORCED_COPPER_FENCE);
        entries.add(ModBlocks.REINFORCED_COPPER_FENCE_GATE);
        entries.add(ModBlocks.REINFORCED_COPPER_WALL);
        entries.add(ModBlocks.REINFORCED_COPPER_BUTTON);
        entries.add(ModBlocks.REINFORCED_COPPER_PRESSURE_PLATE);
        entries.add(ModBlocks.REINFORCED_COPPER_DOOR);
        entries.add(ModBlocks.REINFORCED_COPPER_TRAPDOOR);
        entries.add(ModItems.REINFORCED_COPPER_PICKAXE);
        entries.add(ModItems.REINFORCED_COPPER_AXE);
        entries.add(ModItems.REINFORCED_COPPER_SHOVEL);
        entries.add(ModItems.REINFORCED_COPPER_SWORD);
        entries.add(ModItems.REINFORCED_COPPER_HOE);
        entries.add(ModItems.REINFORCED_COPPER_HELMET);
        entries.add(ModItems.REINFORCED_COPPER_CHESTPLATE);
        entries.add(ModItems.REINFORCED_COPPER_LEGGINGS);
        entries.add(ModItems.REINFORCED_COPPER_BOOTS);

        // KAFERIUM ITEMS
        entries.add(ModItems.KAFERIUM);
        entries.add(ModBlocks.KAFERIUM_BLOCK);
        entries.add(ModBlocks.KAFERIUM_ORE);
        entries.add(ModBlocks.DEEPSLATE_KAFERIUM_ORE);
        entries.add(ModItems.KAFUEL);
        entries.add(ModBlocks.KAFUEL_BLOCK);
        entries.add(ModItems.KAFERIUM_STAFF);
    })).build());

    public static void registerItemGroups() {
        KafCopper.LOGGER.info("Registering Item Groups for " + KafCopper.MOD_ID);
    }
}
