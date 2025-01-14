package net.emirikol.floristry.block;

import net.emirikol.floristry.FloristryMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

public class BreezeCloverBlock extends FlowerbedBlock {
	public BreezeCloverBlock(AbstractBlock.Settings settings) {
		super(settings);
	}

	@Override
	public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
		VoxelShape voxelShape = this.getOutlineShape(state, world, pos, ShapeContext.absent());
		Vec3d vec3d = voxelShape.getBoundingBox().getCenter();
		double d = (double)pos.getX() + vec3d.x;
		double e = (double)pos.getZ() + vec3d.z;

		for(int i = 0; i < 3; ++i) {
			if (random.nextFloat() <= 0.01F) {
				world.addParticle(ParticleTypes.CLOUD, d + random.nextDouble() / (double)5.0F, (double)pos.getY() + ((double)1.0F - random.nextDouble()), e + random.nextDouble() / (double)5.0F, 0.0F, 0.0F, 0.0F);
			}
		}
	}

	@Override
	protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
		// Play a sound.
		if (entity.fallDistance > 2 && world instanceof ServerWorld serverWorld) {
			serverWorld.playSound(null, pos, SoundEvents.BLOCK_SPONGE_FALL, SoundCategory.BLOCKS, 0.5F, 0.8F);
		}

		// Cancel out velocity.
		entity.fallDistance = 0;
	}
}
