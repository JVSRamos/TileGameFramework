import Models.*;
import Models.Box;
import Views.graphics.*;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapLoader {
    Map<Character, Class> modelMap;
    Map<Character, Class> viewMap;

    Map<Character, String> iconPathMap;
    private void initializeModelMap() {
        modelMap = new HashMap<>();
        modelMap.put('*', Flag.class);
        modelMap.put('#', Wall.class);
        modelMap.put('b', Box.class);
        modelMap.put('o', Player.class);
        modelMap.put('.', Floor.class);
        modelMap.put('-', EmptyTile.class);
    }

    private void initializeIconPathMap() {
        iconPathMap = new HashMap<>();
        iconPathMap.put('*', "src/main/resources/sokoban_icons/blankmarked.png");
        iconPathMap.put('#', "src/main/resources/sokoban_icons/wall.png");
        iconPathMap.put('b', "src/main/resources/sokoban_icons/crate.png");
        iconPathMap.put('o', "src/main/resources/sokoban_icons/player.png");
        iconPathMap.put('.', "src/main/resources/sokoban_icons/blank.png");
    }

    private void initializeViewMap() {
        viewMap = new HashMap<>();
        viewMap.put('*', FlagGraphicView.class);
        viewMap.put('#', WallGraphicView.class);
        viewMap.put('b', BoxGraphicView.class);
        viewMap.put('o', PlayerGraphicView.class);
        viewMap.put('.', FloorGraphicView.class);
    }

    public MapLoader() {
        initializeModelMap();
        initializeViewMap();
        initializeIconPathMap();
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

    public GameModelGraphicView getGameViewFromClass(Class cls) {
        Constructor constructor = null;
        try {
            constructor = cls.getConstructor(null);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        GameModelGraphicView gameView = null;
        try {
            gameView = (GameModelGraphicView) constructor.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return gameView;
    }

    public BoardGraphicView createGraphicViewBoard(List<char[][]> layers) {
        ArrayList<LayerGraphicView> viewLayers = new ArrayList<>();

        for(char[][] layer : layers) {
            LayerGraphicView viewLayer = new LayerGraphicView(layer.length, layer[0].length);
            for(int i = 0; i < layer.length; i++) {
                for(int j = 0; j < layer[0].length; j++) {
                    if(layer[i][j] != '-') {
                        GameModelGraphicView gameView = getGameViewFromClass(viewMap.get(layer[i][j]));
                        viewLayer.addTileToCell(i, j, gameView);
                    }
                }
            }
            viewLayers.add(viewLayer);
        }

        return new BoardGraphicView();
    }

}
