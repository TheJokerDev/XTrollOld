package me.TheJokerDev.XTroll.commands;

import me.TheJokerDev.XTroll.Main;
import me.TheJokerDev.XTroll.inventories.AllInOne;
import me.TheJokerDev.XTroll.inventories.SelectorOld;
import me.TheJokerDev.XTroll.inventories.categories.Categories;
import me.TheJokerDev.XTroll.inventories.Selector;
import me.TheJokerDev.XTroll.language.LBase;
import me.TheJokerDev.XTroll.utils.SettingsManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage(Main.prefix+" &c"+LBase.ONLYPLAYERS.toString());
            return true;
        }
        Player p = (Player)commandSender;
        if (strings.length == 0) {
            new Selector(p);
            return true;
        }
        if (strings.length == 1){
            if (!strings[0].equalsIgnoreCase("reload")){
                String name = strings[0];
                Player t = Bukkit.getPlayer(name);
                if (t==null){
                    p.sendMessage(Main.prefix+" "+LBase.Messages_PlayerNoExists.toString());
                    return true;
                }
                Main.target.put(p, t);
                if (SettingsManager.checkUserSettings(p)){
                    if (SettingsManager.getGUIMode(p).equals("categories")){
                        new Categories(Main.i, p);
                        return true;
                    }
                    if (SettingsManager.getGUIMode(p).equals("allinone")){
                        new AllInOne(Main.i, p);
                    }
                }
            }
        }
        return true;
    }
}
