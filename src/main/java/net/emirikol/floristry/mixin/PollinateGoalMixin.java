package net.emirikol.floristry.mixin;

import net.emirikol.floristry.FloristryMod;
import net.emirikol.floristry.breeding.Cultivar;
import net.emirikol.floristry.breeding.Cultivars;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.*;

@Mixin(targets = "net.minecraft.entity.passive.BeeEntity$PollinateGoal")
public abstract class PollinateGoalMixin {

	// Synthetic field used to access the parent BeeEntity object.
	@Shadow @Final BeeEntity field_20377;
	private final BeeEntity beeEntity = field_20377;

	// Shadow declarations for private methods/fields of PollinateGoal.
	@Shadow protected abstract boolean completedPollination();

	@Inject(method = "stop", at = @At("TAIL"), cancellable = true)
	private void stopPollinating(CallbackInfo info) {
		BlockPos flowerPos = beeEntity.getFlowerPos();
		if (flowerPos == null) { return; }

		Optional<Block> donor = this.getPollenDonor(flowerPos);
		if (donor.isPresent()) {
			// Iterate through nearby flowers to identify potential cultivars that could produce children.
			// We use a set so that each cultivar is only rolled for once (spamming flowers does nothing).
			Set<Cultivar> candidates = new HashSet<>();
			for (Block nearbyFlower : this.getNearbyFlowers(flowerPos)) {
				Block[] candidateParents = {donor.get(), nearbyFlower};
				List<Cultivar> candidateMatches = Cultivars.getMatches(candidateParents);
				candidates.addAll(candidateMatches);
			}

			// Attempt breeding with established candidates.
			Optional<Cultivar> breedingResult = Cultivars.breedingRoll(new ArrayList<>(candidates));
			if (breedingResult.isPresent()) {
				Cultivar cultivar = breedingResult.get();
				FloristryMod.LOGGER.info("Successful breeding: " + cultivar.toString());
				// TODO - spawning logic
			}
		}
	}

	public Optional<Block> getPollenDonor(BlockPos pos) {
		if (!this.completedPollination()) { return Optional.empty(); }
		return Optional.of(beeEntity.getWorld().getBlockState(pos).getBlock());
	}

	public List<Block> getNearbyFlowers(BlockPos pos) {
		List<Block> output = new ArrayList<>();
		Iterable<BlockPos> iterable = BlockPos.iterateOutwards(pos, FloristryMod.FLOWER_SCAN_RANGE, FloristryMod.FLOWER_SCAN_RANGE, FloristryMod.FLOWER_SCAN_RANGE);
		for (BlockPos curPos : iterable) {
			BlockState blockState = beeEntity.getWorld().getBlockState(curPos);
			if (BeeEntity.isAttractive(blockState)) {
				output.add(blockState.getBlock());
			}
		}
		return output;
	}
}