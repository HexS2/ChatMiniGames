package fr.h3x.rdm;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class EventRunnable extends BukkitRunnable {

    private Main plugin;

    public EventRunnable(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        plugin.setStarted(true);
            plugin.setMessage(new Message(getRandomNumberInRange(5,15),"AbCdEFgHIjK^$LMnO!pQRStUVwXYZ@*").getRandomString());
           Bukkit.broadcastMessage("§7[§6QatariaGame§7] §aJeu de rapidité : Le premier qui écrit §c"+plugin.getMessage()+" §agagne 50$ !");
   }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
