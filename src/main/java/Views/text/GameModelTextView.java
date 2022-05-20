package Views.text;

import Views.GameModelView;

public abstract class GameModelTextView implements GameModelView {

    protected char symbol;

    public GameModelTextView(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void showView() {

    }
}
