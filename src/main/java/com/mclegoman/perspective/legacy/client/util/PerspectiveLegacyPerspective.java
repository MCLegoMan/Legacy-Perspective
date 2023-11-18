/*
    Perspective: LegacyFabric
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Legacy-Perspective
    License: GNU LGPLv3
*/

package com.mclegoman.perspective.legacy.client.util;

import net.minecraft.client.MinecraftClient;

public class PerspectiveLegacyPerspective {
	private static boolean BACK_LOCK;
	private static int BACK_PREV;
	private static boolean FRONT_LOCK;
	private static int FRONT_PREV;
	public static void tick(MinecraftClient client) {
		for (int i = 0; i < 2; i++) {
			if (PerspectiveLegacyKeybindings.HOLD_PERSPECTIVE_FRONT.isPressed()) {
				if (!PerspectiveLegacyKeybindings.HOLD_PERSPECTIVE_BACK.isPressed() && !BACK_LOCK) {
					if (!FRONT_LOCK) {
						FRONT_PREV = client.options.perspective;
						if (client.options.perspective == 2) client.options.perspective = 0;
						else client.options.perspective = 2;
					}
					FRONT_LOCK = true;
				}
			}
			if (!PerspectiveLegacyKeybindings.HOLD_PERSPECTIVE_FRONT.isPressed() && FRONT_LOCK) {
				FRONT_LOCK = false;
				client.options.perspective = FRONT_PREV;
			}
			if (PerspectiveLegacyKeybindings.HOLD_PERSPECTIVE_BACK.isPressed()) {
				if (!PerspectiveLegacyKeybindings.HOLD_PERSPECTIVE_FRONT.isPressed() && !FRONT_LOCK) {
					if (!BACK_LOCK) {
						BACK_PREV = client.options.perspective;
						if (client.options.perspective == 1) client.options.perspective = 0;
						else client.options.perspective = 1;
					}
					BACK_LOCK = true;
				}
			}
			if (!PerspectiveLegacyKeybindings.HOLD_PERSPECTIVE_BACK.isPressed() && BACK_LOCK) {
				BACK_LOCK = false;
				client.options.perspective = BACK_PREV;
			}
		}
	}
	public static boolean isHoldingPerspective() {
		return BACK_LOCK || FRONT_LOCK;
	}
}
