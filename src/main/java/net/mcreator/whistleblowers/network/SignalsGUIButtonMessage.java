
package net.mcreator.whistleblowers.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.whistleblowers.world.inventory.SignalsGUIMenu;
import net.mcreator.whistleblowers.procedures.PlayWhistle3Procedure;
import net.mcreator.whistleblowers.procedures.PlayWhistle2Procedure;
import net.mcreator.whistleblowers.procedures.PlayWhistle1Procedure;
import net.mcreator.whistleblowers.procedures.PlayNOWProcedure;
import net.mcreator.whistleblowers.procedures.PlayFlirtyWhistleProcedure;
import net.mcreator.whistleblowers.procedures.PlayClapProcedure;
import net.mcreator.whistleblowers.WhistleBlowersMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SignalsGUIButtonMessage {
	private final int buttonID, x, y, z;

	public SignalsGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public SignalsGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(SignalsGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(SignalsGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = SignalsGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			PlayClapProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			PlayFlirtyWhistleProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			PlayWhistle1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			PlayWhistle2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			PlayWhistle3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			PlayNOWProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		WhistleBlowersMod.addNetworkMessage(SignalsGUIButtonMessage.class, SignalsGUIButtonMessage::buffer, SignalsGUIButtonMessage::new, SignalsGUIButtonMessage::handler);
	}
}
