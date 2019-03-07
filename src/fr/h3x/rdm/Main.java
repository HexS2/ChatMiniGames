package fr.h3x.rdm;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {
    private String message;
    private boolean started = false;
    private static Economy econ = null;

    public void onEnable() {
        setupEconomy();
        new EventRunnable(this).runTaskTimer(this, 150, 150);
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }


    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }


    @EventHandler
    public void onPlayerChat(PlayerChatEvent e) {
        if (isStarted()) {
            if (e.getMessage().equals(message)) {
                Main.econ.depositPlayer(e.getPlayer(), 50);
                Bukkit.broadcastMessage("§7[§6QatariaGame§7] §aLe joueur §6" + e.getPlayer().getName() + " §aa été le plus rapide !");
                setStarted(false);
            }
        }
    }
}
