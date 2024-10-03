package net.diemond_player.simpleconcrete.util;

import net.diemond_player.simpleconcrete.SimpleConcrete;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ConcretePowderBlock;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemActionResult;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        return ItemActionResult.success(world.isClient);
    };

}
