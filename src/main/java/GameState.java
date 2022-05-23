import Controllers.BoardController;

public class GameState {

    private BoardController boardController;
    public GameState(BoardController boardController) {
        this.boardController = boardController;
    }

    public void run() {
        boardController.run();
    }



}
