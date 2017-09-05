package de.elrobto.MineTheftAuto.Weapon;

    import de.elrobto.MineTheftAuto.MySQL.PlayerDatabase;
import de.elrobto.MineTheftAuto.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class WeaponShop implements Listener {
    
    public static Inventory shop_mainmenu = Bukkit.createInventory(null, 27, "§7Wähle/Choose");
    public static Inventory shop_weapon = Bukkit.createInventory(null, 54, "§7Waffen/Weapons");
    public static Inventory shop_buy = Bukkit.createInventory(null, 54, "§7Kauf/Buy");
    public static Integer seite = 0;
    
    public static void startShop_Mainmenu(Player p) {
        
    }
    
    public static void startShop(Player p) {
        shop_weapon.setItem(53, Utils.createItem(Material.BARRIER, 1, 0, "Weiter"));
    }
    
    public static void initBuy_Menu(Player p1, Material material, Integer SubID, String weapon, String[] info) {
        de.elrobto.MineTheftAuto.API.Player p = new de.elrobto.MineTheftAuto.API.Player(p1);

        if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
            shop_buy.setItem(11, Utils.createItem(Material.EMERALD_BLOCK, 1, 0, "§aKaufen", new String[] { "§7Rechtsklick zum §akaufen", "§7und schließe den Shop" }));
        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
            shop_buy.setItem(11, Utils.createItem(Material.EMERALD_BLOCK, 1, 0, "§aBuy", new String[] { "§7Rightclick to §abuy", "§7and close the Shop" }));
        }
        
        shop_buy.setItem(13, Utils.createItem(material, 1, SubID, weapon, info));
        
        if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
            shop_buy.setItem(11, Utils.createItem(Material.REDSTONE_BLOCK, 1, 0, "§cAbbrechen", new String[] { "§7Rechtsklick zum §cabbrachen", "§7und zurück in die Waffenauswahl" }));
        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
            shop_buy.setItem(11, Utils.createItem(Material.REDSTONE_BLOCK, 1, 0, "§cCancel", new String[] { "§7Rightclick to §ccancel", "§7and back to the Weaponchoose" }));
        }
    }
}