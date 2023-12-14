/*
    Perspective: LegacyFabric
    Contributor(s): MCLegoMan
    Github: https://github.com/MCLegoMan/Legacy-Perspective
    License: GNU LGPLv3
*/

package com.mclegoman.perspective.legacy.client.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderEffect;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class Shader {
	@Nullable
	public static ShaderEffect postProcessor;
	private static boolean ENABLED;
	public static void tick() throws IOException {
		if (PerspectiveLegacyKeybindings.TOGGLE_SHADER.wasPressed()) {
			toggle();
		}
	}
	public static void toggle() throws IOException {
		ENABLED = !ENABLED;
		if (ENABLED) {
			set();
		} else {
			if (postProcessor != null) {
				postProcessor.disable();
				postProcessor = null;
			}
		}
	}
	public static void set() throws IOException {
		postProcessor = new ShaderEffect(MinecraftClient.getInstance().getTextureManager(), MinecraftClient.getInstance().getResourceManager(), MinecraftClient.getInstance().getFramebuffer(), new Identifier("shaders/post/perspective.json"));
		postProcessor.setupDimensions(MinecraftClient.getInstance().getFramebuffer().viewportWidth, MinecraftClient.getInstance().getFramebuffer().viewportHeight);
	}
	public static boolean shouldRenderShader() {
		return (postProcessor != null && ENABLED);
	}
	public static void render(float tickDelta) {
		if (postProcessor != null) postProcessor.render(tickDelta);
	}
}