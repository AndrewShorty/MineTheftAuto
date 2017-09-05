package de.elrobto.MineTheftAuto.Jobs;

import de.elrobto.MineTheftAuto.MySQL.PlayerDatabase;
import de.elrobto.MineTheftAuto.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class Jobs implements Listener {
    
    public static void initJobmenu(de.elrobto.MineTheftAuto.API.Player p, Player p1) {
        Inventory inv = Bukkit.createInventory(null, 27, "§eJobs");
        if(p.getPlayerData().getLanguage(p1.getUniqueId().toString()).equalsIgnoreCase("DE")) {
            inv.setItem(0, Utils.createItem(Material.WHEAT, 1, 0, "§eFarmer"));
            inv.setItem(1, Utils.createItem(Material.GRASS, 1, 0, "§2Gärtner"));
            inv.setItem(2, Utils.createItem(Material.FISHING_ROD, 1, 0, "§9Fischer"));
        } else if(p.getPlayerData().getLanguage(p1.getUniqueId().toString()).equalsIgnoreCase("EN")) {
            inv.setItem(0, Utils.createItem(Material.WHEAT, 1, 0, "§eFarmer"));
            inv.setItem(1, Utils.createItem(Material.GRASS, 1, 0, "§2Gardener"));
            inv.setItem(2, Utils.createItem(Material.FISHING_ROD, 1, 0, "§9Fisher"));
        }
        
        p1.openInventory(inv);
    }
}