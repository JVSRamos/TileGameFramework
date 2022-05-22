package Views.graphics;

import Models.GameModel;
import Views.GameModelView;

import javax.swing.*;
import java.awt.*;

public abstract class GameModelGraphicView extends JComponent implements GameModelView {

    JLabel iconContainer;
    final int DEFAULT_TILE_SIZE = 32;

    public GameModelGraphicView() {
        iconContainer = new JLabel();
        iconContainer.setSize(new Dimension(DEFAULT_TILE_SIZE, DEFAULT_TILE_SIZE));
    }
    public GameModelGraphicView(Icon icon) {
        iconContainer = new JLabel();
        iconContainer.setIcon(icon);
        iconContainer.setSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        this.add(this.iconContainer);
        this.setVisible(false);
    }

    @Override
    public void showView(GameModel gameModel) {
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
