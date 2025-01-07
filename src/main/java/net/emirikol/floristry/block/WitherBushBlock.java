package net.emirikol.floristry.block;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class WitherBushBlock extends TallFlowerBlock {
	public WitherBushBlock(AbstractBlock.Settings settings) {
		super(settings);
	}

	@Override
	protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
		return super.canPlantOnTop(floor, world, pos) || floor.isOf(Blocks.NETHERRACK) || floor.isOf(Blocks.SOUL_SAND) || floor.isOf(Blocks.SOUL_SOIL);
	}

	@Override
	public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
		VoxelShape voxelShape = this.getOutlineShape(state, world, pos, ShapeContext.absent());
		Vec3d vec3d = voxelShape.getBoundingBox().getCenter();
		double d = (double)pos.getX() + vec3d.x;
		double e = (double)pos.getZ() + vec3d.z;

		for(int i = 0; i < 3; ++i) {
			if (random.nextBoolean()) {
				world.addParticle(ParticleTypes.SMOKE, d + random.nextDouble() / (double)5.0F, (double)pos.getY() + ((double)0.5F - random.nextDouble()), e + random.nextDouble() / (double)5.0F, 0.0F, 0.0F, 0.0F);
			}
		}

	}

	@Override
	protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		if (world instanceof ServerWorld serverWorld) {
			if (world.getDifficulty() != Difficulty.PEACEFUL && entity instanceof LivingEntity livingEntity) {
				if (!livingEntity.isInvulnerableTo(serverWorld, world.getDamageSources().wither())) {
					livingEntity.addStatusEffect(this.getContactEffect());
				}
			}
		}

	}

	public StatusEffectInstance getContactEffect() {
		return new StatusEffectInstance(StatusEffects.WITHER, 40);
	}
}
