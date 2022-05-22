package Controllers;

import Input.Direction;
import Models.Board;
import Models.Layer;
import Models.Player;
import Views.BoardView;
import Views.LayerView;

import java.util.ArrayList;
import java.util.List;

public class BoardController {

    Board board;
    BoardView boardView;

    List<LayerController> layerControllers;

    public BoardController(Board board, BoardView boardView) {
        this.boardView = boardView;
        this.board = board;
    }

    private void showBoard(Board board) {
        boardView.showBoard(board);
    }

    public int getNumMarks() {return board.getNumMarks();}

    public int getNumMarkedBoxes() {return board.getNumMarkedBoxes();}

    public void HandleInput(Direction direction) {
        Player player = board.findPlayer();
        player.move(direction, board.findPlayerLayer(), board);
        this.showBoard(board);

    }

    public void run() {
        this.showBoard(board);
    }


}
