package Views.graphics;

import Input.KeyBoardHandler;
import Models.Board;
import Models.Layer;
import Views.BoardView;
import Views.GameModelView;
import Views.LayerView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardGraphicView extends BoardView {
    JFrame boardFrame;
    public BoardGraphicView() {
        super();
        boardFrame = new JFrame();
        boardFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void addLayer(LayerView layer) {
        this.layers.add(layer);
    }

    private int getBoardWidthSize() {
        LayerGraphicView layer = (LayerGraphicView) layers.get(0);
        Dimension tileSize = layer.getTileSize();
        return tileSize.width * layer.getNcols();
    }

    private int getBoardHeightSize() {
        LayerGraphicView layer = (LayerGraphicView) layers.get(0);
        Dimension tileSize = layer.getTileSize();
        return tileSize.height * layer.getNrows();
    }

    @Override
    public void showBoard(Board board) {
        List<Layer> modelLayers = board.getLayers();
        this.layers = new ArrayList<>();
        for(Layer layer : modelLayers) {
            this.addLayer(new LayerGraphicView(layer.getNumRows(), layer.getNumCols()));
        }

        for(int i = 0; i < layers.size(); i++) {
            layers.get(i).showLayer(modelLayers.get(i));
        }

        JLayeredPane layeredPane = new JLayeredPane();

        for(int depth = 0; depth < layers.size(); depth++) {
            LayerGraphicView layer = (LayerGraphicView) layers.get(depth);
            layer.getPanel().setBounds(0,0, getBoardWidthSize(), getBoardHeightSize());
            layeredPane.add(layer.getPanel(), depth);
        }

        boardFrame.getContentPane().removeAll();
        boardFrame.repaint();
        boardFrame.add(layeredPane);
        boardFrame.setSize(new Dimension(getBoardWidthSize() + 12, getBoardHeightSize() + 32));
        boardFrame.setVisible(true);
    }

    @Override
    public void addInputListener(KeyBoardHandler keyBoardHandler) {
        this.boardFrame.addKeyListener(keyBoardHandler);
    }
}
