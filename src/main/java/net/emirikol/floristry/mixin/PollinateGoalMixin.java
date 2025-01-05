package net.emirikol.floristry.mixin;

import net.emirikol.floristry.FloristryMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(targets = "net.minecraft.entity.passive.BeeEntity$PollinateGoal")
public abstract class PollinateGoalMixin {

	// Synthetic field used to access the parent BeeEntity object.
	@Shadow private BeeEntity field_20377;
	private BeeEntity beeEntity = field_20377;

	// Shadow declarations for private methods/fields of PollinateGoal.
	@Shadow protected abstract boolean completedPollination();

	@Inject(method = "stop", at = @At("TAIL"), cancellable = true)
	private void stopPollinating(CallbackInfo info) {
		Block donor = this.getPollenDonor();
		if (donor != null) {
			FloristryMod.LOGGER.info("A bee successfully got pollen from: " + donor.getName().getString());
			List<Block> nearbyFlowers = this.getNearbyFlowers();
			for (Block nearbyFlower : nearbyFlowers) {
				FloristryMod.LOGGER.info("\tNearby flower: " + nearbyFlower.getName().getString());
			}
		}
	}

	public Block getPollenDonor() {
		BlockPos flowerPos = beeEntity.getFlowerPos();
		if (flowerPos == null || !this.completedPollination()) { return null; }
		return beeEntity.getWorld().getBlockState(flowerPos).getBlock();
	}

	public List<Block> getNearbyFlowers() {
		List<Block> output = new ArrayList<Block>();
		Iterable<BlockPos> iterable = BlockPos.iterateOutwards(beeEntity.getBlockPos(), FloristryMod.FLOWER_SCAN_RANGE, FloristryMod.FLOWER_SCAN_RANGE, FloristryMod.FLOWER_SCAN_RANGE);
		for (BlockPos pos : iterable) {
			BlockState blockState = beeEntity.getWorld().getBlockState(pos);
			if (BeeEntity.isAttractive(blockState)) {
				output.add(blockState.getBlock());
			}
		}
		return output;
	}
}