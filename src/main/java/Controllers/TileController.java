package Controllers;

import Components.Tile;
import Views.ComponentView;

public class TileController {

    Tile tile;
    ComponentView tileView;

    void updateView() {
        tileView.showComponent();
    }

}
