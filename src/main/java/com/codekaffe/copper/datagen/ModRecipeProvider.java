package com.codekaffe.copper.datagen;

import com.codekaffe.copper.block.ModBlocks;
import com.codekaffe.copper.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> KAFERIUM_SMELTABLES = List.of(ModBlocks.KAFERIUM_ORE, ModBlocks.DEEPSLATE_KAFERIUM_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder
                .create(RecipeCategory.MISC, ModItems.COPPER_IRON_ALLOY, 1)
                .input(Items.COPPER_INGOT)
                .input(Items.IRON_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COPPER_IRON_ALLOY)));

        offerSmelting(exporter, List.of(ModItems.COPPER_IRON_ALLOY), RecipeCategory.MISC, ModItems.REINFORCED_COPPER_INGOT, 0.7f, 200, "copper");
        offerBlasting(exporter, List.of(ModItems.COPPER_IRON_ALLOY), RecipeCategory.MISC, ModItems.REINFORCED_COPPER_INGOT, 0.7f, 200, "copper");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.REINFORCED_COPPER_INGOT, RecipeCategory.DECORATIONS, ModBlocks.REINFORCED_COPPER_BLOCK);


        offerSmelting(exporter, KAFERIUM_SMELTABLES, RecipeCategory.MISC, ModItems.KAFERIUM, 0.7f, 200, "kaferium");
        offerBlasting(exporter, KAFERIUM_SMELTABLES, RecipeCategory.MISC, ModItems.KAFERIUM, 0.7f, 200, "kaferium");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.KAFERIUM, RecipeCategory.DECORATIONS, ModBlocks.KAFERIUM_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.KAFUEL, RecipeCategory.DECORATIONS, ModBlocks.KAFUEL_BLOCK);

        ShapedRecipeJsonBuilder
                .create(RecipeCategory.MISC, ModItems.COPPER_APPLE, 1)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .input('X', Items.COPPER_INGOT)
                .input('O', Items.APPLE)
                .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COPPER_APPLE)));

        createDoorRecipe(ModBlocks.REINFORCED_COPPER_DOOR, Ingredient.ofItems(ModItems.REINFORCED_COPPER_INGOT))
                .criterion(hasItem(ModItems.REINFORCED_COPPER_INGOT), conditionsFromItem(ModItems.REINFORCED_COPPER_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.REINFORCED_COPPER_DOOR)));
    }
}
