package com.codekaffe.copper.item;

import com.codekaffe.copper.KafCopper;
import com.codekaffe.copper.block.ModBlocks;
import com.codekaffe.copper.item.custom.CopperApple;
import com.codekaffe.copper.item.custom.DebugStickItem;
import com.codekaffe.copper.item.custom.ModArmorItem;
import com.codekaffe.copper.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    // DEBUG
    public static final Item DEBUG_STICK = registerItem(
            "debug_stick",
            new DebugStickItem(new FabricItemSettings().maxDamage(64))
    );

    // COPPER ITEMS
    public static final Item COPPER_APPLE = registerItem("copper_apple",
            new CopperApple(new FabricItemSettings().food(ModFoodComponents.COPPER_APPLE))
    );
    public static final Item COPPER_IRON_ALLOY = registerItem(
            "copper_iron_alloy",
            new Item(new FabricItemSettings())
    );
    public static final Item REINFORCED_COPPER_INGOT = registerItem(
            "reinforced_copper_ingot",
            new Item(new FabricItemSettings())
    );
    public static final Item REINFORCED_COPPER_PICKAXE = registerItem("reinforced_copper_pickaxe",
            new PickaxeItem(ModToolMaterial.REINFORCED_COPPER, 2, 2f, new FabricItemSettings())
    );
    public static final Item REINFORCED_COPPER_AXE = registerItem("reinforced_copper_axe",
            new AxeItem(ModToolMaterial.REINFORCED_COPPER, 2, 2f, new FabricItemSettings())
    );
    public static final Item REINFORCED_COPPER_SHOVEL = registerItem("reinforced_copper_shovel",
            new ShovelItem(ModToolMaterial.REINFORCED_COPPER, 2, 2f, new FabricItemSettings())
    );
    public static final Item REINFORCED_COPPER_SWORD = registerItem("reinforced_copper_sword",
            new SwordItem(ModToolMaterial.REINFORCED_COPPER, 5, 3f, new FabricItemSettings())
    );
    public static final Item REINFORCED_COPPER_HOE = registerItem("reinforced_copper_hoe",
            new HoeItem(ModToolMaterial.REINFORCED_COPPER, 0, 0f, new FabricItemSettings())
    );
    public static final Item REINFORCED_COPPER_HELMET = registerItem("reinforced_copper_helmet",
            new ModArmorItem(ModArmorMaterials.REINFORCED_COPPER,
                    ArmorItem.Type.HELMET,
                    new FabricItemSettings()
            )
    );
    public static final Item REINFORCED_COPPER_CHESTPLATE = registerItem("reinforced_copper_chestplate",
            new ArmorItem(ModArmorMaterials.REINFORCED_COPPER,
                    ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()
            )
    );
    public static final Item REINFORCED_COPPER_LEGGINGS = registerItem("reinforced_copper_leggings",
            new ArmorItem(ModArmorMaterials.REINFORCED_COPPER,
                    ArmorItem.Type.LEGGINGS,
                    new FabricItemSettings()
            )
    );
    public static final Item REINFORCED_COPPER_BOOTS = registerItem("reinforced_copper_boots",
            new ArmorItem(ModArmorMaterials.REINFORCED_COPPER,
                    ArmorItem.Type.BOOTS,
                    new FabricItemSettings()
            )
    );

    public static final Item TOMATO = registerItem(
            "tomato",
            new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO))
    );
    public static final Item TOMATO_SEEDS = registerItem(
            "tomato_seeds",
            new AliasedBlockItem(ModBlocks.TOMATO_CROP, new FabricItemSettings())
    );
    public static final Item CORN = registerItem("corn",
            new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO))
    );
    public static final Item CORN_SEEDS = registerItem("corn_seeds",
            new AliasedBlockItem(ModBlocks.CORN_CROP, new FabricItemSettings())
    );

    public static final Item EMERALD_DISC = registerItem("emerald_disc",
            new MusicDiscItem(7, ModSounds.EMERALD_DISC, new FabricItemSettings().maxCount(1), 115)
    );

    // KAFERIUM ITEMS
    public static final Item KAFERIUM = registerItem(
            "kaferium",
            new Item(new FabricItemSettings())
    );
    public static final Item KAFUEL = registerItem("kafuel", new Item(new FabricItemSettings()));
    public static final Item KAFERIUM_STAFF = registerItem(
            "kaferium_staff",
            new Item(new FabricItemSettings().maxCount(1))
    );


    public static void addItemsToIngredientsTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(COPPER_IRON_ALLOY);
        entries.add(REINFORCED_COPPER_INGOT);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(KafCopper.MOD_ID, name), item);
    }

    public static void registerModItems() {
        KafCopper.LOGGER.info("Registering mod items for " + KafCopper.MOD_ID);

        ItemGroupEvents
                .modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register(ModItems::addItemsToIngredientsTabItemGroup);
    }
}
