package net.emirikol.floristry.block;

import net.emirikol.floristry.FloristryMod;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class FloristryBlocks {
	public static Identifier HERMIT_PURPLE_ID = Identifier.of(FloristryMod.MOD_ID, "hermit_purple");
	public static Identifier MOONFLOWER_ID = Identifier.of(FloristryMod.MOD_ID, "moonflower");
	public static Identifier WITHER_BUSH_ID = Identifier.of(FloristryMod.MOD_ID, "wither_bush");

	public static RegistryKey<Block> HERMIT_PURPLE_KEY = RegistryKey.of(RegistryKeys.BLOCK, HERMIT_PURPLE_ID);
	public static RegistryKey<Block> MOONFLOWER_KEY = RegistryKey.of(RegistryKeys.BLOCK, MOONFLOWER_ID);
	public static RegistryKey<Block> WITHER_BUSH_KEY = RegistryKey.of(RegistryKeys.BLOCK, WITHER_BUSH_ID);

	public static FlowerBlock HERMIT_PURPLE = new FlowerBlock(StatusEffects.NIGHT_VISION, 5.0F, createFlowerBlockSettings(HERMIT_PURPLE_KEY));
	public static TallFlowerBlock MOONFLOWER = new TallFlowerBlock(createTallFlowerBlockSettings(MOONFLOWER_KEY));
	public static WitherBushBlock WITHER_BUSH = new WitherBushBlock(createTallFlowerBlockSettings(WITHER_BUSH_KEY));

	public static Block.Settings createFlowerBlockSettings(RegistryKey<Block> key) {
		return AbstractBlock.Settings.create().registryKey(key).mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY);
	}

	public static Block.Settings createTallFlowerBlockSettings(RegistryKey<Block> key) {
		return AbstractBlock.Settings.create().registryKey(key).mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY);
	}
}
