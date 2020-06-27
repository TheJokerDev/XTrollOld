package me.TheJokerDev.XTroll.language;

import me.TheJokerDev.XTroll.Main;
import xyz.theprogramsrc.supercoreapi.spigot.utils.storage.SpigotYMLConfig;

public class Settings {
    public static SpigotYMLConfig getSettingsYML(){
        return Main.i.getSettingsStorage().getConfig();
    }
}
