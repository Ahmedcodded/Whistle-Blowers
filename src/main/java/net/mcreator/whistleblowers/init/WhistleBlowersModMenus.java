
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.whistleblowers.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.whistleblowers.world.inventory.SignalsGUIMenu;
import net.mcreator.whistleblowers.WhistleBlowersMod;

public class WhistleBlowersModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, WhistleBlowersMod.MODID);
	public static final RegistryObject<MenuType<SignalsGUIMenu>> SIGNALS_GUI = REGISTRY.register("signals_gui", () -> IForgeMenuType.create(SignalsGUIMenu::new));
}
