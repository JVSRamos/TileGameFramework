package Views.graphics;

import Views.GameModelView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BoardGraphicView implements GameModelView {
    JFrame boardFrame;
    List<LayerGraphicView> layers;

    public BoardGraphicView(List<LayerGraphicView> layers) {
        boardFrame = new JFrame();
        JLayeredPane layeredPane = new JLayeredPane();
        this.layers = layers;
        for(int depth = 0; depth < layers.size(); depth++) {
            layers.get(depth).setBounds(0,0, 160, 160);
            layeredPane.add(layers.get(depth), depth);
        }
        boardFrame.add(layeredPane);
    }

    @Override
    public void showView() {
        for(LayerGraphicView layer : layers) {
            layer.showView();
        }
        boardFrame.setSize(new Dimension(200, 200));
        boardFrame.setVisible(true);
    }

    public static void main(String[] args) {
        LayerGraphicView layer = new LayerGraphicView(5, 5);

        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                ImageIcon icon = new ImageIcon("src/main/resources/sokoban_icons/crate.png");
                TileGraphicView tile = new TileGraphicView(icon);
                layer.addComponentToCell(i, j, tile);
            }
        }

        ArrayList<LayerGraphicView> layers = new ArrayList<>();
        layers.add(layer);

        LayerGraphicView layer2 = new LayerGraphicView(5, 5);

        for(int i = 2; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                ImageIcon icon = new ImageIcon("src/main/resources/sokoban_icons/blank.png");
                TileGraphicView tile = new TileGraphicView(icon);
                layer2.addComponentToCell(i, j, tile);
            }
        }

        layers.add(layer2);

        BoardGraphicView board = new BoardGraphicView(layers);
        board.showView();
    }

}
