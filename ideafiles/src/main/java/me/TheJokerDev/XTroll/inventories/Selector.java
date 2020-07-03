package me.TheJokerDev.XTroll.inventories;

import me.TheJokerDev.XTroll.Main;
import me.TheJokerDev.XTroll.inventories.categories.Categories;
import me.TheJokerDev.XTroll.language.LBase;
import me.TheJokerDev.XTroll.utils.PlaceHolders;
import me.TheJokerDev.XTroll.utils.SettingsManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import xyz.theprogramsrc.supercoreapi.global.utils.Utils;
import xyz.theprogramsrc.supercoreapi.spigot.guis.BrowserGUI;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUIButton;
import xyz.theprogramsrc.supercoreapi.spigot.guis.action.ClickAction;
import xyz.theprogramsrc.supercoreapi.spigot.guis.action.ClickType;
import xyz.theprogramsrc.supercoreapi.spigot.guis.events.GUIEvent;
import xyz.theprogramsrc.supercoreapi.spigot.guis.events.GUIOpenEvent;
import xyz.theprogramsrc.supercoreapi.spigot.items.SimpleItem;
import xyz.theprogramsrc.supercoreapi.spigot.utils.skintexture.SkinTexture;
import xyz.theprogramsrc.supercoreapi.spigot.utils.xseries.XMaterial;

import java.util.ArrayList;
import java.util.List;

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
    public boolean centerTitle() {
        return false;
    }

    @Override
    public GUIButton getButton(Player player) {
        SimpleItem item = new SimpleItem(XMaterial.PLAYER_HEAD)
                .setSkin(SkinTexture.fromPlayer(player))
                .setDisplayName("&a" + player.getName())
                .setLore(
                        "&9Left Click &7Open Categories",
                        "&9Right Click &7Open User Settings"
                );
        return new GUIButton(item).setAction(a->{
            if(a.getAction() == ClickType.RIGHT_CLICK){
                Main.target.put(a.getPlayer(), player);
                new PlayerSettings(Main.i, getPlayer());
            }else{
                Main.target.put(a.getPlayer(), player);
                if (SettingsManager.checkUserSettings(getPlayer())){
                    if (SettingsManager.getGUIMode(getPlayer()).equals("categories")){
                        new Categories(Main.i, getPlayer());
                        return;
                    }
                    if (SettingsManager.getGUIMode(getPlayer()).equals("allinone")){
                        new AllInOne(Main.i, getPlayer());
                    }
                }
            }
        });
    }
    @Override
    public void onEvent(GUIEvent event){

        if(event instanceof GUIOpenEvent){
            this.addButton(getSettingsMenu());
        }
    }

    private GUIButton getSettingsMenu(){
        SimpleItem item = new SimpleItem(XMaterial.CHEST)
                .setDisplayName("&cSettings of %prefix%").addPlaceholder("%prefix%", Main.i.getPluginName())
                .setLore(
                        "&7Open the menu to change",
                        "&7settings of XTroll."
                );
        return new GUIButton(47, PlaceHolders.setPlaceHolders(item, getPlayer()), a-> new Settings(Main.i, getPlayer()));
    }

    @Override
    public Player getPlayer() {
        return super.getPlayer();
    }

    @Override
    public void onBack(ClickAction clickAction) {
        clickAction.getPlayer().closeInventory();
    }

    @Override
    protected String getTitle() {
        return Main.prefix + LBase.Titles_Selector.toString();
    }
}
