package com.alotofletters.gastrolimitalbypass.mixin;

import net.minecraft.server.ServerMetadata;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerMetadata.Players.class)
public class MetadataPlayersMixin {

	@Inject(method = "getPlayerLimit", at = @At("HEAD"), cancellable = true)
	public void getPlayerLimit(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(-1);
	}
}
