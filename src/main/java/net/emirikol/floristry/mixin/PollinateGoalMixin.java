package net.emirikol.floristry.mixin;

import net.emirikol.floristry.FloristryMod;
import net.minecraft.block.BlockState;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.minecraft.entity.passive.BeeEntity$PollinateGoal")
public abstract class PollinateGoalMixin {
	@Shadow private BeeEntity field_20377;
	private BeeEntity beeEntity = field_20377;

	@Inject(method = "stop", at = @At("TAIL"), cancellable = true)
	private void stopPollinating(CallbackInfo info) {
		BlockPos flowerPos = beeEntity.getFlowerPos();
		if (flowerPos != null) {
			BlockState blockState = beeEntity.getWorld().getBlockState(flowerPos);
			FloristryMod.LOGGER.info("A bee stopped pollinating a " + blockState.toString() + "!");
		}
	}
}