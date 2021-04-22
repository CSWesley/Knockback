package com.booked.knockback;

import com.booked.knockback.commands.Reload;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Knockback extends JavaPlugin implements Listener {

    public Knockback() {
        instance = this;
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("knockback").setExecutor(new Reload());
        saveDefaultConfig();
        getServer().getConsoleSender().sendMessage("§4Knockback plugin enabled! \uD83D\uDE03\n" +
                "\n" +
                "§dCheck the config.yml to change the knockback and for information on how to contact me!\n" +
                "§bThis plugin was made by booked61 and can be used with his permission. See config.yml for contact information!");
    }

    @Override
    public void onDisable() {
    }


    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent e){
        if (e.getEntity() instanceof Player) {
            Entity p = e.getEntity();
            p.setVelocity(e.getDamager().getLocation().getDirection().multiply(getConfig().getInt("knockback-of-mobs")));
        } else if (e.getEntity() != null) {
            Entity p = e.getEntity();
            p.setVelocity(e.getDamager().getLocation().getDirection().multiply(getConfig().getInt("knockback-of-mobs")));
        }
    }

    public static Knockback instance;

    public static Knockback getInstance() {
        return instance;
    }
}

