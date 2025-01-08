package net.emirikol.floristry.item;

import net.emirikol.floristry.block.FloristryBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class FloristryItems {
	public static RegistryKey<Item> HERMIT_PURPLE_ITEM_KEY = RegistryKey.of(RegistryKeys.ITEM, FloristryBlocks.HERMIT_PURPLE_ID);
	public static RegistryKey<Item> MOONFLOWER_ITEM_KEY = RegistryKey.of(RegistryKeys.ITEM, FloristryBlocks.MOONFLOWER_ID);
	public static RegistryKey<Item> WITHER_BUSH_ITEM_KEY = RegistryKey.of(RegistryKeys.ITEM, FloristryBlocks.WITHER_BUSH_ID);

	public static BlockItem HERMIT_PURPLE_ITEM = new BlockItem(FloristryBlocks.HERMIT_PURPLE, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(HERMIT_PURPLE_ITEM_KEY));
	public static BlockItem MOONFLOWER_ITEM = new BlockItem(FloristryBlocks.MOONFLOWER, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(MOONFLOWER_ITEM_KEY));
	public static BlockItem WITHER_BUSH_ITEM = new BlockItem(FloristryBlocks.WITHER_BUSH, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(WITHER_BUSH_ITEM_KEY));
}
