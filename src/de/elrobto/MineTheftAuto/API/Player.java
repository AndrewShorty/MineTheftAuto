package de.elrobto.MineTheftAuto.API;

import de.dytanic.cloudnet.api.CloudAPI;
import de.dytanic.cloudnet.bridge.CloudServer;
import de.dytanic.cloudnet.lib.player.permission.PermissionGroup;
import de.elrobto.MineTheftAuto.Enums.MessageEnum;
import de.elrobto.MineTheftAuto.MySQL.ContactDatabase;
import de.elrobto.MineTheftAuto.MySQL.LicenseDatabase;
import de.elrobto.MineTheftAuto.MySQL.PlayerDatabase;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.inventory.Inventory;

import java.util.UUID;

public class Player {

    private org.bukkit.entity.Player p;

    public Player(org.bukkit.entity.Player p1) {
        p = p1;
    }

    public void sendMessage(String message) {
        p.sendMessage(message);
    }

    public void sendMessage(MessageEnum prefix, String message) {
        if(prefix == MessageEnum.OFFLINE) {
            p.sendMessage(API.OFFLINE_prefix + message);
        } else if(prefix == MessageEnum.ONLINE) {
            p.sendMessage(API.ONLINE_prefix + message);
        } else if(prefix == MessageEnum.MARKT) {
            p.sendMessage(API.MARKT_prefix + message);
        } else if(prefix == MessageEnum.JOBS) {
            p.sendMessage(API.JOBS_prefix + message);
        } else if(prefix == MessageEnum.HÄNDLER) {
            p.sendMessage(API.HÄNDLER_prefix + message);
        } else if(prefix == MessageEnum.SYSTEM) {
            p.sendMessage(API.SYSTEM_prefix + message);
        } else if(prefix == MessageEnum.SMARTPHONE) {
            p.sendMessage(API.SMARTPHONE_prefix + message);
        } else {
            p.sendMessage(API.ONLINE_prefix + message);
        }
    }

    public PlayerDatabase getPlayerData() {
        PlayerDatabase database = new PlayerDatabase();
        return database;
    }

    public ContactDatabase getContactData() {
        ContactDatabase database = new ContactDatabase();
        return database;
    }

    public LicenseDatabase getLicenseData() {
        LicenseDatabase database = new LicenseDatabase();
        return database;
    }

    public void sendMessage(String prefix, String message) {
        p.sendMessage(prefix + message);
    }

    public PermissionGroup hasRank() {
        final PermissionGroup rank = CloudServer.getInstance().getCloudPlayers().get(p.getUniqueId()).getPermissionEntity().getHighestPermissionGroup(CloudAPI  .getInstance().getPermissionPool());
        return rank;
    }

    public String getName() {
        String a = p.getName();
        return a;
    }

    public String getDisplayName() {
        String a = p.getDisplayName();
        return a;
    }

    public String getCustomName() {
        String a = p.getCustomName();
        return a;
    }

    public String getPlayerListName() {
        String a = p.getPlayerListName();
        return a;
    }

    public String setDisplayName(String name) {
        p.setDisplayName(name);
        return null;
    }

    public String setCustomName(String name) {
        p.setCustomName(name);
        return null;
    }

    public String setPlayerListName(String name) {
        p.setPlayerListName(name);
        return null;
    }

    public boolean isOnline() {
        boolean a = p.isOnline();
        return a;
    }

    public UUID getUniqueId() {
        UUID uuid = p.getUniqueId();
        return p.getUniqueId();
    }

    public Inventory getInventory() {
        Inventory a = p.getInventory();
        return a;
    }

    public Location getLocation() {
        Location loc = p.getLocation();
        return loc;
    }

    public Location teleport(org.bukkit.entity.Player target) {
        p.teleport(target);
        return teleport(target);
    }

    public Location teleport(World W, Integer X, Integer Y, Integer Z) {
        Location loc = new Location((World) W, X, Y, Z);
        p.teleport(loc);
        return teleport(W, X, Y, Z);
    }

    public Location teleport(World W, Integer X, Integer Y, Integer Z, float yaw, float pitch) {
        Location loc = new Location((World) W, X, Y, Z, (float) yaw, (float) pitch);
        p.teleport(loc);
        return teleport(W, X, Y, Z, yaw, pitch);
    }
}