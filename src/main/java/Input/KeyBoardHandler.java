package Input;

import Controllers.BoardController;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class KeyBoardHandler extends KeyAdapter {


    public Direction direction = null;

    Map<Integer, Direction> keyCodeDirectionMap;

    public void initializeKeyCodeDirectionMap() {
        keyCodeDirectionMap = new HashMap<>();
        keyCodeDirectionMap.put(KeyEvent.VK_UP, Direction.UP);
        keyCodeDirectionMap.put(KeyEvent.VK_DOWN, Direction.DOWN);
        keyCodeDirectionMap.put(KeyEvent.VK_LEFT, Direction.LEFT);
        keyCodeDirectionMap.put(KeyEvent.VK_RIGHT, Direction.RIGHT);
    }

    public KeyBoardHandler() {
        initializeKeyCodeDirectionMap();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        direction = keyCodeDirectionMap.get(key);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
