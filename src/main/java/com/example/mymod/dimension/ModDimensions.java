package com.example.mymod.dimension;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {
    public static DimensionType MY_DIMENSION;

    public static void register() {
        MY_DIMENSION = DimensionType.register("MyDimension", "_mydim", 2, WorldProviderMyDim.class, false);
        DimensionManager.registerDimension(2, MY_DIMENSION);
    }
}