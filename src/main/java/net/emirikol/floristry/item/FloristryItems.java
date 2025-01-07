package net.emirikol.floristry.item;

import net.emirikol.floristry.block.FloristryBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class FloristryItems {
	public static RegistryKey<Item> WITHER_BUSH_ITEM_KEY = RegistryKey.of(RegistryKeys.ITEM, FloristryBlocks.WITHER_BUSH_ID);

	public static BlockItem WITHER_BUSH_ITEM = new BlockItem(FloristryBlocks.WITHER_BUSH, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(WITHER_BUSH_ITEM_KEY));
}
