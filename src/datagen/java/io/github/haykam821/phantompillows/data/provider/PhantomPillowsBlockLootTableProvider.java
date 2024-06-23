package io.github.haykam821.phantompillows.data.provider;

import io.github.haykam821.phantompillows.Main;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class PhantomPillowsBlockLootTableProvider extends FabricBlockLootTableProvider {
	public PhantomPillowsBlockLootTableProvider(FabricDataGenerator dataGenerator) {
		super(dataGenerator);
	}

	@Override
	protected void generateBlockLootTables() {
		this.addDrop(Main.PHANTOM_PILLOW);
	}
}
