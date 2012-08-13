package net.roguedraco.infobutton.commands;

import org.bukkit.command.CommandSender;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import com.sk89q.minecraft.util.commands.NestedCommand;

public class GeneralCommands {
	@Command(aliases = { "ib", "infobutton" }, desc = "InfoButton commands.")
	@NestedCommand(value = { InfoButtonCommands.class })
	public static void jp(CommandContext args, CommandSender sender) throws CommandException {
	}
}
