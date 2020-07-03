package me.TheJokerDev.XTroll.inventories;

import me.TheJokerDev.XTroll.Main;
import me.TheJokerDev.XTroll.inventories.categories.Categories;
import me.TheJokerDev.XTroll.language.LBase;
import me.TheJokerDev.XTroll.utils.PlaceHolders;
import me.TheJokerDev.XTroll.utils.SettingsManager;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import xyz.theprogramsrc.supercoreapi.spigot.items.SimpleItem;
import xyz.theprogramsrc.supercoreapi.spigot.utils.skintexture.SkinTexture;
import xyz.theprogramsrc.supercoreapi.spigot.utils.xseries.XMaterial;

import java.util.*;

public class SelectorOld implements Listener {
    private final HashMap<UUID, Integer> opened = new HashMap<>();
    private final List<Integer> borders = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            17, 18, 26, 27, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44);

    private void openPage(Player p, int page) {
        String SelectorTitle = Main.prefix + LBase.Titles_Selector.toString();
        List<Player> players = new ArrayList<>(Main.i.getServer().getOnlinePlayers());
        if (page > 0 && players.size() < page * 21 + 1) {
            openPage(p, page - 1);
            return;
        }
        Inventory gui = Bukkit.createInventory(null, 45, SelectorTitle);
        SimpleItem edge = new SimpleItem(XMaterial.BLACK_STAINED_GLASS_PANE)
                .setDisplayName("&a ");
        for (Integer integer : this.borders) {
            gui.setItem(integer, edge.build());
        }
        gui.setItem(40, PlaceHolders.setPlaceHolders(new SimpleItem(XMaterial.BARRIER)
                .setDisplayName("&cClose"), p).build());
        gui.setItem(38, PlaceHolders.setPlaceHolders(new SimpleItem(XMaterial.CHEST)
                .setDisplayName("&cSettings of %prefix%").addPlaceholder("%prefix%", Main.i.getPluginName())
                .setLore(
                        "&7Open the menu to change",
                        "&7settings of XTroll."
                ), p).build());
        int i;
        for (i = 10; i <= 16; i++)
            gui.setItem(i, null);
        for (i = 19; i <= 25; i++)
            gui.setItem(i, null);
        for (i = 28; i <= 34; i++)
            gui.setItem(i, null);
        if (page > 0) {
            gui.setItem(18, Main.i.getPreloadedItems().getBackItem().build());
        } else {
            gui.setItem(18, edge.build());
        }
        if (players.size() > (page + 1) * 21) {
            gui.setItem(26, Main.i.getPreloadedItems().getNextItem().build());
        } else {
            gui.setItem(26, edge.build());
        }
        if (players.size() > 21)
            players = players.subList(page * 21, Math.min(page * 21 + 21, players.size()));
        if (players.size() > 0) {
            for (Player player : players) {
                SimpleItem item = new SimpleItem(XMaterial.PLAYER_HEAD)
                        .setSkin(SkinTexture.fromPlayer(player))
                        .setDisplayName("&a" + player.getName())
                        .setLore(
                                "&9Left Click &7Open Categories",
                                "&9Right Click &7Open User Settings"
                        );
                gui.addItem(PlaceHolders.setPlaceHolders(item, p).build());
            }
        } else {
            gui.setItem(22, edge.build());
        }
        if (!this.opened.containsKey(p.getUniqueId())) {
            p.openInventory(gui);
        } else {
            p.getOpenInventory().getTopInventory().setContents(gui.getContents());
        }
        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.i, (Runnable) () -> opened.put(p.getUniqueId(), page), 1L);
    }

    public void open(Player p) {
        p.updateInventory();
        openPage(p, 0);
        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.i, (Runnable) () -> opened.put(p.getUniqueId(), 0), 1L);
    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack localItemStack = e.getCurrentItem();
        String SelectorTitle = Main.prefix + LBase.Titles_Selector.toString();
        ItemStack back = Main.i.getPreloadedItems().getBackItem().build();
        ItemStack next = Main.i.getPreloadedItems().getNextItem().build();
        if (e.getView().getTitle().equalsIgnoreCase(SelectorTitle)) {
            if (localItemStack == null || localItemStack.getType() == Material.AIR || localItemStack.getItemMeta().getDisplayName() == null) {
                e.setCancelled(true);
                return;
            }
            SimpleItem edge = new SimpleItem(XMaterial.BLACK_STAINED_GLASS_PANE)
                    .setDisplayName("&a ");
            if (e.getCurrentItem().getType() == edge.build().getType()) {
                e.setCancelled(true);
            }
            int slot = e.getRawSlot();
            if (slot == 18 && e.getCurrentItem().getType() == back.getType()) {
                openPage(p, this.opened.get(p.getUniqueId()) - 1);
                return;
            }
            if (slot == 26 && e.getCurrentItem().getType() == next.getType()) {
                openPage(p, this.opened.get(p.getUniqueId()) + 1);
                return;
            }
            if (slot == 40) {
                e.setCancelled(true);
                p.closeInventory();
                return;
            }
            if (slot == 38) {
                new Settings(Main.i, p);
                e.setCancelled(true);
                return;
            }
            e.setCancelled(true);
            String t1 = ChatColor.stripColor(localItemStack.getItemMeta().getDisplayName());
            Player t = Bukkit.getPlayer(t1);
            if (t == null) {
                e.setCancelled(true);
                return;
            }
            if (e.isShiftClick()) {
                e.setCancelled(true);
                p.closeInventory();
                p.teleport(t.getLocation());
                p.updateInventory();
                return;
            }
            if (e.isLeftClick()) {
                e.setCancelled(true);
                Main.target.put(p, t);
                if (SettingsManager.checkUserSettings(p)) {
                    if (SettingsManager.getGUIMode(p).equals("categories")) {
                        new Categories(Main.i, p);
                        return;
                    }
                    if (SettingsManager.getGUIMode(p).equals("allinone")) {
                        new AllInOne(Main.i, p);
                    }
                }
                if (e.isRightClick()) {
                    Main.target.put(p, t);
                    new PlayerSettings(Main.i, t);
                }
            }
        }
    }

    @EventHandler
    public void InventoryCloseEvent(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();
        if (opened.get(p.getUniqueId()) != null) {
            this.opened.remove(p.getUniqueId());
        }
    }
}