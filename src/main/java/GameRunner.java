import Controllers.BoardController;
import Input.KeyBoardHandler;
import Models.Board;
import Views.graphics.BoardGraphicView;
import Views.text.BoardTextView;
import WinHandler.SokobanWinHandler;

import java.io.IOException;
import java.util.ArrayList;

public class GameRunner {


    public static void main(String[] args) {
        MapLoader mapLoader = new MapLoader();
        GameLevel level1 = mapLoader.LoadLevelFromFile("src/main/resources/maps/map1", new BoardGraphicView());
        GameLevel level2 = mapLoader.LoadLevelFromFile("src/main/resources/maps/map2", new BoardTextView());
        TileGame tileGame = new TileGame();
        tileGame.addLevel(level1);
        tileGame.addLevel(level2);

        tileGame.run();
    }

}
