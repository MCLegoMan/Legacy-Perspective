/*
    Perspective: LegacyFabric
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Legacy-Perspective
    License: GNU LGPLv3
*/

package com.mclegoman.perspective.legacy.mixin;

import com.mclegoman.perspective.legacy.client.util.Keybindings;
import com.mclegoman.perspective.legacy.client.util.Zoom;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
	@Inject(method = "doPick", at = @At("HEAD"), cancellable = true)
	private void resetZoom(CallbackInfo ci) {
		if (Keybindings.ZOOM_KEY.isPressed()) {
			Zoom.reset();
			ci.cancel();
		}
	}
}