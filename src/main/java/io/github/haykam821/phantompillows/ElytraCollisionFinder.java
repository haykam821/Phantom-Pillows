package io.github.haykam821.phantompillows;

import java.util.Optional;

import io.github.haykam821.phantompillows.block.PhantomPillowsBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockCollisionSpliterator;

public final class ElytraCollisionFinder {
	private static final double EPSILON = 0.5;

	private ElytraCollisionFinder() {
		return;
	}

	/**
	 * {@return the nearest block position to the center of an entity that has collision within a specified box}
	 * 
	 * @see net.minecraft.world.WorldAccess#findSupportingBlockPos(Entity, Box)
	 */
	private static Optional<BlockPos> findCollidingBlockPos(Entity entity, Box box) {
		Vec3d entityPos = new Vec3d(entity.getX(), entity.getBodyY(0.5), entity.getZ());

		BlockPos nearestPos = null;
		double nearestDistance = Double.MAX_VALUE;

		BlockCollisionSpliterator<BlockPos> iterator = new BlockCollisionSpliterator<>(entity.getWorld(), entity, box, false, (pos, voxelShape) -> pos);

		while (iterator.hasNext()) {
			BlockPos pos = (BlockPos) iterator.next();
			double distance = pos.getSquaredDistance(entityPos);

			if (distance < nearestDistance || distance == nearestDistance && (nearestPos == null || nearestPos.compareTo(pos) < 0)) {
				nearestPos = pos.toImmutable();
				nearestDistance = distance;
			}
		}

		return Optional.ofNullable(nearestPos);
	}

	public static Optional<BlockPos> getCollidingBlockPos(LivingEntity entity) {
		Box boundingBox = entity.getBoundingBox();
		Box box = boundingBox.expand(EPSILON, 0, EPSILON);

		return findCollidingBlockPos(entity, box);
	}

	public static boolean isNearElytraCushioningBlock(LivingEntity entity) {
		Optional<BlockPos> pos = getCollidingBlockPos(entity);
		if (pos.isEmpty()) return false;

		BlockState state = entity.getWorld().getBlockState(pos.get());
		return state.isIn(PhantomPillowsBlockTags.ELYTRA_CUSHIONING_BLOCKS);
	}
}
