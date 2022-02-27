package me.toto7735.congratulation;

import me.toto7735.congratulation.functions.Function;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class Congratulation extends JavaPlugin {

    private static Congratulation instance;

    @Override
    public void onEnable() {
        System.out.println("Enabled! >_<");
        instance = this;
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§c§kL §eSpawner of Youtube Algorithm §c§kL");
        meta.setLore(Arrays.asList("§7This is the gateway to becoming a YouTuber.", "", "§eRecommend Items", "§f- §bWater bucket", "§f- §fIron Sword & Iron Armor full set"));
        item.setItemMeta(meta);
        NamespacedKey key = new NamespacedKey(this, "spawner");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("OIO", "III", "OIO");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('O', Material.OAK_LOG);
        Bukkit.addRecipe(recipe);

        Bukkit.getPluginManager().registerEvents(new Function(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("Disabled! >_<");
    }

    public static Congratulation getInstance() {
        return instance;
    }

}
