import Components.Board;
import Controllers.BoardController;

public class GameState {

    private WinHandler winHandler;
    private BoardController boardController;

    public GameState(BoardController boardController) {
        this.boardController = boardController;
    }

    void run() {

    }

}
