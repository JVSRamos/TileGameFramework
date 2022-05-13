package Views.graphics;

import Views.ComponentView;

import javax.swing.*;
import java.awt.*;

public class TileGraphicView extends GameComponentGraphicView implements ComponentView {

    public TileGraphicView(JComponent icon) {
        super(icon);
    }

    @Override
    public void showComponent() {
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.icon.repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JLabel label = new JLabel();
        ImageIcon icon = new ImageIcon("./resources/sokoban_icons/crate.png");
        label.setIcon(icon);
        TileGraphicView tile = new TileGraphicView(label);
        frame.add(label);
        frame.pack();
        frame.setVisible(true);
    }

}


