package me.TheJokerDev.XTroll.events;

import me.TheJokerDev.XTroll.Main;
import me.TheJokerDev.XTroll.utils.TrollArrays;
import me.TheJokerDev.XTroll.utils.TrollItems;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Random;
@SuppressWarnings("all")
public class PlayerEvents implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player t = e.getPlayer();
        if (TrollArrays.FreezeTroll.contains(t.getName())){
            e.setCancelled(true);
            t.teleport(t.getLocation());
        }
        if (TrollArrays.FreezeAllTroll.contains(t.getName())){
            e.setCancelled(true);
            t.teleport(t.getLocation());
        }
        if (TrollArrays.fakeLagTroll.contains(t.getName())) {
            TrollArrays.fakeLagTroll.remove(t.getName());
            final Location from = e.getFrom();
            runSync(new Runnable() {
                public void run() {
                    t.teleport(from);
                    t.sendMessage("§eInternetException§f: 1286 (Fatal Conection Error)");
                    runSync(new Runnable() {
                        public void run() {
                            TrollArrays.fakeLagTroll.add(t.getName());
                        }
                    }, getRandom(2, 3)*20);
                }
            }, getRandom(0, 3)*20);
        }
    }
    private int getRandom(int lower, int upper) {
        return new Random().nextInt(upper - lower + 1) + lower;
    }
    public int runSync(final Runnable task, int delay) {
        if (task == null) {
            throw new IllegalArgumentException("task cannot be null.");
        } else {
            return delay <= 0L ? Bukkit.getServer().getScheduler().runTask(Main.i, new Runnable() {
                public void run() {
                    try {
                        task.run();
                    } catch (Exception var3) {
                        throw var3;
                    }
                }
            }).getTaskId() : Bukkit.getServer().getScheduler().runTaskLater(Main.i, new Runnable() {
                public void run() {
                    try {
                        task.run();
                    } catch (Exception var3) {
                        throw var3;
                    }
                }
            }, delay).getTaskId();
        }
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();
        ItemStack item = p.getItemInHand();
        if (e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR){
            if (item.getType() == Material.AIR){
                return;
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase(TrollItems.getExplosiveWand().getItemMeta().getDisplayName())){
                if (item.getItemMeta().getLore() != null){
                    return;
                }
                if (!item.getItemMeta().getLore().equals(TrollItems.getExplosiveWand().getItemMeta().getLore())){
                    return;
                }
                if (!item.getType().equals(TrollItems.getExplosiveWand().getType())){
                    return;
                }
                HashSet<Material> transparent = new HashSet<>();
                transparent.add(Material.AIR);
                transparent.add(Material.WATER);
                Block block = p.getTargetBlock(transparent, 120);
                p.getWorld().strikeLightning(block.getLocation());
                p.getWorld().createExplosion(block.getLocation(), 3f);
                return;
            }
        }
    }
}
