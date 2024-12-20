package io.github.haykam821.phantompillows.data.provider;

import java.util.concurrent.CompletableFuture;

import io.github.haykam821.phantompillows.Main;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

public class PhantomPillowsBlockLootTableProvider extends FabricBlockLootTableProvider {
	public PhantomPillowsBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registries) {
		super(dataOutput, registries);
	}

	@Override
	public void generate() {
		this.addDrop(Main.PHANTOM_PILLOW);

		this.lootTables.forEach((key, lootTable) -> {
			lootTable.randomSequenceId(key.getValue());
		});
	}
}
