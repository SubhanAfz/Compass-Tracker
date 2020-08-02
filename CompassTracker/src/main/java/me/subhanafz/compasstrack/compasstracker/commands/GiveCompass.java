package me.subhanafz.compasstrack.compasstracker.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveCompass  implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player plr = (Player)sender;
            if(plr.hasPermission("compasstrack.giveCompass")){
                ItemStack compass = new ItemStack(Material.COMPASS);
                plr.getInventory().addItem(compass);
            }else{
                plr.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
            }
        }
        return true;
    }
}
