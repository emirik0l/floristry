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

	public static Identifier WITHER_BUSH_ID = Identifier.of(MOD_ID, "wither_bush");
	public static Identifier MOONFLOWER_ID = Identifier.of(MOD_ID, "moonflower");
	public static Identifier HERMIT_PURPLE_ID = Identifier.of(MOD_ID, "hermit_purple");

	public static final boolean DEBUG_LOGGING = true; //TODO change for release
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
		Registry.register(Registries.BLOCK, HERMIT_PURPLE_ID, FloristryBlocks.HERMIT_PURPLE);
		Registry.register(Registries.BLOCK, MOONFLOWER_ID, FloristryBlocks.MOONFLOWER);
		Registry.register(Registries.BLOCK, WITHER_BUSH_ID, FloristryBlocks.WITHER_BUSH);

		Registry.register(Registries.ITEM, HERMIT_PURPLE_ID, FloristryItems.HERMIT_PURPLE_ITEM);
		Registry.register(Registries.ITEM, MOONFLOWER_ID, FloristryItems.MOONFLOWER_ITEM);
		Registry.register(Registries.ITEM, WITHER_BUSH_ID, FloristryItems.WITHER_BUSH_ITEM);
	}
}