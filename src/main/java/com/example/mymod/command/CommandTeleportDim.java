package com.example.mymod.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class CommandTeleportDim extends CommandBase {

    @Override
    public String getName() {
        return "tpdim";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/tpdim <dimension_id>";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length != 1) {
            throw new CommandException("Usage: /tpdim <dimension_id>");
        }

        if (!(sender instanceof EntityPlayer)) {
            throw new CommandException("Only players can use this command");
        }

        EntityPlayer player = (EntityPlayer) sender;
        int dimId;

        try {
            dimId = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            throw new CommandException("Invalid dimension ID");
        }

        if (!player.world.isRemote) {
            player.changeDimension(dimId);
            player.sendMessage(new TextComponentString("Teleported to dimension " + dimId));
        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2; // OP level
    }
}