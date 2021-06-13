package com.alotofletters.gastrolimitalbypass.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.dedicated.DedicatedPlayerManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DedicatedPlayerManager.class)
public class DedicatedPlayerManagerMixin {

	@Inject(method = "canBypassPlayerLimit", at = @At("HEAD"), cancellable = true)
	public void canBypassPlayerLimit(GameProfile profile, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(true);
	}
}
