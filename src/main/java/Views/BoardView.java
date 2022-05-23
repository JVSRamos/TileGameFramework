package Views;

import Input.InputHandler;
import Models.Board;

import java.util.ArrayList;
import java.util.List;

public abstract class BoardView {

    protected List<LayerView> layers;

    public BoardView() {
        this.layers = new ArrayList<>();
    }

    public List<LayerView> getLayers() {
        return layers;
    }

    public abstract void showBoard(Board board);

    public abstract void addInputListener(InputHandler inputHandler);

}
