package Models;

import java.util.List;

public class Board extends GameModel {

    private int numRows, numCols;

    private List<Layer> layers;

    public Board(List<Layer> layers) {
        this.layers = layers;
    }

    public Player findPlayer() {

        for(Layer layer : layers) {
            Player player = layer.findPlayer();
            if(player != null) return player;
        }

        return null;

    }

    public List<Layer> getLayers() {
        return layers;
    }

    public Layer findPlayerLayer() {

        for(Layer layer : layers) {
            if(layer.findPlayer() != null) return layer;
        }

        return null;

    }

}
