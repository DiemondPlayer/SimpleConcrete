package net.diemond_player.simpleconcrete;

import net.diemond_player.simpleconcrete.util.SimpleConcreteCauldronBehaviors;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleConcrete implements ModInitializer {
	public static final String MOD_ID = "simpleconcrete";
//	public static final String DYE_DEPOT_MOD_ID = "dye_depot";
//	public static final boolean DYE_DEPOT = FabricLoader.getInstance().isModLoaded(DYE_DEPOT_MOD_ID);


	@Override
	public void onInitialize() {
		SimpleConcreteCauldronBehaviors.registerCauldronBehaviors();
	}
}