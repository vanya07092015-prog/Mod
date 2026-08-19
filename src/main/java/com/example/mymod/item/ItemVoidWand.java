package com.example.mymod.item;

import com.example.mymod.entity.EntityVoidProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ItemVoidWand extends Item {
    public ItemVoidWand() {
        setUnlocalizedName("void_wand");
        setRegistryName("void_wand");
        setMaxStackSize(1);
        setCreativeTab(net.minecraft.creativetab.CreativeTabs.COMBAT);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);

        if (!worldIn.isRemote) {
            EntityVoidProjectile projectile = new EntityVoidProjectile(worldIn, playerIn);
            projectile.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.8F, 1.0F);
            worldIn.spawnEntity(projectile);
            worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ,
                    SoundEvents.ENTITY_ENDERPEARL_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F);
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }
}