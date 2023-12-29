/*
    Perspective: LegacyFabric
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Legacy-Perspective
    License: GNU LGPLv3
*/

package com.mclegoman.perspective.legacy.mixin;

import com.mclegoman.perspective.legacy.client.util.Keybindings;
import com.mclegoman.perspective.legacy.client.util.Zoom;
import net.minecraft.entity.player.PlayerInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerInventory.class)
public class PlayerInventoryMixin {
	@Inject(method = "scrollInHotbar", at = @At("HEAD"), cancellable = true)
	private void adjustZoom(int scrollAmount, CallbackInfo ci) {
		if (Keybindings.ZOOM_KEY.isPressed()) {
			if (scrollAmount != 0) {
				Zoom.zoom(scrollAmount > 0, 1);
				ci.cancel();
			}
		}
	}
}