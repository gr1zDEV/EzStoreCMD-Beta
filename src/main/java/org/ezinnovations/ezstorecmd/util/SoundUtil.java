package org.ezinnovations.ezstorecmd.util;

import org.ezinnovations.ezstorecmd.EZStoreCmd;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public final class SoundUtil {
    private SoundUtil() {
    }

    public static void playConfiguredPling(EZStoreCmd plugin, Player player) {
        boolean enabled = plugin.getConfig().getBoolean("sounds.pling.enabled", true);
        if (!enabled) {
            return;
        }

        String soundName = plugin.getConfig().getString("sounds.pling.sound", "BLOCK_NOTE_BLOCK_PLING");
        float volume = (float) plugin.getConfig().getDouble("sounds.pling.volume", 0.5);
        float pitch = (float) plugin.getConfig().getDouble("sounds.pling.pitch", 1.0);

        try {
            Sound sound = Sound.valueOf(soundName);
            player.playSound(player.getLocation(), sound, volume, pitch);
        } catch (IllegalArgumentException ex) {
            plugin.getLogger().warning(plugin.pluginPrefix() + "Invalid sound in config: " + soundName);
        }
    }
}
