package Views.text;

import Models.*;
import Views.LayerView;
import Views.graphics.*;

public class LayerTextView extends LayerView {

    char[][] layerCharMatrix;


    public char[][] getLayer() {
        return layerCharMatrix;
    }

    @Override
    public void showLayer(Layer layer) {
        GameModel[][] gameModels = layer.layer;
        int nrows = gameModels.length;
        int ncols = gameModels[0].length;
        layerCharMatrix = new char[nrows][ncols];

        for(int i = 0; i < nrows; i++) {
            for(int j = 0; j < ncols; j++) {
                GameModelTextView gameModelView = new GameModelTextView();
                gameModelView.showView(gameModels[i][j]);
                layerCharMatrix[i][j] = gameModelView.getSymbol();
            }
        }
    }
}
