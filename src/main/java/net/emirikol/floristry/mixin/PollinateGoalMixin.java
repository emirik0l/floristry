package net.emirikol.floristry.mixin;

import net.emirikol.floristry.FloristryMod;
import net.emirikol.floristry.breeding.Cultivar;
import net.emirikol.floristry.breeding.Cultivars;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.*;

import static net.minecraft.block.TallPlantBlock.HALF;

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
			FloristryMod.logInfo("Bee got pollen from a " + donor.get().getName().getString());

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
				FloristryMod.logInfo("Breeding successful! Cultivar: " + cultivar.toString());
				this.attemptFlowerPlacement(flowerPos, cultivar);
			}
		}
	}

	public Optional<Block> getPollenDonor(BlockPos pos) {
		if (!this.completedPollination()) { return Optional.empty(); }
		return Optional.of(beeEntity.getWorld().getBlockState(pos).getBlock());
	}

	public List<Block> getNearbyFlowers(BlockPos startPos) {
		List<Block> output = new ArrayList<>();
		Iterable<BlockPos> iterable = BlockPos.iterateOutwards(startPos, FloristryMod.FLOWER_SCAN_RANGE, FloristryMod.FLOWER_SCAN_RANGE, FloristryMod.FLOWER_SCAN_RANGE);
		for (BlockPos curPos : iterable) {
			// Self-loving is not permitted.
			if (areSameFlower(curPos, startPos)) { continue; }

			BlockState blockState = beeEntity.getWorld().getBlockState(curPos);
			if (BeeEntity.isAttractive(blockState)) {
				output.add(blockState.getBlock());
			}
		}
		return output;
	}

	public boolean areSameFlower(BlockPos left, BlockPos right) {
		boolean samePos = left.equals(right);
		boolean tallPlant = left.up().equals(right) || right.up().equals(left);

		return samePos || tallPlant;
	}

	public void attemptFlowerPlacement(BlockPos startPos, Cultivar cultivar) {
		Iterable<BlockPos> iterable = BlockPos.iterateOutwards(startPos, FloristryMod.FLOWER_PLACE_RANGE, FloristryMod.FLOWER_PLACE_RANGE, FloristryMod.FLOWER_PLACE_RANGE);
		for (BlockPos curPos : iterable) {
			BlockState blockState = beeEntity.getWorld().getBlockState(curPos);
			if (this.isValidPlacementBlock(curPos, blockState)) {
				Block child = cultivar.getChild();
				if (child instanceof TallPlantBlock tallChild) {
					FloristryMod.logInfo("Placing a tall plant: " + child.getName().getString());
					BlockState lowerBlockState = tallChild.getDefaultState().with(HALF, DoubleBlockHalf.LOWER);
					BlockState upperBlockState = tallChild.getDefaultState().with(HALF, DoubleBlockHalf.UPPER);
					beeEntity.getWorld().setBlockState(curPos.up(1), lowerBlockState);
					beeEntity.getWorld().setBlockState(curPos.up(2), upperBlockState);
					return;
 				}
				if (child instanceof PlantBlock) {
					FloristryMod.logInfo("Placing a normal plant: " + child.getName().getString());
					BlockState childBlockState = child.getDefaultState();
					beeEntity.getWorld().setBlockState(curPos.up(), childBlockState);
					return;
				}
			}
		}
	}

	public boolean isValidPlacementBlock(BlockPos pos, BlockState blockState) {
		boolean isDirt = blockState.isIn(BlockTags.DIRT);

		BlockState upOne = beeEntity.getWorld().getBlockState(pos.up(1));
		BlockState upTwo = beeEntity.getWorld().getBlockState(pos.up(2));
		boolean hasSpace = upOne.isAir() && upTwo.isAir();

		return isDirt && hasSpace;
	}
}