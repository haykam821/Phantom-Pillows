package io.github.haykam821.phantompillows.block;

import io.github.haykam821.phantompillows.Main;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public final class PhantomPillowsBlockTags {
	public static final TagKey<Block> ELYTRA_CUSHIONING_BLOCKS = of("elytra_cushioning_blocks");

	private PhantomPillowsBlockTags() {
		return;
	}

	private static TagKey<Block> of(String path) {
		return TagKey.of(RegistryKeys.BLOCK, Main.identifier(path));
	}
}
