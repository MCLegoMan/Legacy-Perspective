/*
    Perspective: LegacyFabric
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Legacy-Perspective
    License: GNU LGPLv3
*/

package com.mclegoman.perspective.legacy.mixin;

import com.mclegoman.perspective.legacy.client.util.PerspectiveLegacyKeybindings;
import com.mclegoman.perspective.legacy.client.util.PerspectiveLegacyZoom;
import net.minecraft.entity.player.PlayerInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerInventory.class)
public class PerspectivePlayerInventoryMixin {
	@Inject(method = "scrollInHotbar", at = @At("HEAD"), cancellable = true)
	private void scrollInHotbar(int scrollAmount, CallbackInfo ci) {
		if (PerspectiveLegacyKeybindings.ZOOM_KEY.isPressed()) {
			if (scrollAmount != 0) {
				PerspectiveLegacyZoom.zoom(scrollAmount > 0, 1);
				ci.cancel();
			}
		}
	}
}