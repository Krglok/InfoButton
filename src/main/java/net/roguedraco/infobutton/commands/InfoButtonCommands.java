package net.roguedraco.infobutton.commands;

import net.roguedraco.infobutton.ActionType;
import net.roguedraco.infobutton.InfoButton;
import net.roguedraco.infobutton.InfoButtons;
import net.roguedraco.lang.Lang;

import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import com.sk89q.minecraft.util.commands.CommandPermissions;

public class InfoButtonCommands {
	@Command(aliases = { "create", "c" }, usage = "", flags = "", desc = "Create an InfoButton", help = "Makes the button/block you are looking at an InfoButton", min = 0, max = 0)
	@CommandPermissions("infobutton.admin.create")
	public static void create(CommandContext args, CommandSender sender)
			throws CommandException {
		Player player = (Player) sender;
		Block block = player.getTargetBlock(null, 200);
		InfoButton ib = new InfoButton(block);
		InfoButtons.addButton(ib);
		sender.sendMessage(Lang.get("commands.addedButton"));
	}

	@Command(aliases = { "addcommand", "pcommand", "apc" }, usage = "", flags = "", desc = "Add a player command", help = "Adds a player command to the InfoButton you are looking at.", min = 0, max = -1)
	@CommandPermissions("infobutton.admin.addcommand")
	public static void addcommand(CommandContext args, CommandSender sender)
			throws CommandException {
		Player player = (Player) sender;
		Block block = player.getTargetBlock(null, 200);
		if (InfoButtons.isButton(block)) {
			InfoButtons.getButton(block).addAction(ActionType.PLAYER_COMMAND,
					args.getJoinedStrings(0));
			sender.sendMessage(Lang.get("commands.addPlayerCommand").replaceAll("%C",args.getJoinedStrings(0)));
		} else {
			sender.sendMessage(Lang.get("exceptions.notInfoButton"));
		}
	}

	@Command(aliases = { "addconsolecommand", "ccommand", "acc" }, usage = "", flags = "", desc = "Add a console command", help = "Adds a console command to the InfoButton you are looking at. (Hint: %player% is the player who pressed the button)", min = 0, max = -1)
	@CommandPermissions("infobutton.admin.addccommand")
	public static void addconsolecommand(CommandContext args,
			CommandSender sender) throws CommandException {
		Player player = (Player) sender;
		Block block = player.getTargetBlock(null, 200);
		if (InfoButtons.isButton(block)) {
			InfoButtons.getButton(block).addAction(ActionType.CONSOLE_COMMAND,
					args.getJoinedStrings(0));
			sender.sendMessage(Lang.get("commands.addConsoleCommand").replaceAll("%C",args.getJoinedStrings(0)));
		} else {
			sender.sendMessage(Lang.get("exceptions.notInfoButton"));
		}
	}

	@Command(aliases = { "addfile", "file", "af" }, usage = "", flags = "", desc = "Add a console command", help = "Adds a console command to the InfoButton you are looking at. (Hint: %player% is the player who pressed the button)", min = 0, max = -1)
	@CommandPermissions("infobutton.admin.addfile")
	public static void addfile(CommandContext args, CommandSender sender)
			throws CommandException {
		Player player = (Player) sender;
		Block block = player.getTargetBlock(null, 200);
		if (InfoButtons.isButton(block)) {
			InfoButtons.getButton(block).addAction(ActionType.FILE_READ,
					args.getJoinedStrings(0));
			sender.sendMessage(Lang.get("commands.addFile").replaceAll("%F",args.getJoinedStrings(0)));
		} else {
			sender.sendMessage(Lang.get("exceptions.notInfoButton"));
		}
	}
	
	@Command(aliases = { "setperm", "perm", "p" }, usage = "", flags = "", desc = "Set the permission for the button", help = "Sets the required permission node to use this button.", min = 0, max = 1)
	@CommandPermissions("infobutton.admin.setperm")
	public static void setperm(CommandContext args, CommandSender sender)
			throws CommandException {
		Player player = (Player) sender;
		Block block = player.getTargetBlock(null, 200);
		if (InfoButtons.isButton(block)) {
			InfoButtons.getButton(block).setPermission(args.getString(0));
			sender.sendMessage(Lang.get("commands.setPerm").replaceAll("%P",args.getString(0)));
		} else {
			sender.sendMessage(Lang.get("exceptions.notInfoButton"));
		}
	}
}
