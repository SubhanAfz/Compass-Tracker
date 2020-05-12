package me.subhanafz.compasstrack.compasstracker.commands;

import me.subhanafz.compasstrack.compasstracker.events.PlayerMove;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Track implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player plr = (Player)sender;
            if (args.length > 0){
                if (plr.hasPermission("compasstrack.track")){
                    PlayerMove playerMove = new PlayerMove();
                    playerMove.targetName = args[0];
                }else{
                    plr.sendMessage(ChatColor.DARK_RED +"You don't have permission to use the /track command!");
                }

            }
            else{
                plr.sendMessage("Your command doesn't contain argument");
                plr.sendMessage("/track [playerName]");
            }
        }

        return  true;
    }
}
