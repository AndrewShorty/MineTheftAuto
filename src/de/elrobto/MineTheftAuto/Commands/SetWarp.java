package de.elrobto.MineTheftAuto.Commands;

import de.elrobto.MineTheftAuto.API.API;
import de.elrobto.MineTheftAuto.Enums.MessageEnum;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SetWarp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p1 = (Player)sender;
            de.elrobto.MineTheftAuto.API.Player p = new de.elrobto.MineTheftAuto.API.Player((Player)sender);

            if(cmd.getName().equalsIgnoreCase("setwarp"))
                if(p.getPlayerData().getRank(p.getUniqueId().toString()).equalsIgnoreCase("ADMIN") || (p.getPlayerData().getRank(p.getUniqueId().toString()).equalsIgnoreCase("DEVELOPER"))) {
                    File file = new File("plugins/GTA", "Spiellocations.yml");
                    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

                    if(args.length == 1) {
                        Location loc = p.getLocation();
                        String name =  args[0].toString();
                        cfg.set(name + ".world", loc.getWorld().getName());
                        cfg.set(name + ".x", (loc.getX()));
                        cfg.set(name + ".y", (loc.getY()));
                        cfg.set(name + ".z", (loc.getZ()));
                        cfg.set(name + ".yaw", (loc.getYaw()));
                        cfg.set(name + ".pitch", (loc.getPitch()));
                        p.sendMessage(MessageEnum.SYSTEM, "§7The Warp §e" + name + " §7was set.");
                        try {
                            cfg.save(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        p.sendMessage(MessageEnum.SYSTEM, "§cError");
                    }
                }
            return true;
        }
        return false;
    }
}