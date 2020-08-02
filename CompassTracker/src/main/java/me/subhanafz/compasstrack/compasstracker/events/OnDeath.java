package me.subhanafz.compasstrack.compasstracker.events;

import me.subhanafz.compasstrack.compasstracker.CompassTracker;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class OnDeath implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        Player p = e.getEntity();
        FileConfiguration config = CompassTracker.plugin.getConfig();
        if (config.getBoolean("RemoveCompassOnHunterDeath")){
            if(!CompassTracker.Speedrunners.contains(p)){
                e.getDrops().removeIf(next -> (next.getType() == Material.COMPASS));
            }
        }
    }
}
