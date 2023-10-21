/*
    Perspective: LegacyFabric
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Legacy-Perspective
    License: GNU LGPLv3
*/

package com.mclegoman.perspective.legacy.mixin;

import com.mclegoman.perspective.legacy.client.util.PerspectiveLegacyZoom;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public class PerspectiveLegacyGameRenderer {
	@Inject(method = "getFov", at = @At("RETURN"), cancellable = true)
	private void getFov(float tickDelta, boolean changingFov, CallbackInfoReturnable<Float> cir) {
		double f = cir.getReturnValue();
		f *= PerspectiveLegacyZoom.getZoomMultiplier(tickDelta);
		cir.setReturnValue((float)f);
	}
}