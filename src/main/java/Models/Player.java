package Models;

import Input.Direction;
import Views.graphics.EmptyTileGraphicView;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Player extends GameModel {

    Map<Direction, Point> gridMove;

    public void initializeGridMoveMap() {
        gridMove = new HashMap<>();
        gridMove.put(Direction.DOWN, new Point(1, 0));
        gridMove.put(Direction.UP, new Point(-1, 0));
        gridMove.put(Direction.LEFT, new Point(0, -1));
        gridMove.put(Direction.RIGHT, new Point(0, 1));
    }

    public Player() {}
    public Player(Point position) {
        super(position);
        initializeGridMoveMap();
    }
    public void move(Direction direction, Layer layer, Board board) {
        Point gridDirection = gridMove.get(direction);
        Point curPosition = new Point((int) (position.getX() + gridDirection.getX()),
                (int) (position.getY() + gridDirection.getY()));

        GameModel nextTile = layer.layer[curPosition.x][curPosition.y];

        if(nextTile instanceof PhysicsModel) {
            PhysicsModel nextTileWithPhysics = (PhysicsModel) nextTile;
            nextTileWithPhysics.action(direction, layer, board);
        }

        if(layer.layer[curPosition.x][curPosition.y] instanceof EmptyTile) {
            layer.layer[position.x][position.y] = layer.layer[curPosition.x][curPosition.y];
            layer.layer[curPosition.x][curPosition.y] = this;
            position = curPosition;
        }

    }

}
