/*
    Perspective: LegacyFabric
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Legacy-Perspective
    License: GNU LGPLv3
*/

package com.mclegoman.perspective.legacy.client;

import com.mclegoman.perspective.legacy.client.util.PerspectiveLegacyKeybindings;
import com.mclegoman.perspective.legacy.client.util.PerspectiveLegacyPerspective;
import com.mclegoman.perspective.legacy.client.util.PerspectiveLegacyZoom;
import net.fabricmc.api.ModInitializer;
import net.legacyfabric.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import org.lwjgl.input.Mouse;

public class PerspectiveLegacyClient implements ModInitializer {
	@Override
	public void onInitialize() {
		PerspectiveLegacyKeybindings.init();
		ClientTickEvents.END_CLIENT_TICK.register((client) -> {
			PerspectiveLegacyZoom.tick();
			PerspectiveLegacyPerspective.tick(client);
			if (Mouse.hasWheel()) {
				if (Mouse.isButtonDown(2)) PerspectiveLegacyZoom.reset();
			}
		});
	}
}