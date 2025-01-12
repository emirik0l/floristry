package net.emirikol.floristry.mixin;

import net.emirikol.floristry.FloristryComponents;
import net.emirikol.floristry.block.MagicHoneyProvider;
import net.emirikol.floristry.component.NectarComponent;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.entity.BeehiveBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.block.BeehiveBlock.HONEY_LEVEL;

@Mixin(BeehiveBlock.class)
public abstract class GetHoneyMixin {
	@Shadow protected abstract boolean hasBees(World world, BlockPos pos);
	@Shadow protected abstract void angerNearbyBees(World world, BlockPos pos);
	@Shadow public abstract void takeHoney(World world, BlockState state, BlockPos pos);
	@Shadow public abstract void takeHoney(World world, BlockState state, BlockPos pos, @Nullable PlayerEntity player, BeehiveBlockEntity.BeeState beeState);

	@Inject(method = "onUseWithItem", at = @At("HEAD"), cancellable = true)
	protected void getHoney(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> info) {
		BeehiveBlockEntity entity = (BeehiveBlockEntity) world.getBlockEntity(pos);
		NectarComponent hiveNectar = FloristryComponents.NECTAR_SOURCE.get(entity);

		// Check whether the nectar in the hive corresponds to any of our "special" flowers; if not, redirect to vanilla logic.
		Block nectarSource = hiveNectar.getSource();
		if(!(nectarSource instanceof MagicHoneyProvider)) { return; }
		Item honey = ((MagicHoneyProvider) nectarSource).honeyItem();

		// Check whether the hive is full of honey and the player is using an empty bottle; if not, redirect to vanilla logic.
		int honeyLevel = state.get(HONEY_LEVEL);
		if (honeyLevel < 5) { return; }
		if (!stack.isOf(Items.GLASS_BOTTLE)) { return; }

		// This logic is copied directly from BeehiveBlock and may need to be adjusted for future versions of Minecraft.
		stack.decrement(1);
		world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);

		if (stack.isEmpty()) {
			player.setStackInHand(hand, new ItemStack(honey));
		} else if (!player.getInventory().insertStack(new ItemStack(honey))) {
			player.dropItem(new ItemStack(honey), false);
		}

		if (!CampfireBlock.isLitCampfireInRange(world, pos)) {
			if (this.hasBees(world, pos)) {
				this.angerNearbyBees(world, pos);
			}
			this.takeHoney(world, state, pos, player, BeehiveBlockEntity.BeeState.EMERGENCY);
		} else {
			this.takeHoney(world, state, pos);
		}

		world.emitGameEvent(player, GameEvent.FLUID_PICKUP, pos);
		if (world.isClient()) {  player.incrementStat(Stats.USED.getOrCreateStat(stack.getItem())); }

		// Cancel the rest of the onUseWithItem() function and return early.
		info.setReturnValue(ActionResult.SUCCESS);
	}
}
