package WinHandler;

import Controllers.BoardController;

public class WinHandler {

    BoardController boardController;

    public WinHandler(BoardController boardController) {
        this.boardController = boardController;
    }

    public boolean checkWin() {
        return boardController.getNumMarks() == boardController.getNumMarkedBoxes();
    }

}
