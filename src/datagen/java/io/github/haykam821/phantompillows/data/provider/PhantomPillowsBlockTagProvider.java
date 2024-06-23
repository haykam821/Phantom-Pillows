package io.github.haykam821.phantompillows.data.provider;

import io.github.haykam821.phantompillows.Main;
import io.github.haykam821.phantompillows.block.PhantomPillowsBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

public class PhantomPillowsBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	public PhantomPillowsBlockTagProvider(FabricDataGenerator dataGenerator) {
		super(dataGenerator);
	}

	@Override
	protected void generateTags() {
		this.getOrCreateTagBuilder(PhantomPillowsBlockTags.ELYTRA_CUSHIONING_BLOCKS)
			.add(Main.PHANTOM_PILLOW);
	}
}
