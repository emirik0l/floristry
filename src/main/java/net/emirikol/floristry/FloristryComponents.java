package net.emirikol.floristry;

import net.emirikol.floristry.component.NectarComponent;
import net.minecraft.block.entity.BeehiveBlockEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.util.Identifier;
import org.ladysnake.cca.api.v3.block.BlockComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.block.BlockComponentInitializer;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;

public class FloristryComponents implements EntityComponentInitializer, BlockComponentInitializer {
	public static final Identifier NECTAR_SOURCE_ID = Identifier.of(FloristryMod.MOD_ID, "nectar_source");
	public static final ComponentKey<NectarComponent> NECTAR_SOURCE = ComponentRegistry.getOrCreate(NECTAR_SOURCE_ID, NectarComponent.class);

	@Override
	public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
		registry.registerFor(BeeEntity.class, NECTAR_SOURCE, NectarComponent::new);
	}

	@Override
	public void registerBlockComponentFactories(BlockComponentFactoryRegistry registry) {
		registry.registerFor(BeehiveBlockEntity.class, NECTAR_SOURCE, NectarComponent::new);
	}
}
