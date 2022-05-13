package Components;

import javax.swing.*;
import java.awt.*;

public abstract class GameComponent {

    protected Point position;

    public GameComponent() {}

    public GameComponent(Point position) {
        this.position = position;
    }

}
