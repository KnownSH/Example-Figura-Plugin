package net.knsh.figurasvc;

import de.maxhenkel.voicechat.api.VoicechatPlugin;
import de.maxhenkel.voicechat.api.events.ClientSoundEvent;
import de.maxhenkel.voicechat.api.events.EventRegistration;
import org.figuramc.figura.FiguraMod;
import org.figuramc.figura.avatar.Avatar;
import org.figuramc.figura.avatar.AvatarManager;
import org.figuramc.figura.entries.FiguraAPI;
import org.figuramc.figura.entries.annotations.FiguraAPIPlugin;
import org.figuramc.figura.lua.LuaWhitelist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Example API Plugin
 *  Annotation required for Forge to Locate and Load the Plugin
 *  Entrypoint in fabric.mod.json: figura_api
 *  Fabric requires entrypoints have an empty constructor, Figura will not use it
 */
@FiguraAPIPlugin
@LuaWhitelist
public class FiguraSVC implements FiguraAPI {
    public static final String PLUGIN_ID = "svc";
    public static final Logger LOGGER = LoggerFactory.getLogger(PLUGIN_ID);
    private Avatar avatar;

    public FiguraSVC() {
    }
    public FiguraSVC(Avatar avatar) {
        this.avatar = avatar;
    }

    /**
     * You can do common things on init here
     */
    //public static void init() {}

    @Override
    public FiguraAPI build(Avatar avatar) {
        return new FiguraSVC(avatar);
    }

    @Override
    public String getName() {
        return PLUGIN_ID;
    }

    @Override
    public Collection<Class<?>> getWhitelistedClasses() {
        List<Class<?>> classesToRegister = new ArrayList<>();
        for (Class<?> aClass : EXAMPLE_PLUGIN_CLASSES) {
            if (aClass.isAnnotationPresent(LuaWhitelist.class)) {
                classesToRegister.add(aClass);
            }
        }
        return classesToRegister;
    }

    @Override
    public Collection<Class<?>> getDocsClasses() {
        return List.of();
    }

    public static final Class<?>[] EXAMPLE_PLUGIN_CLASSES = new Class[] {
            FiguraSVC.class,
    };
}
