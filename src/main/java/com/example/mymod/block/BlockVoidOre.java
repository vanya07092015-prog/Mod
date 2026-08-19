package com.example.mymod.block;

import com.example.mymod.item.ModItems;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockVoidOre extends BlockOre {
    public BlockVoidOre() {
        super();
        setUnlocalizedName("void_ore");
        setRegistryName("void_ore");
        setHardness(4.0F);
        setResistance(20.0F);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ModItems.VOID_SHARD;
    }

    @Override
    public int quantityDropped(Random random) {
        return 1 + random.nextInt(2); // 1-2 shards
    }
}