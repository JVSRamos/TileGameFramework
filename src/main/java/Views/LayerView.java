package Views;

import Models.Layer;

public abstract class LayerView {

    protected GameModelView[][] layer;

    public abstract void showLayer(Layer layer);

}
