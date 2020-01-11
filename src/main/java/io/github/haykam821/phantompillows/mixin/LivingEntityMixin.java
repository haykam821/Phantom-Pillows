package io.github.haykam821.phantompillows.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import io.github.haykam821.phantompillows.Main;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	public LivingEntityMixin(EntityType<?> entityType, World world) {
		super(entityType, world);
	}

	boolean isNearSoftBlock(LivingEntity livingEntity) {
		BlockPos landing = this.getLandingPos();

		if (livingEntity.world.getBlockState(landing.up()).getBlock() == Main.PHANTOM_PILLOW) return true;
		if (livingEntity.world.getBlockState(landing.down()).getBlock() == Main.PHANTOM_PILLOW) return true;

		if (livingEntity.world.getBlockState(landing.north()).getBlock() == Main.PHANTOM_PILLOW) return true;
		if (livingEntity.world.getBlockState(landing.east()).getBlock() == Main.PHANTOM_PILLOW) return true;
		if (livingEntity.world.getBlockState(landing.south()).getBlock() == Main.PHANTOM_PILLOW) return true;
		if (livingEntity.world.getBlockState(landing.west()).getBlock() == Main.PHANTOM_PILLOW) return true;

		return false;
	}

	@Redirect(method = "travel", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;playSound(Lnet/minecraft/sound/SoundEvent;FF)V"))
    private void playSound(LivingEntity livingEntity, SoundEvent sound, float volume, float pitch) {
		if (this.isNearSoftBlock(livingEntity)) {
			super.playSound(SoundEvents.BLOCK_WOOL_FALL, volume, pitch);
		} else {
			super.playSound(sound, volume, pitch);
		}
	}
    @Redirect(method = "travel", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"))
    private boolean damage(LivingEntity livingEntity, DamageSource source, float amount) {
        if (!this.isNearSoftBlock(livingEntity)) {
			return livingEntity.damage(source, amount);
		}
		return false;
    }
}