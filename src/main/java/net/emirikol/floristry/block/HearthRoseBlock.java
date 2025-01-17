package net.emirikol.floristry.block;

import net.emirikol.floristry.block.entity.HearthRoseBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class HearthRoseBlock extends FlowerBlock implements BlockEntityProvider {

	public HearthRoseBlock(AbstractBlock.Settings settings) {
		super(StatusEffects.REGENERATION, 5.0F, settings);
	}

	@Override
	public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new HearthRoseBlockEntity(pos, state);
	}

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
		return (type == FloristryBlocks.HEARTH_ROSE_ENTITY) ? HearthRoseBlockEntity::tick : null;
	}
}
