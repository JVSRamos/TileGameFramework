package Views.text;
import Views.GameModelView;
import Views.graphics.LayerGraphicView;
import Views.graphics.TileGraphicView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class BoardTextView implements GameModelView {
	
	List<LayerTextView> layers;
	
    public BoardTextView(ArrayList<LayerTextView> layers2) {
        this.layers = layers2;
    }

    @Override
    public void showView() {
        for(LayerTextView layer : layers){
            layer.showView();
        }
    }

    public static void main(String[] args) {
    	LayerTextView layer = new LayerTextView(5,5);

        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                TileTextView tile = new TileTextView('0');
                layer.addComponentToCell(i, j, tile);
            }
        }

        ArrayList<LayerTextView> layers = new ArrayList<>();
        layers.add(layer);

        LayerTextView layer2 = new LayerTextView(5,5);

        for(int i = 2; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
            	TileTextView tile = new TileTextView('*');
            	layer.addComponentToCell(i, j, tile);
            }
        }

        layers.add(layer2);

        BoardTextView board = new BoardTextView(layers);
        board.showView();
    }

}