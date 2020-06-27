package me.TheJokerDev.XTroll.inventories;

import me.TheJokerDev.XTroll.Main;
import me.TheJokerDev.XTroll.language.LBase;
import org.bukkit.entity.Player;
import xyz.theprogramsrc.supercoreapi.spigot.SpigotPlugin;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUI;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUIButton;
import xyz.theprogramsrc.supercoreapi.spigot.guis.action.ClickType;
import xyz.theprogramsrc.supercoreapi.spigot.guis.objects.GUIRows;
import xyz.theprogramsrc.supercoreapi.spigot.items.SimpleItem;
import xyz.theprogramsrc.supercoreapi.spigot.utils.skintexture.SkinTexture;
import xyz.theprogramsrc.supercoreapi.spigot.utils.xseries.XMaterial;

public class Categories extends GUI {
    private Player player = null;
    private Player target = null;

    public Categories(SpigotPlugin plugin, Player player) {
        super(plugin, player);
        player = player;
        target = Main.target.get(player);
        this.open();
    }

    @Override
    protected String getTitle() {
        return Main.prefix + " "+ LBase.Titles_Categories.toString();
    }

    @Override
    protected GUIRows getRows() {
        return GUIRows.THREE;
    }

    @Override
    protected GUIButton[] getButtons() {
        return new GUIButton[]{this.getButton()};
    }

    private GUIButton getButton(){
        SimpleItem item = new SimpleItem(XMaterial.PAPER)
                .setDisplayName("&aChat")
                .setLore(
                        "&9Left Click &7Open Troll Selector",
                        "&9Right Click &7Open User Settings"
                );
        return new GUIButton(0, item, a->{
            a.getPlayer().sendMessage("Testing!");
        });
    }

}
