package Controllers;

import Components.Board;
import Input.InputHandler;
import Views.ComponentView;

public class BoardController {

    Board board;
    ComponentView boardView;

    InputHandler inputHandler;

    void updateView() {
        boardView.showComponent();
    }




}
