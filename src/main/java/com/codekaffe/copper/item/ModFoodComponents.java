package com.codekaffe.copper.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent COPPER_APPLE = new FoodComponent.Builder()
            .hunger(4)
            .saturationModifier(0.3f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100), 1f)
            .build();
    public static final FoodComponent TOMATO = new FoodComponent.Builder()
            .hunger(4)
            .saturationModifier(0.3f)
            .build();
}
