package net.emirikol.floristry.mixin;

import net.emirikol.floristry.FloristryComponents;
import net.emirikol.floristry.component.NectarComponent;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BeehiveBlockEntity;
import net.minecraft.entity.passive.BeeEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BeeEntity.class)
public abstract class DeliverNectarMixin {
	BeeEntity beeEntity = (BeeEntity) (Object) this;

	// Shadow declarations for private methods/fields of BeeEntity.
	@Shadow	abstract BeehiveBlockEntity getHive();

	@Inject(method = "onHoneyDelivered", at = @At("TAIL"), cancellable = true)
	public void onHoneyDelivered(CallbackInfo info) {
		NectarComponent beeNectar = FloristryComponents.NECTAR_SOURCE.get(beeEntity);

		// Retrieve the beehive block entity.
		BeehiveBlockEntity hive = getHive();
		NectarComponent hiveNectar = FloristryComponents.NECTAR_SOURCE.get(hive);

		// If the bee doesn't have nectar data, do nothing.
		Block flower = beeNectar.getSource();
		if (flower.equals(Blocks.AIR)) {
			return;
		}

		// Copy data from bee to hive.
		hiveNectar.setSource(flower);

		// Clear data from bee.
		beeNectar.clearSource();
	}
}
