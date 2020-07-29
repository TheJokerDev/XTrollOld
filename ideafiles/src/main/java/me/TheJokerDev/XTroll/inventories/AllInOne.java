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
    public boolean isTitleCentered() {
        return false;
    }

    @Override
    protected GUIRows getRows() {
        return GUIRows.SIX;
    }

    @Override
    protected GUIButton[] getButtons() {
        return new GUIButton[]{
                TrollItems.BedrockCageItem(0, getPlayer()),
                TrollItems.BurnPlayerItem(1, getPlayer()),
                TrollItems.chargedCreepersItem(2, getPlayer()),
                TrollItems.controlPlayerItem(3, getPlayer()),
                TrollItems.demostrationItem(4, getPlayer()),
                TrollItems.dropInventoryItem(5, getPlayer()),
                TrollItems.extremeTrollItem(6, getPlayer()),
                TrollItems.explosiveWandItem(7, getPlayer()),
                TrollItems.facepalmItem(8, getPlayer()),
                TrollItems.fakeBanItem(9, getPlayer()),
                TrollItems.fakeOPItem(10, getPlayer()),
                TrollItems.fillInventoryItem(11, getPlayer()),
                TrollItems.flyCarpetItem(12, getPlayer()),
                TrollItems.FreezePlayerItem(13, getPlayer()),
                TrollItems.FreezeAllPlayerItem(14, getPlayer()),
                TrollItems.HidePlayerItem(15, getPlayer()),
                TrollItems.InfiniteInventoryItem(16, getPlayer()),
                TrollItems.fakeLagItem(17, getPlayer()),
                TrollItems.launchPlayerItem(18, getPlayer()),
                TrollItems.launchPlayerInvertedItem(19, getPlayer()),
                TrollItems.lavaCageItem(20, getPlayer()),
                TrollItems.getLevitationItem(21, getPlayer()),
                TrollItems.getLevitationAllItem(22, getPlayer()),
                TrollItems.getMatrixItem(23, getPlayer()),
                TrollItems.getMorphsItem(24, getPlayer()),
                TrollItems.getBackItem(48, 0)};
    }
}

