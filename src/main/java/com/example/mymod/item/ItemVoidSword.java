package com.example.mymod.item;

import net.minecraft.item.ItemSword;

public class ItemVoidSword extends ItemSword {
    public ItemVoidSword() {
        super(ToolMaterial.DIAMOND); // strong material
        setUnlocalizedName("void_sword");
        setRegistryName("void_sword");
        setCreativeTab(net.minecraft.creativetab.CreativeTabs.COMBAT);
    }
}