package me.subhanafz.compasstrack.compasstracker.events;

import me.subhanafz.compasstrack.compasstracker.CompassTracker;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnLeave implements Listener {
    public static void onLeave(PlayerQuitEvent e){
        Player plr = e.getPlayer();
        for (Player p : CompassTracker.Speedrunners){
            if(p.equals(plr)){
                CompassTracker.Speedrunners.remove(p);
            }
        }
    }
}
