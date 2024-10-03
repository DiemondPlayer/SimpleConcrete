package net.diemond_player.simpleconcrete;

import net.diemond_player.simpleconcrete.util.SimpleConcreteCauldronBehaviors;
import net.fabricmc.api.ModInitializer;

public class SimpleConcrete implements ModInitializer {
	@Override
	public void onInitialize() {
		SimpleConcreteCauldronBehaviors.registerCauldronBehaviors();
	}
}