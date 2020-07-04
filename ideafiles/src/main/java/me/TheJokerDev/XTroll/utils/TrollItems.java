package me.TheJokerDev.XTroll.utils;

import me.TheJokerDev.XTroll.Main;
import me.TheJokerDev.XTroll.inventories.Selector;
import me.TheJokerDev.XTroll.inventories.SelectorOld;
import me.TheJokerDev.XTroll.inventories.categories.Categories;
import me.TheJokerDev.XTroll.language.LBase;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUIButton;
import xyz.theprogramsrc.supercoreapi.spigot.items.SimpleItem;
import xyz.theprogramsrc.supercoreapi.spigot.utils.xseries.XMaterial;
import org.bukkit.entity.Player;

public class TrollItems {
    public static GUIButton FreezePlayerItem(Integer i, Player p){
        SimpleItem item = new SimpleItem(XMaterial.ICE)
                .setDisplayName("&aFreeze Player")
                .setLore("&7Status: %freeze-status%");
        Player t = Main.target.get(p);
        return new GUIButton(i, PlaceHolders.setPlaceHolders(item, t), a-> {
            if(!TrollArrays.FreezeTroll.contains(t.getName())){
                TrollArrays.FreezeTroll.add(t.getName());
                Main.i.getSuperUtils().sendMessage(t,Main.prefix+ LBase.Messages_FreezeActivated.options().placeholder("{target}", t.getName()).toString());
                return;
            } else {
                TrollArrays.FreezeTroll.remove(t.getName());
                Main.i.getSuperUtils().sendMessage(t,Main.prefix+ LBase.Messages_FreezeDeactivated.options().placeholder("{target}", t.getName()).toString());
                return;
            }
        });
    }
    public static GUIButton getBackItem(Integer slot, Integer i2){
        GUIButton returnitem = null;
        if (i2 == 0){
            returnitem =new GUIButton(slot, Main.i.getPreloadedItems().getBackItem(), a-> {
                new SelectorOld().open(a.getPlayer());
            });
        }
        if (i2 == 1){
            returnitem =new GUIButton(slot, Main.i.getPreloadedItems().getBackItem(), a-> {
                new Categories(Main.i, a.getPlayer());
            });
        }
        return returnitem;
    }
}
