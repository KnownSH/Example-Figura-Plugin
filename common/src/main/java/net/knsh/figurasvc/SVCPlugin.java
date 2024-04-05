package net.knsh.figurasvc;

import de.maxhenkel.voicechat.api.VoicechatPlugin;
import de.maxhenkel.voicechat.api.events.ClientSoundEvent;
import de.maxhenkel.voicechat.api.events.EventRegistration;
import org.figuramc.figura.FiguraMod;
import org.figuramc.figura.avatar.Avatar;
import org.figuramc.figura.avatar.AvatarManager;

public class SVCPlugin implements VoicechatPlugin {
    @Override
    public String getPluginId() {
        return FiguraSVC.PLUGIN_ID;
    }

    @Override
    public void registerEvents(EventRegistration registration) {
        registration.registerEvent(ClientSoundEvent.class, this::onClientSpeak);
    }

    private void onClientSpeak(ClientSoundEvent event) {
        Avatar avatar = AvatarManager.getAvatarForPlayer(FiguraMod.getLocalPlayerUUID());
        if (!event.getVoicechat().isMuted()) {
            avatar.run("SVC.MICROPHONE", avatar.tick);
        }
    }
}
