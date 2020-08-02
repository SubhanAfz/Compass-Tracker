package me.subhanafz.compasstrack.compasstracker;

import me.subhanafz.compasstrack.compasstracker.commands.*;
import me.subhanafz.compasstrack.compasstracker.events.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class CompassTracker extends JavaPlugin {

    public static CompassTracker plugin;
    public static ArrayList<Player> Speedrunners = new ArrayList<>();
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getCommand("giveCompass").setExecutor(new GiveCompass());
        getCommand("startTracking").setExecutor(new StartTracking());
        getCommand("addSpeedrunners").setExecutor(new addSpeedrunners());
        getCommand("getSpeedrunners").setExecutor(new getSpeedrunners());
        getCommand("removeSpeedrunners").setExecutor(new removeSpeedrunners());
        getServer().getPluginManager().registerEvents(new PlayerMove(), this);
        getServer().getPluginManager().registerEvents(new OnJoin(), this);
        getServer().getPluginManager().registerEvents(new OnLeave(), this);
        getServer().getPluginManager().registerEvents(new OnRespawn(), this);
        getServer().getPluginManager().registerEvents(new OnDeath(), this);
        getServer().getPluginManager().registerEvents(new OnDrop(), this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        System.out.println("Compass Tracker has started up successfully!");
    }

}
