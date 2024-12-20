package io.github.haykam821.phantompillows;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class Main implements ModInitializer {
	private static final String MOD_ID = "phantompillows";

	private static final Identifier PILLOW_ID = Main.identifier("pillow");

	private static final Identifier PHANTOM_PILLOW_ID = Main.identifier("phantom_pillow");

	private static final RegistryKey<Block> PHANTOM_PILLOW_BLOCK_KEY = RegistryKey.of(RegistryKeys.BLOCK, PHANTOM_PILLOW_ID);
	public static final Block PHANTOM_PILLOW = new PillowBlock(Block.Settings.copy(Blocks.LIGHT_GRAY_WOOL).registryKey(PHANTOM_PILLOW_BLOCK_KEY));

	private static final RegistryKey<Item> PHANTOM_PILLOW_ITEM_KEY = RegistryKey.of(RegistryKeys.ITEM, PHANTOM_PILLOW_ID);
	public static final BlockItem PHANTOM_PILLOW_ITEM = new BlockItem(PHANTOM_PILLOW, new Item.Settings().registryKey(PHANTOM_PILLOW_ITEM_KEY).useBlockPrefixedTranslationKey());

	@Override
	public void onInitialize() {
		Registry.register(Registries.BLOCK_TYPE, PILLOW_ID, PillowBlock.CODEC);

		Registry.register(Registries.BLOCK, PHANTOM_PILLOW_ID, PHANTOM_PILLOW);
		Registry.register(Registries.ITEM, PHANTOM_PILLOW_ID, PHANTOM_PILLOW_ITEM);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
			entries.addAfter(Items.SCAFFOLDING, PHANTOM_PILLOW_ITEM);
		});

		// Allow phantom pillows to be used as fuel for 100 ticks (5 seconds) of fuel time
		FuelRegistryEvents.BUILD.register((builder, context) -> {
			builder.add(PHANTOM_PILLOW_ITEM, context.baseSmeltTime() / 2);
		});
	}

	public static Identifier identifier(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
