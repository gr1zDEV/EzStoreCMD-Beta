package org.ezinnovations.ezstorecmd.commands;

import org.ezinnovations.ezstorecmd.EZStoreCmd;
import org.ezinnovations.ezstorecmd.util.MessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EZStoreCommand implements CommandExecutor {
    private final EZStoreCmd plugin;

    public EZStoreCommand(EZStoreCmd plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            if (sender instanceof Player && !sender.hasPermission("ezstore.admin")) {
                sender.sendMessage(MessageUtil.colorize("&cYou do not have permission to use this command."));
                return true;
            }

            plugin.reloadPluginConfig();
            List<String> reloadLines = plugin.getConfig().getStringList("message.reload");

            for (String line : reloadLines) {
                if (sender instanceof Player) {
                    sender.sendMessage(MessageUtil.colorize(line));
                } else {
                    sender.sendMessage(MessageUtil.stripColor(line));
                }
            }

            return true;
        }

        sender.sendMessage(MessageUtil.colorize("&fUsage: &b/ezstore reload"));
        return true;
    }
}
