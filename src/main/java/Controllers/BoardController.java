package Controllers;

import Input.Direction;
import Input.KeyBoardHandler;
import Models.Board;
import Models.Player;
import Views.BoardView;
import WinHandler.SokobanWinHandler;
import WinHandler.WinHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BoardController {

    Board board;
    BoardView boardView;

    KeyBoardHandler keyBoardHandler;

    WinHandler winHandler;

    List<LayerController> layerControllers;

    private Set<Direction> inputSet = new HashSet<>();

    public BoardController(Board board, BoardView boardView, KeyBoardHandler keyBoardHandler, WinHandler winHandler) {
        this.keyBoardHandler = keyBoardHandler;
        this.winHandler = winHandler;
        this.boardView = boardView;
        this.board = board;
        addInputListener(keyBoardHandler);
    }

    public void addInputListener(KeyBoardHandler keyBoardHandler) {
        boardView.addInputListener(keyBoardHandler);
    }

    private void showBoard(Board board) {
        boardView.showBoard(board);
    }


    public int getNumMarks() {return board.getNumMarks();}

    public int getNumMarkedBoxes() {return board.getNumMarkedBoxes();}

    public void handleInput(Direction direction) {
        Player player = board.findPlayer();
        player.move(direction, board.findPlayerLayer(), board);
        this.showBoard(board);

    }

    public void run() {
        this.showBoard(board);

        while(!winHandler.checkWin(this)) {
            if(keyBoardHandler.direction != null) {
                handleInput(keyBoardHandler.direction);
                keyBoardHandler.direction = null;
            }
            showBoard(board);
        }

    }

}
