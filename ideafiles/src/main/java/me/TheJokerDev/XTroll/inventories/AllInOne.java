package me.TheJokerDev.XTroll.inventories;

import me.TheJokerDev.XTroll.Main;
import me.TheJokerDev.XTroll.language.LBase;
import me.TheJokerDev.XTroll.utils.TrollItems;
import org.bukkit.entity.Player;
import xyz.theprogramsrc.supercoreapi.spigot.SpigotPlugin;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUI;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUIButton;
import xyz.theprogramsrc.supercoreapi.spigot.guis.objects.GUIRows;

public class AllInOne extends GUI {
    public AllInOne(SpigotPlugin plugin, Player player) {
        super(plugin, player);
        this.open();
    }

    @Override
    protected String getTitle() {
        return Main.prefix+ LBase.Titles_AllInOne.toString();
    }

    @Override
    public boolean centerTitle() {
        return false;
    }

    @Override
    protected GUIRows getRows() {
        return GUIRows.SIX;
    }

    @Override
    protected GUIButton[] getButtons() {
        return new GUIButton[]{TrollItems.FreezePlayerItem(0, getPlayer()),TrollItems.getBackItem(48, 1)};
    }
}
