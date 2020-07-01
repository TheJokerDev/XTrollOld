package me.TheJokerDev.XTroll.language;

import me.TheJokerDev.XTroll.Main;
import xyz.theprogramsrc.supercoreapi.global.translations.Translation;
import xyz.theprogramsrc.supercoreapi.global.translations.TranslationManager;
import xyz.theprogramsrc.supercoreapi.global.translations.TranslationPack;

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
    PlaceHolders_AllInOne("AllInOne")
    ;

    private TranslationManager manager;
    private final String content;

    LBase(String content){
        this.content = content;
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
        return Main.i.getSuperUtils().color(this.get().translate());
    }

}