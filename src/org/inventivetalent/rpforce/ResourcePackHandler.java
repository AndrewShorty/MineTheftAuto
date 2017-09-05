package org.inventivetalent.rpforce;

import de.elrobto.MineTheftAuto.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.Bukkit;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.inventivetalent.rpapi.ResourcePackAPI;
import org.inventivetalent.rpapi.ResourcePackStatusEvent;

public class ResourcePackHandler implements Listener
{
    public static void setPack(final Player p) {
        ResourcePackAPI.setResourcepack(p, "https://gta.Minerax.eu/dl/Pack.zip", "GTA_Pack");
    }
    
    @EventHandler
    public void onResourcePackStatus(final ResourcePackStatusEvent e) {
        if (e.getHash() != null) {
            return;
        }
        Main.instance.getLogger().info("Result of " + e.getPlayer().getName() + ": " + e.getStatus());
        boolean accepted = true;
        switch (e.getStatus()) {
            case ACCEPTED: {
                break;
            }
            case SUCCESSFULLY_LOADED: {
                break;
            }
            case DECLINED: {
                accepted = false;
                break;
            }
            case FAILED_DOWNLOAD: {
                accepted = false;
                break;
            }
        }
        if (accepted) {
            e.getPlayer().setMetadata("rp_force_accepted", (MetadataValue)new FixedMetadataValue((Plugin)Main.instance, (Object)true));
        } else {
            e.getPlayer().removeMetadata("rp_force_accepted", (Plugin)Main.instance);
            //if (RPForcePlugin.KICK_ON_DENY) {
                Bukkit.getScheduler().runTask((Plugin)Main.instance, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        e.getPlayer().kickPlayer("PACKNOTACCEPT");
                    }
                });
            //}
        }
    }
}
