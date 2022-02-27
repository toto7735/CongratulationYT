package me.toto7735.congratulation.functions;

import me.toto7735.congratulation.Congratulation;
import me.toto7735.congratulation.boss.Algorithm;
import me.toto7735.congratulation.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class Function implements Listener {

    public Function() {
        new BukkitRunnable() {
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    for (Entity entity : player.getLocation().getChunk().getEntities()) {
                        if (entity instanceof Firework) return;
                        if (entity instanceof Wither && Utils.getCurrentAlgorithm() != null && Utils.getCurrentAlgorithm().getPhase() == 1) {
                            entity.teleport(player.getLocation().add(0, new Random().nextInt(2), 0));
                            continue;
                        }
                        if (entity instanceof Player || entity instanceof Item || entity instanceof Wither) continue;
                        entity.getLocation().getBlock().setType(Material.CAKE);
                    }
                }
            }
        }.runTaskTimer(Congratulation.getInstance(), 0, 2);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if ((event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) || event.getItem() == null || !event.getItem().hasItemMeta() || event.getItem().getItemMeta().getDisplayName() == null || !event.getItem().getItemMeta().getDisplayName().equals("§c§kL §eSpawner of Youtube Algorithm §c§kL")) return;
        event.getPlayer().getInventory().getItemInMainHand().setAmount(event.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
        new Algorithm(event.getPlayer());
    }

    @EventHandler
    public void onHit(EntityDamageEvent event) {
        if (!event.getEntity().getType().equals(EntityType.PIG) && !event.getEntity().getType().equals(EntityType.SHEEP) && !event.getEntity().getType().equals(EntityType.CHICKEN) && !event.getEntity().getType().equals(EntityType.COW)) return;
        Utils.spawnFireWork(event.getEntity().getLocation());
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager().hasMetadata("nodamage")) event.setDamage(event.getDamage() / 10);
        if (event.getDamager().getCustomName() == null || !event.getDamager().getCustomName().equals("§c[YOUTUBE] §fAlgorithm")) return;
        event.setDamage(event.getDamage() / 3);
    }

    @EventHandler
    public void onPlace(BlockBreakEvent event) {
        Utils.spawnFireWork(event.getBlock().getLocation());
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Utils.spawnFireWork(event.getBlock().getLocation());
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        if (event.getEntity().getCustomName() == null || !event.getEntity().getCustomName().equals("§c[YOUTUBE] §fAlgorithm") || Utils.getCurrentAlgorithm().getPhase() != 1) return;
        event.getDrops().clear();
        Utils.getCurrentAlgorithm().setPhase(2);
    }

    @EventHandler
    public void onChat(PlayerChatEvent event) {
        if (Utils.getCurrentAlgorithm() == null || Utils.getCurrentAlgorithm().getQuizPhase() == 0) return;
        switch (Utils.getCurrentAlgorithm().getQuizPhase()) {
            case 1:
                if (!event.getMessage().contains("shellphone")) return;
                Utils.getCurrentAlgorithm().setQuizPhase(2);
            case 2:
                if (!event.getMessage().contains("they fast")) return;
                Utils.getCurrentAlgorithm().setQuizPhase(3);
            case 3:
                if (!event.getMessage().contains("too tired")) return;
                Utils.getCurrentAlgorithm().setPhase(4);
        }
    }

}
