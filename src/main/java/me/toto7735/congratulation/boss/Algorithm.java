package me.toto7735.congratulation.boss;

import me.toto7735.congratulation.Congratulation;
import me.toto7735.congratulation.util.Utils;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Algorithm {

    private LivingEntity entity;
    private Player player;
    private int phase;
    private int quizPhase;

    public Algorithm(Player player) {
        this.player = player;
        Utils.setCurrentAlgorithm(this);
        Location location = player.getLocation().add(0, 10, 0);
        this.entity = (LivingEntity) location.getWorld().spawnEntity(location, EntityType.WITHER);
        entity.setCustomNameVisible(true);
        entity.setMaxHealth(entity.getMaxHealth() / 20);
        entity.setAI(false);
        entity.setCustomName("§c[YOUTUBE] §fAlgorithm");
        entity.setGravity(false);

        this.phase = 1;
        Utils.sendMessage(player, "§c[YOUTUBE] §fAlgorithm: Welcome to the world of YouTube.", 2);
        Utils.sendMessage(player, "§c[YOUTUBE] §fAlgorithm: But it is almost impossible to be loved by many people in this world.", 6);
        Utils.sendMessage(player, "§c[YOUTUBE] §fAlgorithm: §fAnd there are too many YouTubers on YouTube for you to be a YouTuber.", 10);
        Utils.sendMessage(player, "§c[YOUTUBE] §fAlgorithm: But if you beat me, I'll help a little many people know your channel. §7§oIt's lie. silly dog.", 14);

        new BukkitRunnable() {
            public void run() {
                entity.getWorld().playSound(entity.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1, 0.5F);
                entity.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, entity.getLocation(), 1);
                entity.setAI(true);
            }
        }.runTaskLater(Congratulation.getInstance(), 340);
    }

    public int getPhase() {
        return this.phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
        player.sendTitle("§c§lPhase " + phase, "§fWhy don't you giveup?", 5, 30, 10);
        player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SPAWN, 1, 1);
        if (phase == 2) {
            Location location = player.getLocation().add(0, 10, 0);
            this.entity = (LivingEntity) location.getWorld().spawnEntity(location, EntityType.WITHER);
            entity.setCustomName("§c[YOUTUBE] §fAlgorithm");
            entity.setAI(false);
            entity.setCustomNameVisible(true);
            entity.setMaxHealth(1000);
            entity.setHealth(1000);

            Utils.sendMessage(player, "§c[YOUTUBE] §fAlgorithm: Okay, a lot of people have come this far. But it will be difficult from now on. Out of countless people, only about 29,000 became famous.", 2);
            Utils.sendMessage(player, "§c[YOUTUBE] §fAlgorithm: Minecraft YouTubers should good at waterfall. isn't it?", 9);
            new BukkitRunnable() {
                public void run() {
                    player.sendTitle("§c§lTRY WATERFALL. OR", "§c§lDEATH UNDER THE YOUTUBE.", 5, 30, 10);
                    new BukkitRunnable() {
                        int i = 1;
                        public void run() {
                            if (i > 5) {
                                this.cancel();
                                entity.setInvulnerable(true);
                                Utils.sendMessage(player, "§c[YOUTUBE] §fAlgorithm: §cWELL, WELL OKAY. ARE YOU GOING TO COME OUT LIKE THAT???", 0);
                                Utils.sendMessage(player, "§c[YOUTUBE] §fAlgorithm: §cThen, finally, I will test the most important \"sense\" for YouTubers.", 4);
                                setPhase(3);
                                return;
                            }
                            Utils.sendMessage(player, "§c[YOUTUBE] §bWaterFall! §7(" + i + "/5)", 0);
                            player.setVelocity(player.getVelocity().multiply(0).setY(3));
                            ++i;
                        }
                    }.runTaskTimer(Congratulation.getInstance(), 10, 180);
                }
            }.runTaskLater(Congratulation.getInstance(), 170);
        } else if (phase == 3) {
            new BukkitRunnable() {
                public void run() {
                    entity.remove();
                    quizPhase = 1;
                    Utils.sendMessage(player, "§c[YOUTUBE] §fAlgorithm: §fFirst, How do turtles communicate?", 0);
                }
            }.runTaskLater(Congratulation.getInstance(), 190);
        } else if (phase == 4) {
            Location location = player.getLocation().add(0, 10, 0);
            this.entity = (LivingEntity) location.getWorld().spawnEntity(location, EntityType.WITHER);
            entity.setCustomName("§c[YOUTUBE] §4SUPER ANGRY Algorithm");
            entity.setCustomNameVisible(true);
            entity.setMaxHealth(1000);
            Utils.sendMessage(player, "§c[YOUTUBE] §4SUPER ANGRY Algorithm: §4HEY YOU, YES IT'S YOU. THE VIEWR OF THIS VIDEO.", 2);
            Utils.sendMessage(player, "§c[YOUTUBE] §4SUPER ANGRY Algorithm: §4WHY DON'T YOU PLAY MINECRAFT IN YOUR TIME TO WATCH THIS POOR VIDEO?", 6);
            Utils.sendMessage(player, "§c[YOUTUBE] §7frightened Algorithm: §7W..WAIT ", 11);
            Utils.sendMessage(player, "§c[YOUTUBE] §7frightened Algorithm: §7D..DON'T PRESS SUBSCRIBE AND LIKE TO THIS POOR CHANNEL AND QUIT THIS VIDEO RIGHT NOW!", 13);
            Utils.sendMessage(player, "§c[YOUTUBE] §7frightened Algorithm: §7I'M DYING BY YOUR INTEREST AND LOVE FOR THIS YOUTUBER...", 17);
            new BukkitRunnable() {
                public void run() {
                    entity.setAI(false);
                }
            }.runTaskLater(Congratulation.getInstance(), 220);
            new BukkitRunnable() {
                public void run() {
                    entity.remove();
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                    player.sendTitle("§bThanks for watching this video!", "", 5, 100, 0);
                    new BukkitRunnable() {
                        public void run() {
                            player.sendTitle("§bThanks for watching this video!", "§7by toto", 0, 5, 0);
                            new BukkitRunnable() {
                                public void run() {
                                    player.sendTitle("§bThanks for watching this video!", "", 0, 300, 10);
                                }
                            }.runTaskLater(Congratulation.getInstance(), 5);
                        }
                    }.runTaskLater(Congratulation.getInstance(), 100);
                }
            }.runTaskLater(Congratulation.getInstance(), 420);
        }
    }

    public int getQuizPhase() {
        return this.quizPhase;
    }

    public void setQuizPhase(int phase) {
        this.quizPhase = phase;
        if (quizPhase == 2) {
            new BukkitRunnable() {
                public void run() {
                    quizPhase = 2;
                    Utils.sendMessage(player, "§c[YOUTUBE] §6Little Angry Algorithm: §6Then, What do sprinters eat before a race?", 0);
                }
            }.runTaskLater(Congratulation.getInstance(), 50);
        } else if (quizPhase == 3) {
            new BukkitRunnable() {
                public void run() {
                    quizPhase = 3;
                    Utils.sendMessage(player, "§c[YOUTUBE] §cAngry Algorithm: §cWhy couldn't the bicycle stand up by itself?", 0);
                }
            }.runTaskLater(Congratulation.getInstance(), 50);
        }
    }

    public Player getPlayer() {
        return this.player;
    }

}
