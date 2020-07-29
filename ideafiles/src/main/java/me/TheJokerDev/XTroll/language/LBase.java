package me.TheJokerDev.XTroll.language;

import me.TheJokerDev.XTroll.Main;
import me.TheJokerDev.XTroll.utils.SettingsManager;
import xyz.theprogramsrc.supercoreapi.global.translations.Translation;
import xyz.theprogramsrc.supercoreapi.global.translations.TranslationManager;
import xyz.theprogramsrc.supercoreapi.global.translations.TranslationPack;
import xyz.theprogramsrc.supercoreapi.global.utils.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public enum LBase implements TranslationPack {

    Titles_Selector("&8Player Browser"),
    Titles_Settings("&8Settings Menu"),
    Titles_Categories("&8Categories Menu"),
    Titles_InCategory("&8Categories | {category}"),
    Titles_AllInOne("&8AllInOne Menu"),
    Titles_Morphs("&8Morphs Menu"),
    Titles_PlayerSettings("&8Settings of {target}!"),
    ONLYPLAYERS("&cThis command is only to players!"),
    Messages_PlayerNoExists("&cThis player not exists!"),
    PlaceHolders_Toggle("Toggle"),
    PlaceHolders_Chat("Chat"),
    PlaceHolders_World("World"),
    PlaceHolders_Creative("Creative"),
    PlaceHolders_Survival("Survival"),
    PlaceHolders_Adventure("Adventure"),
    PlaceHolders_Spectator("Spectator"),
    PlaceHolders_Operator("&a&lOperator"),
    PlaceHolders_Troller("&a&lTroller"),
    PlaceHolders_User("&8User"),
    PlaceHolders_Categories("Categories"),
    PlaceHolders_AllInOne("AllInOne"),
    PlaceHolders_Active("On"),
    PlaceHolders_Deactive("Off"),
    Messages_noPermissions("&cYou don't have permissions!"),
    Messages_DependenciesProtocolLib("&cProtocolLib not found, disabling the plugin..."),
    Messages_DependenciesLibsDisguises("&cLibsDisguises not found, disabling the plugin..."),
    Messages_VersionOutdated("&cYou need a version higher then {version}+ to use this"),
    Messages_FreezeActivated("&7Freeze activated for &e{target}&7."),
    Messages_FreezeDeactivated("&7Freeze deactivated for &e{target}&7."),
    Messages_FreezeAllActivated("&7Freeze activated for &eall&7."),
    Messages_FreezeAllDeactivated("&7Freeze deactivated for &eall&7."),
    Messages_FacepalmActivated("&7Facepalm activated for &e{target}&7."),
    Messages_FacepalmDeactivated("&7Facepalm deactivated for &e{target}&7."),
    Messages_controlPlayerActivated("&7Now you are controlling &e{target}&7."),
    Messages_controlPlayerDeactivated("&7You was stopped the control of &e{target}&7."),
    Messages_hidePlayerActivated("&e{target}&7 is now hidden from all players."),
    Messages_hidePlayerDeactivated("&e{target}&7 is now showed from all players."),
    Messages_infiniteInvActivated("&7The infinite inventory has been activated for&e{target}&7."),
    Messages_infiniteInvDeactivated("&7The infinite inventory has been deactivated for&e{target}&7."),
    Messages_fakeLagActivated("&7The fake lag has been activated for&e{target}&7."),
    Messages_fakeLagDeactivated("&7The fake lag has been deactivated for&e{target}&7."),
    Messages_anotherAllPlayer("&cThis troll is needed to do to all players, not only you!" +
            "\n&cYou have to wait more online players!"),
    Messages_anotherPlayer("&cThis troll is needed to do to another player, not you!"),
    ;

    private TranslationManager manager;
    private final String content;

    LBase(String msg){
        this.content = msg;
    }

    @Override
    public Locale getLanguage() {
        return new Locale("en","US");
    }

    @Override
    public Translation get() {
        return new Translation(this, this.name(), this.content);
    }

    @Override
    public List<Translation> translations() {
        return Arrays.stream(values()).map(LBase::get).collect(Collectors.toList());
    }

    @Override
    public void setManager(TranslationManager translationManager) {
        this.manager = translationManager;
    }

    @Override
    public TranslationManager getManager() {
        return manager;
    }

    @Override
    public String toString() {
        return Utils.ct(this.get().translate());
    }

}