package net.diemond_player.simpleconcrete.mixin;

import net.diemond_player.simpleconcrete.util.IConcretePowderAccessor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ConcretePowderBlock;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ConcretePowderBlock.class)
public abstract class ConcretePowderBlockMixin implements IConcretePowderAccessor {

	@Shadow @Final private BlockState hardenedState;

	@Override
	public BlockState simpleConcrete$getHardenedState() {
		return hardenedState;
	}
}