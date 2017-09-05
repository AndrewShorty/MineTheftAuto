package de.elrobto.MineTheftAuto;

import java.util.Arrays;
import java.util.Random;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.Dye;
import org.bukkit.potion.PotionEffect;

public class Utils {
    
    public static void roundInv(Inventory inv, Integer subid) {
        inv.setItem(0, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(1, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(2, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(3, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(4, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(5, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(6, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(7, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(8, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        
        inv.setItem(9, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(17, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        
        inv.setItem(18, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(26, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        
        inv.setItem(27, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(35, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        
        inv.setItem(36, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(44, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        
        inv.setItem(45, Utils.createItem(Material.BARRIER, 1, subid, "§7Zurück"));
        inv.setItem(46, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(47, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(48, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(49, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(50, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(51, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(52, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(53, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
    }
    
    public static void roundInv(Inventory inv, Integer subid, String absetzen) {
        inv.setItem(0, Utils.createItem(Material.BARRIER, 1, subid, "§7" + absetzen));
        inv.setItem(1, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(2, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(3, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(4, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(5, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(6, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(7, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(8, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        
        inv.setItem(9, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(17, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        
        inv.setItem(18, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(26, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        
        inv.setItem(27, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(35, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        
        inv.setItem(36, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(44, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        
        inv.setItem(45, Utils.createItem(Material.BARRIER, 1, subid, "§7Zurück"));
        inv.setItem(46, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(47, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(48, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(49, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(50, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(51, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(52, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        inv.setItem(53, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
    }
    
    public static void fillInv(Inventory inv, Integer subid) {
        if(inv.getSize() == 9) {
            inv.setItem(0, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(1, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(2, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(3, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(4, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(5, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(6, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(7, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(8, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        } else if(inv.getSize() == 18) {
            inv.setItem(0, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(1, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(2, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(3, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(4, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(5, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(6, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(7, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(8, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));

            inv.setItem(9, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(10, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(11, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(12, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(13, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(14, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(15, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(16, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(17, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        } else if(inv.getSize() == 27) {
            inv.setItem(0, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(1, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(2, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(3, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(4, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(5, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(6, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(7, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(8, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));

            inv.setItem(9, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(10, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(11, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(12, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(13, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(14, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(15, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(16, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(17, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));

            inv.setItem(18, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(19, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(20, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(21, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(22, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(23, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(24, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(25, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(26, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        } else if(inv.getSize() == 36) {
            inv.setItem(0, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(1, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(2, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(3, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(4, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(5, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(6, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(7, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(8, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));

            inv.setItem(9, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(10, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(11, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(12, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(13, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(14, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(15, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(16, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(17, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));

            inv.setItem(18, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(19, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(20, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(21, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(22, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(23, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(24, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(25, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(26, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));

            inv.setItem(27, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(28, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(29, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(30, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(31, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(32, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(33, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(34, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(35, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        } else if(inv.getSize() == 45) {
            inv.setItem(0, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(1, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(2, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(3, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(4, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(5, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(6, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(7, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(8, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));

            inv.setItem(9, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(10, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(11, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(12, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(13, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(14, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(15, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(16, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(17, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));

            inv.setItem(18, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(19, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(20, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(21, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(22, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(23, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(24, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(25, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(26, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));

            inv.setItem(27, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(28, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(29, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(30, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(31, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(32, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(33, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(34, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(35, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));

            inv.setItem(36, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(37, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(38, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(39, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(40, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(41, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(42, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(43, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(44, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        } else if(inv.getSize() == 54) {
            inv.setItem(0, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(1, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(2, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(3, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(4, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(5, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(6, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(7, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(8, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));

            inv.setItem(9, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(10, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(11, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(12, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(13, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(14, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(15, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(16, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(17, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));

            inv.setItem(18, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(19, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(20, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(21, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(22, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(23, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(24, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(25, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(26, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));

            inv.setItem(27, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(28, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(29, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(30, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(31, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(32, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(33, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(34, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(35, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));

            inv.setItem(36, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(37, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(38, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(39, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(40, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(41, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(42, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(43, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(44, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));

            inv.setItem(45, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(46, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(47, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(48, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(49, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(50, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(51, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(52, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
            inv.setItem(53, Utils.createItem(Material.STAINED_GLASS_PANE, 1, subid, "§c "));
        }
    }

    public static ItemStack createItem(Material mat, int anzahl, int id, String name) {
        ItemStack it = new ItemStack(mat, anzahl, (short)id);
        ItemMeta meta = it.getItemMeta();
        meta.setDisplayName(name);
        it.setItemMeta(meta);
        return it;
    }

    public static ItemStack createItem(Material mat, int anzahl, int id, String name, String[] Lore) {
        ItemStack it = new ItemStack(mat, anzahl, (short)id);
        ItemMeta meta = it.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(Lore));
        it.setItemMeta(meta);
        return it;
    }

    public static ItemStack createItem(Material mat, int anzahl, int id, String name, boolean Leuchtend) {
        ItemStack it = new ItemStack(mat, anzahl, (short)id);
        ItemMeta meta = it.getItemMeta();
        meta.setDisplayName(name);
        it.setItemMeta(meta);
        if (Leuchtend) {
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
            meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        }
        return it;
    }

    public static ItemStack createItem(Material mat, int anzahl, int id, String name, String[] Lore, boolean Leuchtend) {
        ItemStack it = new ItemStack(mat, anzahl, (short)id);
        ItemMeta meta = it.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(Lore));
        if (Leuchtend) {
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
            meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        }
        it.setItemMeta(meta);
        return it;
    }

    public static ItemStack setHead(Player p, String Von, String Displayname) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwner(Von);
        meta.setDisplayName(Displayname);
        skull.setItemMeta(meta);
        p.getInventory().setHelmet(skull);
        return skull;
    }

    public static ItemStack setHead(Player p, String Von, String Displayname, int Slot) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwner(Von);
        meta.setDisplayName(Displayname);
        skull.setItemMeta(meta);
        p.getInventory().setItem(Slot, skull);
        return skull;
    }

    public static ItemStack setHead(String Von, String Displayname, String[] Lore) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwner(Von);
        meta.setDisplayName(Displayname);
        meta.setLore(Arrays.asList(Lore));
        skull.setItemMeta(meta);
        return skull;
    }

    public static ItemStack setHead(String Von, String Displayname) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();
        meta.setOwner(Von);
        meta.setDisplayName(Displayname);
        skull.setItemMeta(meta);
        return skull;
    }

    public static ItemStack setItemTagsColor(DyeColor dye, String name, boolean glow) {
        ItemStack stack = new Dye(dye).toItemStack(1);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(name);
        if (glow) {
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
            meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        }
        stack.setItemMeta(meta);
        return stack;
    }

    public static ItemStack setItemTagsColor(DyeColor dye, String name, String[] Lore, boolean glow) {
        ItemStack stack = new Dye(dye).toItemStack(1);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(Lore));
        if (glow) {
            meta.addEnchant(Enchantment.DURABILITY, 1, true);
            meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        }
        stack.setItemMeta(meta);
        return stack;
    }

    public static void clearPlayer(Player p) {
        p.setHealth(20.0D);
        p.setFoodLevel(20);
        p.setLevel(0);
        p.setExp(0.0F);
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        for (PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }
    }

    public int rndInt(int min, int max) {
        Random r = new Random();
        int i = r.nextInt(max - min + 1) + min;
        return i;
    }

    public static ItemStack setRed(String DisplayName, String[] lore) {
        ItemStack e1 = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta emeta = (LeatherArmorMeta)e1.getItemMeta();
        emeta.setLore(Arrays.asList(lore));
        emeta.setColor(Color.fromRGB(255, 59, 59));
        emeta.setDisplayName(DisplayName);
        e1.setItemMeta(emeta);
        return e1;
    }

    public static ItemStack createBoots(String DisplayName, int X, int Y, int Z) {
        ItemStack e1 = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta emeta = (LeatherArmorMeta)e1.getItemMeta();
        emeta.setColor(Color.fromRGB(X, Y, Z));
        emeta.setDisplayName(DisplayName);
        e1.setItemMeta(emeta);
        return e1;
    }

    public static ItemStack createBoots(String DisplayName, int X, int Y, int Z, String[] lore) {
        ItemStack e1 = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta emeta = (LeatherArmorMeta)e1.getItemMeta();
        emeta.setLore(Arrays.asList(lore));
        emeta.setColor(Color.fromRGB(X, Y, Z));
        emeta.setDisplayName(DisplayName);
        e1.setItemMeta(emeta);
        return e1;
    }

    public static ItemStack setRed(String DisplayName) {
        ItemStack e1 = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta emeta = (LeatherArmorMeta)e1.getItemMeta();
        emeta.setColor(Color.fromRGB(255, 59, 59));
        emeta.setDisplayName(DisplayName);
        e1.setItemMeta(emeta);
        return e1;
    }
}