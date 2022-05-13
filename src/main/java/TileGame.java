import java.util.ArrayList;

public class TileGame {

    ArrayList<GameLevel> levels;

    public TileGame() {
        levels = new ArrayList<GameLevel>();
    }

    public void addLevel(GameLevel level) {
        levels.add(level);
    }

    public void run() {

        for(GameLevel level : levels) {
            level.run();
        }

    }


}
