package io.github.haykam821.phantompillows;

import com.mojang.serialization.MapCodec;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class PillowBlock extends Block {
	public static final MapCodec<PillowBlock> CODEC = Block.createCodec(PillowBlock::new);

	public PillowBlock(Settings settings) {
		super(settings);
	}

	@Override
	public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float distance) {
		entity.playSound(SoundEvents.BLOCK_WOOL_FALL, 1, 1);
		entity.handleFallDamage(distance, 0, entity.getDamageSources().fall());
	}

	@Override
	public void onEntityLand(BlockView world, Entity entity) {
		if (entity.bypassesLandingEffects()) {
			super.onEntityLand(world, entity);
		} else {
			Vec3d velocity = entity.getVelocity();
			if (velocity.y < 0) {
				double livingModifier = entity instanceof LivingEntity ? 1 : 0.8;
				entity.setVelocity(velocity.x, velocity.y * livingModifier * -0.8, velocity.z);
			}
		}
	}

	@Override
	protected MapCodec<? extends PillowBlock> getCodec() {
		return CODEC;
	}
}
