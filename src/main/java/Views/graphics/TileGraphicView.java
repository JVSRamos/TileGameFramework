package Views.graphics;

import Views.ComponentView;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.File;

public class TileGraphicView extends GameComponentGraphicView {

    public TileGraphicView(Icon icon) {
        super(icon);
        this.add(this.iconContainer);
        this.setVisible(false);
    }

    @Override
    public void showComponent() {
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.iconContainer.getWidth(), this.iconContainer.getHeight());
    }

}


