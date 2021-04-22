package com.booked.knockback.commands;

import com.booked.knockback.Knockback;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("knockback")) {
            if (args.length == 0) {
                p.sendMessage("§6_________________________________________________________\n" +
                        "§8>>§6§lCommands§8§r<<\n" +
                        "§b/knockback reload §cor §b/kb reload\n" +
                        "§aMake sure to check the config.yml for more information!\n" +
                        "§6_________________________________________________________");
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    p.sendMessage("§cConfig reloading...");
                    Knockback.getInstance().reloadConfig();
                    p.sendMessage("§aConfig reloaded!");
                } else if (args[0].equalsIgnoreCase("help")) {
                    p.sendMessage("§6_________________________________________________________\n" +
                            "§8>>§6§lCommands§8§r<<\n" +
                            "§b/knockback reload §cor §b/kb reload\n" +
                            "§aMake sure to check the config.yml for more information!\n" +
                            "§6_________________________________________________________");
                }
            }
        }
        return true;
    }
}
