package me.subhanafz.compasstrack.compasstracker.commands;

import me.subhanafz.compasstrack.compasstracker.CompassTracker;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class getSpeedrunners implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player plr = (Player)sender;
            String str = "";
            if(plr.hasPermission("compasstrack.getSpeedrunners")){
                for(Player p : CompassTracker.Speedrunners){
                   str = str + p.getPlayerListName() + ", ";
                }
                    plr.sendMessage(str);

            }else{
                plr.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
            }
        }
        return false;
    }
}
