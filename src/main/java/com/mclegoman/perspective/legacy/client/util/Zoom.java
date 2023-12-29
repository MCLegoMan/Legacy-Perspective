/*
    Perspective: LegacyFabric
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Legacy-Perspective
    License: GNU LGPLv3
*/

package com.mclegoman.perspective.legacy.client.util;

import net.minecraft.util.math.MathHelper;

public class Zoom {
	public static int zoomPercentage = 80;
	public static double prevZoomMultiplier;
	public static double zoomMultiplier;
	public static void tick() {
		updateZoomMultiplier();
	}
	public static double getZoomMultiplier(double tickDelta) {
		return prevZoomMultiplier + tickDelta * (zoomMultiplier - prevZoomMultiplier);
	}
	public static void updateZoomMultiplier() {
		prevZoomMultiplier = zoomMultiplier;
		zoomMultiplier += ((Keybindings.ZOOM_KEY.isPressed() ? 1 - ((float) zoomPercentage / 100) : 1) - zoomMultiplier) * 0.5F;
	}

	public static void zoom(boolean in, int amount) {
		for (int i = 0; i < amount; i++){
			if (in) {
				if (!(zoomPercentage >= 100)) {
					zoomPercentage += 1;
				}
			}
			else {
				if (!(zoomPercentage <= 0)) {
					zoomPercentage -= 1;
				}
			}
		}
	}
	public static void reset() {
		if (zoomPercentage != 80) {
			zoomPercentage = 80;
		}
	}
	public static double limitFov(double fov) {
		return MathHelper.clamp(fov, 0.1, 110);
	}
}