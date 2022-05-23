import Controllers.BoardController;
import Input.KeyBoardHandler;
import Models.*;
import Models.Box;
import Views.BoardView;
import Views.graphics.BoardGraphicView;
import WinHandler.SokobanWinHandler;

import java.awt.*;
import java.awt.desktop.SystemSleepEvent;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.List;

public class MapLoader {
    Map<Character, Class> modelMap;
    private void initializeModelMap() {
        modelMap = new HashMap<>();
        modelMap.put('*', Flag.class);
        modelMap.put('#', Wall.class);
        modelMap.put('b', Box.class);
        modelMap.put('o', Player.class);
        modelMap.put('.', Floor.class);
        modelMap.put('-', EmptyTile.class);
    }

    public MapLoader() {
        initializeModelMap();
    }

    public GameLevel LoadLevelFromFile(String levelPath, BoardView boardView) {
        Board board;
        try {
            board = this.createModelBoard(levelPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        BoardController controller = new BoardController(board, boardView, new KeyBoardHandler(), new SokobanWinHandler());

        return new GameLevel(controller);

    }

    public Board createModelBoard(String mapPath) throws IOException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(mapPath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String curLine = reader.readLine();
        String[] numLayersStr = curLine.split(" ");

        int numLayers = Integer.parseInt(numLayersStr[0]);

        curLine = reader.readLine();
        String[] dimension = curLine.split(" ");

        int nrows = Integer.parseInt(dimension[0]);
        int ncols = Integer.parseInt(dimension[1]);

        List<Layer> modelLayers = new ArrayList<>();

        for(int i = 0; i < numLayers; i++) {
            Layer layer = new Layer(nrows, ncols);
            for(int j = 0; j < nrows; j++) {
                curLine = reader.readLine();
                String[] row = curLine.split(" ");
                for(int k = 0; k < ncols; k++) {
                    GameModel gameModel = getGameModelFromClass(modelMap.get(row[k].charAt(0)), new Point(j, k));
                    layer.addModelAtPos(j, k, gameModel);
                }
            }
            curLine = reader.readLine();
            modelLayers.add(layer);
        }

        return new Board(modelLayers);

    }

    public Board createModelBoard(List<char[][]> layers) {
        ArrayList<Layer> modelLayers = new ArrayList<>();

        for(char[][] layer : layers) {
            Layer modelLayer = new Layer(layer.length, layer[0].length);
            for(int i = 0; i < layer.length; i++) {
                for(int j = 0; j < layer[0].length; j++) {
                    GameModel gameModel = getGameModelFromClass(modelMap.get(layer[i][j]), new Point(i, j));
                    modelLayer.addModelAtPos(i, j, gameModel);
                }
            }
            modelLayers.add(modelLayer);
        }

        return new Board(modelLayers);
    }

    public GameModel getGameModelFromClass(Class cls, Point position) {
        Class parameterType[] = new Class[] { Point.class };
        Constructor constructor = null;
        try {
            constructor = cls.getConstructor(parameterType);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        GameModel gameModel = null;
        try {
            gameModel = (GameModel) constructor.newInstance(position);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return gameModel;
    }

}
