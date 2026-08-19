package com.example.mymod.dimension;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldProviderMyDim extends WorldProvider {
    @Override
    public DimensionType getDimensionType() {
        return ModDimensions.MY_DIMENSION;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkGeneratorMyDim(world, world.getSeed());
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }

    // Purple fog
    @Override
    public net.minecraft.util.math.Vec3d getFogColor(float celestialAngle, float partialTicks) {
        return new net.minecraft.util.math.Vec3d(0.6, 0.2, 0.8); // nice purple
    }

    @Override
    public boolean doesXZShowFog(int x, int z) {
        return true;
    }
}