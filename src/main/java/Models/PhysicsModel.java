package Models;

import Input.Direction;

import java.awt.*;

public abstract class PhysicsModel extends GameModel {

    public PhysicsModel(Point position) {
        super(position);
    }
    public void action(Direction direction, Layer layer) {}

}
