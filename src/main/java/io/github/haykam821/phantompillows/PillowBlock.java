package io.github.haykam821.phantompillows;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class PillowBlock extends Block {
	public PillowBlock(Settings settings) {
		super(settings);
	}

	public void onLandedUpon(World world, BlockPos blockPos, Entity entity, float f) {
		entity.playSound(SoundEvents.BLOCK_WOOL_FALL, 1.0F, 1.0F);
		entity.handleFallDamage(f, 0.0F);
	}

	public void onEntityLand(BlockView blockView, Entity entity) {
		if (entity.bypassesLandingEffects()) {
			super.onEntityLand(blockView, entity);
		} else {
			Vec3d vec3d = entity.getVelocity();
			if (vec3d.y < 0.0D) {
				double livingModifier = entity instanceof LivingEntity ? 1.0D : 0.8D;
				entity.setVelocity(vec3d.x, vec3d.y * livingModifier * -0.8, vec3d.z);
			}
		}

	}
}
