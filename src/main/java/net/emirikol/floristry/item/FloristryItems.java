package net.emirikol.floristry.item;

import net.emirikol.floristry.block.FloristryBlocks;
import net.emirikol.floristry.registry.FloristryRegistryKeys;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;

public class FloristryItems {
	public static BlockItem AGLAOPHOTIS_ITEM = new BlockItem(FloristryBlocks.AGLAOPHOTIS, createFlowerItemSettings(FloristryRegistryKeys.AGLAOPHOTIS_ITEM_KEY));
	public static BlockItem BLOOMING_THISTLE_ITEM = new BlockItem(FloristryBlocks.BLOOMING_THISTLE, createFlowerItemSettings(FloristryRegistryKeys.BLOOMING_THISTLE_ITEM_KEY));
	public static BlockItem BONFLOWER_ITEM = new BlockItem(FloristryBlocks.BONFLOWER, createFlowerItemSettings(FloristryRegistryKeys.BONFLOWER_ITEM_KEY));
	public static BlockItem BRANDFLOWER_ITEM = new BlockItem(FloristryBlocks.BRANDFLOWER, createFlowerItemSettings(FloristryRegistryKeys.BRANDFLOWER_ITEM_KEY));
	public static BlockItem BUBBLEBUD_ITEM = new BlockItem(FloristryBlocks.BUBBLEBUD, createFlowerItemSettings(FloristryRegistryKeys.BUBBLEBUD_ITEM_KEY));
	public static BlockItem FALSE_ROSE_ITEM = new BlockItem(FloristryBlocks.FALSE_ROSE, createFlowerItemSettings(FloristryRegistryKeys.FALSE_ROSE_ITEM_KEY));
	public static BlockItem HERMIT_PURPLE_ITEM = new BlockItem(FloristryBlocks.HERMIT_PURPLE, createFlowerItemSettings(FloristryRegistryKeys.HERMIT_PURPLE_ITEM_KEY));
	public static BlockItem MOONFLOWER_ITEM = new BlockItem(FloristryBlocks.MOONFLOWER, createFlowerItemSettings(FloristryRegistryKeys.MOONFLOWER_ITEM_KEY));
	public static BlockItem PATINA_FLOWER_ITEM = new BlockItem(FloristryBlocks.PATINA_FLOWER, createFlowerItemSettings(FloristryRegistryKeys.PATINA_FLOWER_ITEM_KEY));
	public static BlockItem VIRIDELPHIA_ITEM = new BlockItem(FloristryBlocks.VIRIDELPHIA, createFlowerItemSettings(FloristryRegistryKeys.VIRIDELPHIA_ITEM_KEY));
	public static BlockItem WITHER_BUSH_ITEM = new BlockItem(FloristryBlocks.WITHER_BUSH, createFlowerItemSettings(FloristryRegistryKeys.WITHER_BUSH_ITEM_KEY));

	public static BonflowerHoneyItem BONFLOWER_HONEY = new BonflowerHoneyItem(createHoneySettings(FloristryRegistryKeys.BONFLOWER_HONEY_KEY));

	public static Item.Settings createFlowerItemSettings(RegistryKey<Item> key) {
		return new Item.Settings().useBlockPrefixedTranslationKey().registryKey(key);
	}

	public static Item.Settings createHoneySettings(RegistryKey<Item> key) {
		return new Item.Settings().useItemPrefixedTranslationKey().registryKey(key);
	}

	public static void registerFuels() {
		FuelRegistryEvents.BUILD.register((builder, context) -> {
			builder.add(BONFLOWER_ITEM, context.baseSmeltTime() * 3);
		});
	}
}
