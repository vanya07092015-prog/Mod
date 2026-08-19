package com.example.mymod.dimension;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;

import java.util.Random;

public class ChunkGeneratorMyDim implements IChunkGenerator {
    private final World world;
    private final Random rand;
    private final NoiseGeneratorOctaves noiseGen1;

    public ChunkGeneratorMyDim(World worldIn, long seed) {
        this.world = worldIn;
        this.rand = new Random(seed);
        this.noiseGen1 = new NoiseGeneratorOctaves(rand, 16);
    }

    @Override
    public Chunk generateChunk(int x, int z) {
        Chunk chunk = new Chunk(world, x, z);
        Biome biome = Biome.getBiome(1);

        for (int bx = 0; bx < 16; bx++) {
            for (int bz = 0; bz < 16; bz++) {
                chunk.setBiomeArray(bx + bz * 16, (byte) biome.getIdForBiome(biome));

                // Hill generation
                double noise = noiseGen1.generateNoiseOctaves(null, x * 16 + bx, z * 16 + bz, 1, 1, 0.05, 0.05, 0.5)[0];
                int height = 50 + (int) (noise * 20);
                height = Math.max(45, Math.min(75, height));

                for (int y = 0; y < height - 3; y++) {
                    if (rand.nextInt(8) == 0) {
                        chunk.setBlockState(new BlockPos(bx, y, bz), com.example.mymod.block.ModBlocks.VOID_STONE.getDefaultState());
                    } else {
                        chunk.setBlockState(new BlockPos(bx, y, bz), Blocks.STONE.getDefaultState());
                    }
                }
                chunk.setBlockState(new BlockPos(bx, height - 3, bz), Blocks.DIRT.getDefaultState());
                chunk.setBlockState(new BlockPos(bx, height - 2, bz), Blocks.DIRT.getDefaultState());
                chunk.setBlockState(new BlockPos(bx, height - 1, bz), Blocks.GRASS.getDefaultState());
            }
        }
        chunk.generateSkylightMap();
        return chunk;
    }

    @Override
    public void populate(int x, int z) {
        // Генерация Void Ore
        if (rand.nextInt(6) == 0) {
            int oreX = x * 16 + rand.nextInt(16);
            int oreY = 20 + rand.nextInt(30);
            int oreZ = z * 16 + rand.nextInt(16);
            if (world.getBlockState(new net.minecraft.util.math.BlockPos(oreX, oreY, oreZ)).getBlock() == net.minecraft.init.Blocks.STONE) {
                world.setBlockState(new net.minecraft.util.math.BlockPos(oreX, oreY, oreZ), com.example.mymod.block.ModBlocks.VOID_ORE.getDefaultState());
            }
        }

        // Spawn Void Dungeon (rare)
        if (rand.nextInt(40) == 0) {
            int structX = x * 16 + 8;
            int structZ = z * 16 + 8;
            int structY = 55;
            new com.example.mymod.world.gen.StructureVoidDungeon().generate(world, rand,
                    new net.minecraft.util.math.BlockPos(structX, structY, structZ));
        }

        // Spawn Void Boss Dungeon (very rare)
        if (rand.nextInt(80) == 0) {
            int bossX = x * 16 + 8;
            int bossZ = z * 16 + 8;
            int bossY = 55;
            new com.example.mymod.world.gen.StructureVoidBossDungeon().generate(world, rand,
                    new net.minecraft.util.math.BlockPos(bossX, bossY, bossZ));
        }
    }

    @Override
    public boolean generateStructures(Chunk chunkIn, int x, int z) {
        return false;
    }

    @Override
    public java.util.List<net.minecraft.world.biome.Biome.SpawnListEntry> getPossibleCreatures(net.minecraft.entity.EnumCreatureType creatureType, net.minecraft.util.math.BlockPos pos) {
        return java.util.Collections.emptyList();
    }

    @Override
    public net.minecraft.util.math.BlockPos getNearestStructurePos(World worldIn, String structureName, net.minecraft.util.math.BlockPos position, boolean findUnexplored) {
        return null;
    }

    @Override
    public boolean isInsideStructure(World worldIn, String structureName, net.minecraft.util.math.BlockPos pos) {
        return false;
    }

    @Override
    public void recreateStructures(Chunk chunkIn, int x, int z) {}
}