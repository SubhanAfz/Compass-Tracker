package me.subhanafz.compasstrack.compasstracker;

import me.subhanafz.compasstrack.compasstracker.commands.GiveCompass;
import me.subhanafz.compasstrack.compasstracker.commands.Track;
import me.subhanafz.compasstrack.compasstracker.events.OnJoin;
import me.subhanafz.compasstrack.compasstracker.events.PlayerMove;
import org.bukkit.plugin.java.JavaPlugin;

public final class CompassTracker extends JavaPlugin {

    public static CompassTracker plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getCommand("giveCompass").setExecutor(new GiveCompass());
        getCommand("track").setExecutor(new Track());
        getServer().getPluginManager().registerEvents(new PlayerMove(), this);
        getServer().getPluginManager().registerEvents(new OnJoin(), this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        System.out.println("Compass Tracker has started up successfully!");
    }

}
