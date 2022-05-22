package Views.graphics;

import Models.*;
import Models.Box;
import Views.GameModelView;
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
                layer[i][j] = new EmptyTileGraphicView();
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

    public GameModelGraphicView getViewFromModel(GameModel gameModel) {
        if(gameModel instanceof Box) {
            Box box = (Box) gameModel;
            if(box.getMarked()) return new MarkedBoxGraphicView();
            else return new BoxGraphicView();
        }
        else if(gameModel instanceof Player) return new PlayerGraphicView();
        else if(gameModel instanceof Flag) return new FlagGraphicView();
        else if(gameModel instanceof Floor) return new FloorGraphicView();
        else if(gameModel instanceof Wall) return new WallGraphicView();
        else return null;
    }

    @Override
    public void showLayer(Layer layer) {
        for(int i = 0; i < nrows; i++) {
            for(int j = 0; j < ncols; j++) {
                boolean isEmpty = layer.layer[i][j] instanceof EmptyTile;
                if(!isEmpty) {
                    GameModelGraphicView gameModelView = getViewFromModel(layer.layer[i][j]);
                    addTileToCell(i, j, gameModelView);
                    gameModelView.showView(layer.layer[i][j]);
                }
            }
        }
    }

}
