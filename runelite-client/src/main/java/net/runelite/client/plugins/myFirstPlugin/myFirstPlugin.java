package net.runelite.client.plugins.myFirstPlugin;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.StatChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
        name = "Nerd Counter",
        description = "Plugin that counts how many times people call each other nerds in the Public Chat"
)
public class myFirstPlugin extends Plugin {

    private int nerdCount = 0;

    @Inject
    private Client client;

    @Inject
    private OverlayManager overlayManager;

    @Inject MyOverlay myOverlay;

    @Override
    public void startUp() {
        overlayManager.add(myOverlay);
    }

    @Override
    public void shutDown() {
        overlayManager.remove(myOverlay);
    }

    @Subscribe
    public void onChatMessage(ChatMessage chatMessage) {
        if (chatMessage.getType().equals(ChatMessageType.PUBLICCHAT) && chatMessage.getMessage().toLowerCase().contains("nerd")) {
            nerdCount++;
            System.out.println(nerdCount);
        }
    }

    protected int getNerdCount() { return nerdCount; }
    
//    @Subscribe
//    public void onStatChanged(StatChanged statChanged)
//    {
//      System.out.println("GIMMIE DAT XP");
//    }
}
