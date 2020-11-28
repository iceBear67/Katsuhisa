package io.ib67.katsuhisa.example.editconfig;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class EditConfig extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getDataFolder().mkdirs();
        getConfig().options().copyDefaults(true);
        getConfig().addDefault("enable_me",false);
        saveDefaultConfig();
        reloadConfig();
        if(!getConfig().getBoolean("enable_me")) {
            Bukkit.getScheduler().runTask(this, Bukkit::shutdown);
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Please turn on the config!");
    }
}
