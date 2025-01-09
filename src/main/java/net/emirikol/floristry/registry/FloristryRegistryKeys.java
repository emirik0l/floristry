package net.emirikol.floristry.registry;

import net.emirikol.floristry.FloristryMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class FloristryRegistryKeys {
	// Blocks
	public static RegistryKey<Block> BRANDFLOWER_KEY = RegistryKey.of(RegistryKeys.BLOCK, FloristryMod.BRANDFLOWER_ID);
	public static RegistryKey<Block> FALSE_ROSE_KEY = RegistryKey.of(RegistryKeys.BLOCK, FloristryMod.FALSE_ROSE_ID);
	public static RegistryKey<Block> HERMIT_PURPLE_KEY = RegistryKey.of(RegistryKeys.BLOCK, FloristryMod.HERMIT_PURPLE_ID);
	public static RegistryKey<Block> MOONFLOWER_KEY = RegistryKey.of(RegistryKeys.BLOCK, FloristryMod.MOONFLOWER_ID);
	public static RegistryKey<Block> WITHER_BUSH_KEY = RegistryKey.of(RegistryKeys.BLOCK, FloristryMod.WITHER_BUSH_ID);

	public static RegistryKey<Block> POTTED_HERMIT_PURPLE_KEY = RegistryKey.of(RegistryKeys.BLOCK, FloristryMod.POTTED_HERMIT_PURPLE_ID);

	// Items
	public static RegistryKey<Item> BRANDFLOWER_ITEM_KEY = RegistryKey.of(RegistryKeys.ITEM, FloristryMod.BRANDFLOWER_ID);
	public static RegistryKey<Item> FALSE_ROSE_ITEM_KEY = RegistryKey.of(RegistryKeys.ITEM, FloristryMod.FALSE_ROSE_ID);
	public static RegistryKey<Item> HERMIT_PURPLE_ITEM_KEY = RegistryKey.of(RegistryKeys.ITEM, FloristryMod.HERMIT_PURPLE_ID);
	public static RegistryKey<Item> MOONFLOWER_ITEM_KEY = RegistryKey.of(RegistryKeys.ITEM, FloristryMod.MOONFLOWER_ID);
	public static RegistryKey<Item> WITHER_BUSH_ITEM_KEY = RegistryKey.of(RegistryKeys.ITEM, FloristryMod.WITHER_BUSH_ID);
}
