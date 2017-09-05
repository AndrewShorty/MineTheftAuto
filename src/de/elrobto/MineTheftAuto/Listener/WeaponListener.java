package de.elrobto.MineTheftAuto.Listener;

import de.elrobto.MineTheftAuto.API.API;
import de.elrobto.MineTheftAuto.MySQL.PlayerDatabase;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class WeaponListener implements Listener {
    
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p1 = e.getPlayer();
        de.elrobto.MineTheftAuto.API.Player p = new de.elrobto.MineTheftAuto.API.Player(p1);
        if (((e.getAction() == Action.RIGHT_CLICK_BLOCK ? 1 : 0) | (e.getAction() == Action.RIGHT_CLICK_AIR ? 1 : 0)) != 0) {
            try {
                if (e.getItem().getItemMeta().getDisplayName().contains("§7Gefechts MG") || e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Battle MG")) {
                    if(p.getInventory().getItem(8).getType().equals(Material.MELON_SEEDS)) {
                        p1.launchProjectile(Arrow.class);
                        p1.launchProjectile(Arrow.class);
                        p1.launchProjectile(Arrow.class);
                        p1.launchProjectile(Arrow.class);
                        p1.launchProjectile(Arrow.class);
                        p1.launchProjectile(Arrow.class);
                        p1.launchProjectile(Arrow.class);
                        p.getInventory().getItem(8).setAmount(p.getInventory().getItem(8).getAmount() - 1);
                        if(p.getInventory().getItem(8).getAmount() >= 2) {
                            p.getInventory().getItem(8).setAmount(p.getInventory().getItem(8).getAmount() - 1);
                        } else {
                            p.getInventory().setItem(8, null);
                        }
                    } else {
                        if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                            p.sendMessage(API.OFFLINE_prefix + "§cDu hast keine Munition auf den 9 Slot. Bitte setz dort §eMG MUNITION§c hin.");
                        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                            p.sendMessage(API.OFFLINE_prefix + "§cYou have no ammo on the 9 slot. Please put §eMG MUNITION§c there.");
                        }
                    }
                }
            } catch (Exception localException) {}

            try {
                if (e.getItem().getItemMeta().getDisplayName().contains("§7Raketenwerfer") || e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Rocket Launcher")) {
                    if(p.getInventory().getItem(8).getType().equals(Material.GOLD_NUGGET)) {
                        p1.launchProjectile(Fireball.class);
                        p.getInventory().getItem(8).setAmount(p.getInventory().getItem(8).getAmount() - 1);
                        if(p.getInventory().getItem(8).getAmount() >= 2) {
                            p.getInventory().getItem(8).setAmount(p.getInventory().getItem(8).getAmount() - 1);
                        } else {
                            p.getInventory().setItem(8, null);
                        }
                    } else {
                        if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                            p.sendMessage(API.OFFLINE_prefix + "§cDu hast keine Munition auf den 9 Slot. Bitte setz dort §eRaketenwerfer MunitionN§c hin.");
                        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                            p.sendMessage(API.OFFLINE_prefix + "§cYou have no ammo on the 9 slot. Please put §eRocket Launcher Ammo§c there.");
                        }
                    }
                }
            } catch (Exception localException) {}
        }
    }
}