package io.github.haykam821.phantompillows.block;

import io.github.haykam821.phantompillows.Main;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class PhantomPillowsBlockTags {
	private static final Identifier ELYTRA_CUSHIONING_BLOCKS_ID = new Identifier(Main.MOD_ID, "elytra_cushioning_blocks");
	public static final TagKey<Block> ELYTRA_CUSHIONING_BLOCKS = TagKey.of(RegistryKeys.BLOCK, ELYTRA_CUSHIONING_BLOCKS_ID);
}
