package io.github.haykam821.phantompillows.block;

import io.github.haykam821.phantompillows.Main;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class PhantomPillowsBlockTags {
	private static final Identifier ELYTRA_CUSHIONING_BLOCKS_ID = new Identifier(Main.MOD_ID, "elytra_cushioning_blocks");
	public static final TagKey<Block> ELYTRA_CUSHIONING_BLOCKS = TagKey.of(Registry.BLOCK_KEY, ELYTRA_CUSHIONING_BLOCKS_ID);
}
