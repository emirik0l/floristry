package net.emirikol.floristry.component;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import org.ladysnake.cca.api.v3.component.Component;

public class NectarComponent implements Component {
	private Block nectarSource = Blocks.AIR;

	public Block getSource() { return this.nectarSource; }
	public void setSource(Block block) { this.nectarSource = block; }
	public void resetSource() { this.nectarSource = Blocks.AIR; }

	@Override public void readFromNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registries) {
		String sourceIdStr = tag.getString("nectar_source");
		Identifier sourceId = Identifier.of(sourceIdStr);
		this.nectarSource = Registries.BLOCK.get(sourceId);
	}

	@Override public void writeToNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registries) {
		Identifier sourceId = Registries.BLOCK.getId(this.nectarSource);
		String sourceIdStr = sourceId.toString();
		tag.putString("nectar_source", sourceIdStr);
	}

}
