package net.emirikol.floristry.mixin;

import net.emirikol.floristry.FloristryComponents;
import net.emirikol.floristry.component.NectarComponent;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BeehiveBlockEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.minecraft.entity.passive.BeeEntity$EnterHiveGoal")
public abstract class EnterHiveGoalMixin {

	// Synthetic field used to access the parent BeeEntity object.
	@Shadow @Final BeeEntity field_20367;
	private final BeeEntity beeEntity = field_20367;

	@Inject(method = "start", at = @At("TAIL"), cancellable = true)
	public void enterHive(CallbackInfo info) {
		NectarComponent beeNectar = FloristryComponents.NECTAR_SOURCE.get(beeEntity);

		// Retrieve the beehive block entity.
		BlockPos hivePos = beeEntity.getHivePos();
		BeehiveBlockEntity hive = (BeehiveBlockEntity) beeEntity.getWorld().getBlockEntity(hivePos);
		if (hive == null) {
			return;
		}
		NectarComponent hiveNectar = FloristryComponents.NECTAR_SOURCE.get(hive);

		// If the bee doesn't have nectar data, do nothing.
		Block flower = beeNectar.getSource();
		if (flower.equals(Blocks.AIR)) {
			return;
		}

		// Copy data from bee to hive.
		hiveNectar.setSource(flower);
		hive.markDirty();

		// Clear data from bee.
		beeNectar.clearSource();
	}
}
