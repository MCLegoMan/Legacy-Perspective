/*
    Perspective: LegacyFabric
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Legacy-Perspective
    License: GNU LGPLv3
*/

package com.mclegoman.perspective.legacy.client.util;

import net.legacyfabric.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;

public class PerspectiveLegacyKeybindings {
	public static final KeyBinding ZOOM_KEY;
	public static final KeyBinding HOLD_PERSPECTIVE_FRONT;
	public static final KeyBinding HOLD_PERSPECTIVE_BACK;
	public static void init() {
	}
	static {
		ZOOM_KEY = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.zoom", 46, "key.categories.misc"));
		HOLD_PERSPECTIVE_FRONT = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.hold_perspective.front", 45, "key.categories.misc"));
		HOLD_PERSPECTIVE_BACK = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.hold_perspective.back", 44, "key.categories.misc"));
	}
}