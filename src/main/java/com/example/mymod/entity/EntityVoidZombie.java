package com.example.mymod.entity;

import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.world.World;

public class EntityVoidZombie extends EntityZombie {

    public EntityVoidZombie(World worldIn) {
        super(worldIn);
    }

    @Override
    public void onLivingUpdate() {
        if (!this.world.isRemote) {
            // Prevent burning in sunlight
            this.extinguish();
        }
        super.onLivingUpdate();
    }

    @Override
    protected boolean isValidLightLevel() {
        return true; // Can spawn in any light
    }
}