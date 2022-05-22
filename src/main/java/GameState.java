import Controllers.BoardController;
import Input.KeyBoardHandler;
import Views.BoardView;
import Views.GameModelView;

import java.awt.event.KeyListener;
import java.util.EventListener;

public class GameState {

    private WinHandler winHandler;
    private BoardController boardController;

    public GameState(BoardController boardController) {
        this.boardController = boardController;
        winHandler = new WinHandler(boardController);
    }

    public void run() {
        boardController.run();
    }



}
