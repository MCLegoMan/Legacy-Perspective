/*
    Perspective: LegacyFabric
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Legacy-Perspective
    License: GNU LGPLv3
*/

package com.mclegoman.perspective.legacy.mixin;

import com.mclegoman.perspective.legacy.client.util.PerspectiveLegacyPerspective;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class PerspectiveLegacyInGameHud {
	@Inject(method = "render", at = @At("HEAD"), cancellable = true)
	private void render(float tickDelta, CallbackInfo ci) {
		if (PerspectiveLegacyPerspective.isHoldingPerspective()) ci.cancel();
	}
}