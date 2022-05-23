package Views.graphics;

import Models.*;
import Models.Box;
import Views.LayerView;

import javax.swing.*;
import java.awt.*;

public class LayerGraphicView extends LayerView {
    private JPanel layerPanel;
    int nrows, ncols;
    public LayerGraphicView(int nrows, int ncols) {
        layerPanel = new JPanel();
        layerPanel.setOpaque(true);
        layerPanel.setBackground(new Color(0,0,0,0));

        this.nrows = nrows;
        this.ncols = ncols;

        layer = new GameModelGraphicView[nrows][ncols];
        layerPanel.setLayout(new GridLayout(nrows, ncols, 0, 0));
        for(int i = 0; i < nrows; i++) {
            for(int j = 0; j < ncols; j++) {
                layer[i][j] = new GameModelGraphicView();
                layerPanel.add((GameModelGraphicView) layer[i][j]);
            }
        }
    }

    public JPanel getPanel() {
        return this.layerPanel;
    }

    public Dimension getTileSize() {
        GameModelGraphicView tile = (GameModelGraphicView) layer[0][0];
        return tile.getTileSize();
    }

    public int getNrows() {
        return nrows;
    }

    public int getNcols() {
        return ncols;
    }

    private void addComponentsToPanel() {
        for(int i = 0; i < nrows; i++) {
            for(int j = 0; j < ncols; j++) {
                layerPanel.add((GameModelGraphicView) layer[i][j]);
            }
        }
    }

    public void addTileToCell(int i, int j, GameModelGraphicView comp) {
        layerPanel.removeAll();
        layerPanel.revalidate();
        layerPanel.repaint();
        this.layer[i][j] = comp;
        addComponentsToPanel();
    }

    @Override
    public void showLayer(Layer layer) {
        for(int i = 0; i < nrows; i++) {
            for(int j = 0; j < ncols; j++) {
                boolean isEmpty = layer.layer[i][j] instanceof EmptyTile;
                if(!isEmpty) {
                    GameModelGraphicView gameModelView = new GameModelGraphicView();
                    addTileToCell(i, j, gameModelView);
                    gameModelView.showView(layer.layer[i][j]);
                }
            }
        }
    }

}
