package me.TheJokerDev.XTroll;

import me.TheJokerDev.XTroll.commands.MainCommand;
import me.TheJokerDev.XTroll.events.PlayerEvents;
import me.TheJokerDev.XTroll.language.LBase;
import me.TheJokerDev.XTroll.utils.TrollArrays;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import xyz.theprogramsrc.supercoreapi.SuperUtils;
import xyz.theprogramsrc.supercoreapi.spigot.SpigotPlugin;

import java.util.ArrayList;
import java.util.HashMap;
@SuppressWarnings("all")
public class Main extends SpigotPlugin {
    public static HashMap<Player, Player> target = new HashMap<>();
    public static String prefix;
    public static Main i;
    public HashMap<String, ItemStack[]> inventory;
    HashMap<String, ItemStack[]> armor;
    ArrayList<String> cd;
    private int maxControlTime;
    private int cooldown;

    @Override
    public void onPluginLoad() {
        i = this;
    }

    @Override
    public void onPluginEnable() {
        registerTranslation(LBase.class);
        //TranslationDownloader.downloadFromGitHub(Main.i, "TheJokerDev", "XTroll", "translations");
        loadPrefix();
        loadAdditionalsSettings();
        listener(new PlayerEvents());
        listener(new iListener(this));
        this.armor = new HashMap<>();
        this.inventory = new HashMap<>();
        this.maxControlTime = 0;
        this.cooldown = 0;
        this.cd = new ArrayList<>();
        getCommand("troll").setExecutor(new MainCommand());
        hookDependiencies();

    }
    private void loadAdditionalsSettings(){
        if (getSettingsStorage().getConfig().get("Trolls") == null){
            this.getSettingsStorage().getConfig().add("Trolls.KickMessage", "&cYou have been banned for using hacks!");
            this.getSettingsStorage().getConfig().add("Trolls.FakeOPMessage", "&7&o[Server: %target% is now administrator]");
        }
        if (getSettingsStorage().getConfig().get("regenerationblocks") == null){
            this.getSettingsStorage().getConfig().add("regenerationblocks.activated", false);
            this.getSettingsStorage().getConfig().add("regenerationblocks.delay", 10);
        }
        this.getSettingsStorage().getConfig().save();
    }
    @Override
    public SuperUtils getSuperUtils() {
        return super.getSuperUtils();
    }

    public static void loadPrefix(){
        prefix = Main.i.getSuperUtils().color(Main.i.getSettingsStorage().getPrefix())+" ";
    }
    private void hookDependiencies()
    {
        new BukkitRunnable()
        {
            public void run()
            {
                if (!Bukkit.getPluginManager().isPluginEnabled("ProtocolLib"))
                {
                    Bukkit.getConsoleSender().sendMessage(prefix + LBase.Messages_DependenciesProtocolLib.toString());
                    Main.this.setEnabled(false);
                }
            }
        }

                .runTaskLater(this, 1L);

        new BukkitRunnable()
        {
            public void run()
            {
                if (!Bukkit.getPluginManager().isPluginEnabled("LibsDisguises"))
                {
                    Bukkit.getConsoleSender().sendMessage(prefix + LBase.Messages_DependenciesLibsDisguises.toString());
                    Main.this.setEnabled(false);
                }
            }
        }

                .runTaskLater(this, 1L);
    }
    public void stopControlling(Player v, Player c)
    {
        c.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 200, 1));

        v.removeMetadata("iCU_P", this);
        v.setGameMode(GameMode.SURVIVAL);

        c.removeMetadata("iCU_H", this);
        DisguiseAPI.undisguiseToAll(c);

        v.getInventory().setContents(c.getInventory().getContents());
        v.getInventory().setArmorContents(c.getInventory().getArmorContents());

        c.getInventory().setContents(this.inventory.get(c.getName()));
        c.getInventory().setArmorContents(this.armor.get(c.getName()));
        this.inventory.remove(c.getName());
        this.armor.remove(c.getName());

        v.teleport(c);
        c.teleport(TrollArrays.controlPlayerLocation.get(c));
        TrollArrays.controlPlayerLocation.clear();
        if (this.cooldown > 0)
        {
            this.cd.add(c.getName());
            new Cooldown(this, c).runTaskLater(this, this.cooldown * 20);
        }
    }

    public void startControlling(Player v, Player c)
    {
        v.setMetadata("iCU_P", new FixedMetadataValue(this, c.getName()));
        c.setMetadata("iCU_H", new FixedMetadataValue(this, v.getName()));

        this.inventory.put(c.getName(), c.getInventory().getContents());
        this.armor.put(c.getName(), c.getInventory().getArmorContents());
        TrollArrays.controlPlayerLocation.put(c, c.getLocation());
        c.getInventory().setContents(v.getInventory().getContents());
        c.getInventory().setArmorContents(v.getInventory().getArmorContents());

        c.teleport(v);
        c.setGameMode(v.getGameMode());
        v.setGameMode(GameMode.SPECTATOR);

        PlayerDisguise disV = new PlayerDisguise(v.getName());
        DisguiseAPI.disguiseToAll(c, disV);

        new CheckVictim(v, c).runTaskTimer(this, 100L, 100L);
        if (this.maxControlTime > 0) {
            new ControlTimer(c, v, this).runTaskLater(this, this.maxControlTime * 20);
        }
    }
    @Override
    public void onPluginDisable() {

    }
}
