package com.example.mymod.world.gen;

import com.example.mymod.block.ModBlocks;
import com.example.mymod.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class StructureVoidDungeon extends WorldGenerator {

    @Override
    public boolean generate(World world, Random rand, BlockPos position) {
        int size = 15; // giant building size
        int height = 8;

        // Build walls and floor (Void Stone)
        for (int x = -size / 2; x <= size / 2; x++) {
            for (int z = -size / 2; z <= size / 2; z++) {
                for (int y = 0; y <= height; y++) {
                    BlockPos pos = position.add(x, y, z);

                    if (y == 0) {
                        // Floor
                        world.setBlockState(pos, ModBlocks.VOID_STONE.getDefaultState());
                    } else if (x == -size / 2 || x == size / 2 || z == -size / 2 || z == size / 2) {
                        // Walls
                        if (y < height) {
                            world.setBlockState(pos, ModBlocks.VOID_STONE.getDefaultState());
                        } else {
                            // Roof
                            world.setBlockState(pos, ModBlocks.VOID_STONE.getDefaultState());
                        }
                    } else if (y == height) {
                        world.setBlockState(pos, ModBlocks.VOID_STONE.getDefaultState());
                    } else {
                        // Inside - air
                        world.setBlockState(pos, Blocks.AIR.getDefaultState());
                    }
                }
            }
        }

        // Place central chest exactly in the middle
        BlockPos chestPos = position.add(0, 1, 0);
        world.setBlockState(chestPos, Blocks.CHEST.getDefaultState());

        // Fill chest with ONE random item
        TileEntityChest chest = (TileEntityChest) world.getTileEntity(chestPos);
        if (chest != null) {
            ItemStack loot = getRandomLoot(rand);
            chest.setInventorySlotContents(13, loot); // center slot
        }

        // Spawn 3-5 Void Zombies (immune to sun)
        for (int i = 0; i < 3 + rand.nextInt(3); i++) {
            com.example.mymod.entity.EntityVoidZombie zombie =
                    new com.example.mymod.entity.EntityVoidZombie(world);
            zombie.setPosition(position.getX() + rand.nextInt(5) - 2,
                    position.getY() + 1,
                    position.getZ() + rand.nextInt(5) - 2);
            world.spawnEntity(zombie);
        }

        return true;
    }

    private ItemStack getRandomLoot(Random rand) {
        int choice = rand.nextInt(6);
        switch (choice) {
            case 0: return new ItemStack(ModItems.VOID_INGOT);
            case 1: return new ItemStack(ModBlocks.VOID_BLOCK);
            case 2: return new ItemStack(ModItems.VOID_SWORD);
            case 3: return new ItemStack(ModItems.VOID_PICKAXE);
            case 4: return new ItemStack(ModItems.VOID_HELMET);
            case 5: return new ItemStack(ModItems.VOID_CHESTPLATE);
            default: return new ItemStack(ModItems.VOID_INGOT);
        }
    }
}