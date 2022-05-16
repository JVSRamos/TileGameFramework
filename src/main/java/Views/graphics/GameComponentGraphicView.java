package Views.graphics;

import Views.ComponentView;

import javax.swing.*;
import java.awt.*;

public abstract class GameComponentGraphicView extends JComponent implements ComponentView {

    JLabel iconContainer;
    final int DEFAULT_TILE_SIZE = 32;

    public GameComponentGraphicView() {
        iconContainer = new JLabel();
        iconContainer.setSize(new Dimension(DEFAULT_TILE_SIZE, DEFAULT_TILE_SIZE));
    }
    public GameComponentGraphicView(Icon icon) {
        iconContainer = new JLabel();
        iconContainer.setIcon(icon);
        iconContainer.setSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
    }

    @Override
    public void showComponent() {}

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
