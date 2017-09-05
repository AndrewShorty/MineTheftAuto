package de.elrobto.MineTheftAuto;

import java.util.Random;

import de.elrobto.MineTheftAuto.Commands.SetWarp;
import de.elrobto.MineTheftAuto.Listener.SignChange;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import de.elrobto.MineTheftAuto.API.API;
import de.elrobto.MineTheftAuto.Commands.Edit;
import de.elrobto.MineTheftAuto.Commands.IngameCommands;
import de.elrobto.MineTheftAuto.Commands.Language;
import de.elrobto.MineTheftAuto.Listener.HändlerListener;
import de.elrobto.MineTheftAuto.Listener.JoinQuitListener;
import de.elrobto.MineTheftAuto.Listener.PlayerListener;
import de.elrobto.MineTheftAuto.Listener.WeaponListener;
import de.elrobto.MineTheftAuto.MySQL.MySQL;
import java.net.MalformedURLException;
import java.net.URL;
import org.bukkit.entity.Player;

public class Main extends JavaPlugin {
	
        public static Main instance;
	public static Main main;
	public boolean händler;
	public static MySQL mysql;
	/*public NPC w1;
	public NPC w2;
	public NPC w3;
	public NPC w4;
	public NPC w5;
        
        public NPC farmer;
        public NPC fisher;
        public NPC gardener;*/
	
	@Override
	public void onEnable() {
		main = this;
		händler = true;
		
		mysql = new MySQL("localhost", "GTA_Server", "root", "QfTxwUrWKqVhEGpJgBR4xuXqB2Mp7r4MwNaRyrE8", "3306");
        mysql.connect();
        mysql.update("CREATE TABLE IF NOT EXISTS GTA_PLAYER(UUID varchar(64), NAME varchar(16), RANK varchar(28), NUMBER varchar(20), LANGUAGE varchar(64), RANG varchar(64), WANTED int, LEVEL int, MONEY int, CASH int);");
		mysql.update("CREATE TABLE IF NOT EXISTS GTA_LICENSE(UUID varchar(64), PERSO varchar(10), WAFFEN varchar(10), AUTO varchar(10), JOB varchar(10), MARKT varchar(10));");
		mysql.update("CREATE TABLE IF NOT EXISTS GTA_Contacts(PLAYER varchar(16), CONTACT varchar(16));");
                
		Bukkit.getConsoleSender().sendMessage(API.OFFLINE_prefix + "§c§lMineTheftAuto §7wurde §agestartet§7.");
		Bukkit.getConsoleSender().sendMessage(API.OFFLINE_prefix + "§7Du verwendest die neuste MineTheftAuto version.");
		
		Bukkit.getPluginManager().registerEvents(new HändlerListener(), this);
		Bukkit.getPluginManager().registerEvents(new JoinQuitListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerListener(this), this);
		Bukkit.getPluginManager().registerEvents(new SignChange(), this);
        Bukkit.getPluginManager().registerEvents(new WeaponListener(), this);
		
		//getCommand("setpos").setExecutor(new SetPos());
		getCommand("language").setExecutor(new Language());
		getCommand("edit").setExecutor(new Edit());
		getCommand("setwarp").setExecutor(new SetWarp());
        getCommand("sms").setExecutor(new IngameCommands());
		getCommand("bank").setExecutor(new IngameCommands());
        getCommand("contact").setExecutor(new IngameCommands());
        getCommand("giveweapon").setExecutor(new IngameCommands());
                
		/*w1 = new NPC("Testopfer", "§7Waffenhändler", "§7Waffenhändler", new Random().nextInt(10000), API.getLocation("WaffenH.1", true), Material.BOW, true);
		w2 = new NPC("Testopfer", "§7Waffenhändler", "§7Waffenhändler", new Random().nextInt(10000), API.getLocation("WaffenH.2", true), Material.BOW, true);
		w3 = new NPC("Testopfer", "§7Waffenhändler", "§7Waffenhändler", new Random().nextInt(10000), API.getLocation("WaffenH.3", true), Material.BOW, true);
		w4 = new NPC("Testopfer", "§7Waffenhändler", "§7Waffenhändler", new Random().nextInt(10000), API.getLocation("WaffenH.4", true), Material.BOW, true);
		w5 = new NPC("Testopfer", "§7Waffenhändler", "§7Waffenhändler", new Random().nextInt(10000), API.getLocation("WaffenH.5", true), Material.BOW, true);
		w1.spawn();
		w2.spawn();
		w3.spawn();
		w4.spawn();
		w5.spawn();
		Bukkit.getConsoleSender().sendMessage(API.OFFLINE_prefix + "§aWaffenhändler wurden gespawnt.");*/
                
        Bukkit.getConsoleSender().sendMessage(API.OFFLINE_prefix + "§cDie interne NPC API wurde deaktiviert. Es könnten Probleme auftreten.");
                
                /*farmer = new NPC("Farmer", "§7Farmer", "§7Farmer", new Random().nextInt(10000), API.getLocation("farmer", true), Material.WHEAT, true);
		farmer.spawn();
		Bukkit.getConsoleSender().sendMessage(API.OFFLINE_prefix + "§aFarmer wurden gespawnt.");
                
                fisher = new NPC("Farmer", "§7Fisher", "§7Fisher", new Random().nextInt(10000), API.getLocation("fisher", true), Material.WHEAT, true);
		fisher.spawn();
		Bukkit.getConsoleSender().sendMessage(API.OFFLINE_prefix + "§aFischer wurden gespawnt.");
                
                gardener = new NPC("Farmer", "§7Gardener", "§7Gardener", new Random().nextInt(10000), API.getLocation("gaertner", true), Material.WHEAT, true);
		gardener.spawn();
		Bukkit.getConsoleSender().sendMessage(API.OFFLINE_prefix + "§aGärtner wurden gespawnt.");*/
                
                instance = this;
                //this.saveDefaultConfig();
                //Bukkit.getPluginManager().registerEvents((Listener)new ResourcePackHandler(), (Plugin)this);
                //Bukkit.getPluginManager().registerEvents((Listener)new DenyListener(), (Plugin)this);
                //Bukkit.getPluginManager().registerEvents((Listener)new OnListener(), (Plugin)this);
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(API.OFFLINE_prefix + "§c§lMineTheftAuto §7wurde §cgestoppt§7.");
		/*w1.despawn();
		w2.despawn();
		w3.despawn();
		w4.despawn();
		w5.despawn();*/
	}
	
	@Override
	public void onLoad() {
		Bukkit.getConsoleSender().sendMessage(API.OFFLINE_prefix + "§c§lMineTheftAuto §7wird §6geladen§7. Bitte warte..");
	}
        
    public static void sendMessage(final Player p, final String message) {
	    if (message != null && !message.isEmpty()) {
            p.sendMessage(message);
        }
    }

        private String parseLink(final String link) {
            if (link == null || link.isEmpty()) {
                return link;
            }
            URL url = null;
            try {
                url = new URL(link);
            }
            catch (MalformedURLException e) {
                this.getLogger().warning("Invalid resource pack URL: " + link);
            }
            if (url == null) {
                return link;
            }
            return url.toString();
        }

        String colorize(final String s) {
            return s.replaceAll("(&([a-fk-or0-9]))", "�$2");
        }
}