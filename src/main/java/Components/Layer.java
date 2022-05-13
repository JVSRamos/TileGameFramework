package Components;

import java.util.List;

public class Layer {

    int numRows, numCols;
    GameComponent[][] layer;

    public Layer(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        layer = new GameComponent[numRows][numCols];
    }

}
