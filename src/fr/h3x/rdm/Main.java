package fr.h3x.rdm;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener  {
    static String message;
    static boolean event = false;
    private static Economy econ = null;
    public void onEnable() {
        setupEconomy();
        new EventRunnable().runTaskTimer(this,36000,36000);
        Bukkit.getServer().getPluginManager().registerEvents(this,this);

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
    public void onPlayerChat(PlayerChatEvent e){
    if(event == true){
        if(e.getMessage().equals(message)){
            Main.econ.depositPlayer(e.getPlayer(),50);
            Bukkit.broadcastMessage("§7[§6QatariaGame§7] §aLe joueur §6"+e.getPlayer().getName()+" §aa été le plus rapide !");
            event = false;
        }
    }
}
}
