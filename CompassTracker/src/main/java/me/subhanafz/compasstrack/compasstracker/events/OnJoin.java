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


public class OnJoin implements Listener {

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){
        Player p = e.getPlayer();
        FileConfiguration config = CompassTracker.plugin.getConfig();
        if (config.getBoolean("giveCompassOnSpawn")){
            ItemStack compass = new ItemStack(Material.COMPASS);
            p.getInventory().addItem(compass);
        }
        String player = config.getString("TrackPlayerAuto");
        if (p.getPlayerListName() == player){
            CompassTracker.Speedrunners.add(p);
        }

    }

}
