package io.github.haykam821.phantompillows.data.provider;

import java.util.concurrent.CompletableFuture;

import io.github.haykam821.phantompillows.Main;
import io.github.haykam821.phantompillows.block.PhantomPillowsBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;

public class PhantomPillowsBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	public PhantomPillowsBlockTagProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registries) {
		super(dataOutput, registries);
	}

	@Override
	protected void configure(WrapperLookup lookup) {
		this.getOrCreateTagBuilder(PhantomPillowsBlockTags.ELYTRA_CUSHIONING_BLOCKS)
			.add(Main.PHANTOM_PILLOW);
	}
}
