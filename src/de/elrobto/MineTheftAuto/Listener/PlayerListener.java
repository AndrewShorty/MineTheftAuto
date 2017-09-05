package de.elrobto.MineTheftAuto.Listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import de.elrobto.MineTheftAuto.Main;
import de.elrobto.MineTheftAuto.MySQL.PlayerDatabase;

public class PlayerListener implements Listener {

    public Main plugin;

    public PlayerListener(Main Instance) {
        this.plugin = Instance;
    }

    public static void createBoard(Player p1) {
        de.elrobto.MineTheftAuto.API.Player p = new de.elrobto.MineTheftAuto.API.Player(p1);

        Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = sb.registerNewObjective("fff", "ggg");
        obj.setDisplayName("§cMINETHEFTAUTO");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score s = obj.getScore("§a");
        Score s1 = obj.getScore("§b");
        Score s2 = obj.getScore("§c");
        Score s3 = obj.getScore("§d");
        Score s4 = obj.getScore("§e");
        Score s5 = obj.getScore("§7");

        Score srang = null;
        if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
            srang = obj.getScore("§8• §7Rang");
        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
            srang = obj.getScore("§8• §7Rank");
        }
        Score rang = obj.getScore("   §8§l» §e" + p.getPlayerData().getRang(p.getUniqueId().toString()));

        Score slevel = null;
        if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
            slevel = obj.getScore("§8• §7Level");
        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
            slevel = obj.getScore("§8• §7Level");
        }
        Score level = obj.getScore("   §8§l» §e" + p.getPlayerData().getLevel(p.getUniqueId().toString()));

        Score swanted = null;
        if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
            swanted = obj.getScore("§8• §7Sterne");
        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
            swanted = obj.getScore("§8• §7Stars");
        }
        Score wanted = null;
        if(p.getPlayerData().getWanted(p.getUniqueId().toString()) == 5) {
            wanted = obj.getScore("   §8§l» §e➊ ➋ ➌ ➍ ➎");
        } else if(p.getPlayerData().getWanted(p.getUniqueId().toString()) == 4) {
            wanted = obj.getScore("   §8§l» §e➊ ➋ ➌ ➍ ➄");
        } else if(p.getPlayerData().getWanted(p.getUniqueId().toString()) == 3) {
            wanted = obj.getScore("   §8§l» §e➊ ➋ ➌ ➃ ➄");
        } else if(p.getPlayerData().getWanted(p.getUniqueId().toString()) == 2) {
            wanted = obj.getScore("   §8§l» §e➊ ➋ ➂ ➃ ➄");
        } else if(p.getPlayerData().getWanted(p.getUniqueId().toString()) == 1) {
            wanted = obj.getScore("   §8§l» §e➊ ➁ ➂ ➃ ➄");
        } else if(p.getPlayerData().getWanted(p.getUniqueId().toString()) == 0) {
            wanted = obj.getScore("   §8§l» §e➀ ➁ ➂ ➃ ➄");
        }

        Score smoney = obj.getScore("§8• §7Bank");
        Score money = obj.getScore("   §4§8§l» §e" + p.getPlayerData().getMoney(p.getUniqueId().toString()) + "$");

        Score scash = null;
        if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("DE")) {
            scash = obj.getScore("§8• §7Bargeld");
        } else if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("EN")) {
            scash = obj.getScore("§8• §7Cash");
        }
        Score cash = obj.getScore("   §8§l» §e" + p.getPlayerData().getCash(p.getUniqueId().toString()) + "$");

        Score UNKNOW = obj.getScore("§c§lPlease Choose a Language!");
        Score UNKNOW_CMD = obj.getScore("§cUse: §4§l/lang");

        if(p.getPlayerData().getLanguage(p.getUniqueId().toString()).equalsIgnoreCase("UNKNOW")) {
            UNKNOW.setScore(0);
            UNKNOW_CMD.setScore(-1);
        } else {
            s5.setScore(15);
            swanted.setScore(14);
            wanted.setScore(13);
            s4.setScore(12);
            srang.setScore(11);
            rang.setScore(10);
            s3.setScore(9);
            slevel.setScore(8);
            level.setScore(7);
            s2.setScore(6);
            smoney.setScore(5);
            money.setScore(4);
            s1.setScore(3);
            scash.setScore(2);
            cash.setScore(1);
            s.setScore(0);
        }

        joinTeam(sb, p1, p);

        p1.setScoreboard(sb);
    }

    public static void updateScoreboard(Player p) {
        setAllBoards();
    }

    static void joinTeam(Scoreboard sb, Player a, de.elrobto.MineTheftAuto.API.Player pi) {
        sb.registerNewTeam("003Spieler");
        sb.getTeam("003Spieler").setPrefix("§7");

        sb.registerNewTeam("002Developer");
        sb.getTeam("002Developer").setPrefix("§bDev §8× §b");

        sb.registerNewTeam("001Admin");
        sb.getTeam("001Admin").setPrefix("§4Admin §8× §4");

        for (Player p : Bukkit.getOnlinePlayers()) {
            String team = "";
            if(pi.getPlayerData().getRank(pi.getUniqueId().toString()).equalsIgnoreCase("ADMIN")) {
                team = "001Admin";
            } else if(pi.getPlayerData().getRank(pi.getUniqueId().toString()).equalsIgnoreCase("DEVELOPER")) {
                team = "002Developer";
            } else {
                team = "003Spieler";
            }
            if (sb == null) {
                Bukkit.broadcastMessage("");
            }
            if (team == null) {
                Bukkit.broadcastMessage("");
            }
            if (p == null) {
                Bukkit.broadcastMessage("");
            }
            if (sb.getTeam(team) == null) {
                Bukkit.broadcastMessage("");
            }
            sb.getTeam(team).addPlayer(p);
        }
    }

    public static void setAllBoards() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            createBoard(p);
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        de.elrobto.MineTheftAuto.API.Player pi = new de.elrobto.MineTheftAuto.API.Player(p);

        for(Player all : Bukkit.getOnlinePlayers()) {
            if(pi.getPlayerData().getRank(pi.getUniqueId().toString()).equalsIgnoreCase("ADMIN")) {
                all.sendMessage("§4" + p.getName() + " §8» §7" + e.getMessage());
            } else if(pi.getPlayerData().getRank(pi.getUniqueId().toString()).equalsIgnoreCase("DEVELOPER   ")) {
                all.sendMessage("§b" + p.getName() + " §8» §7" + e.getMessage());
            } else {
                all.sendMessage("§7" + p.getName() + " §8» §7" + e.getMessage());
            }
        }

        e.setCancelled(true);
    }
}