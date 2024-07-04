package io.github.haykam821.phantompillows.data.provider;

import io.github.haykam821.phantompillows.Main;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class PhantomPillowsBlockLootTableProvider extends FabricBlockLootTableProvider {
	public PhantomPillowsBlockLootTableProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generate() {
		this.addDrop(Main.PHANTOM_PILLOW);

		this.lootTables.forEach((id, lootTable) -> {
			lootTable.randomSequenceId(id);
		});
	}
}
