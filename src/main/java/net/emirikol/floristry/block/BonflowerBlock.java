package net.emirikol.floristry.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;

public class BonflowerBlock extends FlowerBlock {
	public BonflowerBlock(AbstractBlock.Settings settings) {
		super(StatusEffects.NIGHT_VISION, 5.0F, settings);
	}
}
