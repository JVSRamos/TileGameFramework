import Controllers.BoardController;
import WinHandler.SokobanWinHandler;

public class GameState {

    private SokobanWinHandler winHandler;
    private BoardController boardController;

    public GameState(BoardController boardController) {
        this.boardController = boardController;
    }

    public void run() {
        boardController.run();
    }



}
