
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.whistleblowers.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.whistleblowers.WhistleBlowersMod;

public class WhistleBlowersModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, WhistleBlowersMod.MODID);
	public static final RegistryObject<SoundEvent> CLAP = REGISTRY.register("clap", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("whistle_blowers", "clap")));
	public static final RegistryObject<SoundEvent> WHISTLE1 = REGISTRY.register("whistle1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("whistle_blowers", "whistle1")));
	public static final RegistryObject<SoundEvent> WHISTLE2 = REGISTRY.register("whistle2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("whistle_blowers", "whistle2")));
	public static final RegistryObject<SoundEvent> WHISTLE3 = REGISTRY.register("whistle3", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("whistle_blowers", "whistle3")));
	public static final RegistryObject<SoundEvent> FLIRTY_WHISTLE = REGISTRY.register("flirty_whistle", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("whistle_blowers", "flirty_whistle")));
	public static final RegistryObject<SoundEvent> NOW = REGISTRY.register("now", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("whistle_blowers", "now")));
}
