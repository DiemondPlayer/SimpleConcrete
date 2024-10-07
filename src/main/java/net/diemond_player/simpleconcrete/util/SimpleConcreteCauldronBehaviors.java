package net.diemond_player.simpleconcrete.util;

import net.minecraft.block.Block;
import net.minecraft.block.ConcretePowderBlock;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;

import java.util.List;

import static net.minecraft.block.cauldron.CauldronBehavior.WATER_CAULDRON_BEHAVIOR;

public class SimpleConcreteCauldronBehaviors {
    public static void registerCauldronBehaviors(){
        List<Block> list = Registries.BLOCK.stream().filter(
                block -> block instanceof ConcretePowderBlock).toList();
        for(Block block : list){
            WATER_CAULDRON_BEHAVIOR.map().put(block.asItem(), HARDEN_CONCRETE_POWDER);
        }
    }

    public static final CauldronBehavior HARDEN_CONCRETE_POWDER = (state, world, pos, player, hand, stack) -> {
        if (!world.isClient) {
            ItemStack itemStack = new ItemStack(((IConcretePowderAccessor)((ConcretePowderBlock)((BlockItem)stack.getItem()).getBlock())).simpleConcrete$getHardenedState());
            itemStack.setCount(stack.getCount());
            player.setStackInHand(hand, itemStack);
            player.incrementStat(Stats.USE_CAULDRON);
            LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
        }
        return ActionResult.success(world.isClient);
    };

}
