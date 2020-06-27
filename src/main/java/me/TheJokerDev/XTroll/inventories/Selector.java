package me.TheJokerDev.XTroll.inventories;

import me.TheJokerDev.XTroll.Main;
import me.TheJokerDev.XTroll.language.LBase;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import xyz.theprogramsrc.supercoreapi.spigot.SpigotPlugin;
import xyz.theprogramsrc.supercoreapi.spigot.guis.BrowserGUI;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUIButton;
import xyz.theprogramsrc.supercoreapi.spigot.guis.action.ClickAction;
import xyz.theprogramsrc.supercoreapi.spigot.guis.action.ClickType;
import xyz.theprogramsrc.supercoreapi.spigot.items.SimpleItem;
import xyz.theprogramsrc.supercoreapi.spigot.utils.skintexture.SkinTexture;
import xyz.theprogramsrc.supercoreapi.spigot.utils.xseries.XMaterial;

public class Selector extends BrowserGUI<Player> {
    public Selector(Player player){
        super(Main.i, player); // Inicializa el GUI
        this.open(); // Abre el GUI
    }

    @Override
    public Player[] getObjects() {
        return Bukkit.getOnlinePlayers().stream().toArray(Player[]::new);
    }

    @Override
    public GUIButton getButton(Player player) {
        SimpleItem item = new SimpleItem(XMaterial.PLAYER_HEAD)
                .setSkin(SkinTexture.fromPlayer(player))
                .setDisplayName("&a" + player.getName())
                .setLore(
                        "&7",
                        "&9Left Click &7Open Troll Selector",
                        "&9Right Click &7Open User Settings"
                );
        return new GUIButton(item).setAction(a->{
            if(a.getAction() == ClickType.RIGHT_CLICK){
                // Click Derecho
            }else{
                // Click Izquierdo
            }
        });
    }

    @Override
    public void onBack(ClickAction clickAction) {

    }

    @Override
    protected String getTitle() {
        return Main.prefix + " &8"+LBase.Titles_Selector.toString();
    }
}
