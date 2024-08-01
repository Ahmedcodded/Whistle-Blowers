package net.mcreator.whistleblowers.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.whistleblowers.world.inventory.SignalsGUIMenu;
import net.mcreator.whistleblowers.network.SignalsGUIButtonMessage;
import net.mcreator.whistleblowers.WhistleBlowersMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SignalsGUIScreen extends AbstractContainerScreen<SignalsGUIMenu> {
	private final static HashMap<String, Object> guistate = SignalsGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_clap;
	Button button_flirty_whistle;
	Button button_1st_whistle;
	Button button_2nd_whistle;
	Button button_3rd_whistle;
	Button button_now;

	public SignalsGUIScreen(SignalsGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 294;
		this.imageHeight = 192;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		button_clap = Button.builder(Component.translatable("gui.whistle_blowers.signals_gui.button_clap"), e -> {
			if (true) {
				WhistleBlowersMod.PACKET_HANDLER.sendToServer(new SignalsGUIButtonMessage(0, x, y, z));
				SignalsGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 110, this.topPos + 2, 72, 20).build();
		guistate.put("button:button_clap", button_clap);
		this.addRenderableWidget(button_clap);
		button_flirty_whistle = Button.builder(Component.translatable("gui.whistle_blowers.signals_gui.button_flirty_whistle"), e -> {
			if (true) {
				WhistleBlowersMod.PACKET_HANDLER.sendToServer(new SignalsGUIButtonMessage(1, x, y, z));
				SignalsGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 218, this.topPos + 56, 72, 20).build();
		guistate.put("button:button_flirty_whistle", button_flirty_whistle);
		this.addRenderableWidget(button_flirty_whistle);
		button_1st_whistle = Button.builder(Component.translatable("gui.whistle_blowers.signals_gui.button_1st_whistle"), e -> {
			if (true) {
				WhistleBlowersMod.PACKET_HANDLER.sendToServer(new SignalsGUIButtonMessage(2, x, y, z));
				SignalsGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 2, this.topPos + 119, 72, 20).build();
		guistate.put("button:button_1st_whistle", button_1st_whistle);
		this.addRenderableWidget(button_1st_whistle);
		button_2nd_whistle = Button.builder(Component.translatable("gui.whistle_blowers.signals_gui.button_2nd_whistle"), e -> {
			if (true) {
				WhistleBlowersMod.PACKET_HANDLER.sendToServer(new SignalsGUIButtonMessage(3, x, y, z));
				SignalsGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 2, this.topPos + 47, 72, 20).build();
		guistate.put("button:button_2nd_whistle", button_2nd_whistle);
		this.addRenderableWidget(button_2nd_whistle);
		button_3rd_whistle = Button.builder(Component.translatable("gui.whistle_blowers.signals_gui.button_3rd_whistle"), e -> {
			if (true) {
				WhistleBlowersMod.PACKET_HANDLER.sendToServer(new SignalsGUIButtonMessage(4, x, y, z));
				SignalsGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 218, this.topPos + 119, 72, 20).build();
		guistate.put("button:button_3rd_whistle", button_3rd_whistle);
		this.addRenderableWidget(button_3rd_whistle);
		button_now = Button.builder(Component.translatable("gui.whistle_blowers.signals_gui.button_now"), e -> {
			if (true) {
				WhistleBlowersMod.PACKET_HANDLER.sendToServer(new SignalsGUIButtonMessage(5, x, y, z));
				SignalsGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 110, this.topPos + 164, 72, 20).build();
		guistate.put("button:button_now", button_now);
		this.addRenderableWidget(button_now);
	}
}
