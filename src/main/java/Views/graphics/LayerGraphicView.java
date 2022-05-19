package Views.graphics;

import Views.GameModelView;

import javax.swing.*;
import java.awt.*;

public class LayerGraphicView extends JPanel implements GameModelView {

    GameModelGraphicView[][] layer;
    int nrows, ncols;
    public LayerGraphicView(int nrows, int ncols) {
        this.setOpaque(true);
        this.setBackground(new Color(0,0,0,0));

        this.nrows = nrows;
        this.ncols = ncols;

        layer = new GameModelGraphicView[nrows][ncols];
        this.setLayout(new GridLayout(nrows, ncols, 0, 0));
        for(int i = 0; i < nrows; i++) {
            for(int j = 0; j < ncols; j++) {
                layer[i][j] = new EmptyTileGraphicView();
                this.add(layer[i][j]);
            }
        }
    }

    private void addComponentsToPanel() {
        for(int i = 0; i < nrows; i++) {
            for(int j = 0; j < ncols; j++) {
                this.add(layer[i][j]);
            }
        }
    }

    public void addComponentToCell(int i, int j, GameModelGraphicView comp) {
        this.removeAll();
        this.revalidate();
        this.repaint();
        this.layer[i][j] = comp;
        addComponentsToPanel();
    }

    @Override
    public void showView() {
        for(int i = 0; i < nrows; i++) {
            for(int j = 0; j < ncols; j++) {
                Boolean isEmpty = layer[i][j] instanceof EmptyTileGraphicView;
                if(!isEmpty) layer[i][j].showView();
            }
        }
    }

}
