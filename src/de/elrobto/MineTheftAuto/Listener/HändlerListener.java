package de.elrobto.MineTheftAuto.Listener;

import de.elrobto.MineTheftAuto.API.API;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import de.elrobto.MineTheftAuto.Utils;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.InventoryClickEvent;

public class HändlerListener implements Listener {

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onInteract1(NPCRightClickEvent e) {
        Player p1 = (Player)e.getClicker();
        de.elrobto.MineTheftAuto.API.Player p = new de.elrobto.MineTheftAuto.API.Player(p1);

        if(e.getNPC().getName().contains("Shop")) {
            if(p.getLicenseData().get(p.getUniqueId().toString(), "PERSO").equalsIgnoreCase("NEIN")) {
                if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                    p.sendMessage("§cDu benötigst einen Personal Ausweis um etwas kaufen zu können. Du kannst diesen nur bei dem Polizei Chef im LSPD erwerben.");
                } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                    p.sendMessage("§cYou need an identity card to buy something. You can only purchase this at the police chief in the LSPD.");
                }
                return;
            }
        } else if(e.getNPC().getName().contains("Mission")) {
            if(p.getLicenseData().get(p.getUniqueId().toString(), "PERSO").equalsIgnoreCase("NEIN")) {
                if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                    p.sendMessage("§cDu kannst derzeit keine Mission spielen da diese in Entwicklung sind oder nur für Entwickler offen sind.");
                } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                    p.sendMessage("§cYou can not play a mission at the moment because they are under development or open only to developers.");
                }
                return;
            }
        } else if(e.getNPC().getName().contains("Game")) {
            if(p.getLicenseData().get(p.getUniqueId().toString(), "PERSO").equalsIgnoreCase("NEIN")) {
                if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                    p.sendMessage("§cDu benötigst einen Personal Ausweis um etwas spielen zu können. Du kannst diesen nur bei dem Polizei Chef im LSPD erwerben.");
                } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                    p.sendMessage("§cYou need an identity card to play something. You can only purchase this at the police chief in the LSPD.");
                }
                return;
            }
        } else if(e.getNPC().getName().contains("Job")) {
            if(p.getLicenseData().get(p.getUniqueId().toString(), "PERSO").equalsIgnoreCase("NEIN")) {
                if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                    p.sendMessage("§cDu benötigst einen Personal Ausweis um etwas spielen zu können. Du kannst diesen nur bei dem Polizei Chef im LSPD erwerben.");
                } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                    p.sendMessage("§cYou need an identity card to play something. You can only purchase this at the police chief in the LSPD.");
                }
                return;
            }
            if(p.getLicenseData().get(p.getUniqueId().toString(), "JOB").equalsIgnoreCase("NEIN")) {
                if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                    p.sendMessage("§cDu benötigst eine Job Lizenz um etwas spielen zu können. Du kannst diesen nur bei dem Polizei Chef im LSPD erwerben.");
                } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                    p.sendMessage("§cYou need an job license to play something. You can only purchase this at the police chief in the LSPD.");
                }
                return;
            }
        }

        if(e.getNPC().getName().contains("Waffen")) {
            if(p.getPlayerData().getLevel(p.getUniqueId().toString()) < 3) {
                if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                    p.sendMessage("§cDu musst Level 3 sein damit du dir Waffen kaufen kannst.");
                } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                    p.sendMessage("§cYou must be level 3 to can buy weapons.");
                }
                return;
            }

            if(p.getLicenseData().get(p.getUniqueId().toString(), "WAFFEN").equalsIgnoreCase("NEIN")) {
                if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                    p.sendMessage("§cDu benötigst eine Waffen Lizenz damit du dir Waffen kaufen kannst. Diese kannst du legal bei einem Polizei Chief erwerben oder Illegal bei einem Fälscher.");
                } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                    p.sendMessage("§cYou need a weapon license to can buy weapons. These can be legally purchased at a police chief or illegally at a forger");
                }
                return;
            }

            Inventory inv = null;

            if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                inv = Bukkit.createInventory(null, 27, "§7Waffen Shop");
            } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                inv = Bukkit.createInventory(null, 27, "§7Weapon Shop");
            }

            e.getClicker().openInventory(inv);
        }

        if(e.getNPC().getName().contains("Chief")) {
            Inventory inv = null;

            if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                inv = Bukkit.createInventory(null, 27, "§7Lizenzen");
                Utils.fillInv(inv, 15);
                inv.setItem(10, Utils.createItem(Material.MAP, 1, 0, "§7Personalausweis", new String[] { "§7Preis: §e20$" }));
                if(p.getLicenseData().get(p.getUniqueId().toString(), "PERSO").equalsIgnoreCase("NEIN")) {
                    inv.setItem(11, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cWaffen Lizenz", new String[] { "§cDu benötigst für diese Lizenz einen Personalausweis." }));
                    inv.setItem(12, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cJob Lizenz", new String[] { "§cDu benötigst für diese Lizenz einen Personalausweis." }));
                    inv.setItem(13, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cAuto Lizenz", new String[] { "§cDu benötigst für diese Lizenz einen Personalausweis." }));
                    inv.setItem(14, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cMarkt Lizenz", new String[] { "§cDu benötigst für diese Lizenz einen Personalausweis." }));
                    inv.setItem(15, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cUnbekannte Lizenz", new String[] { "§cDu kannst diesen Lizenz derzeit nicht erwerben." }));
                    inv.setItem(16, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cUnbekannte Lizenz", new String[] { "§cDu kannst diesen Lizenz derzeit nicht erwerben." }));
                } else if(p.getLicenseData().get(p.getUniqueId().toString(), "PERSO").equalsIgnoreCase("JA")) {
                    inv.setItem(11, Utils.createItem(Material.MAP, 1, 0, "§7Waffen Lizenz", new String[] { "§7Preis: §e25000$" }));
                    inv.setItem(12, Utils.createItem(Material.MAP, 1, 0, "§7Job Lizenz", new String[] { "§7Preis: §e500$" }));
                    inv.setItem(13, Utils.createItem(Material.MAP, 1, 0, "§7Auto Lizenz", new String[] { "§7Preis: §e1000$" }));
                    inv.setItem(14, Utils.createItem(Material.MAP, 1, 0, "§7Markt Lizenz", new String[] { "§7Preis: §e12000$" }));
                    inv.setItem(15, Utils.createItem(Material.MAP, 1, 0, "§7Unbekannte Lizenz", new String[] { "§cDu kannst diesen Lizenz derzeit nicht erwerben." }));
                    inv.setItem(16, Utils.createItem(Material.MAP, 1, 0, "§7Unbekannte Lizenz", new String[] { "§cDu kannst diesen Lizenz derzeit nicht erwerben." }));
                }
            } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                inv = Bukkit.createInventory(null, 27, "§7Licenses");
                Utils.fillInv(inv, 15);
                inv.setItem(10, Utils.createItem(Material.MAP, 1, 0, "§7Identity card", new String[] { "§7Price: §e20$" }));
                if(p.getLicenseData().get(p.getUniqueId().toString(), "PERSO").equalsIgnoreCase("NEIN")) {
                    inv.setItem(11, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cWeapon license", new String[] { "§cYou need a identity card for this license." }));
                    inv.setItem(12, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cJob license", new String[] { "§cYou need a identity card for this license." }));
                    inv.setItem(13, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cCar license", new String[] { "§cYou need a identity card for this license." }));
                    inv.setItem(14, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cMarket license", new String[] { "§cYou need a identity card for this license." }));
                    inv.setItem(15, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cUnknow license", new String[] { "§cYou can't currently purchase this license." }));
                    inv.setItem(16, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cUnknow license", new String[] { "§cYou can't currently purchase this license." }));
                } else if(p.getLicenseData().get(p.getUniqueId().toString(), "PERSO").equalsIgnoreCase("JA")) {
                    inv.setItem(11, Utils.createItem(Material.MAP, 1, 0, "§7Weapon license", new String[] { "§7Price: §e25000$" }));
                    inv.setItem(12, Utils.createItem(Material.MAP, 1, 0, "§7Job license", new String[] { "§7Price: §e500$" }));
                    inv.setItem(13, Utils.createItem(Material.MAP, 1, 0, "§7Car license", new String[] { "§7Price: §e1000$" }));
                    inv.setItem(14, Utils.createItem(Material.MAP, 1, 0, "§7Market license", new String[] { "§7Price: §e12000$" }));
                    inv.setItem(15, Utils.createItem(Material.MAP, 1, 0, "§cUnknow license", new String[] { "§cYou can't currently purchase this license." }));
                    inv.setItem(16, Utils.createItem(Material.MAP, 1, 0, "§cUnknow license", new String[] { "§cYou can't currently purchase this license." }));
                }
            }

            e.getClicker().openInventory(inv);
        }
    }

    private void initLizenzshop(de.elrobto.MineTheftAuto.API.Player p, Player p1) {
        Inventory inv = null;

        if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
            inv = Bukkit.createInventory(null, 27, "§7Lizenzen");
            Utils.fillInv(inv, 15);
            inv.setItem(10, Utils.createItem(Material.MAP, 1, 0, "§7Personalausweis", new String[] { "§7Preis: §e20$" }));
            if(p.getLicenseData().get(p.getUniqueId().toString(), "PERSO").equalsIgnoreCase("NEIN")) {
                inv.setItem(11, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cWaffen Lizenz", new String[] { "§cDu benötigst für diese Lizenz einen Personalausweis." }));
                inv.setItem(12, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cJob Lizenz", new String[] { "§cDu benötigst für diese Lizenz einen Personalausweis." }));
                inv.setItem(13, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cAuto Lizenz", new String[] { "§cDu benötigst für diese Lizenz einen Personalausweis." }));
                inv.setItem(14, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cMarkt Lizenz", new String[] { "§cDu benötigst für diese Lizenz einen Personalausweis." }));
                inv.setItem(15, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cUnbekannte Lizenz", new String[] { "§cDu kannst diesen Lizenz derzeit nicht erwerben." }));
                inv.setItem(16, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cUnbekannte Lizenz", new String[] { "§cDu kannst diesen Lizenz derzeit nicht erwerben." }));
            } else if(p.getLicenseData().get(p.getUniqueId().toString(), "PERSO").equalsIgnoreCase("JA")) {
                inv.setItem(11, Utils.createItem(Material.MAP, 1, 0, "§7Waffen Lizenz", new String[] { "§7Preis: §e25000$" }));
                inv.setItem(12, Utils.createItem(Material.MAP, 1, 0, "§7Job Lizenz", new String[] { "§7Preis: §e500$" }));
                inv.setItem(13, Utils.createItem(Material.MAP, 1, 0, "§7Auto Lizenz", new String[] { "§7Preis: §e1000$" }));
                inv.setItem(14, Utils.createItem(Material.MAP, 1, 0, "§7Markt Lizenz", new String[] { "§7Preis: §e12000$" }));
                inv.setItem(15, Utils.createItem(Material.MAP, 1, 0, "§7Unbekannte Lizenz", new String[] { "§cDu kannst diesen Lizenz derzeit nicht erwerben." }));
                inv.setItem(16, Utils.createItem(Material.MAP, 1, 0, "§7Unbekannte Lizenz", new String[] { "§cDu kannst diesen Lizenz derzeit nicht erwerben." }));
            }
        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
            inv = Bukkit.createInventory(null, 27, "§7Licenses");
            Utils.fillInv(inv, 15);
            inv.setItem(10, Utils.createItem(Material.MAP, 1, 0, "§7Identity card", new String[] { "§7Price: §e20$" }));
            if(p.getLicenseData().get(p.getUniqueId().toString(), "PERSO").equalsIgnoreCase("NEIN")) {
                inv.setItem(11, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cWeapon license", new String[] { "§cYou need a identity card for this license." }));
                inv.setItem(12, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cJob license", new String[] { "§cYou need a identity card for this license." }));
                inv.setItem(13, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cCar license", new String[] { "§cYou need a identity card for this license." }));
                inv.setItem(14, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cMarket license", new String[] { "§cYou need a identity card for this license." }));
                inv.setItem(15, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cUnknow license", new String[] { "§cYou can't currently purchase this license." }));
                inv.setItem(16, Utils.createItem(Material.STAINED_GLASS_PANE, 1, 14, "§cUnknow license", new String[] { "§cYou can't currently purchase this license." }));
            } else if(p.getLicenseData().get(p.getUniqueId().toString(), "PERSO").equalsIgnoreCase("JA")) {
                inv.setItem(11, Utils.createItem(Material.MAP, 1, 0, "§7Weapon license", new String[] { "§7Price: §e25000$" }));
                inv.setItem(12, Utils.createItem(Material.MAP, 1, 0, "§7Job license", new String[] { "§7Price: §e500$" }));
                inv.setItem(13, Utils.createItem(Material.MAP, 1, 0, "§7Car license", new String[] { "§7Price: §e1000$" }));
                inv.setItem(14, Utils.createItem(Material.MAP, 1, 0, "§7Market license", new String[] { "§7Price: §e12000$" }));
                inv.setItem(15, Utils.createItem(Material.MAP, 1, 0, "§cUnknow license", new String[] { "§cYou can't currently purchase this license." }));
                inv.setItem(16, Utils.createItem(Material.MAP, 1, 0, "§cUnknow license", new String[] { "§cYou can't currently purchase this license." }));
            }
        }

        p1.openInventory(inv);
    }

    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        if (e.getInventory().getName().equalsIgnoreCase("§7Lizenzen") || (e.getInventory().getName().equalsIgnoreCase("§7Licenses"))) {
            e.setCancelled(true);
            Player p1 = (Player) e.getWhoClicked();

            de.elrobto.MineTheftAuto.API.Player p = new de.elrobto.MineTheftAuto.API.Player(p1);

            try {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Personalausweis") || (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Identity card"))) {
                    if(p.getLicenseData().get(p.getUniqueId().toString(), "PERSO").equalsIgnoreCase("NEIN")) {
                        if(p.getPlayerData().getCash(p.getUniqueId().toString()) >= 20) {
                            if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                                p.sendMessage(API.MARKT_prefix + "§7Du hast einen §cPersonalausweis §7gekauft.");
                            } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                                p.sendMessage(API.MARKT_prefix + "§7You have purchased an §cIdentity card§7.");
                            }
                            p.getPlayerData().removeCash(p.getUniqueId().toString(), 20);
                            p.getLicenseData().set(p.getUniqueId().toString(), "PERSO", "JA");
                            p1.closeInventory();
                            initLizenzshop(p, p1);
                            PlayerListener.updateScoreboard(p1);
                        } else {
                            int cash = 20- p.getPlayerData().getCash(p.getUniqueId().toString());
                            if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                                p.sendMessage(API.MARKT_prefix + "§cDu benötigt weitere  " + cash + "$ für einen Personalausweis.");
                            } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                                p.sendMessage(API.MARKT_prefix + "§cYou still need " + cash + "$ for a Identity card.");
                            }
                            p1.closeInventory();
                        }
                    } else if(p.getLicenseData().get(p.getUniqueId().toString(), "PERSO").equalsIgnoreCase("JA")) {
                        if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                            p.sendMessage(API.MARKT_prefix + "§cDu besitz bereits einen Personalausweis.");
                        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                            p.sendMessage(API.MARKT_prefix + "§cYou already have a Identity card.");
                        }
                        p1.closeInventory();
                    }
                }
            } catch (Exception localException) {}

            try {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Waffen Lizenz") || (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Weapon license"))) {
                    if(p.getLicenseData().get(p.getUniqueId().toString(), "WAFFEN").equalsIgnoreCase("NEIN")) {
                        if(p.getPlayerData().getCash(p.getUniqueId().toString()) >= 25000) {
                            if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                                p.sendMessage(API.MARKT_prefix + "§7Du hast eine §cWaffen Lizenz §7gekauft.");
                            } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                                p.sendMessage(API.MARKT_prefix + "§7You have purchased an §cweapon license§7.");
                            }
                            p.getPlayerData().removeCash(p.getUniqueId().toString(), 25000);
                            p.getLicenseData().set(p.getUniqueId().toString(), "WAFFEN", "JA");
                            p1.closeInventory();
                            initLizenzshop(p, p1);
                            PlayerListener.updateScoreboard(p1);
                        } else {
                            int cash = 25000- p.getPlayerData().getCash(p.getUniqueId().toString());
                            if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                                p.sendMessage(API.MARKT_prefix + "§cDu benötigt weitere " + cash + "$ für eine Waffen Lizenz.");
                            } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                                p.sendMessage(API.MARKT_prefix + "§cYou still need " + cash + "$ for a weapon license.");
                            }
                            p1.closeInventory();
                        }
                    } else if(p.getLicenseData().get(p.getUniqueId().toString(), "WAFFEN").equalsIgnoreCase("JA")) {
                        if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                            p.sendMessage(API.MARKT_prefix + "§cDu besitz bereits eine Waffen Lizenz.");
                        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                            p.sendMessage(API.MARKT_prefix + "§cYou already have a weapon license.");
                        }
                        p1.closeInventory();
                    }
                }
            } catch (Exception localException) {}

            try {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Job Lizenz") || (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Job license"))) {
                    if(p.getLicenseData().get(p.getUniqueId().toString(), "JOB").equalsIgnoreCase("NEIN")) {
                        if(p.getPlayerData().getCash(p.getUniqueId().toString()) >= 500) {
                            if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                                p.sendMessage(API.MARKT_prefix + "§7Du hast eine §cJob Lizenz §7gekauft.");
                            } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                                p.sendMessage(API.MARKT_prefix + "§7You have purchased an §cjob license§7.");
                            }
                            p.getPlayerData().removeCash(p.getUniqueId().toString(), 500);
                            p.getLicenseData().set(p.getUniqueId().toString(), "JOB", "JA");
                            p1.closeInventory();
                            initLizenzshop(p, p1);
                            PlayerListener.updateScoreboard(p1);
                        } else {
                            int cash = 500- p.getPlayerData().getCash(p.getUniqueId().toString());
                            if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                                p.sendMessage(API.MARKT_prefix + "§cDu benötigt weitere " + cash + "$ für eine Job Lizenz.");
                            } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                                p.sendMessage(API.MARKT_prefix + "§cYou still need " + cash + "$ for a job license.");
                            }
                            p1.closeInventory();
                        }
                    } else if(p.getLicenseData().get(p.getUniqueId().toString(), "JOB").equalsIgnoreCase("JA")) {
                        if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                            p.sendMessage(API.MARKT_prefix + "§cDu besitz bereits eine Job Lizenz.");
                        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                            p.sendMessage(API.MARKT_prefix + "§cYou already have a job license.");
                        }
                        p1.closeInventory();
                    }
                }
            } catch (Exception localException) {}

            try {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Auto Lizenz") || (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Car license"))) {
                    if(p.getLicenseData().get(p.getUniqueId().toString(), "AUTO").equalsIgnoreCase("NEIN")) {
                        if(p.getPlayerData().getCash(p.getUniqueId().toString()) >= 1000) {
                            if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                                p.sendMessage(API.MARKT_prefix + "§7Du hast eine §cAuto Lizenz §7gekauft.");
                            } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                                p.sendMessage(API.MARKT_prefix + "§7You have purchased an §ccar license§7.");
                            }
                            p.getPlayerData().removeCash(p.getUniqueId().toString(), 1000);
                            p.getLicenseData().set(p.getUniqueId().toString(), "AUTO", "JA");
                            p1.closeInventory();
                            initLizenzshop(p, p1);
                            PlayerListener.updateScoreboard(p1);
                        } else {
                            int cash = 1000- p.getPlayerData().getCash(p.getUniqueId().toString());
                            if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                                p.sendMessage(API.MARKT_prefix + "§cDu benötigt weitere " + cash + "$ für eine Auto Lizenz.");
                            } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                                p.sendMessage(API.MARKT_prefix + "§cYou still need " + cash + "$ for a car license.");
                            }
                            p1.closeInventory();
                        }
                    } else if(p.getLicenseData().get(p.getUniqueId().toString(), "AUTO").equalsIgnoreCase("JA")) {
                        if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                            p.sendMessage(API.MARKT_prefix + "§cDu besitz bereits eine Auto Lizenz.");
                        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                            p.sendMessage(API.MARKT_prefix + "§cYou already have a car license.");
                        }
                        p1.closeInventory();
                    }
                }
            } catch (Exception localException) {}

            try {
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Markt Lizenz") || (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Market license"))) {
                    if(p.getLicenseData().get(p.getUniqueId().toString(), "MARKT").equalsIgnoreCase("NEIN")) {
                        if(p.getPlayerData().getCash(p.getUniqueId().toString()) >= 12000) {
                            if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                                p.sendMessage(API.MARKT_prefix + "§7Du hast eine §cMarkt Lizenz §7gekauft.");
                            } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                                p.sendMessage(API.MARKT_prefix + "§7You have purchased an §cmarkt license§7.");
                            }
                            p.getPlayerData().removeCash(p.getUniqueId().toString(), 12000);
                            p.getLicenseData().set(p.getUniqueId().toString(), "MARKT", "JA");
                            p1.closeInventory();
                            initLizenzshop(p, p1);
                            PlayerListener.updateScoreboard(p1);
                        } else {
                            int cash = 12000- p.getPlayerData().getCash(p.getUniqueId().toString());
                            if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                                p.sendMessage(API.MARKT_prefix + "§cDu benötigt weitere " + cash + "$ für eine Markt Lizenz.");
                            } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                                p.sendMessage(API.MARKT_prefix + "§cYou still need " + cash + "$ for a market license.");
                            }
                            p1.closeInventory();
                        }
                    } else if(p.getLicenseData().get(p.getUniqueId().toString(), "MARKT").equalsIgnoreCase("JA")) {
                        if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                            p.sendMessage(API.MARKT_prefix + "§cDu besitz bereits eine Markt Lizenz.");
                        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                            p.sendMessage(API.MARKT_prefix + "§cYou already have a market license.");
                        }
                        p1.closeInventory();
                    }
                }
            } catch (Exception localException) {}
        }
    }
}