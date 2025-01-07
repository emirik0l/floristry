package net.emirikol.floristry.block;

import net.emirikol.floristry.FloristryMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class FloristryBlocks {
	public static Identifier WITHER_BUSH_ID = Identifier.of(FloristryMod.MOD_ID, "wither_bush");

	public static RegistryKey<Block> WITHER_BUSH_KEY = RegistryKey.of(RegistryKeys.BLOCK, WITHER_BUSH_ID);

	public static WitherBushBlock WITHER_BUSH = new WitherBushBlock(AbstractBlock.Settings.create().registryKey(WITHER_BUSH_KEY).mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).burnable().pistonBehavior(PistonBehavior.DESTROY));
}
