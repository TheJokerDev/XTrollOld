package me.TheJokerDev.XTroll;

import me.TheJokerDev.XTroll.commands.MainCommand;
import me.TheJokerDev.XTroll.language.LBase;
import org.bukkit.entity.Player;
import xyz.theprogramsrc.supercoreapi.spigot.SpigotPlugin;

import java.util.HashMap;

public class Main extends SpigotPlugin {
    public static HashMap<Player, Player> target = new HashMap<>();
    public static String prefix;
    public static Main i;

    @Override
    public void onPluginLoad() {
        i = this;
    }

    @Override
    public void onPluginEnable() {
        registerTranslation(LBase.class);
        //TranslationDownloader.downloadFromGitHub(Main.i, "TheJokerDev", "XTroll", "translations");
        prefix = this.getSettingsStorage().getPrefix();
        getCommand("troll").setExecutor(new MainCommand());
    }

    @Override
    public void onPluginDisable() {

    }
}