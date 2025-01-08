package net.emirikol.floristry.block;

import net.emirikol.floristry.registry.FloristryRegistryKeys;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;

public class FloristryBlocks {
	public static FlowerBlock HERMIT_PURPLE = new FlowerBlock(StatusEffects.NIGHT_VISION, 5.0F, createFlowerBlockSettings(FloristryRegistryKeys.HERMIT_PURPLE_KEY));
	public static TallFlowerBlock MOONFLOWER = new TallFlowerBlock(createTallFlowerBlockSettings(FloristryRegistryKeys.MOONFLOWER_KEY));
	public static WitherBushBlock WITHER_BUSH = new WitherBushBlock(createTallFlowerBlockSettings(FloristryRegistryKeys.WITHER_BUSH_KEY));

	public static Block.Settings createFlowerBlockSettings(RegistryKey<Block> key) {
		return AbstractBlock.Settings.create().registryKey(key).mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY);
	}

	public static Block.Settings createTallFlowerBlockSettings(RegistryKey<Block> key) {
		return AbstractBlock.Settings.create().registryKey(key).mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY);
	}
}
