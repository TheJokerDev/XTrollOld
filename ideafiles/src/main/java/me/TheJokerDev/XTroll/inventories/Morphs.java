package me.TheJokerDev.XTroll.inventories;

import me.TheJokerDev.XTroll.Main;
import me.TheJokerDev.XTroll.language.LBase;
import me.TheJokerDev.XTroll.utils.PlaceHolders;
import me.TheJokerDev.XTroll.utils.TrollArrays;
import me.TheJokerDev.XTroll.utils.TrollItems;
import org.bukkit.entity.Player;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUI;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUIButton;
import xyz.theprogramsrc.supercoreapi.spigot.guis.objects.GUIRows;
import xyz.theprogramsrc.supercoreapi.spigot.items.SimpleItem;
import xyz.theprogramsrc.supercoreapi.spigot.utils.skintexture.SkinTexture;
import xyz.theprogramsrc.supercoreapi.spigot.utils.xseries.XMaterial;
@SuppressWarnings("all")
public class Morphs extends GUI {
    public Morphs(Player player) {
        super(Main.i, player);
        TrollArrays.MorphsSection.put(player, 0);
        this.open();
    }

    @Override
    protected String getTitle() {
        String title = null;
        if (TrollArrays.MorphsSection.get(getPlayer()) == 0){
            title = LBase.Titles_Morphs.toString();
        }
        return Main.prefix+ title;
    }

    @Override
    public boolean isTitleCentered() {
        return false;
    }

    @Override
    protected GUIRows getRows() {
        return GUIRows.FOUR;
    }

    @Override
    protected GUIButton[] getButtons() {
        return new GUIButton[]{
                MobsDisguiseItem(),
                TrollItems.getBackItem(27, 1)
        };
    }
    private GUIButton MobsDisguiseItem(){
        SimpleItem item = new SimpleItem(XMaterial.PLAYER_HEAD)
                .setSkin(SkinTexture.fromPlayer(getPlayer()))
                .setDisplayName("&aMobs Disguises")
                .setLore(
                        "&7Select to see the disguises",
                        "&7to change your body to another",
                        "&7one"
                );
        return new GUIButton(11, PlaceHolders.setPlaceHolders(item, getPlayer()), a-> {
            new MorphsBrowser(getPlayer());
        });
    }

}
