package Views.graphics;

import Components.Board;
import Views.ComponentView;

public class BoardGraphicView implements ComponentView {

    Board board;

    public BoardGraphicView(Board board) {
        this.board = board;
    }

    @Override
    public void showComponent() {

    }
}
