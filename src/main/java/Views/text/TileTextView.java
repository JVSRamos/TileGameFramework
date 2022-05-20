package Views.text;

import Views.GameModelView;

public class TileTextView extends GameModelTextView {

    public TileTextView(char symbol) {
        super(symbol);
    }
    @Override
    public void showView() {
        System.out.print(this.symbol);
    }
}
