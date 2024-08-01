
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.whistleblowers.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.whistleblowers.potion.WhistleCooldownMobEffect;
import net.mcreator.whistleblowers.WhistleBlowersMod;

public class WhistleBlowersModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, WhistleBlowersMod.MODID);
	public static final RegistryObject<MobEffect> WHISTLE_COOLDOWN = REGISTRY.register("whistle_cooldown", () -> new WhistleCooldownMobEffect());
}
