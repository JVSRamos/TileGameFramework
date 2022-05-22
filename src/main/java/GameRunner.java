import Controllers.BoardController;
import Input.KeyBoardHandler;
import Models.Board;
import Views.graphics.BoardGraphicView;

import java.util.ArrayList;

public class GameRunner {

    public static void main(String[] args) {

        ArrayList<char[][]> layers = new ArrayList<>();

        char[][] layer1 = {{'.', '.', '.', '.'},
                          {'.', '.', '.', '.'},
                          {'.', '.', '.', '.'},
                          {'.', '.', '.', '.'},
                          {'.', '*', '.', '.'},
                          {'.', '.', '.', '.'}};

        char[][] layer2 = {{'#', '#', '#', '#'},
                           {'#', '-', '-', '#'},
                           {'#', 'o', '-', '#'},
                           {'#', 'b', '-', '#'},
                           {'#', '-', '-', '#'},
                           {'#', '#', '#', '#'}};

        layers.add(layer2);
        layers.add(layer1);

        MapLoader mapLoader = new MapLoader();
        Board board = mapLoader.createModelBoard(layers);
        BoardGraphicView boardView = mapLoader.createGraphicViewBoard(layers);
        BoardController controller = new BoardController(board, boardView);
        // **** Add coupling of model with graphics view
        boardView.addInputListener(new KeyBoardHandler(controller));

        GameLevel level = new GameLevel(controller);
        TileGame tileGame = new TileGame();
        tileGame.addLevel(level);

        tileGame.run();

    }

}
