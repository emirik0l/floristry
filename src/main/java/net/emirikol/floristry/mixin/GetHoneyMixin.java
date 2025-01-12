package net.emirikol.floristry.mixin;

import net.emirikol.floristry.FloristryComponents;
import net.emirikol.floristry.component.NectarComponent;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BeehiveBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BeehiveBlock.class)
public abstract class GetHoneyMixin {

	@Inject(method = "onUseWithItem", at = @At("HEAD"), cancellable = true)
	protected void getHoney(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> info) {
		BeehiveBlockEntity entity = (BeehiveBlockEntity) world.getBlockEntity(pos);
		NectarComponent hiveNectar = FloristryComponents.NECTAR_SOURCE.get(entity);

		// Check whether the nectar in the hive corresponds to any of our "special" flowers; if not, return to vanilla logic.
		// TODO
	}
}
