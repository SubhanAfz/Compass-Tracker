package me.subhanafz.compasstrack.compasstracker.events;

import me.subhanafz.compasstrack.compasstracker.CompassTracker;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class OnRespawn implements Listener {
    @EventHandler
    public void onPlayerRespawn(PlayerDropItemEvent e){
        Player p = e.getPlayer();
        FileConfiguration config = CompassTracker.plugin.getConfig();
        if (config.getBoolean("RemoveCompassOnHunterDeath")){
            if(!CompassTracker.Speedrunners.contains(p) && e.getItemDrop().getItemStack().getType() == Material.COMPASS ){
                e.setCancelled(true);
            }
        }
    }
}
