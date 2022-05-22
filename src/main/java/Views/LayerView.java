package Views;

import Models.GameModel;
import Models.Layer;

public abstract class LayerView {

    protected GameModelView[][] layer;

    public abstract void showLayer(Layer layer);

}
