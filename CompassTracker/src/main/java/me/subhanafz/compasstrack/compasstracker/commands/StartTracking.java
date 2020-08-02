package me.subhanafz.compasstrack.compasstracker.commands;

import me.subhanafz.compasstrack.compasstracker.events.PlayerMove;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class StartTracking implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player plr = (Player)sender;
            if (plr.hasPermission("compasstrack.starttracking")){
                PlayerMove playerMove = new PlayerMove();

                if(PlayerMove.isTracking == true){
                    PlayerMove.isTracking=false;
                    plr.sendMessage(ChatColor.RED + "Tracking has been disabled!");
                }else{
                    PlayerMove.isTracking = true;
                    plr.sendMessage(ChatColor.GREEN + "Tracking has been enabled!");
                }
            }else{
                plr.sendMessage(ChatColor.DARK_RED +"You don't have permission to use this command!");
            }

        }
        return true;
    }
}