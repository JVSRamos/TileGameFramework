package Input;

import Controllers.BoardController;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class KeyBoardHandler implements KeyListener {

    BoardController boardController;
    Map<Integer, Direction> keyCodeDirectionMap;

    public void initializeKeyCodeDirectionMap() {
        keyCodeDirectionMap = new HashMap<>();
        keyCodeDirectionMap.put(KeyEvent.VK_UP, Direction.UP);
        keyCodeDirectionMap.put(KeyEvent.VK_DOWN, Direction.DOWN);
        keyCodeDirectionMap.put(KeyEvent.VK_LEFT, Direction.LEFT);
        keyCodeDirectionMap.put(KeyEvent.VK_RIGHT, Direction.RIGHT);
    }

    public KeyBoardHandler(BoardController boardController) {
        this.boardController = boardController;
        initializeKeyCodeDirectionMap();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        boardController.HandleInput(keyCodeDirectionMap.get(key));
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
