package de.elrobto.MineTheftAuto.Commands;

import de.elrobto.MineTheftAuto.API.API;
import de.elrobto.MineTheftAuto.API.Player;
import de.elrobto.MineTheftAuto.Enums.MessageEnum;
import de.elrobto.MineTheftAuto.Listener.PlayerListener;
import de.elrobto.MineTheftAuto.MySQL.ContactDatabase;
import de.elrobto.MineTheftAuto.MySQL.PlayerDatabase;
import de.elrobto.MineTheftAuto.Utils;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class IngameCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = new Player((org.bukkit.entity.Player)sender);
        org.bukkit.entity.Player p1 = (org.bukkit.entity.Player)sender;

        if(cmd.getName().equalsIgnoreCase("bank")) {
            if(p1.getInventory().getItemInHand().getType() == Material.WATCH) {
                if(args.length == 0) {
                    if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                        p.sendMessage(API.OFFLINE_prefix + "§7Derzeit hast derzeit §c" + p.getPlayerData().getMoney(p.getUniqueId().toString()));
                        p.sendMessage(API.OFFLINE_prefix + "§7Falls du Geld abbuchen möchtest, brauchst du nur §c/" + cmd.getName() + " drop <Beitrag> §7nutzen.");
                    } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                        p.sendMessage(API.OFFLINE_prefix + "§7You have currently §c" + p.getPlayerData().getMoney(p.getUniqueId().toString()) + "$");
                        p.sendMessage(API.OFFLINE_prefix + "§7If you want to cancel money, you only need to do §c/" + cmd.getName() + " drop <contribution>§7.");
                    }
                } else {
                    if(args[0].equalsIgnoreCase("drop")) {
                        int money = Integer.valueOf(args[1]);
                        if(p.getPlayerData().getMoney(p.getUniqueId().toString()) >= money) {
                            p.getPlayerData().removeMoney(p.getUniqueId().toString(), money);
                            p.getPlayerData().addCash(p.getUniqueId().toString(), money);
                            PlayerListener.setAllBoards();
                            if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                                p.sendMessage(API.OFFLINE_prefix + "§7Du hast §c" + money + "$ §7von deinem Konto abgebucht.");
                            } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                                p.sendMessage(API.OFFLINE_prefix + "§7You have debited §c" + money + "$ §7from your account.");
                            }
                        } else {
                            if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                                p.sendMessage(API.OFFLINE_prefix + "§cDu hast nicht " + money + "$ auf deinem Konto. Bitte wähle einen anderen Betrag.");
                            } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                                p.sendMessage(API.OFFLINE_prefix + "§cYou do not have " + money + "$ on your account. Please choose a different amount.");
                            }
                        }
                    }
                }
            } else {
                if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                    p.sendMessage(API.OFFLINE_prefix + "§cDu musst ein Smartphone in der Hand halten um dein derzeitigen Kontostand abrufen zu können.");
                } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                    p.sendMessage(API.OFFLINE_prefix + "§cYou must hold a smartphone in your hand to retrieve your current account.");
                }
            }
        } else if(cmd.getName().equalsIgnoreCase("sms")) {
            if(p.getPlayerData().getRank(p.getUniqueId().toString()).equalsIgnoreCase("DEVELOPER")) {
                Player target = new Player(Bukkit.getPlayer(args[0]));

                if(target.isOnline()) {
                    String msg = "";
                    for (int i = 1; i < args.length; ++i) {
                        msg = String.valueOf(msg) + args[i] + " ";
                    }
                    if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                        p.sendMessage(MessageEnum.SMARTPHONE, "§cDu §8➜ §c" + target.getDisplayName() + " §8» §7" + msg);
                    } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                        p.sendMessage(MessageEnum.SMARTPHONE, "§cYou §8➜ §c" + target.getDisplayName() + " §8» §7" + msg);
                    }

                    if(target.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                        p.sendMessage(MessageEnum.SMARTPHONE, "§c" + p.getDisplayName() + " §8➜ §cDir §8» §7" + msg);
                    } else if(target.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                        p.sendMessage(MessageEnum.SMARTPHONE, "§c" + p.getDisplayName() + " §8➜ §cYou §8» §7" + msg);
                    }
                } else {
                    if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                        p.sendMessage(API.OFFLINE_prefix + "§c" + target.getDisplayName() + "§7 ist derzeit nicht auf der Insel.");
                    } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                        p.sendMessage(API.OFFLINE_prefix + "§c" + target.getDisplayName() + "§7 is currently not on the island.");
                    }
                }
            } else {
                if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                    p.sendMessage(API.OFFLINE_prefix + "§cDerzeit ist diese Funktion nur für Entwickler freigeschaltet.");
                } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                    p.sendMessage(API.OFFLINE_prefix + "§cCurrently, this feature is only available for developers.");
                }
            }
        } else if(cmd.getName().equalsIgnoreCase("contact")) {
            if(p1.getInventory().getItemInHand().getType() == Material.WATCH) {
                if(args.length == 0) {
                    if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                        p.sendMessage(API.OFFLINE_prefix + "§7Wenn du ein Kontakt entfernen oder hinzufügen möchtest dann gebe folgendes ein: §c/" + cmd.getName() + " <add/remove> <Nummer>");
                        p.sendMessage("§7Du hast derzeit §c" + p.getContactData().getContats(p.getName()) + " Kontakte§7:");
                    } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                        p.sendMessage(API.OFFLINE_prefix + "§7If you want to remove or add a contact then type: §c /" + cmd.getName () + " <add/remove> <Number>");
                        p.sendMessage("§7You have currently §c" + p.getContactData().getContats(p.getName()) + " contacts§7:");
                    }
                    final List<String> contacts = p.getContactData().getAllContacts(p.getName());
                    for (final String contact : contacts) {
                        if(p.getPlayerData().getRank(p.getUniqueId().toString()).equalsIgnoreCase("ADMIN")) {
                            p.sendMessage("§8- §4" + contact);
                        } else if(p.getPlayerData().getRank(p.getUniqueId().toString()).equalsIgnoreCase("DEVELOPER")) {
                            p.sendMessage("§8- §b" + contact);
                        } else if(p.getPlayerData().getRank(p.getUniqueId().toString()).equalsIgnoreCase("BUILDER")) {
                            p.sendMessage("§8- §2" + contact);
                        } else if(p.getPlayerData().getRank(p.getUniqueId().toString()).equalsIgnoreCase("VIP")) {
                            p.sendMessage("§8- §5" + contact);
                        } else if(p.getPlayerData().getRank(p.getUniqueId().toString()).equalsIgnoreCase("PLAYER")) {
                            p.sendMessage("§8- §7" + contact);
                        }
                    }

                } else {
                    if(args[0].equalsIgnoreCase("add")) {
                            if(Bukkit.getOfflinePlayer(args[1]).hasPlayedBefore()) {
                            if(p.getContactData().isContact(p.getName(), args[1])) {
                                if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                                    p.sendMessage(API.OFFLINE_prefix + "§cDieser Benutzer ist bereits in deiner Kontaktliste.");
                                } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                                    p.sendMessage(API.OFFLINE_prefix + "§cThis user is already in your contact list.");
                                }
                            } else {
                                p.getContactData().addContact(p.getName(), args[1]);
                            }
                        } else {
                            if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                                p.sendMessage(API.OFFLINE_prefix + "§cDieser Benutzer ist noch nicht in der Stadt gewesen.");
                            } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                                p.sendMessage(API.OFFLINE_prefix + "§cThis user has not been in town yet.");
                            }
                        }
                    } else if(args[0].equalsIgnoreCase("remove")) {
                        if(Bukkit.getOfflinePlayer(args[1]).hasPlayedBefore()) {
                            if(p.getContactData().isContact(p.getName(), args[1])) {
                                p.getContactData().removeContact(p.getName(), args[1]);
                            } else {
                                if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                                    p.sendMessage(API.OFFLINE_prefix + "§cDieser Benutzer ist nicht in deiner Kontaktliste.");
                                } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                                    p.sendMessage(API.OFFLINE_prefix + "§cThis user is not in your contact list.");
                                }
                            }
                        } else {
                            if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                                p.sendMessage(API.OFFLINE_prefix + "§cDieser Benutzer ist noch nicht in der Stadt gewesen.");
                            } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                                p.sendMessage(API.OFFLINE_prefix + "§cThis user has not been in town yet.");
                            }
                        }
                    }
                }
            } else {
                if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                    p.sendMessage(API.OFFLINE_prefix + "§cDu musst ein Smartphone in der Hand halten um deine Kontakte aufrufen zu können oder um einen hinzufügen oder entfernen zu können.");
                } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
                    p.sendMessage(API.OFFLINE_prefix + "§cYou need to hold a smartphone in your hand to access your contacts or to add or remove one.");
                }
            }
        } else if(cmd.getName().equalsIgnoreCase("giveweapon")) {
            if(p.getPlayerData().getRank(p.getUniqueId().toString()).equalsIgnoreCase("ADMIN")) {
                if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                    p.getInventory().setItem(0, Utils.createItem(Material.GOLD_HOE, 1, 0, "§7Gefechts MG"));
                } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
                    p.getInventory().setItem(0, Utils.createItem(Material.GOLD_HOE, 1, 0, "§7Battle MG"));
                }
            }
        }

        return false;
    }
}