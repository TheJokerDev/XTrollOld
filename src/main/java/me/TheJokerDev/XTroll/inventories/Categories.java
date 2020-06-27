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
        SimpleItem item = new SimpleItem(XMaterial.PLAYER_HEAD)
                .setSkin(SkinTexture.fromPlayer(target))
                .setDisplayName("&a" + target.getName())
                .setLore(
                        "&7",
                        "&9Left Click &7Open Troll Selector",
                        "&9Right Click &7Open User Settings"
                );
        new GUIButton(1, item);
        return new GUIButton[]{new GUIButton(1, item, clickAction -> player.sendMessage("hola"))};
}
}
