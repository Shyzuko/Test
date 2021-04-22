package fr.shyzuko;

import fr.shyzuko.commands.Freeze;
import fr.shyzuko.commands.tuto;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class ReportManager extends JavaPlugin {
    public static ReportManager instance;
    public String prefix = "§3Heneria §8»";

    @Override
    public void onEnable() {
        instance = this;

        PluginManager pm = Bukkit.getServer().getPluginManager();
        getCommand("tuto").setExecutor(new tuto());
        getCommand("freeze").setExecutor(new Freeze());
        
    }

    public static ReportManager getInstance() {
        return instance;
    }

    public String getPrefix() {
        return prefix;
    }
}
