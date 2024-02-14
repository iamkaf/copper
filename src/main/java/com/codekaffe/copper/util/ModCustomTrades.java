package com.codekaffe.copper.util;

import com.codekaffe.copper.block.ModBlocks;
import com.codekaffe.copper.item.ModItems;
import com.codekaffe.copper.villager.ModVillagers;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.COPPER_IRON_ALLOY, 1),
                    6,
                    5,
                    0.075f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.TOMATO, 1),
                    6,
                    5,
                    0.075f
            ));
        });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.SOUND_MASTER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 32),
                    new ItemStack(ModBlocks.SOUND_BLOCK, 1),
                    2,
                    5,
                    0.075f
            ));
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(ModBlocks.SOUND_BLOCK, 1),
                    new ItemStack(Items.EMERALD, 16),
                    1,
                    5,
                    0.075f
            ));
        });
    }
}
