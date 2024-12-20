package io.github.haykam821.phantompillows.data.provider;

import io.github.haykam821.phantompillows.Main;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;

public class PhantomPillowsModelProvider extends FabricModelProvider {
	public PhantomPillowsModelProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator modelGenerator) {
		modelGenerator.registerSimpleCubeAll(Main.PHANTOM_PILLOW);
	}

	@Override
	public void generateItemModels(ItemModelGenerator modelGenerator) {
		return;
	}
}
