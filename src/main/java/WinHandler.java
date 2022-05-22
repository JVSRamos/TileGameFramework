import Controllers.BoardController;
import Models.Board;

public class WinHandler {

    BoardController boardController;

    public WinHandler(BoardController boardController) {
        this.boardController = boardController;
    }

    public boolean checkWin() {
        return boardController.getNumMarks() == boardController.getNumMarkedBoxes();
    }

}
