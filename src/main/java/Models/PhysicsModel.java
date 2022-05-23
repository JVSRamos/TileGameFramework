package Models;

import Input.Direction;

import java.awt.*;

public abstract class PhysicsModel extends GameModel {

    public PhysicsModel(Point position) {
        super(position);
    }
    public abstract void action(Direction direction, Layer layer, Board board);

}
