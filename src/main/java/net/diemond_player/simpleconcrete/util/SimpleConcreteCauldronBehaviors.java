package net.diemond_player.simpleconcrete.util;

import net.diemond_player.simpleconcrete.SimpleConcrete;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ConcretePowderBlock;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemActionResult;

import static net.minecraft.block.cauldron.CauldronBehavior.WATER_CAULDRON_BEHAVIOR;

public class SimpleConcreteCauldronBehaviors {
    public static void registerCauldronBehaviors(){

        WATER_CAULDRON_BEHAVIOR.map().put(Items.WHITE_CONCRETE_POWDER, HARDEN_CONCRETE_POWDER);
        WATER_CAULDRON_BEHAVIOR.map().put(Items.BLACK_CONCRETE_POWDER, HARDEN_CONCRETE_POWDER);
        WATER_CAULDRON_BEHAVIOR.map().put(Items.BROWN_CONCRETE_POWDER, HARDEN_CONCRETE_POWDER);
        WATER_CAULDRON_BEHAVIOR.map().put(Items.RED_CONCRETE_POWDER, HARDEN_CONCRETE_POWDER);
        WATER_CAULDRON_BEHAVIOR.map().put(Items.BLUE_CONCRETE_POWDER, HARDEN_CONCRETE_POWDER);
        WATER_CAULDRON_BEHAVIOR.map().put(Items.YELLOW_CONCRETE_POWDER, HARDEN_CONCRETE_POWDER);
        WATER_CAULDRON_BEHAVIOR.map().put(Items.LIGHT_GRAY_CONCRETE_POWDER, HARDEN_CONCRETE_POWDER);
        WATER_CAULDRON_BEHAVIOR.map().put(Items.GRAY_CONCRETE_POWDER, HARDEN_CONCRETE_POWDER);
        WATER_CAULDRON_BEHAVIOR.map().put(Items.PINK_CONCRETE_POWDER, HARDEN_CONCRETE_POWDER);
        WATER_CAULDRON_BEHAVIOR.map().put(Items.MAGENTA_CONCRETE_POWDER, HARDEN_CONCRETE_POWDER);
        WATER_CAULDRON_BEHAVIOR.map().put(Items.PURPLE_CONCRETE_POWDER, HARDEN_CONCRETE_POWDER);
        WATER_CAULDRON_BEHAVIOR.map().put(Items.LIGHT_BLUE_CONCRETE_POWDER, HARDEN_CONCRETE_POWDER);
        WATER_CAULDRON_BEHAVIOR.map().put(Items.CYAN_CONCRETE_POWDER, HARDEN_CONCRETE_POWDER);
        WATER_CAULDRON_BEHAVIOR.map().put(Items.ORANGE_CONCRETE_POWDER, HARDEN_CONCRETE_POWDER);
        WATER_CAULDRON_BEHAVIOR.map().put(Items.GREEN_CONCRETE_POWDER, HARDEN_CONCRETE_POWDER);
        WATER_CAULDRON_BEHAVIOR.map().put(Items.LIME_CONCRETE_POWDER, HARDEN_CONCRETE_POWDER);

//        if(SimpleConcrete.DYE_DEPOT){
//            WATER_CAULDRON_BEHAVIOR.map().put(Registries.BLOCK.stream().filter(
//                    block -> Registries.BLOCK.getId(block).equals(Identifier.of(SimpleConcrete.DYE_DEPOT_MOD_ID, "mint_concrete_powder"))).findFirst().get().asItem(), HARDEN_CONCRETE_POWDER);
//        }
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
