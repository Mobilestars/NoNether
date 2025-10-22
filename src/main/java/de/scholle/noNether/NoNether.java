package de.scholle.noNether;

import org.bukkit.plugin.java.JavaPlugin;

public class NoNether extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new NoNetherListener(this), this);
        getLogger().info("NoNether enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("NoNether disabled!");
    }
}
