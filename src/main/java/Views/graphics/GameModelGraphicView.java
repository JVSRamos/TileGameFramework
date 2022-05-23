package Views.graphics;

import Models.*;
import Models.Box;
import Views.GameModelView;

import javax.swing.*;
import java.awt.*;

public class GameModelGraphicView extends JComponent implements GameModelView {

    JLabel iconContainer;
    final int DEFAULT_TILE_SIZE = 32;

    public GameModelGraphicView() {
        iconContainer = new JLabel();
        iconContainer.setSize(new Dimension(DEFAULT_TILE_SIZE, DEFAULT_TILE_SIZE));
    }
    public ImageIcon getIconFromModel(GameModel gameModel) {
        if(gameModel instanceof Models.Box) {
            Models.Box box = (Box) gameModel;
            if(box.isMarked()) return new ImageIcon("src/main/resources/sokoban_icons/cratemarked.png");
            else return new ImageIcon("src/main/resources/sokoban_icons/crate.png");
        }
        else if(gameModel instanceof Player) return new ImageIcon("src/main/resources/sokoban_icons/player.png");
        else if(gameModel instanceof Flag) return new ImageIcon("src/main/resources/sokoban_icons/blankmarked.png");
        else if(gameModel instanceof Floor) return new ImageIcon("src/main/resources/sokoban_icons/blank.png");
        else if(gameModel instanceof Wall) return new ImageIcon("src/main/resources/sokoban_icons/wall.png");
        else return null;
    }

    @Override
    public void showView(GameModel gameModel) {
        ImageIcon icon = getIconFromModel(gameModel);
        iconContainer = new JLabel();
        iconContainer.setIcon(icon);
        iconContainer.setSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        this.add(this.iconContainer);
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
