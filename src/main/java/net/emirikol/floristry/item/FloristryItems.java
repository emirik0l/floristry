package net.emirikol.floristry.item;

import net.emirikol.floristry.block.FloristryBlocks;
import net.emirikol.floristry.registry.FloristryRegistryKeys;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;

public class FloristryItems {
	public static BlockItem HERMIT_PURPLE_ITEM = new BlockItem(FloristryBlocks.HERMIT_PURPLE, createFlowerItemSettings(FloristryRegistryKeys.HERMIT_PURPLE_ITEM_KEY));
	public static BlockItem MOONFLOWER_ITEM = new BlockItem(FloristryBlocks.MOONFLOWER, createFlowerItemSettings(FloristryRegistryKeys.MOONFLOWER_ITEM_KEY));
	public static BlockItem WITHER_BUSH_ITEM = new BlockItem(FloristryBlocks.WITHER_BUSH, createFlowerItemSettings(FloristryRegistryKeys.WITHER_BUSH_ITEM_KEY));

	public static Item.Settings createFlowerItemSettings(RegistryKey<Item> key) {
		return new Item.Settings().useBlockPrefixedTranslationKey().registryKey(key);
	}
}
