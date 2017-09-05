package de.elrobto.MineTheftAuto.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.elrobto.MineTheftAuto.API.API;
import de.elrobto.MineTheftAuto.Listener.JoinQuitListener;

public class Language implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(API.GERMAN_prefixerror + "NOPLAYER547");
		}
		
		Player player = (Player)sender;
		
		JoinQuitListener.initLanguage(player);
		
		return false;
	}
}