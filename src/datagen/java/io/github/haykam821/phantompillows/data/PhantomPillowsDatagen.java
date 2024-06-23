package io.github.haykam821.phantompillows.data;

import io.github.haykam821.phantompillows.data.provider.PhantomPillowsBlockLootTableProvider;
import io.github.haykam821.phantompillows.data.provider.PhantomPillowsBlockTagProvider;
import io.github.haykam821.phantompillows.data.provider.PhantomPillowsModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class PhantomPillowsDatagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
		dataGenerator.addProvider(PhantomPillowsBlockLootTableProvider::new);
		dataGenerator.addProvider(PhantomPillowsBlockTagProvider::new);
		dataGenerator.addProvider(PhantomPillowsModelProvider::new);
	}
}
