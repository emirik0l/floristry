package net.emirikol.floristry.mixin;

import net.emirikol.floristry.FloristryMod;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.minecraft.entity.passive.BeeEntity$PollinateGoal")
public abstract class PollinateGoalMixin {

	// Synthetic field used to access the parent BeeEntity object.
	@Shadow private BeeEntity field_20377;
	private BeeEntity beeEntity = field_20377;

	// Shadow declarations for private methods/fields of PollinateGoal.
	@Shadow protected abstract boolean completedPollination();

	@Inject(method = "stop", at = @At("TAIL"), cancellable = true)
	private void stopPollinating(CallbackInfo info) {
		BlockPos flowerPos = beeEntity.getFlowerPos();
		if (flowerPos != null && this.completedPollination()) {
			Block block = beeEntity.getWorld().getBlockState(flowerPos).getBlock();
			FloristryMod.LOGGER.info("A bee successfully got pollen from: " + block.getName().getString());
		}
	}
}