import Controllers.BoardController;
import Input.KeyBoardHandler;
import Models.Board;
import Views.graphics.BoardGraphicView;
import Views.text.BoardTextView;
import WinHandler.SokobanWinHandler;

import java.util.ArrayList;

public class GameRunner {

    public static GameLevel createLevel1() {
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
        BoardTextView boardView = new BoardTextView();
        BoardController controller = new BoardController(board, boardView, new KeyBoardHandler(), new SokobanWinHandler());

        GameLevel level = new GameLevel(controller);
        return level;
    }

    public static GameLevel createLevel2() {
        ArrayList<char[][]> layers = new ArrayList<>();

        char[][] layer1 = {{'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '*', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '*', '.', '.'},
                {'.', '*', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '*', '.', '.', '.'},
                {'.', '.', '.', '*', '.', '.', '*', '.'},
                {'.', '.', '.', '.', '*', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};

        char[][] layer2 = {{'.', '.', '#', '#', '#', '#', '#', '.'},
                {'#', '#', '#', '-', '-', '-', '#', '.'},
                {'#', '-', 'o', 'b', '-', '-', '#', '.'},
                {'#', '#', '#', '-', 'b', '-', '#', '.'},
                {'#', '-', '#', '#', 'b', '-', '#', '.'},
                {'#', '-', '#', '-', '-', '-', '#', '#'},
                {'#', 'b', '-', 'b', 'b', 'b', '-', '#'},
                {'#', '-', '-', '-', '-', '-', '-', '#'},
                {'#', '#', '#', '#', '#', '#', '#', '#'}};

        layers.add(layer2);
        layers.add(layer1);

        MapLoader mapLoader = new MapLoader();
        Board board = mapLoader.createModelBoard(layers);
        BoardGraphicView boardView = new BoardGraphicView();
        BoardController controller = new BoardController(board, boardView, new KeyBoardHandler(), new SokobanWinHandler());

        GameLevel level = new GameLevel(controller);
        return level;
    }

    public static void main(String[] args) {

        GameLevel level1 = createLevel1();
        GameLevel level2 = createLevel2();
        TileGame tileGame = new TileGame();
        //tileGame.addLevel(level1);
        tileGame.addLevel(level2);

        tileGame.run();

    }

}
