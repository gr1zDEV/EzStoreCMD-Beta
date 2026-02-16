package org.ezinnovations.ezstorecmd;

import org.ezinnovations.ezstorecmd.commands.EZStoreCommand;
import org.ezinnovations.ezstorecmd.commands.StoreCommand;
import org.jetbrains.annotations.NotNull;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class EZStoreCmd extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        registerCommands();
        getLogger().info("EZStoreCmd enabled.");
    }

    private void registerCommands() {
        PluginCommand store = getCommand("store");
        PluginCommand ezstore = getCommand("ezstore");

        if (store == null || ezstore == null) {
            throw new IllegalStateException("Commands not found in plugin.yml");
        }

        store.setExecutor(new StoreCommand(this));
        ezstore.setExecutor(new EZStoreCommand(this));
    }

    public void reloadPluginConfig() {
        reloadConfig();
    }

    public @NotNull String pluginPrefix() {
        return "[EZStoreCmd] ";
    }
}
