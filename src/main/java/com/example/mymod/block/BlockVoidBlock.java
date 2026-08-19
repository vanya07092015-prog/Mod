package com.example.mymod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockVoidBlock extends Block {
    public BlockVoidBlock() {
        super(Material.IRON);
        setUnlocalizedName("void_block");
        setRegistryName("void_block");
        setHardness(5.0F);
        setResistance(30.0F);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}