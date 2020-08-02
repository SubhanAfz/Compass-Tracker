package me.subhanafz.compasstrack.compasstracker.events;

import me.subhanafz.compasstrack.compasstracker.CompassTracker;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.List;

public class PlayerMove implements Listener {
    public static boolean isTracking = false;
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
       if(!isTracking){
           return;
       }
        Player plr = e.getPlayer();
        Location plrLocation = plr.getLocation();
        if (plr.getWorld().getEnvironment() == World.Environment.NORMAL){
            //System.out.println(plr.getPlayerListName());
            String plrName = plr.getPlayerListName();
            double LowestDistance = Double.MAX_VALUE;
            Location LowestLocation = plr.getLocation();
            for (Player p : CompassTracker.Speedrunners){
                if(!p.getPlayerListName().equals(plrName)) {
                    // this is not yourself
                    if (p.getWorld().getEnvironment() == World.Environment.NORMAL) {
                        Location pLocation = p.getLocation();


                        if (LowestDistance > plrLocation.distance(pLocation)) {
                            LowestDistance = plrLocation.distance(pLocation);
                            LowestLocation = pLocation;
                        }

                    }
                }
            }

            // we now have the lowest location and distance
            plr.setCompassTarget(LowestLocation);


        }

    }

}

