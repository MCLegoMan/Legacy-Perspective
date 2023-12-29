/*
    Perspective: LegacyFabric
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Legacy-Perspective
    License: GNU LGPLv3
*/

package com.mclegoman.perspective.legacy.client;

import com.mclegoman.perspective.legacy.client.util.Keybindings;
import com.mclegoman.perspective.legacy.client.util.HoldPerspective;
import com.mclegoman.perspective.legacy.client.util.Zoom;
import net.fabricmc.api.ModInitializer;
import net.legacyfabric.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class PerspectiveLegacyClient implements ModInitializer {
	@Override
	public void onInitialize() {
		Keybindings.init();
		ClientTickEvents.END_CLIENT_TICK.register((client) -> {
			Zoom.tick();
			HoldPerspective.tick(client);
		});
	}
}