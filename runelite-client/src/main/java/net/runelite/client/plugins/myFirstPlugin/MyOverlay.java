package net.runelite.client.plugins.myFirstPlugin;

import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import javax.inject.Inject;
import java.awt.*;

public class MyOverlay extends Overlay {

    private myFirstPlugin plugin;

    private PanelComponent panelComponent = new PanelComponent();

    @Inject
    public MyOverlay(myFirstPlugin plugin) {
        super(plugin);
        setPosition(OverlayPosition.TOP_LEFT);
        setLayer(OverlayLayer.ABOVE_SCENE);
        this.plugin = plugin;
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        panelComponent.getChildren().clear();
        panelComponent.getChildren().add(LineComponent.builder().left("Nerd Counter").right(Integer.toString(plugin.getNerdCount())).build());
        return panelComponent.render(graphics);
    }
}
