package io.github.haykam821.phantompillows.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.haykam821.phantompillows.ElytraCollisionFinder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	public LivingEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	@Redirect(method = "travel", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"))
	private void playSound(LivingEntity entity, SoundEvent sound, float volume, float pitch) {
		if (ElytraCollisionFinder.isNearElytraCushioningBlock(entity)) {
			super.playSound(SoundEvents.BLOCK_WOOL_FALL, volume, pitch);
		} else {
			super.playSound(sound, volume, pitch);
		}
	}

	@Redirect(method = "travel", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"))
	private boolean damage(LivingEntity entity, DamageSource source, float amount) {
		if (!ElytraCollisionFinder.isNearElytraCushioningBlock(entity)) {
			return entity.damage(source, amount);
		}
		return false;
	}
}
