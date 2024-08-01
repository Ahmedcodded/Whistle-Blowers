
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.whistleblowers.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.whistleblowers.network.Whistle3Message;
import net.mcreator.whistleblowers.network.Whistle2Message;
import net.mcreator.whistleblowers.network.Whistle1Message;
import net.mcreator.whistleblowers.network.SignalsKeyMessage;
import net.mcreator.whistleblowers.network.NOWMessage;
import net.mcreator.whistleblowers.network.FlirtyWhistleMessage;
import net.mcreator.whistleblowers.network.ClapMessage;
import net.mcreator.whistleblowers.WhistleBlowersMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class WhistleBlowersModKeyMappings {
	public static final KeyMapping WHISTLE_1 = new KeyMapping("key.whistle_blowers.whistle_1", GLFW.GLFW_KEY_UNKNOWN, "key.categories.multiplayer") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WhistleBlowersMod.PACKET_HANDLER.sendToServer(new Whistle1Message(0, 0));
				Whistle1Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping WHISTLE_2 = new KeyMapping("key.whistle_blowers.whistle_2", GLFW.GLFW_KEY_UNKNOWN, "key.categories.multiplayer") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WhistleBlowersMod.PACKET_HANDLER.sendToServer(new Whistle2Message(0, 0));
				Whistle2Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping WHISTLE_3 = new KeyMapping("key.whistle_blowers.whistle_3", GLFW.GLFW_KEY_UNKNOWN, "key.categories.multiplayer") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WhistleBlowersMod.PACKET_HANDLER.sendToServer(new Whistle3Message(0, 0));
				Whistle3Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping FLIRTY_WHISTLE = new KeyMapping("key.whistle_blowers.flirty_whistle", GLFW.GLFW_KEY_UNKNOWN, "key.categories.multiplayer") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WhistleBlowersMod.PACKET_HANDLER.sendToServer(new FlirtyWhistleMessage(0, 0));
				FlirtyWhistleMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping NOW = new KeyMapping("key.whistle_blowers.now", GLFW.GLFW_KEY_UNKNOWN, "key.categories.multiplayer") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WhistleBlowersMod.PACKET_HANDLER.sendToServer(new NOWMessage(0, 0));
				NOWMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping CLAP = new KeyMapping("key.whistle_blowers.clap", GLFW.GLFW_KEY_UNKNOWN, "key.categories.multiplayer") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WhistleBlowersMod.PACKET_HANDLER.sendToServer(new ClapMessage(0, 0));
				ClapMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SIGNALS_KEY = new KeyMapping("key.whistle_blowers.signals_key", GLFW.GLFW_KEY_UNKNOWN, "key.categories.multiplayer") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				WhistleBlowersMod.PACKET_HANDLER.sendToServer(new SignalsKeyMessage(0, 0));
				SignalsKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(WHISTLE_1);
		event.register(WHISTLE_2);
		event.register(WHISTLE_3);
		event.register(FLIRTY_WHISTLE);
		event.register(NOW);
		event.register(CLAP);
		event.register(SIGNALS_KEY);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				WHISTLE_1.consumeClick();
				WHISTLE_2.consumeClick();
				WHISTLE_3.consumeClick();
				FLIRTY_WHISTLE.consumeClick();
				NOW.consumeClick();
				CLAP.consumeClick();
				SIGNALS_KEY.consumeClick();
			}
		}
	}
}
