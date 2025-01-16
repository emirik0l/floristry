package net.emirikol.floristry;

import net.emirikol.floristry.block.FloristryBlocks;
import net.emirikol.floristry.item.FloristryItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FloristryMod implements ModInitializer {
	public static final String MOD_ID = "floristry";

	public static Identifier AGLAOPHOTIS_ID = Identifier.of(MOD_ID, "aglaophotis");
	public static Identifier BLOOMING_THISTLE_ID = Identifier.of(MOD_ID, "blooming_thistle");
	public static Identifier BONFLOWER_ID = Identifier.of(MOD_ID, "bonflower");
	public static Identifier BRANDFLOWER_ID = Identifier.of(MOD_ID, "brandflower");
	public static Identifier BREEZE_CLOVER_ID = Identifier.of(MOD_ID, "breeze_clover");
	public static Identifier BUBBLEBUD_ID = Identifier.of(MOD_ID, "bubblebud");
	public static Identifier FALSE_ROSE_ID = Identifier.of(MOD_ID, "false_rose");
	public static Identifier HEARTH_ROSE_ID = Identifier.of(MOD_ID, "hearth_rose");
	public static Identifier HERMIT_PURPLE_ID = Identifier.of(MOD_ID, "hermit_purple");
	public static Identifier MOONFLOWER_ID = Identifier.of(MOD_ID, "moonflower");
	public static Identifier PATINA_FLOWER_ID = Identifier.of(MOD_ID, "patina_flower");
	public static Identifier VIRIDELPHIA_ID = Identifier.of(MOD_ID, "viridelphia");
	public static Identifier WITHER_BUSH_ID = Identifier.of(MOD_ID, "wither_bush");

	public static Identifier POTTED_AGLAOPHOTIS_ID = Identifier.of(MOD_ID, "potted_aglaophotis");
	public static Identifier POTTED_BLOOMING_THISTLE_ID = Identifier.of(MOD_ID, "potted_blooming_thistle");
	public static Identifier POTTED_BONFLOWER_ID = Identifier.of(MOD_ID, "potted_bonflower");
	public static Identifier POTTED_BRANDFLOWER_ID = Identifier.of(MOD_ID, "potted_brandflower");
	public static Identifier POTTED_BUBBLEBUD_ID = Identifier.of(MOD_ID, "potted_bubblebud");
	public static Identifier POTTED_FALSE_ROSE_ID = Identifier.of(MOD_ID, "potted_false_rose");
	public static Identifier POTTED_HERMIT_PURPLE_ID = Identifier.of(MOD_ID, "potted_hermit_purple");
	public static Identifier POTTED_PATINA_FLOWER_ID = Identifier.of(MOD_ID, "potted_patina_flower");
	public static Identifier POTTED_VIRIDELPHIA_ID = Identifier.of(MOD_ID, "potted_viridelphia");

	public static Identifier BONFLOWER_HONEY_ID = Identifier.of(MOD_ID, "bonflower_honey");
	public static Identifier BREEZE_HONEY_ID = Identifier.of(MOD_ID, "breeze_honey");

	public static final boolean DEBUG_LOGGING = false;
	public static final int FLOWER_PLACE_RANGE = 5;
	public static final int FLOWER_SCAN_RANGE = 5;

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static void logInfo(String s) {
		if (FloristryMod.DEBUG_LOGGING) {
			FloristryMod.LOGGER.info(s);
		}
	}

	@Override
	public void onInitialize() {
		Registry.register(Registries.BLOCK, AGLAOPHOTIS_ID, FloristryBlocks.AGLAOPHOTIS);
		Registry.register(Registries.BLOCK, BLOOMING_THISTLE_ID, FloristryBlocks.BLOOMING_THISTLE);
		Registry.register(Registries.BLOCK, BONFLOWER_ID, FloristryBlocks.BONFLOWER);
		Registry.register(Registries.BLOCK, BRANDFLOWER_ID, FloristryBlocks.BRANDFLOWER);
		Registry.register(Registries.BLOCK, BREEZE_CLOVER_ID, FloristryBlocks.BREEZE_CLOVER);
		Registry.register(Registries.BLOCK, BUBBLEBUD_ID, FloristryBlocks.BUBBLEBUD);
		Registry.register(Registries.BLOCK, FALSE_ROSE_ID, FloristryBlocks.FALSE_ROSE);
		Registry.register(Registries.BLOCK, HEARTH_ROSE_ID, FloristryBlocks.HEARTH_ROSE);
		Registry.register(Registries.BLOCK, HERMIT_PURPLE_ID, FloristryBlocks.HERMIT_PURPLE);
		Registry.register(Registries.BLOCK, MOONFLOWER_ID, FloristryBlocks.MOONFLOWER);
		Registry.register(Registries.BLOCK, PATINA_FLOWER_ID, FloristryBlocks.PATINA_FLOWER);
		Registry.register(Registries.BLOCK, VIRIDELPHIA_ID, FloristryBlocks.VIRIDELPHIA);
		Registry.register(Registries.BLOCK, WITHER_BUSH_ID, FloristryBlocks.WITHER_BUSH);

		Registry.register(Registries.BLOCK, POTTED_AGLAOPHOTIS_ID, FloristryBlocks.POTTED_AGLAOPHOTIS);
		Registry.register(Registries.BLOCK, POTTED_BLOOMING_THISTLE_ID, FloristryBlocks.POTTED_BLOOMING_THISTLE);
		Registry.register(Registries.BLOCK, POTTED_BONFLOWER_ID, FloristryBlocks.POTTED_BONFLOWER);
		Registry.register(Registries.BLOCK, POTTED_BRANDFLOWER_ID, FloristryBlocks.POTTED_BRANDFLOWER);
		Registry.register(Registries.BLOCK, POTTED_BUBBLEBUD_ID, FloristryBlocks.POTTED_BUBBLEBUD);
		Registry.register(Registries.BLOCK, POTTED_FALSE_ROSE_ID, FloristryBlocks.POTTED_FALSE_ROSE);
		Registry.register(Registries.BLOCK, POTTED_HERMIT_PURPLE_ID, FloristryBlocks.POTTED_HERMIT_PURPLE);
		Registry.register(Registries.BLOCK, POTTED_PATINA_FLOWER_ID, FloristryBlocks.POTTED_PATINA_FLOWER);
		Registry.register(Registries.BLOCK, POTTED_VIRIDELPHIA_ID, FloristryBlocks.POTTED_VIRIDELPHIA);

		Registry.register(Registries.ITEM, AGLAOPHOTIS_ID, FloristryItems.AGLAOPHOTIS_ITEM);
		Registry.register(Registries.ITEM, BLOOMING_THISTLE_ID, FloristryItems.BLOOMING_THISTLE_ITEM);
		Registry.register(Registries.ITEM, BONFLOWER_ID, FloristryItems.BONFLOWER_ITEM);
		Registry.register(Registries.ITEM, BRANDFLOWER_ID, FloristryItems.BRANDFLOWER_ITEM);
		Registry.register(Registries.ITEM, BREEZE_CLOVER_ID, FloristryItems.BREEZE_CLOVER_ITEM);
		Registry.register(Registries.ITEM, BUBBLEBUD_ID, FloristryItems.BUBBLEBUD_ITEM);
		Registry.register(Registries.ITEM, FALSE_ROSE_ID, FloristryItems.FALSE_ROSE_ITEM);
		Registry.register(Registries.ITEM, HEARTH_ROSE_ID, FloristryItems.HEARTH_ROSE_ITEM);
		Registry.register(Registries.ITEM, HERMIT_PURPLE_ID, FloristryItems.HERMIT_PURPLE_ITEM);
		Registry.register(Registries.ITEM, MOONFLOWER_ID, FloristryItems.MOONFLOWER_ITEM);
		Registry.register(Registries.ITEM, PATINA_FLOWER_ID, FloristryItems.PATINA_FLOWER_ITEM);
		Registry.register(Registries.ITEM, VIRIDELPHIA_ID, FloristryItems.VIRIDELPHIA_ITEM);
		Registry.register(Registries.ITEM, WITHER_BUSH_ID, FloristryItems.WITHER_BUSH_ITEM);

		Registry.register(Registries.ITEM, BONFLOWER_HONEY_ID, FloristryItems.BONFLOWER_HONEY);
		Registry.register(Registries.ITEM, BREEZE_HONEY_ID, FloristryItems.BREEZE_HONEY);

		FloristryItems.registerFuels();
	}
}