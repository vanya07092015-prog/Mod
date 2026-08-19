package com.example.mymod.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityVoidProjectile extends EntityThrowable {

    public EntityVoidProjectile(World worldIn) {
        super(worldIn);
    }

    public EntityVoidProjectile(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.entityHit != null) {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 6.0F);
        }
        if (!this.world.isRemote) {
            this.setDead();
        }
    }

    @Override
    protected float getGravityVelocity() {
        return 0.0F; // No gravity, straight shot
    }
}