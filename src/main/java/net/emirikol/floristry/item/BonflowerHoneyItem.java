package net.emirikol.floristry.item;

import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class BonflowerHoneyItem extends Item {
	public BonflowerHoneyItem(Item.Settings settings) {
		super(settings.recipeRemainder(Items.GLASS_BOTTLE).food(FoodComponents.HONEY_BOTTLE, ConsumableComponents.HONEY_BOTTLE).useRemainder(Items.GLASS_BOTTLE).maxCount(16));
	}
}
