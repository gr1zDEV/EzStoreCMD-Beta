package org.ezinnovations.ezstorecmd.util;

import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MessageUtil {
    private static final Pattern HEX_PATTERN = Pattern.compile("&#([A-Fa-f0-9]{6})");

    private MessageUtil() {
    }

    public static String colorize(String input) {
        String withHex = applyHexColors(input);
        return ChatColor.translateAlternateColorCodes('&', withHex);
    }

    public static String stripColor(String input) {
        return ChatColor.stripColor(colorize(input));
    }

    private static String applyHexColors(String input) {
        Matcher matcher = HEX_PATTERN.matcher(input);
        StringBuilder builder = new StringBuilder();

        while (matcher.find()) {
            String hex = matcher.group(1);
            matcher.appendReplacement(builder, Matcher.quoteReplacement(ChatColor.of("#" + hex).toString()));
        }

        matcher.appendTail(builder);
        return builder.toString();
    }
}
