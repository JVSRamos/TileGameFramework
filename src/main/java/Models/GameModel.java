package Models;

import java.awt.Point;

public abstract class GameModel {

    protected Point position;

    public GameModel() {}

    public GameModel(Point position) {
        this.position = position;
    }

}
