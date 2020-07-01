package me.TheJokerDev.XTroll.inventories;

import me.TheJokerDev.XTroll.Main;
import me.TheJokerDev.XTroll.language.LBase;
import me.TheJokerDev.XTroll.utils.PlaceHolders;
import me.TheJokerDev.XTroll.utils.SettingsManager;
import me.TheJokerDev.XTroll.utils.TrollArrays;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemFlag;
import xyz.theprogramsrc.supercoreapi.spigot.SpigotPlugin;
import xyz.theprogramsrc.supercoreapi.spigot.dialog.Dialog;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUI;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUIButton;
import xyz.theprogramsrc.supercoreapi.spigot.guis.objects.GUIRows;
import xyz.theprogramsrc.supercoreapi.spigot.items.SimpleItem;
import xyz.theprogramsrc.supercoreapi.spigot.utils.skintexture.SkinTexture;
import xyz.theprogramsrc.supercoreapi.spigot.utils.xseries.XMaterial;

public class Settings extends GUI {
    public Settings(SpigotPlugin plugin, Player player) {
        super(plugin, player);
        TrollArrays.SettingsPage.put(getPlayer(), 0);
        this.open();
    }

    @Override
    public void onClose(InventoryCloseEvent event) {
        TrollArrays.SettingsPage.remove(getPlayer());
    }

    @Override
    protected String getTitle() {
        return Main.prefix + LBase.Titles_Settings.toString();
    }

    @Override
    protected GUIRows getRows() {
        return GUIRows.FIVE;
    }
    @Override
    public boolean centerTitle() {
        return false;
    }

    @Override
    protected GUIButton[] getButtons() {
        GUIButton[] buttons = null;
        if (TrollArrays.SettingsPage.get(getPlayer())==0){
            buttons= new GUIButton[]{
                    pluginSettingsItem(),
                    playerSettingsItem(),
                    getSelectItem(),
                    getBackItem()};
        }
        if (TrollArrays.SettingsPage.get(getPlayer())==1){
            buttons= new GUIButton[]{
                    pluginSettingsItem(),
                    changePrefixItem(),
                    getBackItem()};
        }
        if (TrollArrays.SettingsPage.get(getPlayer())==2){
            buttons= new GUIButton[]{
                    pluginSettingsItem(),
                    changeGUIMode(),
                    getBackItem()};
        }

        return buttons;
    }
    private GUIButton pluginSettingsItem(){
        SimpleItem item = new SimpleItem(XMaterial.REPEATER)
                .setDisplayName("&aPlugin Settings")
                .setLore(
                        "&7Select to see the options",
                        "&7to change the settings of",
                        "&7the plugin"
                );
        return new GUIButton(3, PlaceHolders.setPlaceHolders(item, getPlayer()), a-> {
            TrollArrays.SettingsPage.put(getPlayer(), 1);
            this.open();
        });
    }
    private GUIButton changePrefixItem(){
        SimpleItem item = new SimpleItem(XMaterial.BOOK)
                .setDisplayName("&9Prefix")
                .setLore(
                        "&7Click to change the prefix",
                        "&7",
                        "&7Actual: {prefix}"
                ).addPlaceholder("{prefix}", Main.prefix);
        return new GUIButton(22, PlaceHolders.setPlaceHolders(item, getPlayer()), a-> {
            new Dialog(Main.i, a.getPlayer()) {

                @Override
                public String getTitle() {
                    return "&3Prefix";
                }

                @Override
                public String getSubtitle() {
                    return "&7Create a new prefix to the plugin!";
                }

                @Override
                public String getActionbar() {
                    return "&7Actual prefix: {Prefix}";
                }
                @Override
                public boolean onResult(String playerInput) {
                    Main.i.getSettingsStorage().getConfig().set("Prefix", playerInput);
                    Main.i.getSettingsStorage().getConfig().save();
                    Main.loadPrefix();
                    return true;
                }
            }.addPlaceholder("{Prefix}", Main.i.getSettingsStorage().getPrefix()).setRecall(p->{
                this.open();
            });
    });
    }
    private GUIButton changeGUIMode(){
        SimpleItem item = new SimpleItem(XMaterial.REDSTONE_TORCH)
                .setDisplayName("&cGUIMode")
                .setLore(
                        "&7Click to change your GUI Mode",
                        "&7",
                        "&7Actual: %guimode%"
                );
        return new GUIButton(22, PlaceHolders.setPlaceHolders(item, getPlayer()), a-> {
            SettingsManager.changeGUIMode(getPlayer());
            this.open();
        });
    }
    private GUIButton playerSettingsItem(){
        SimpleItem item = new SimpleItem(XMaterial.PLAYER_HEAD)
                .setSkin(SkinTexture.fromPlayer(getPlayer()))
                .setDisplayName("&aYour Settings")
                .setLore(
                        "&7Select to see the options",
                        "&7to change your settings"
                );
        return new GUIButton(5, PlaceHolders.setPlaceHolders(item, getPlayer()), a-> {
            TrollArrays.SettingsPage.put(getPlayer(), 2);
            this.open();
        });
    }
    private GUIButton getSelectItem(){
        SimpleItem item = new SimpleItem(XMaterial.NAME_TAG)
                .setDisplayName("&3Select an option")
                .setLore(
                        "&7Select an option above in",
                        "&7this menu :)")
        .addEnchantment(Enchantment.KNOCKBACK, 1)
                .setShowEnchantments(false)
        .addFlag(ItemFlag.HIDE_ENCHANTS);
        return new GUIButton(22, PlaceHolders.setPlaceHolders(item, getPlayer()), a-> {});
    }
    private GUIButton getBackItem(){
        return new GUIButton(36, Main.i.getPreloadedItems().getBackItem(), a-> {
            new Selector(a.getPlayer());
        });
    }
}
