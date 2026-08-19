package com.example.mymod.item;

import net.minecraft.item.ItemPickaxe;

public class ItemVoidPickaxe extends ItemPickaxe {
    public ItemVoidPickaxe() {
        super(ToolMaterial.DIAMOND);
        setUnlocalizedName("void_pickaxe");
        setRegistryName("void_pickaxe");
        setCreativeTab(net.minecraft.creativetab.CreativeTabs.TOOLS);
    }
}