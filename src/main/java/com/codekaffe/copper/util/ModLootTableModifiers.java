package com.codekaffe.copper.util;

import com.codekaffe.copper.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModLootTableModifiers {
    private static final Identifier DANDELION_ID = new Identifier("minecraft", "blocks/dandelion");
    private static final Identifier SUSPICIOUS_SAND_ID = new Identifier("minecraft",
            "archaeology_pyramid");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (DANDELION_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool
                        .builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.KAFERIUM))
                        .apply(SetCountLootFunction
                                .builder(UniformLootNumberProvider.create(1.0f, 1.0f))
                                .build());

                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
//            if (SUSPICIOUS_SAND_ID.equals(id)) {
//                List<LootPoolEntry> entries =
//                        new ArrayList<>(Arrays.asList(original.pools[0].entries));
//                entries.add(ItemEntry.builder(ModItems.KAFERIUM).build());
//
//                LootPool.Builder pool = LootPool.builder().with(entries);
//                return LootTable.builder().pool(pool).build();
//            }

            return null;
        });
    }
}
