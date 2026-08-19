package com.example.mymod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockVoidStone extends Block {
    public BlockVoidStone() {
        super(Material.ROCK);
        setUnlocalizedName("void_stone");
        setRegistryName("void_stone");
        setHardness(3.0F);
        setResistance(15.0F);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setLightLevel(0.2F); // slight glow for dimension feel
    }
}