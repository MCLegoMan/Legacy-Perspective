/*
    Perspective: LegacyFabric
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Legacy-Perspective
    License: GNU LGPLv3
*/

package com.mclegoman.perspective.legacy.client.util;

public class PerspectiveLegacyZoom {
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
		zoomMultiplier += ((PerspectiveLegacyKeybindings.ZOOM_KEY.isPressed() ? 1 - ((float) 80 / 100) : 1) - zoomMultiplier) * 0.5F;
	}
}