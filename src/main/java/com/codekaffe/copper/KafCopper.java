package com.codekaffe.copper;

import com.codekaffe.copper.block.ModBlocks;
import com.codekaffe.copper.item.ModFuels;
import com.codekaffe.copper.item.ModItemGroups;
import com.codekaffe.copper.item.ModItems;
import com.codekaffe.copper.sound.ModSounds;
import com.codekaffe.copper.util.ModCustomTrades;
import com.codekaffe.copper.util.ModLootTableModifiers;
import com.codekaffe.copper.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafCopper implements ModInitializer {
	public static final String MOD_ID = "kafcopper";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("kafcopper");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModFuels.registerModFuels();
		ModLootTableModifiers.modifyLootTables();
		ModCustomTrades.registerCustomTrades();
		ModVillagers.registerVillagers();
		ModSounds.registerSounds();
	}
}