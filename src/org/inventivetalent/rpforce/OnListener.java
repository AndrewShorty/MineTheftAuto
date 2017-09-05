package org.inventivetalent.rpforce;

import de.elrobto.MineTheftAuto.Main;
import org.bukkit.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class OnListener implements Listener {
    public static void set(final Player p) {
        Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
            @Override
            public void run() {
                if (p.isOnline()) {
                    ResourcePackHandler.setPack(p);
                }
            }
        }, 10L);
    }
}
