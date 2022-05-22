package Models;

import Input.Direction;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Box extends PhysicsModel {

    Map<Direction, Point> gridMove;

    public void initializeGridMoveMap() {
        gridMove = new HashMap<>();
        gridMove.put(Direction.DOWN, new Point(1, 0));
        gridMove.put(Direction.UP, new Point(-1, 0));
        gridMove.put(Direction.LEFT, new Point(0, -1));
        gridMove.put(Direction.RIGHT, new Point(0, 1));
    }

    public Box(Point position) {
        super(position);
        initializeGridMoveMap();
    }

    @Override
    public void action(Direction direction, Layer layer) {
        Point gridDirection = gridMove.get(direction);
        Point curPosition = new Point((int) (position.getX() + gridDirection.getX()),
                (int) (position.getY() + gridDirection.getY()));

        GameModel nextTile = layer.layer[curPosition.x][curPosition.y];

        if(nextTile instanceof PhysicsModel) {
            PhysicsModel nextTileWithPhysics = (PhysicsModel) nextTile;
            nextTileWithPhysics.action(direction, layer);
        }

        if(layer.layer[curPosition.x][curPosition.y] instanceof EmptyTile) {
            layer.layer[position.x][position.y] = layer.layer[curPosition.x][curPosition.y];
            layer.layer[curPosition.x][curPosition.y] = this;
            position = curPosition;
        }
    }
}
