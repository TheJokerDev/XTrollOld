package me.TheJokerDev.XTroll.inventories;

import me.TheJokerDev.XTroll.Main;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import me.libraryaddict.disguise.disguisetypes.MobDisguise;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import xyz.theprogramsrc.supercoreapi.spigot.guis.BrowserGUI;
import xyz.theprogramsrc.supercoreapi.spigot.guis.GUIButton;
import xyz.theprogramsrc.supercoreapi.spigot.guis.action.ClickAction;
import xyz.theprogramsrc.supercoreapi.spigot.guis.action.ClickType;
import xyz.theprogramsrc.supercoreapi.spigot.items.SimpleItem;
import xyz.theprogramsrc.supercoreapi.spigot.utils.xseries.XMaterial;

import java.util.ArrayList;
@SuppressWarnings("all")
public class MorphsBrowser extends BrowserGUI<LivingEntity> {
    public MorphsBrowser(Player player) {
        super(Main.i, player);
        open();
    }

    @Override
    public LivingEntity[] getObjects() {
        ArrayList<LivingEntity> entitys = null;
        for (World w : Bukkit.getWorlds()){
            entitys.addAll(w.getLivingEntities());
        }
        return entitys.stream().toArray(LivingEntity[]::new);
    }

    @Override
    public GUIButton getButton(LivingEntity entityType) {
        SimpleItem item = new SimpleItem(XMaterial.PAPER)
                .setDisplayName("&a" + entityType.getName())
                .setLore(
                        "&7Left Click to disguise in",
                        "&9"+entityType.getType().getName()
                );
        return new GUIButton(item).setAction(a->{
            if(a.getAction() == ClickType.RIGHT_CLICK){
                return;
            }else{
                getPlayer().closeInventory();
                Player t = Main.target.get(getPlayer());
                MobDisguise disV = new MobDisguise(DisguiseType.getType(entityType));
                DisguiseAPI.disguiseToAll(t, disV);
            }
        });
    }

    @Override
    public boolean isTitleCentered() {
        return false;
    }

    @Override
    public void onBack(ClickAction clickAction) {

    }

    @Override
    protected String getTitle() {
        return Main.prefix;
    }
}
