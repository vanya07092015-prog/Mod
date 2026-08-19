package com.example.mymod.entity;

import com.example.mymod.item.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityVoidBoss extends EntityWither {

    public EntityVoidBoss(World worldIn) {
        super(worldIn);
        this.setCustomNameTag("Void Wither");
        this.setHealth(300.0F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!this.world.isRemote && this.ticksExisted % 40 == 0 && this.getAttackTarget() != null) {
            // Shoot purple projectiles
            EntityVoidProjectile proj = new EntityVoidProjectile(world, this);
            proj.setPosition(this.posX, this.posY + 2, this.posZ);
            proj.shoot(this.getAttackTarget(), 1.5F, 0F, 0F, 1.5F, 1F);
            this.world.spawnEntity(proj);
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        // Can only be damaged by Void Sword
        if (source.getImmediateSource() instanceof EntityLivingBase) {
            EntityLivingBase attacker = (EntityLivingBase) source.getImmediateSource();
            if (attacker.getHeldItemMainhand() != null &&
                attacker.getHeldItemMainhand().getItem() == ModItems.VOID_SWORD) {
                return super.attackEntityFrom(source, amount);
            }
        }
        return false; // Immune to everything else
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_WITHER_AMBIENT;
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        // Drop the special wand on death
        this.entityDropItem(new net.minecraft.item.ItemStack(ModItems.VOID_WAND), 1.0F);
    }
}