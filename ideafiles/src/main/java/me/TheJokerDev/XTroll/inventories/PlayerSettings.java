package me.TheJokerDev.XTroll.inventories;

import me.TheJokerDev.XTroll.Main;
import me.TheJokerDev.XTroll.inventories.categories.Categories;
import me.TheJokerDev.XTroll.language.LBase;
import me.TheJokerDev.XTroll.utils.PlaceHolders;
import me.TheJokerDev.XTroll.utils.SettingsManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import xyz.theprogramsrc.supercoreapi.spigot.SpigotPlugin;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUI;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUIButton;
import xyz.theprogramsrc.supercoreapi.spigot.guis.objects.GUIRows;
import xyz.theprogramsrc.supercoreapi.spigot.items.SimpleItem;
import xyz.theprogramsrc.supercoreapi.spigot.utils.skintexture.SkinTexture;
import xyz.theprogramsrc.supercoreapi.spigot.utils.xseries.XMaterial;
@SuppressWarnings("all")
public class PlayerSettings extends GUI {
    public PlayerSettings(SpigotPlugin plugin, Player player) {
        super(plugin, player);
        this.open();
    }

    @Override
    protected String getTitle() {
        return Main.prefix+LBase.Titles_PlayerSettings.options().placeholder("{target}", Main.target.get(getPlayer()).getName()).toString();
    }

    @Override
    protected GUIRows getRows() {
        return GUIRows.FOUR;
    }

    @Override
    protected GUIButton[] getButtons() {
        return new GUIButton[]{getGameModeItem(), getBackItem(), getInfoItem(), getMenu()};
    }
    private GUIButton getGameModeItem(){
        SimpleItem item = new SimpleItem(XMaterial.CRAFTING_TABLE)
                .setDisplayName("&3Gamemode")
                .setLore(
                        "&7Change the gamemode of",
                        "&7%target%",
                        "&7",
                        "&7Actual gamemode:",
                        "&7%gamemode%"
                );

        Player t = Main.target.get(getPlayer());
        return new GUIButton(15, PlaceHolders.setPlaceHolders(item, t), a-> {
            if (t.getGameMode()== GameMode.CREATIVE){
                t.setGameMode(GameMode.SURVIVAL);
                open();
                return;
            }
            if (t.getGameMode()== GameMode.SURVIVAL){
                t.setGameMode(GameMode.ADVENTURE);
                open();
                return;
            }
            if (t.getGameMode()== GameMode.ADVENTURE){
                t.setGameMode(GameMode.SPECTATOR);
                open();
                return;
            }
            if (t.getGameMode()== GameMode.SPECTATOR){
                t.setGameMode(GameMode.CREATIVE);
                open();
                return;
            }
        });
    }
    private GUIButton getInfoItem(){
        SimpleItem item = new SimpleItem(XMaterial.PAPER)
                .setDisplayName("&7Player Info")
                .setLore(
                        "&7&m ========================= ",
                        "&7Health: &3%health%&7/&c%max-health%",
                        "&7Gamemode: &c%gamemode%",
                        "&7Rank: %rank%"
                );
        Player t = Main.target.get(getPlayer());
        return new GUIButton(11, PlaceHolders.setPlaceHolders(item, t), a-> {});
    }
    private GUIButton getMenu(){
        SimpleItem item = new SimpleItem(XMaterial.PLAYER_HEAD)
                .setSkin(SkinTexture.fromURL("http://textures.minecraft.net/texture/df7f40a86bee8e21a55340856a8621aca495673aa17bfde18d3b7aa61b42c"))
                .setDisplayName("&cTroll Menu")
                .setLore(
                        "&7Open the Troll GUI to",
                        "&7troll to %target%."
                );
        Player t = Main.target.get(getPlayer());
        return new GUIButton(13, PlaceHolders.setPlaceHolders(item, t), a-> {if (SettingsManager.checkUserSettings(getPlayer())){
            if (SettingsManager.getGUIMode(getPlayer()).equals("categories")){
                new Categories(Main.i, getPlayer());
                return;
            }
            if (SettingsManager.getGUIMode(getPlayer()).equals("allinone")){
                new AllInOne(Main.i, getPlayer());
            }
        }});
    }

    @Override
    public boolean isTitleCentered() {
        return false;
    }

    private GUIButton getBackItem(){
        return new GUIButton(27, Main.i.getPreloadedItems().getBackItem(), a-> {
            new Selector(a.getPlayer());
        });
    }
}
