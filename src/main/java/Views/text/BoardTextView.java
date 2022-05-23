package Views.text;

import Input.InputHandler;
import Input.KeyBoardHandler;
import Models.Board;
import Models.Layer;
import Views.BoardView;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import java.util.List;

public class BoardTextView extends BoardView {

    JFrame frame = new JFrame();
    @Override
    public void showBoard(Board board) {
        frame.setVisible(true);
        List<char[][]> layers = new ArrayList<>();

        for(Layer layer : board.getLayers()) {
            LayerTextView layerView = new LayerTextView();
            layerView.showLayer(layer);
            layers.add(layerView.getLayer());
        }

        int nrows = layers.get(0).length;
        int ncols = layers.get(0)[0].length;

        for(int i = 0; i < nrows; i++) {
            for(int j = 0; j < ncols; j++) {
                for(char[][] layer : layers) {
                    if(layer[i][j] != '-') {
                        System.out.printf("%c ", layer[i][j]);
                        break;
                    }
                }
            }
            System.out.print('\n');
        }

        System.out.print('\n');
    }

    @Override
    public void stop() {
        for(int i = 0; i < 50; ++i) System.out.println();
        this.frame.setVisible(false);
        this.frame.dispose();
    }

    @Override
    public void addInputListener(InputHandler inputHandler) {
        frame.addKeyListener((KeyAdapter) inputHandler);
    }
}
