package de.elrobto.MineTheftAuto.Listener;

import de.elrobto.MineTheftAuto.API.API;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.io.File;

/**
 * Created by elrobto on 22.05.2017.
 */
public class SignChange implements Listener {

    @EventHandler
    public void onSignChange(SignChangeEvent e) {
        Player p = e.getPlayer();
        if ((e.getLine(0).equalsIgnoreCase("[Warp]")) || ((e.getLine(0).equalsIgnoreCase("[JnR]")) || ((e.getLine(0).equalsIgnoreCase("Jump and Run")) || ((e.getLine(0).equalsIgnoreCase("TELEPORT")))))) {
            if (p.hasPermission("Minerax.Admin")) {
                if (!e.getLine(1).equalsIgnoreCase("")) {
                    e.setLine(0, "§cTELEPORT");
                    e.setLine(1, e.getLine(1));
                } else {
                    p.sendMessage(API.ONLINE_prefix + "§cDu musst einen Warp angeben.");
                    e.getBlock().setType(Material.AIR);
                }
            } else {
                p.sendMessage(API.ONLINE_prefix);
                e.getBlock().setType(Material.AIR);
            }
        }
    }

    /*

    if(s.getLine(0).equalsIgnoreCase("§cTELEPORT")) {
                if (!s.getLine(1).equals("")) {
                    File file = new File("plugins/Community", "Spiellocations.yml");
                    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

                    World w = Bukkit.getWorld(cfg.getString(s.getLine(1) + ".world"));
                    double x = cfg.getDouble(s.getLine(1) + ".x");
                    double y = cfg.getDouble(s.getLine(1) + ".y");
                    double z = cfg.getDouble(s.getLine(1) + ".z");
                    double yaw = cfg.getDouble(s.getLine(1) + ".yaw");
                    double pitch = cfg.getDouble(".pitch");
                    final Location loc = new Location(w, x, y, z, (float) yaw, (float) pitch);
                    p.teleport(loc);
                }
            }
     */

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && ((e.getClickedBlock().getType() == Material.SIGN) || (e.getClickedBlock().getType() == Material.SIGN_POST) || (e.getClickedBlock().getType() == Material.WALL_SIGN))) {
            BlockState b = e.getClickedBlock().getState();
            Sign s = (Sign) b;

            if(s.getLine(0).equalsIgnoreCase("§cTELEPORT")) {
                if (!s.getLine(1).equals("")) {
                    File file = new File("plugins/Community", "Spiellocations.yml");
                    FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

                    World w = Bukkit.getWorld(cfg.getString(s.getLine(1) + ".world"));
                    double x = cfg.getDouble(s.getLine(1) + ".x");
                    double y = cfg.getDouble(s.getLine(1) + ".y");
                    double z = cfg.getDouble(s.getLine(1) + ".z");
                    double yaw = cfg.getDouble(s.getLine(1) + ".yaw");
                    double pitch = cfg.getDouble(".pitch");
                    final Location loc = new Location(w, x, y, z, (float) yaw, (float) pitch);
                    p.teleport(loc);
                }
            }
        }
    }
}
