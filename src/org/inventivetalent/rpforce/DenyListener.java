// 
// Decompiled by Procyon v0.5.30
// 

package org.inventivetalent.rpforce;

import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;

public class DenyListener implements Listener
{
    static String PERM_BYPASS;
    
    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        if (deny(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onInteractEntity(final PlayerInteractEntityEvent e) {
        if (deny(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onDamage(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && deny((Player)e.getDamager())) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onTeleport(final PlayerTeleportEvent e) {
        if (!e.getFrom().getWorld().equals(e.getTo().getWorld()) && deny(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onChat(final AsyncPlayerChatEvent e) {
        if (deny(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onBlockPlace(final BlockPlaceEvent e) {
        if (deny(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onBlockBreak(final BlockBreakEvent e) {
        if (deny(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onMove(final PlayerMoveEvent e) {
        if (deny(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
    
    public static boolean deny(final Player p) {
        if (!p.hasMetadata("rp_force_accepted") && !p.hasPermission(DenyListener.PERM_BYPASS)) {
            return true;
        }
        return false;
    }
    
    static {
        DenyListener.PERM_BYPASS = "nope";
    }
}
