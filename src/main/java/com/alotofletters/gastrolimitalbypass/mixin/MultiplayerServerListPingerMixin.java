package com.alotofletters.gastrolimitalbypass.mixin;

import net.minecraft.client.network.MultiplayerServerListPinger;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MultiplayerServerListPinger.class)
public class MultiplayerServerListPingerMixin {

	@Inject(method = "createPlayerCountText", at = @At("HEAD"), cancellable = true)
	private static void createPlayerCountText(int current, int max, CallbackInfoReturnable<Text> cir) {
		if (max == -1) {
			cir.setReturnValue((new LiteralText(Integer.toString(current))).append((new LiteralText("/")).formatted(Formatting.DARK_GRAY)).append("∞").formatted(Formatting.GRAY));
		}
	}
}
