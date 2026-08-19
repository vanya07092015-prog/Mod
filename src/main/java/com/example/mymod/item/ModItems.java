package com.example.mymod.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
    public static ItemVoidShard VOID_SHARD;
    public static ItemVoidIngot VOID_INGOT;

    public static ItemVoidSword VOID_SWORD;
    public static ItemVoidPickaxe VOID_PICKAXE;
    public static ItemVoidArmor VOID_HELMET;
    public static ItemVoidArmor VOID_CHESTPLATE;
    public static ItemVoidArmor VOID_LEGGINGS;
    public static ItemVoidArmor VOID_BOOTS;
    public static ItemVoidWand VOID_WAND;

    public static void register() {
        VOID_SHARD = new ItemVoidShard();
        GameRegistry.register(VOID_SHARD);

        VOID_INGOT = new ItemVoidIngot();
        GameRegistry.register(VOID_INGOT);

        VOID_SWORD = new ItemVoidSword();
        GameRegistry.register(VOID_SWORD);

        VOID_PICKAXE = new ItemVoidPickaxe();
        GameRegistry.register(VOID_PICKAXE);

        VOID_HELMET = new ItemVoidArmor(net.minecraft.inventory.EntityEquipmentSlot.HEAD);
        GameRegistry.register(VOID_HELMET);

        VOID_CHESTPLATE = new ItemVoidArmor(net.minecraft.inventory.EntityEquipmentSlot.CHEST);
        GameRegistry.register(VOID_CHESTPLATE);

        VOID_LEGGINGS = new ItemVoidArmor(net.minecraft.inventory.EntityEquipmentSlot.LEGS);
        GameRegistry.register(VOID_LEGGINGS);

        VOID_BOOTS = new ItemVoidArmor(net.minecraft.inventory.EntityEquipmentSlot.FEET);
        GameRegistry.register(VOID_BOOTS);

        VOID_WAND = new ItemVoidWand();
        GameRegistry.register(VOID_WAND);
    }
}