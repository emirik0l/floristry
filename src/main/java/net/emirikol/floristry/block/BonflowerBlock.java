package net.emirikol.floristry.block;

import net.emirikol.floristry.item.FloristryItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

public class BonflowerBlock extends FlowerBlock implements MagicHoneyProvider {
	public BonflowerBlock(AbstractBlock.Settings settings) {
		super(StatusEffects.NIGHT_VISION, 5.0F, settings.luminance((state) -> 14));
	}

	@Override
	public Item honeyItem() {
		return FloristryItems.BONFLOWER_HONEY;
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
}
