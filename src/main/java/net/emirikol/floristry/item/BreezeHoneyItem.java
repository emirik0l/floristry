package net.emirikol.floristry.item;

import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class BreezeHoneyItem extends Item {
	public BreezeHoneyItem(Item.Settings settings) {
		super(settings.recipeRemainder(Items.GLASS_BOTTLE).food(FoodComponents.HONEY_BOTTLE, ConsumableComponents.HONEY_BOTTLE).useRemainder(Items.GLASS_BOTTLE).maxCount(16));
	}

	@Override
	public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
		Text tooltipText = Text.translatable("item.floristry.breeze_honey.tooltip").formatted(Formatting.GRAY).formatted(Formatting.ITALIC);
		tooltip.add(tooltipText);
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.SLOW_FALLING, 1800); // 1.5 minutes
		user.addStatusEffect(effect);
		return super.finishUsing(stack, world, user);
	}
}
