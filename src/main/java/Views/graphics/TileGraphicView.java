package Views.graphics;

import javax.swing.*;
import java.awt.*;

public class TileGraphicView extends GameModelGraphicView {

    public TileGraphicView(Icon icon) {
        super(icon);
        this.add(this.iconContainer);
        this.setVisible(false);
    }

    @Override
    public void showView() {
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
    }

    public Dimension getTileSize() {
        return new Dimension(this.iconContainer.getWidth(), this.iconContainer.getHeight());
    }

    @Override
    public Dimension getPreferredSize() {
        return getTileSize();
    }

}


