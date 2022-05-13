package Views.graphics;

import javax.swing.*;

public abstract class GameComponentGraphicView extends JComponent {

    protected JComponent icon;

    public GameComponentGraphicView(JComponent icon) {
        this.icon = icon;
    }

}
