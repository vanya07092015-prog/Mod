package com.example.mymod.world.gen;

import com.example.mymod.block.ModBlocks;
import com.example.mymod.entity.EntityVoidBoss;
import com.example.mymod.entity.EntityVoidZombie;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class StructureVoidBossDungeon extends WorldGenerator {

    @Override
    public boolean generate(World world, Random rand, BlockPos position) {
        // 3-room structure: 2 zombie rooms + 1 boss room
        int roomSize = 9;
        int roomHeight = 6;

        // Room 1 (zombies)
        buildRoom(world, position.add(-roomSize - 3, 0, 0), roomSize, roomHeight);
        spawnZombies(world, position.add(-roomSize / 2 - 3, 1, 0), 4, rand);

        // Corridor
        buildCorridor(world, position.add(-3, 1, 0), 6);

        // Room 2 (zombies)
        buildRoom(world, position.add(3, 0, 0), roomSize, roomHeight);
        spawnZombies(world, position.add(3 + roomSize / 2, 1, 0), 4, rand);

        // Corridor to boss
        buildCorridor(world, position.add(roomSize + 3, 1, 0), 6);

        // Room 3 - Boss room
        BlockPos bossRoom = position.add(roomSize * 2 + 6, 0, 0);
        buildRoom(world, bossRoom, roomSize, roomHeight);

        // Spawn the boss in the center of the last room
        EntityVoidBoss boss = new EntityVoidBoss(world);
        boss.setPosition(bossRoom.getX() + roomSize / 2, bossRoom.getY() + 1, bossRoom.getZ() + roomSize / 2);
        world.spawnEntity(boss);

        return true;
    }

    private void buildRoom(World world, BlockPos start, int size, int height) {
        for (int x = 0; x < size; x++) {
            for (int z = 0; z < size; z++) {
                for (int y = 0; y <= height; y++) {
                    BlockPos pos = start.add(x, y, z);
                    if (y == 0 || y == height) {
                        world.setBlockState(pos, ModBlocks.VOID_STONE.getDefaultState());
                    } else if (x == 0 || x == size - 1 || z == 0 || z == size - 1) {
                        world.setBlockState(pos, ModBlocks.VOID_STONE.getDefaultState());
                    } else {
                        world.setBlockState(pos, Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
    }

    private void buildCorridor(World world, BlockPos start, int length) {
        for (int i = 0; i < length; i++) {
            world.setBlockState(start.add(i, 0, 0), ModBlocks.VOID_STONE.getDefaultState());
            world.setBlockState(start.add(i, 3, 0), ModBlocks.VOID_STONE.getDefaultState());
            world.setBlockState(start.add(i, 1, -1), ModBlocks.VOID_STONE.getDefaultState());
            world.setBlockState(start.add(i, 1, 1), ModBlocks.VOID_STONE.getDefaultState());
            world.setBlockState(start.add(i, 2, -1), ModBlocks.VOID_STONE.getDefaultState());
            world.setBlockState(start.add(i, 2, 1), ModBlocks.VOID_STONE.getDefaultState());
        }
    }

    private void spawnZombies(World world, BlockPos center, int count, Random rand) {
        for (int i = 0; i < count; i++) {
            EntityVoidZombie zombie = new EntityVoidZombie(world);
            zombie.setPosition(center.getX() + rand.nextInt(5) - 2,
                    center.getY(),
                    center.getZ() + rand.nextInt(5) - 2);
            world.spawnEntity(zombie);
        }
    }
}