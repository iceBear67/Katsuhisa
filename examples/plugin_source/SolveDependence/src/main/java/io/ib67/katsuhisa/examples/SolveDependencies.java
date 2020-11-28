package io.ib67.katsuhisa.examples;

import org.bukkit.plugin.java.JavaPlugin;

public final class SolveDependencies extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Plugin is running!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
