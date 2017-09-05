package de.elrobto.MineTheftAuto.Commands;

import de.elrobto.MineTheftAuto.API.Player;
import de.elrobto.MineTheftAuto.Enums.MessageEnum;
import de.elrobto.MineTheftAuto.Listener.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import de.elrobto.MineTheftAuto.API.API;
import de.elrobto.MineTheftAuto.MySQL.PlayerDatabase;

public class Edit implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof org.bukkit.entity.Player)) {
			sender.sendMessage(API.GERMAN_prefixerror + "NOPLAYER547");
		}

		Player p = new Player((org.bukkit.entity.Player)sender);
		
		if(p.getPlayerData().getRank(p.getUniqueId().toString()).equalsIgnoreCase("ADMIN")) {
			p.sendMessage(MessageEnum.SYSTEM, "§cThis Function is currently not avaiable.");
		} else {
			p.sendMessage(MessageEnum.SYSTEM, "§cNo Permissions.");
		}
		
		return false;
	}
}