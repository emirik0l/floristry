package net.emirikol.floristry.mixin;

import net.emirikol.floristry.FloristryMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.minecraft.entity.passive.BeeEntity$PollinateGoal")
public abstract class PollinateGoalMixin {
	@Inject(method = "stop", at = @At("TAIL"), cancellable = true)
	private void stopPollinating(CallbackInfo info) {
		FloristryMod.LOGGER.info("A bee stopped pollinating something!");
	}
}