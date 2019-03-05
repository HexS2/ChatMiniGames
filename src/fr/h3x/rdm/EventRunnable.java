package fr.h3x.rdm;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class EventRunnable extends BukkitRunnable {
    @Override
    public void run() {
        Main.event = true;
            Main.message = new Message(getRandomNumberInRange(5,15),"AbCdEFgHIjK^$LMnO!pQRStUVwXYZ@*").getRandomString();
           Bukkit.broadcastMessage("§7[§6QatariaGame§7] §aJeu de rapidité : Le premier qui écrit §c"+Main.message+" §agagne 50$ !");
   }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
