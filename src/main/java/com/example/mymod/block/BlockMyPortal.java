package com.example.mymod.block;

import com.example.mymod.dimension.ModDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockMyPortal extends Block {
    public BlockMyPortal() {
        super(Material.PORTAL);
        setUnlocalizedName("my_portal");
        setRegistryName("my_portal");
        setHardness( -1.0F);
        setLightLevel(0.75F);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
                                    EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            if (playerIn.dimension != 2) {
                playerIn.changeDimension(2);
            } else {
                playerIn.changeDimension(0);
            }
        }
        return true;
    }
}