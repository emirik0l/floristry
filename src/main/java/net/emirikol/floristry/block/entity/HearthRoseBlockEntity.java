package net.emirikol.floristry.block.entity;

import net.emirikol.floristry.FloristryMod;
import net.emirikol.floristry.block.FloristryBlocks;
import net.emirikol.floristry.block.HearthRoseBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class HearthRoseBlockEntity extends BlockEntity {
	public HearthRoseBlockEntity(BlockPos pos, BlockState state) {
		super(FloristryBlocks.HEARTH_ROSE_ENTITY, pos, state);
	}

	public int cureTicks = 0;

	@Override
	protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
		super.writeNbt(nbt, registries);
		nbt.putInt("cure_ticks", cureTicks);
	}

	@Override
	protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
		super.readNbt(nbt, registries);
		cureTicks = nbt.getInt("cure_ticks");
	}

	public static <T extends BlockEntity> void tick(World world, BlockPos blockPos, BlockState blockState, T t) {
		HearthRoseBlockEntity entity = (HearthRoseBlockEntity) world.getBlockEntity(blockPos);
		if (entity == null) { return; }

		// Attempt to cure nearby mobs every 10 seconds.
		if (entity.cureTicks % 200 == 0) {
			cureStatusEffects(world, blockPos);
			entity.cureTicks = 0;
		}

		entity.cureTicks++;
	}

	public static void cureStatusEffects(World world, BlockPos blockPos) {
		int r = FloristryMod.FLOWER_EFFECT_RANGE;

		List<LivingEntity> targets = world.getEntitiesByClass(LivingEntity.class, new Box(blockPos).expand(r,r,r), (entity) -> !entity.getStatusEffects().isEmpty());

		for (LivingEntity target : targets) {
			target.clearStatusEffects();
		}

		// TODO remove only harmful effects
		// TODO add some particles and a sound effect
	}
}
