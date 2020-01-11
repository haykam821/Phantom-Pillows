package io.github.haykam821.phantompillows;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PillowBlock extends Block {
	public PillowBlock(Settings settings) {
		super(settings);
	}

	public void onLandedUpon(World world, BlockPos blockPos, Entity entity, float f) {
		entity.playSound(SoundEvents.BLOCK_WOOL_FALL, 1.0F, 1.0F);
		entity.handleFallDamage(f, 0.0F);
	}
}
