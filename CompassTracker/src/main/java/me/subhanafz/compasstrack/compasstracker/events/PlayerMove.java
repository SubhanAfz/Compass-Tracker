package me.subhanafz.compasstrack.compasstracker.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class PlayerMove implements Listener {
    public static String targetName;

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        Player plr = e.getPlayer();
        if (plr.getWorld().getEnvironment() == World.Environment.NORMAL){
            //System.out.println(plr.getPlayerListName());
            String plrName = plr.getPlayerListName();
            if (plrName.equals(targetName)){
                for(Player p : Bukkit.getOnlinePlayers()){
                    p.setCompassTarget(plr.getLocation());
                    //System.out.println(p.getCompassTarget());
                }
            }
        }

    }

}

