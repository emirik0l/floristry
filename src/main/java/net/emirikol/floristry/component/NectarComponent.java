package net.emirikol.floristry.component;

import net.emirikol.floristry.FloristryComponents;
import net.emirikol.floristry.FloristryMod;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import org.ladysnake.cca.api.v3.component.Component;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

public class NectarComponent implements Component, AutoSyncedComponent {
	private final Object provider;
	private Block nectarSource = Blocks.AIR;

	public NectarComponent(Object provider) {
		this.provider = provider;
	}

	public Block getSource() { return this.nectarSource; }

	public void setSource(Block block) {
		this.nectarSource = block;
		FloristryComponents.NECTAR_SOURCE.sync(this.provider);
	}

	public void clearSource() {
		this.nectarSource = Blocks.AIR;
		FloristryComponents.NECTAR_SOURCE.sync(this.provider);
	}

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
