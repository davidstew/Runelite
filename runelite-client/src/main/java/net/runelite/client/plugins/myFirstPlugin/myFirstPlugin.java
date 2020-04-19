package net.runelite.client.plugins.myFirstPlugin;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.events.StatChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
        name = "Experiment",
        description = "Playing around with the RuneLite Plugins"
)
public class myFirstPlugin extends Plugin {

    @Subscribe
    public void onStatChanged(StatChanged statChanged)
    {
      System.out.println("GIMMIE DAT XP");
    }


}
