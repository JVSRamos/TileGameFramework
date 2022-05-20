package Views.text;

import javax.swing.*;
import java.awt.*;
import Views.GameModelView;

public abstract class GameModelTextView extends JComponent implements GameModelView {

    protected char symbol;

    public GameModelTextView(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void showView() {}
}
