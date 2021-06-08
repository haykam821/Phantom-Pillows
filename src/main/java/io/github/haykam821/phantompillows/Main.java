package io.github.haykam821.phantompillows;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Main implements ModInitializer {
	public static final String MOD_ID = "phantompillows";

	private static final Identifier PHANTOM_PILLOW_ID = new Identifier(MOD_ID, "phantom_pillow");
	public static final Block PHANTOM_PILLOW = new PillowBlock(FabricBlockSettings.copy(Blocks.LIGHT_GRAY_WOOL));
	public static final BlockItem PHANTOM_PILLOW_ITEM = new BlockItem(PHANTOM_PILLOW, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));

	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, PHANTOM_PILLOW_ID, PHANTOM_PILLOW);
		Registry.register(Registry.ITEM, PHANTOM_PILLOW_ID, PHANTOM_PILLOW_ITEM);

		// Allow phantom pillows to be used as fuel for 100 ticks (5 seconds) of fuel time
		FuelRegistry.INSTANCE.add(PHANTOM_PILLOW_ITEM, 100);
	}
}
