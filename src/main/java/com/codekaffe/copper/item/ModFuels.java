package com.codekaffe.copper.item;

import com.codekaffe.copper.block.ModBlocks;
import com.codekaffe.copper.KafCopper;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.ItemConvertible;

public class ModFuels {
    private static void registerFuel(ItemConvertible item, Integer burnTime) {
        FuelRegistry.INSTANCE.add(item, burnTime);
    }

    public static void registerModFuels() {
        KafCopper.LOGGER.info("Registering mod fuels for " + KafCopper.MOD_ID);

        registerFuel(ModItems.KAFUEL, 3200);
        registerFuel(ModBlocks.KAFUEL_BLOCK, 32000);
    }
}
