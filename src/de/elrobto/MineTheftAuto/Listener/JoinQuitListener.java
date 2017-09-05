package de.elrobto.MineTheftAuto.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import de.elrobto.MineTheftAuto.Utils;
import de.elrobto.MineTheftAuto.API.API;

import java.util.Random;

public class JoinQuitListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);
        Player p1 = e.getPlayer();
        de.elrobto.MineTheftAuto.API.Player p = new de.elrobto.MineTheftAuto.API.Player(p1);
        if(p1.hasPlayedBefore() || p.getPlayerData().getNumber(p.getUniqueId().toString()).equalsIgnoreCase("UNKNOW")) {
            p.getPlayerData().createPlayer(p.getUniqueId().toString(), p.getName());
            p.getLicenseData().createPlayer(p.getUniqueId().toString());

            Random random = new Random();
            String possible = "0123456789";
            StringBuilder builder = new StringBuilder();
            for (int index = 0; index < 10; index++) {
                builder.append(possible.charAt(random.nextInt(possible.length())));
            }

            String number = builder.toString();

            if(!p.getPlayerData().numberExists(number)) {
                p.getPlayerData().setNumber(p.getUniqueId().toString(), number);
            }
        }

        p.getPlayerData().setName(p.getUniqueId().toString(), p.getName());

        if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
            p.sendMessage(API.ONLINE_prefix + "§7Der Storymode ist derzeit nicht verfügbar.");
        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
            p.sendMessage(API.ONLINE_prefix + "§7The Storymode is currently not available.");
        } else {
            p.sendMessage(API.ONLINE_prefix + "§7The Storymode is currently not available.");
        }

        PlayerListener.setAllBoards();

        String rang = p.getPlayerData().getRang(p.getUniqueId().toString());
        int level = p.getPlayerData().getLevel(p.getUniqueId().toString());

        if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
            API.sendTitle(p1, 20, 40, 20, "§c§lWillkommen zu MTA!", "§cRang: §e§l" + rang + " §8§l| §cLevel: §e§l" + level);
            if(p.getPlayerData().getWanted(p.getUniqueId().toString()) >= 1) {
                p.sendMessage(API.ONLINE_prefix + "§cWenn du 3 Sterne hast können andere Spieler mehr Geld aus dir bekommen und du verlierst alles. Das heisst Wohnung, Geld, Lizenzen und mehr. Also achte drauf das dich niemand tötet.");
            }
        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
            API.sendTitle(p1, 20, 40, 20, "§c§lWelcome to MTA!", "§cRank: §e§l" + rang + " §8§l| §cLevel: §e§l" + level);

            if(p.getPlayerData().getWanted(p.getUniqueId().toString()) >= 1) {
                p.sendMessage(API.ONLINE_prefix + "§cIf you have 3 stars, other players can get more money from you and you lose everything. That means house, money, licenses and more. So make sure no one kills you.");
            }
        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("UNKNOW")) {
            API.sendTitle(p1, 20, 40, 20, "§c§lWelcome to MTA!", "§cRank: §e§lBeginner §8§l| §cLevel: §e§l1");

            if(p.getPlayerData().getWanted(p.getUniqueId().toString()) >= 1) {
                p.sendMessage(API.ONLINE_prefix + "§cIf you have 3 stars, other players can get more money from you and you lose everything. That means house, money, licenses and more. So make sure no one kills you.");
            }
        }

        if(p.getPlayerData().getRank(p.getUniqueId().toString()).equalsIgnoreCase("ADMIN")) {
            p.setPlayerListName("§4" + p.getName() + " §8(§3" + p.getPlayerData().getLevel(p.getUniqueId().toString()) + "§8)");
        } else if(p.getPlayerData().getRank(p.getUniqueId().toString()).equalsIgnoreCase("DEVELOPER")) {
            p.setPlayerListName("§b" + p.getName() + " §8(§3" + p.getPlayerData().getLevel(p.getUniqueId().toString()) + "§8)");
        } else if(p.getPlayerData().getRank(p.getUniqueId().toString()).equalsIgnoreCase("BUILDER")) {
            p.setPlayerListName("§2" + p.getName() + " §8(§3" + p.getPlayerData().getLevel(p.getUniqueId().toString()) + "§8)");
        } else if(p.getPlayerData().getRank(p.getUniqueId().toString()).equalsIgnoreCase("VIP")) {
            p.setPlayerListName("§5" + p.getName() + " §8(§3" + p.getPlayerData().getLevel(p.getUniqueId().toString()) + "§8)");
        } else {
            p.setPlayerListName("§7" + p.getName() + " §8(§3" + p.getPlayerData().getLevel(p.getUniqueId().toString()) + "§8)");
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
    }

    public static void initLanguage(Player p1) {
        de.elrobto.MineTheftAuto.API.Player p = new de.elrobto.MineTheftAuto.API.Player(p1);

        Inventory inv = Bukkit.createInventory(null, 27, "§7Choose");
        if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
            inv.setItem(12, Utils.createItem(Material.PAPER, 1, 0, "§c§lDeutsch/German"));
        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
            inv.setItem(12, Utils.createItem(Material.PAPER, 1, 0, "§7Deutsch/German"));
        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("UNKNOW")) {
            inv.setItem(12, Utils.createItem(Material.PAPER, 1, 0, "§7Deutsch/German"));
        }

        if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
            inv.setItem(14, Utils.createItem(Material.PAPER, 1, 0, "§c§lEnglisch/English"));
        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
            inv.setItem(14, Utils.createItem(Material.PAPER, 1, 0, "§7Englisch/English"));
        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("UNKNOW")) {
            inv.setItem(14, Utils.createItem(Material.PAPER, 1, 0, "§7Englisch/English"));
        }

        p1.openInventory(inv);
    }

    @EventHandler
    public void onInteract(InventoryClickEvent event) {
        final Player p1 = (Player) event.getWhoClicked();

        de.elrobto.MineTheftAuto.API.Player p = new de.elrobto.MineTheftAuto.API.Player((Player) event.getWhoClicked());

        if (event.getInventory().getName().equalsIgnoreCase("§7Choose")) {
            try {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Deutsch/German")) {
                    event.setCancelled(true);

                    if(!p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("UNKNOW")) {
                        if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                            p.sendMessage(API.OFFLINE_prefix + "§cDu kannst deine Sprache nur einmal verändern.");
                        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                            p.sendMessage(API.OFFLINE_prefix + "§cYou can change your language only once.");
                        }
                        return;
                    }

                    p.sendMessage(API.OFFLINE_prefix + "§7Deine Sprache ist nun §c§lDeutsch/German");
                    p.getPlayerData().setLanguage(p.getUniqueId().toString(), "DE");
                    p.getPlayerData().setRang(p.getUniqueId().toString(), "Neuling");
                    PlayerListener.setAllBoards();
                    p1.closeInventory();
                }
            }
            catch (Exception localException) {}

            try {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Englisch/English")) {
                    event.setCancelled(true);

                    if(!p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("UNKNOW")) {
                        if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                            p.sendMessage(API.OFFLINE_prefix + "§cDu kannst deine Sprache nur einmal verändern.");
                        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                            p.sendMessage(API.OFFLINE_prefix + "§cYou can change your language only once.");
                        }
                        return;
                    }

                    p.sendMessage(API.OFFLINE_prefix + "§7Your Language is now §c§lEnglisch/English");
                    p.getPlayerData().setLanguage(p.getUniqueId().toString(), "EN");
                    p.getPlayerData().setRang(p.getUniqueId().toString(), "Beginner");
                    PlayerListener.setAllBoards();
                    p1.closeInventory();
                }
            }
            catch (Exception localException) {}

            try {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lDeutsch/German")) {
                    event.setCancelled(true);

                    p.sendMessage(API.OFFLINE_prefix + "§7Deine Sprache ist bereits §c§lDeutsch/German§7.");
                    p1.closeInventory();
                }
            }
            catch (Exception localException) {}

            try {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lEnglisch/English")) {
                    event.setCancelled(true);

                    p.sendMessage(API.OFFLINE_prefix + "§7Your Language is already §c§lEnglisch/English§7.");
                    p1.closeInventory();
                }
            }
            catch (Exception localException) {}
        }
    }
}