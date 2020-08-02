package me.subhanafz.compasstrack.compasstracker.commands;

import me.subhanafz.compasstrack.compasstracker.CompassTracker;
import me.subhanafz.compasstrack.compasstracker.Functions.getPlayerFromPlayerName;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class addSpeedrunners implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player plr = (Player)sender;
            if(plr.hasPermission("compasstrack.addSpeedrunners")){
                if (args.length > 0 ){
                    for (Player p : CompassTracker.Speedrunners){
                        if(p.getPlayerListName().equals(args[0])){
                            plr.sendMessage(ChatColor.RED + "You already have this player inside the table.");
                            return false;
                        }
                    }
                    // first turn player string into actual player
                    getPlayerFromPlayerName func = new getPlayerFromPlayerName();
                    Player stringPlayer = getPlayerFromPlayerName.getPlayerFromName(args[0]);
                    if(stringPlayer.equals(null)){
                        plr.sendMessage(ChatColor.RED + "This player is not inside the server!");
                    }else{
                        CompassTracker.Speedrunners.add(stringPlayer);
                        plr.sendMessage(ChatColor.GREEN + "This player has been added successfully!");
                    }


                }else{
                    plr.sendMessage(ChatColor.RED + "You do not contain any arguments in the command");
                    plr.sendMessage(ChatColor.RED + "/addSpeedrunners [Player]");
                    return false;
                }
            }else{
                plr.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
                return false;
            }
        }
        return false;
    }
}
