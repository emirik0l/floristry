package net.emirikol.floristry.block;

import net.emirikol.floristry.item.FloristryItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class BreezeCloverBlock extends FlowerbedBlock implements MagicHoneyProvider {
	public BreezeCloverBlock(AbstractBlock.Settings settings) {
		super(settings);
	}

	@Override
	public Item honeyItem() {
		return FloristryItems.BREEZE_HONEY;
	}

	@Override
	public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
		return false;
	}

	@Override
	public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
		VoxelShape voxelShape = this.getOutlineShape(state, world, pos, ShapeContext.absent());
		Vec3d vec3d = voxelShape.getBoundingBox().getCenter();
		double d = (double)pos.getX() + vec3d.x;
		double e = (double)pos.getZ() + vec3d.z;

		for(int i = 0; i < 3; ++i) {
			if (random.nextFloat() <= (0.005F * state.get(FLOWER_AMOUNT))) {
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

		// Bounce proportional to number of flowers.
		if (entity.fallDistance > 0.0 && state.get(FLOWER_AMOUNT) > 1) {
			Vec3d velocity = entity.getVelocity();
			double bounce = (entity instanceof LivingEntity ? (double)1.0F : 0.4) * state.get(FLOWER_AMOUNT) * 0.3;
			entity.setVelocity(velocity.x, bounce, velocity.z);
			entity.velocityModified = true;
			entity.velocityDirty = true;
		}

		// Cancel out velocity.
		entity.fallDistance = 0;
	}
}
