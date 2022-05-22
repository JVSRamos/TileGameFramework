package WinHandler;

import Controllers.BoardController;

public class SokobanWinHandler implements WinHandler {
    @Override
    public boolean checkWin(BoardController boardController) {
        return boardController.getNumMarks() == boardController.getNumMarkedBoxes();
    }
}
