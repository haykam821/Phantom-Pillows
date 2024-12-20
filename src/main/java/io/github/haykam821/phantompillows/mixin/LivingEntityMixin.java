package io.github.haykam821.phantompillows.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

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

	@WrapOperation(method = "checkGlidingCollision", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"))
	private void playCushionedSound(LivingEntity entity, SoundEvent sound, float volume, float pitch, Operation<Void> operation) {
		// Use the wool fall sound when gliding into an elytra cushioning block
		SoundEvent newSound = ElytraCollisionFinder.isNearElytraCushioningBlock(entity) ? SoundEvents.BLOCK_WOOL_FALL : sound;
		operation.call(entity, newSound, volume, pitch);
	}

	@WrapWithCondition(method = "checkGlidingCollision", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;serverDamage(Lnet/minecraft/entity/damage/DamageSource;F)V"))
	private boolean preventCushionedDamage(LivingEntity entity, DamageSource source, float amount) {
		// Prevent damage when gliding into an elytra cushioning block
		return !ElytraCollisionFinder.isNearElytraCushioningBlock(entity);
	}
}
