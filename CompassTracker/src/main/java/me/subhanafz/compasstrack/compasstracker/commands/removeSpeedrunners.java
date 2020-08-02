package me.subhanafz.compasstrack.compasstracker.commands;

import me.subhanafz.compasstrack.compasstracker.CompassTracker;
import me.subhanafz.compasstrack.compasstracker.Functions.getPlayerFromPlayerName;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class removeSpeedrunners implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player plr = (Player)sender;
            if(plr.hasPermission("compasstrack.removeSpeedrunners")){
                if (args.length > 0){
                    getPlayerFromPlayerName getPlayerFromPlayerName= new getPlayerFromPlayerName();
                    Player stringplr = getPlayerFromPlayerName.getPlayerFromName(args[0]);
                    if (stringplr.equals(null)){
                        plr.sendMessage(ChatColor.RED + "This player is not inside the server!");
                    }
                    CompassTracker.Speedrunners.remove(stringplr);
                    plr.sendMessage(ChatColor.GREEN + "This player has been removed successfully!");
                }else{
                    plr.sendMessage(ChatColor.RED + "You have not specified any arguments!");
                    plr.sendMessage(ChatColor.RED + "/removeSpeedrunners [Player]");
                }
            }else{
                plr.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
            }
        }
        return false;
    }
}
