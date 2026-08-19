package com.example.mymod;

import com.example.mymod.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = MyMod.MODID, name = MyMod.NAME, version = MyMod.VERSION)
public class MyMod {
    public static final String MODID = "mymod";
    public static final String NAME = "My Mod";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide = "com.example.mymod.proxy.ClientProxy", serverSide = "com.example.mymod.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        com.example.mymod.dimension.ModDimensions.register();
        com.example.mymod.block.ModBlocks.register();
        com.example.mymod.item.ModItems.register();

        // Register custom zombie
        net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(
                new net.minecraft.util.ResourceLocation("mymod", "void_zombie"),
                com.example.mymod.entity.EntityVoidZombie.class,
                "VoidZombie",
                1,
                this,
                64,
                3,
                true
        );

        // Register Void Boss
        net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(
                new net.minecraft.util.ResourceLocation("mymod", "void_boss"),
                com.example.mymod.entity.EntityVoidBoss.class,
                "VoidBoss",
                2,
                this,
                64,
                3,
                true
        );

        // Register Void Projectile
        net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(
                new net.minecraft.util.ResourceLocation("mymod", "void_projectile"),
                com.example.mymod.entity.EntityVoidProjectile.class,
                "VoidProjectile",
                3,
                this,
                64,
                3,
                true
        );
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        event.registerServerCommand(new com.example.mymod.command.CommandTeleportDim());
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
        net.minecraftforge.fml.common.registry.GameRegistry.addSmelting(
                com.example.mymod.item.ModItems.VOID_SHARD,
                new net.minecraft.item.ItemStack(com.example.mymod.item.ModItems.VOID_INGOT),
                0.7f
        );

        // Крафты из Void Ingot
        net.minecraftforge.fml.common.registry.GameRegistry.addShapedRecipe(
                new net.minecraft.util.ResourceLocation("mymod:void_block"),
                new net.minecraft.util.ResourceLocation("mymod:void"),
                new net.minecraft.item.ItemStack(com.example.mymod.block.ModBlocks.VOID_BLOCK),
                "III", "III", "III",
                'I', com.example.mymod.item.ModItems.VOID_INGOT
        );

        net.minecraftforge.fml.common.registry.GameRegistry.addShapedRecipe(
                new net.minecraft.util.ResourceLocation("mymod:void_sword"),
                new net.minecraft.util.ResourceLocation("mymod:void"),
                new net.minecraft.item.ItemStack(com.example.mymod.item.ModItems.VOID_SWORD),
                " I ", " I ", " S ",
                'I', com.example.mymod.item.ModItems.VOID_INGOT,
                'S', net.minecraft.init.Items.STICK
        );

        net.minecraftforge.fml.common.registry.GameRegistry.addShapedRecipe(
                new net.minecraft.util.ResourceLocation("mymod:void_pickaxe"),
                new net.minecraft.util.ResourceLocation("mymod:void"),
                new net.minecraft.item.ItemStack(com.example.mymod.item.ModItems.VOID_PICKAXE),
                "III", " S ", " S ",
                'I', com.example.mymod.item.ModItems.VOID_INGOT,
                'S', net.minecraft.init.Items.STICK
        );

        // Броня
        net.minecraftforge.fml.common.registry.GameRegistry.addShapedRecipe(
                new net.minecraft.util.ResourceLocation("mymod:void_helmet"),
                new net.minecraft.util.ResourceLocation("mymod:void"),
                new net.minecraft.item.ItemStack(com.example.mymod.item.ModItems.VOID_HELMET),
                "III", "I I", "   ",
                'I', com.example.mymod.item.ModItems.VOID_INGOT
        );

        net.minecraftforge.fml.common.registry.GameRegistry.addShapedRecipe(
                new net.minecraft.util.ResourceLocation("mymod:void_chestplate"),
                new net.minecraft.util.ResourceLocation("mymod:void"),
                new net.minecraft.item.ItemStack(com.example.mymod.item.ModItems.VOID_CHESTPLATE),
                "I I", "III", "III",
                'I', com.example.mymod.item.ModItems.VOID_INGOT
        );

        net.minecraftforge.fml.common.registry.GameRegistry.addShapedRecipe(
                new net.minecraft.util.ResourceLocation("mymod:void_leggings"),
                new net.minecraft.util.ResourceLocation("mymod:void"),
                new net.minecraft.item.ItemStack(com.example.mymod.item.ModItems.VOID_LEGGINGS),
                "III", "I I", "I I",
                'I', com.example.mymod.item.ModItems.VOID_INGOT
        );

        net.minecraftforge.fml.common.registry.GameRegistry.addShapedRecipe(
                new net.minecraft.util.ResourceLocation("mymod:void_boots"),
                new net.minecraft.util.ResourceLocation("mymod:void"),
                new net.minecraft.item.ItemStack(com.example.mymod.item.ModItems.VOID_BOOTS),
                "   ", "I I", "I I",
                'I', com.example.mymod.item.ModItems.VOID_INGOT
        );
    }
}