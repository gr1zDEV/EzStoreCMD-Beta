package org.ezinnovations.ezstorecmd.commands;

import org.ezinnovations.ezstorecmd.EZStoreCmd;
import org.ezinnovations.ezstorecmd.util.MessageUtil;
import org.ezinnovations.ezstorecmd.util.SoundUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StoreCommand implements CommandExecutor {
    private final EZStoreCmd plugin;

    public StoreCommand(EZStoreCmd plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        String link = plugin.getConfig().getString("message.link", "store.2bz.org");
        List<String> storeLines = plugin.getConfig().getStringList("message.store");

        for (String line : storeLines) {
            String parsed = line.replace("%link%", link);
            if (sender instanceof Player) {
                sender.sendMessage(MessageUtil.colorize(parsed));
            } else {
                sender.sendMessage(MessageUtil.stripColor(parsed));
            }
        }

        if (sender instanceof Player player) {
            SoundUtil.playConfiguredPling(plugin, player);
        }

        return true;
    }
}
