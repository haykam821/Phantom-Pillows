package io.github.haykam821.phantompillows.block;

import io.github.haykam821.phantompillows.Main;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class PhantomPillowsBlockTags {
	private static final Identifier ELYTRA_CUSHIONING_BLOCKS_ID = new Identifier(Main.MOD_ID, "elytra_cushioning_blocks");
	public static final Tag<Block> ELYTRA_CUSHIONING_BLOCKS = TagFactory.BLOCK.create(ELYTRA_CUSHIONING_BLOCKS_ID);
}
