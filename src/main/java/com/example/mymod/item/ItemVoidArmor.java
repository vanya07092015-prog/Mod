package com.example.mymod.item;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemVoidArmor extends ItemArmor {
    public ItemVoidArmor(EntityEquipmentSlot slot) {
        super(ArmorMaterial.DIAMOND, 0, slot);
        String name = "void_" + slot.getName();
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(net.minecraft.creativetab.CreativeTabs.COMBAT);
    }
}