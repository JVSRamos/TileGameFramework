package Views.text;

import Models.*;
import Views.GameModelView;
import Views.graphics.*;

public class GameModelTextView implements GameModelView {

    protected char symbol;

    public char getSymbolFromModel(GameModel gameModel) {
        if(gameModel instanceof Box) {
            Box box = (Box) gameModel;
            if(box.isMarked()) return 'm';
            else return 'b';
        }
        else if(gameModel instanceof Player) return 'o';
        else if(gameModel instanceof Flag) return '*';
        else if(gameModel instanceof Floor) return '.';
        else if(gameModel instanceof Wall) return '#';
        else return '-';
    }

    public char getSymbol() {return symbol;}

    @Override
    public void showView(GameModel gameModel) {
        this.symbol = getSymbolFromModel(gameModel);
    }

}
