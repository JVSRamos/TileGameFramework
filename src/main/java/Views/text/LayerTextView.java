package Views.text;

import Views.GameModelView;

import javax.swing.*;
import java.awt.*;

public class LayerTextView extends JPanel implements GameModelView {
	GameModelTextView[][] layer;
	int nrows, ncols;
	public LayerTextView(int nrows, int ncols) {
        this.nrows = nrows;
        this.ncols = ncols;

        layer = new GameModelTextView[nrows][ncols];
        for(int i = 0; i < nrows; i++) {
            for(int j = 0; j < ncols; j++) {
                layer[i][j] = new EmptyTileTextView();
                this.add(layer[i][j]);
            }
        }
    }

	public void showView() {
        for(int i = 0; i < nrows; i++) {
            for(int j = 0; j < ncols; j++) {
            	Boolean isEmpty = layer[i][j] instanceof EmptyTileTextView;
                if(!isEmpty) {
                	layer[i][j].showView();
                }
            }
            System.out.println();
        }
    }

	public void addComponentToCell(int i, int j, GameModelTextView c) {
		this.layer[i][j] = c;
	}
	
}
