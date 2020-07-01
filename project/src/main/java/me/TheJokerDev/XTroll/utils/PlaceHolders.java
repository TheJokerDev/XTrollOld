package me.TheJokerDev.XTroll.utils;

import me.TheJokerDev.XTroll.Main;
import me.TheJokerDev.XTroll.language.LBase;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import xyz.theprogramsrc.supercoreapi.spigot.items.SimpleItem;

import java.util.ArrayList;

public class PlaceHolders {
    public static SimpleItem setPlaceHolders(SimpleItem item, Player t) {
        SimpleItem returnItem = item;
        ArrayList<String> lore = new ArrayList<>();
        for (String all : returnItem.getLore())
            lore.add(ChatColor.translateAlternateColorCodes('&', all));
        for (int i = 0; i < lore.size(); i++) {
            lore.set(i, lore.get(i).replaceAll("%target%", t.getName()));
            if (Main.target.get(t) != null) {
                lore.set(i, lore.get(i).replaceAll("%troller%", Main.target.get(t).getName()));
            }
            lore.set(i, lore.get(i).replaceAll("%health%", String.valueOf(Integer.valueOf((int) t.getHealth()))));
            lore.set(i, lore.get(i).replaceAll("%max-health%", String.valueOf(Integer.valueOf((int) t.getMaxHealth()))));
            lore.set(i, lore.get(i).replaceAll("%gamemode%", String.valueOf(t.getGameMode())));
            lore.set(i, lore.get(i).replaceAll("%pos-x%", String.valueOf(Integer.valueOf((int) t.getLocation().getX()))));
            lore.set(i, lore.get(i).replaceAll("%pos-y%", String.valueOf(Integer.valueOf((int) t.getLocation().getY()))));
            lore.set(i, lore.get(i).replaceAll("%pos-z%", String.valueOf(Integer.valueOf((int) t.getLocation().getZ()))));
            lore.set(i, lore.get(i).replaceAll("CREATIVE", LBase.PlaceHolders_Creative.toString()));
            lore.set(i, lore.get(i).replaceAll("SURVIVAL", LBase.PlaceHolders_Survival.toString()));
            lore.set(i, lore.get(i).replaceAll("ADVENTURE", LBase.PlaceHolders_Adventure.toString()));
            lore.set(i, lore.get(i).replaceAll("SPECTATOR", LBase.PlaceHolders_Spectator.toString()));
            lore.set(i, lore.get(i).replaceAll("%prefix", Main.i.getPluginName()));
            lore.set(i, lore.get(i).replaceAll("%rank%", getRank(t)));
            lore.set(i, lore.get(i).replaceAll("%guimode%", SettingsManager.getGUIMode(t)));
            lore.set(i, lore.get(i).replaceAll("categories", LBase.PlaceHolders_Categories.toString()));
            lore.set(i, lore.get(i).replaceAll("allinone", LBase.PlaceHolders_AllInOne.toString()));
        }
        String returnName = item.getDisplayName();
        returnName.replaceAll("%target%", t.getName());
        if (Main.target.get(t) != null) {
            returnName.replaceAll("%troller%", Main.target.get(t).getName());
        }
        returnName.replaceAll("%health%", String.valueOf(Integer.valueOf((int) t.getHealth())))
                .replaceAll("%max-health%", String.valueOf(Integer.valueOf((int) t.getMaxHealth())))
                .replaceAll("%gamemode%", String.valueOf(t.getGameMode()))
                .replaceAll("%pos-x%", String.valueOf(Integer.valueOf((int) t.getLocation().getX())))
                .replaceAll("%pos-y%", String.valueOf(Integer.valueOf((int) t.getLocation().getY())))
                .replaceAll("%pos-z%", String.valueOf(Integer.valueOf((int) t.getLocation().getZ())))
                .replaceAll("CREATIVE", LBase.PlaceHolders_Creative.toString())
                .replaceAll("SURVIVAL", LBase.PlaceHolders_Survival.toString())
                .replaceAll("ADVENTURE", LBase.PlaceHolders_Adventure.toString())
                .replaceAll("SPECTATOR", LBase.PlaceHolders_Spectator.toString())
                .replaceAll("%prefix%", Main.i.getPluginName())
                .replaceAll("%rank%", getRank(t));
        returnItem.setLore(lore);
        returnItem.setDisplayName(returnName);

        return returnItem;
    }
    public static String getRank(Player p) {
        String sm;
        if (p.getName().equalsIgnoreCase("TheJokerDev")||p.getUniqueId().equals("11ccbfb1-9bab-4baf-b567-b8304b3f00b3")){
            sm = Main.i.getSuperUtils().color("&cCreator");
            return sm;
        }
        if (p.isOp()) {
            sm = LBase.PlaceHolders_Operator.toString();
            return sm;
        }
        if (p.hasPermission("xtroll.troll")) {
            sm = LBase.PlaceHolders_Troller.toString();
            return sm;
        }
        return LBase.PlaceHolders_User.toString();
    }
}
