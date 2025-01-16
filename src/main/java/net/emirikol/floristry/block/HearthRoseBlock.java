package net.emirikol.floristry.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffects;

public class HearthRoseBlock extends FlowerBlock {
	public HearthRoseBlock(AbstractBlock.Settings settings) {
		super(StatusEffects.REGENERATION, 5.0F, settings);
	}
}
