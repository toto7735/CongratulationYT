package me.toto7735.congratulation.util;

import me.toto7735.congratulation.Congratulation;
import me.toto7735.congratulation.boss.Algorithm;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

public class Utils {

    private static Algorithm currentAlgorithm;

    public static void spawnFireWork(Location location) {
        Firework fw = (Firework) location.getWorld().spawnEntity(location, EntityType.FIREWORK);
        fw.setMetadata("nodamage", new FixedMetadataValue(Congratulation.getInstance(), "nodamage"));
        FireworkMeta fwm = fw.getFireworkMeta();
        fwm.setPower(2);
        fwm.addEffect(FireworkEffect.builder().withColor(Color.LIME).flicker(true).build());
        fw.setFireworkMeta(fwm);
        fw.detonate();
    }

    public static void sendMessage(Player player, String message, int delay) {
        new BukkitRunnable() {
            public void run() {
                player.sendMessage(message);
            }
        }.runTaskLater(Congratulation.getInstance(), delay * 20L);
    }

    public static Algorithm getCurrentAlgorithm() {
        return currentAlgorithm;
    }

    public static void setCurrentAlgorithm(Algorithm algorithm) {
        currentAlgorithm = algorithm;
    }

}

