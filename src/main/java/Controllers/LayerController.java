package Controllers;

import Models.Layer;
import Views.GameModelView;
import Views.LayerView;

import java.util.ArrayList;
import java.util.List;

public class LayerController {

    Layer layer;
    LayerView layerView;

    public LayerController(Layer layer, LayerView layerView) {
        this.layerView = layerView;
        this.layer = layer;
    }

}
