package net.emirikol.floristry.block;

import net.emirikol.floristry.registry.FloristryRegistryKeys;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;

public class FloristryBlocks {
	// Flowers
	public static FlowerBlock AGLAOPHOTIS = new FlowerBlock(StatusEffects.WATER_BREATHING, 7.0F, createFlowerBlockSettings(FloristryRegistryKeys.AGLAOPHOTIS_KEY));
	public static FlowerBlock BLOOMING_THISTLE = new FlowerBlock(StatusEffects.RESISTANCE, 5.0F, createFlowerBlockSettings(FloristryRegistryKeys.BLOOMING_THISTLE_KEY));
	public static BonflowerBlock BONFLOWER = new BonflowerBlock(createFlowerBlockSettings(FloristryRegistryKeys.BONFLOWER_KEY));
	public static FlowerBlock BRANDFLOWER = new FlowerBlock(StatusEffects.NIGHT_VISION, 5.0F, createFlowerBlockSettings(FloristryRegistryKeys.BRANDFLOWER_KEY));
	public static BreezeCloverBlock BREEZE_CLOVER = new BreezeCloverBlock(createFlowerBedBlockSettings(FloristryRegistryKeys.BREEZE_CLOVER_KEY));
	public static FlowerBlock BUBBLEBUD = new FlowerBlock(StatusEffects.WATER_BREATHING, 7.0F, createFlowerBlockSettings(FloristryRegistryKeys.BUBBLEBUD_KEY));
	public static FlowerBlock FALSE_ROSE = new FlowerBlock(StatusEffects.REGENERATION, 5.0F, createFlowerBlockSettings(FloristryRegistryKeys.FALSE_ROSE_KEY));
	public static HearthRoseBlock HEARTH_ROSE = new HearthRoseBlock(createFlowerBlockSettings(FloristryRegistryKeys.HEARTH_ROSE_KEY));
	public static FlowerBlock HERMIT_PURPLE = new FlowerBlock(StatusEffects.NIGHT_VISION, 5.0F, createFlowerBlockSettings(FloristryRegistryKeys.HERMIT_PURPLE_KEY));
	public static TallFlowerBlock MOONFLOWER = new MoonflowerBlock(createTallFlowerBlockSettings(FloristryRegistryKeys.MOONFLOWER_KEY));
	public static FlowerBlock PATINA_FLOWER = new FlowerBlock(StatusEffects.JUMP_BOOST, 5.0F, createFlowerBlockSettings(FloristryRegistryKeys.PATINA_FLOWER_KEY));
	public static FlowerBlock VIRIDELPHIA = new FlowerBlock(StatusEffects.JUMP_BOOST, 5.0F, createFlowerBlockSettings(FloristryRegistryKeys.VIRIDELPHIA_KEY));
	public static WitherBushBlock WITHER_BUSH = new WitherBushBlock(createTallFlowerBlockSettings(FloristryRegistryKeys.WITHER_BUSH_KEY));

	// Flowerpots
	public static FlowerPotBlock POTTED_AGLAOPHOTIS = new FlowerPotBlock(AGLAOPHOTIS, createFlowerPotSettings(FloristryRegistryKeys.POTTED_AGLAOPHOTIS_KEY));
	public static FlowerPotBlock POTTED_BLOOMING_THISTLE = new FlowerPotBlock(BLOOMING_THISTLE, createFlowerPotSettings(FloristryRegistryKeys.POTTED_BLOOMING_THISTLE_KEY));
	public static FlowerPotBlock POTTED_BONFLOWER = new FlowerPotBlock(BONFLOWER, createFlowerPotSettings(FloristryRegistryKeys.POTTED_BONFLOWER_KEY));
	public static FlowerPotBlock POTTED_BRANDFLOWER = new FlowerPotBlock(BRANDFLOWER, createFlowerPotSettings(FloristryRegistryKeys.POTTED_BRANDFLOWER_KEY));
	public static FlowerPotBlock POTTED_BUBBLEBUD = new FlowerPotBlock(BUBBLEBUD, createFlowerPotSettings(FloristryRegistryKeys.POTTED_BUBBLEBUD_KEY));
	public static FlowerPotBlock POTTED_FALSE_ROSE = new FlowerPotBlock(FALSE_ROSE, createFlowerPotSettings(FloristryRegistryKeys.POTTED_FALSE_ROSE_KEY));
	public static FlowerPotBlock POTTED_HERMIT_PURPLE = new FlowerPotBlock(HERMIT_PURPLE, createFlowerPotSettings(FloristryRegistryKeys.POTTED_HERMIT_PURPLE_KEY));
	public static FlowerPotBlock POTTED_PATINA_FLOWER = new FlowerPotBlock(PATINA_FLOWER, createFlowerPotSettings(FloristryRegistryKeys.POTTED_PATINA_FLOWER_KEY));
	public static FlowerPotBlock POTTED_VIRIDELPHIA = new FlowerPotBlock(VIRIDELPHIA, createFlowerPotSettings(FloristryRegistryKeys.POTTED_VIRIDELPHIA_KEY));

	public static Block.Settings createFlowerBlockSettings(RegistryKey<Block> key) {
		return AbstractBlock.Settings.create().registryKey(key).mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY);
	}

	public static Block.Settings createFlowerBedBlockSettings(RegistryKey<Block> key) {
		return AbstractBlock.Settings.create().registryKey(key).mapColor(MapColor.DARK_GREEN).noCollision().sounds(BlockSoundGroup.PINK_PETALS).pistonBehavior(PistonBehavior.DESTROY);
	}

	public static Block.Settings createTallFlowerBlockSettings(RegistryKey<Block> key) {
		return AbstractBlock.Settings.create().registryKey(key).mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY);
	}

	public static Block.Settings createFlowerPotSettings(RegistryKey<Block> key) {
		return Blocks.createFlowerPotSettings().registryKey(key);
	}
}
