package de.elrobto.MineTheftAuto.API;

import net.minecraft.server.v1_12_R1.IChatBaseComponent;
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_12_R1.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import de.elrobto.MineTheftAuto.Main;

public class API {
	
	public static String OFFLINE_prefix = "§fMineTheftAuto §8┃ §7";
	public static String ONLINE_prefix = "§fMineTheftOnline §8┃ §7";
	public static String MARKT_prefix = "§fMarkt §8┃ §7";
	public static String JOBS_prefix = "§eJob §8┃ §7";
	public static String HÄNDLER_prefix = "§cDealer §8┃ §7";
	public static String SYSTEM_prefix = "§4System §8┃ §7";
	public static String SMARTPHONE_prefix = "§6Smartphone §8┃ §7";

	//Deutsch
	
	public static String GERMAN_prefixnoperms = "§f§lMineTheftAuto §8┃ §cDu hast keine Rechte dazu, Falls du denkst dies sei ein Fehler kontaktiere den Support.";
	public static String GERMAN_prefixerror = "§f§lMineTheftAuto §8┃ §cEs ist ein Fehler aufgetreten (Kontaktiere ein Teammitglied), Fehlercode: �4�l#";
	
	//English
        
	public static Location getLocation(String s, boolean b) {
	    if (Main.main.getConfig().contains(s)) {
	      String string = Main.main.getConfig().getString(String.valueOf(s) + ".world");
	      double double1 = Main.main.getConfig().getDouble(String.valueOf(s) + ".x");
	      double double2 = Main.main.getConfig().getDouble(String.valueOf(s) + ".y");
	      double double3 = Main.main.getConfig().getDouble(String.valueOf(s) + ".z");
	      double double4 = 0.0D;
	      double double5 = 0.0D;
	      if (Main.main.getConfig().contains(String.valueOf(s) + ".yaw"))  {
	        double4 = Main.main.getConfig().getDouble(String.valueOf(s) + ".yaw");
	        double5 = Main.main.getConfig().getDouble(String.valueOf(s) + ".pitch");
	      }
	      Location location = new Location(Bukkit.getWorld(string), double1, double2, double3);
	      if (b) {
	        location.setYaw((float)double4);
	        location.setPitch((float)double5);
	      }
	      return location;
	    }
	    return null;
	  }
	  
	  public static void setLocation(String s, Location location, boolean b) {
		Main.main.getConfig().set(String.valueOf(s) + ".world", location.getWorld().getName());
	    Main.main.getConfig().set(String.valueOf(s) + ".x", Double.valueOf(location.getX()));
	    Main.main.getConfig().set(String.valueOf(s) + ".y", Double.valueOf(location.getY()));
	    Main.main.getConfig().set(String.valueOf(s) + ".z", Double.valueOf(location.getZ()));
	    if (b) {
	    	Main.main.getConfig().set(String.valueOf(s) + ".yaw", Float.valueOf(location.getYaw()));
	    	Main.main.getConfig().set(String.valueOf(s) + ".pitch", Float.valueOf(location.getPitch()));
	    }
	    Main.main.saveConfig();
	  }
	  
	  public static void sendTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle) {
	    PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
	    PacketPlayOutTitle packetPlayOutTimes = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, fadeIn.intValue(), stay.intValue(), fadeOut.intValue());
	    connection.sendPacket(packetPlayOutTimes);
	    if (subtitle != null) {
	      subtitle = subtitle.replaceAll("%player%", player.getDisplayName());
	      subtitle = ChatColor.translateAlternateColorCodes('&', subtitle);
	      IChatBaseComponent titleSub = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
	      PacketPlayOutTitle packetPlayOutSubTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, titleSub);
	      connection.sendPacket(packetPlayOutSubTitle);
	    }
	    if (title != null) {
	      title = title.replaceAll("%player%", player.getDisplayName());
	      title = ChatColor.translateAlternateColorCodes('&', title);
	      IChatBaseComponent titleMain = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
	      PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleMain);
	      connection.sendPacket(packetPlayOutTitle);
	    }
	  }
	  
	  public static void sendTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title) {
	    PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
	    PacketPlayOutTitle packetPlayOutTimes = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, fadeIn.intValue(), stay.intValue(), fadeOut.intValue());
	    connection.sendPacket(packetPlayOutTimes);
	    if (title != null) {
	      title = title.replaceAll("%player%", player.getDisplayName());
	      title = ChatColor.translateAlternateColorCodes('&', title);
	      IChatBaseComponent titleMain = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
	      PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleMain);
	      connection.sendPacket(packetPlayOutTitle);
	    }
	  }
	  
	  public static void deleteEntities(World world) {
	    for (Entity e : world.getEntities()) {
	      if (e.getType() != EntityType.PLAYER) {
	        e.remove();
	      }
	    }
	  }
}