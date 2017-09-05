package de.elrobto.MineTheftAuto.Jobs;

import de.elrobto.MineTheftAuto.MySQL.PlayerDatabase;
import de.elrobto.MineTheftAuto.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class JobsAPI implements Listener {

    public static void initJob(Player p1, Material material, String title, String[] infos, String[] infos_en) {
        de.elrobto.MineTheftAuto.API.Player p = new de.elrobto.MineTheftAuto.API.Player(p1);

        Inventory inv = Bukkit.createInventory(null, 27, title + "§7 Job");

        if(p.getPlayerData().getLanguage(p1.getUniqueId().toString()).equalsIgnoreCase("DE")) {
            inv.setItem(11, Utils.createItem(Material.EMERALD_BLOCK, 1, 0, "§aAnnehmen"));
            inv.setItem(13, Utils.createItem(material, 1, 0, title, infos));
            inv.setItem(15, Utils.createItem(Material.REDSTONE_BLOCK, 1, 0, "§cAblehnen"));
        } else if(p.getPlayerData().getLanguage(p1.getUniqueId().toString()).equalsIgnoreCase("EN")) {
            inv.setItem(11, Utils.createItem(Material.EMERALD_BLOCK, 1, 0, "§aAccept"));
            inv.setItem(13, Utils.createItem(material, 1, 0, title, infos_en));
            inv.setItem(15, Utils.createItem(Material.REDSTONE_BLOCK, 1, 0, "§cReject"));
        }

        p1.openInventory(inv);
    }

    public static void initJob(Player p1, Material material, int subid, String title, String[] infos, String[] infos_en) {
        de.elrobto.MineTheftAuto.API.Player p = new de.elrobto.MineTheftAuto.API.Player(p1);

        Inventory inv = Bukkit.createInventory(null, 27, title + "§7 Job");

        if(p.getPlayerData().getLanguage(p1.getUniqueId().toString()).equalsIgnoreCase("DE")) {
            inv.setItem(11, Utils.createItem(Material.EMERALD_BLOCK, 1, subid, "§aAnnehmen"));
            inv.setItem(13, Utils.createItem(material, 1, subid, title, infos));
            inv.setItem(15, Utils.createItem(Material.REDSTONE_BLOCK, 1, subid, "§cAblehnen"));
        } else if(p.getPlayerData().getLanguage(p1.getUniqueId().toString()).equalsIgnoreCase("EN")) {
            inv.setItem(11, Utils.createItem(Material.EMERALD_BLOCK, 1, subid, "§aAccept"));
            inv.setItem(13, Utils.createItem(material, 1, subid, title, infos_en));
            inv.setItem(15, Utils.createItem(Material.REDSTONE_BLOCK, 1, subid, "§cReject"));
        }

        p1.openInventory(inv);
    }
}