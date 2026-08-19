package com.example.mymod.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
    public static BlockMyPortal MY_PORTAL;
    public static BlockVoidStone VOID_STONE;
    public static BlockVoidOre VOID_ORE;
    public static BlockVoidBlock VOID_BLOCK;

    public static void register() {
        MY_PORTAL = new BlockMyPortal();
        GameRegistry.register(MY_PORTAL);
        GameRegistry.register(new ItemBlock(MY_PORTAL).setRegistryName(MY_PORTAL.getRegistryName()));

        VOID_STONE = new BlockVoidStone();
        GameRegistry.register(VOID_STONE);
        GameRegistry.register(new ItemBlock(VOID_STONE).setRegistryName(VOID_STONE.getRegistryName()));

        VOID_ORE = new BlockVoidOre();
        GameRegistry.register(VOID_ORE);
        GameRegistry.register(new ItemBlock(VOID_ORE).setRegistryName(VOID_ORE.getRegistryName()));

        VOID_BLOCK = new BlockVoidBlock();
        GameRegistry.register(VOID_BLOCK);
        GameRegistry.register(new ItemBlock(VOID_BLOCK).setRegistryName(VOID_BLOCK.getRegistryName()));
    }
}