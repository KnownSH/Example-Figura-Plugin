package net.knsh.figurasvc;

import com.mojang.datafixers.util.Pair;
import de.maxhenkel.voicechat.api.VoicechatPlugin;
import de.maxhenkel.voicechat.api.events.ClientSoundEvent;
import de.maxhenkel.voicechat.api.events.EventRegistration;
import org.figuramc.figura.entries.FiguraEvent;
import org.figuramc.figura.entries.annotations.FiguraEventPlugin;
import org.figuramc.figura.lua.LuaWhitelist;
import org.figuramc.figura.lua.api.event.LuaEvent;
import org.figuramc.figura.lua.docs.LuaFieldDoc;
import org.figuramc.figura.lua.docs.LuaTypeDoc;

import java.util.Collection;
import java.util.Collections;

@FiguraEventPlugin
public class VoiceChatEvent implements FiguraEvent {
    @LuaWhitelist
    @LuaFieldDoc("svc.microphone_active")
    public static LuaEvent MICROPHONE = new LuaEvent();

    @Override
    public String getID() {
        return FiguraSVC.PLUGIN_ID;
    }

    @Override
    public Collection<Pair<String, LuaEvent>> getEvents() {
        return Collections.singleton(new Pair<>("MICROPHONE", MICROPHONE));
    }
}
