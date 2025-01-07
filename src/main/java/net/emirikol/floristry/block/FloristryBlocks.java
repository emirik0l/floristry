package net.emirikol.floristry.block;

import net.emirikol.floristry.FloristryMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class FloristryBlocks {
	public static Identifier HERMIT_PURPLE_ID = Identifier.of(FloristryMod.MOD_ID, "hermit_purple");
	public static Identifier WITHER_BUSH_ID = Identifier.of(FloristryMod.MOD_ID, "wither_bush");

	public static RegistryKey<Block> HERMIT_PURPLE_KEY = RegistryKey.of(RegistryKeys.BLOCK, HERMIT_PURPLE_ID);
	public static RegistryKey<Block> WITHER_BUSH_KEY = RegistryKey.of(RegistryKeys.BLOCK, WITHER_BUSH_ID);

	public static FlowerBlock HERMIT_PURPLE = new FlowerBlock(StatusEffects.NIGHT_VISION, 5.0F, AbstractBlock.Settings.create().registryKey(HERMIT_PURPLE_KEY).mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY));
	public static WitherBushBlock WITHER_BUSH = new WitherBushBlock(AbstractBlock.Settings.create().registryKey(WITHER_BUSH_KEY).mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY));
}
