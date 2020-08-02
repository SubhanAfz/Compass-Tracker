package me.subhanafz.compasstrack.compasstracker.Functions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class getPlayerFromPlayerName {
    public static Player getPlayerFromName(String str){
        for(Player p: Bukkit.getOnlinePlayers()){
            if(p.getPlayerListName().equals(str)){
                return p;
            }
        }

        return null;
    }
}
