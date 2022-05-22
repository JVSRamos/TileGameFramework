package Models;

public class Layer extends GameModel {

    private int numRows, numCols;
    public GameModel[][] layer;

    public Layer(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        layer = new GameModel[numRows][numCols];
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public int getNumMarks() {
        int numMarks = 0;

        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                if(layer[i][j] instanceof Flag) numMarks++;
            }
        }

        return numMarks;
    }

    public int getNumMarkedBoxes() {
        int boxes = 0;

        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                if(layer[i][j] instanceof Box) {
                    Box box = (Box) layer[i][j];
                    if(box.isMarked()) boxes++;
                }
            }
        }

        return boxes;
    }

    public Player findPlayer() {
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                if(layer[i][j] instanceof Player) return (Player) layer[i][j];
            }
        }

        return null;
    }

    public void addModelAtPos(int i, int j, GameModel model) {
        this.layer[i][j] = model;
    }

}
