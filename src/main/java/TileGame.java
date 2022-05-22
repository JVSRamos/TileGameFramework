import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class TileGame {

    List<GameLevel> levels;
    public TileGame() {
        levels = new ArrayList<GameLevel>();
    }

    public TileGame(List<GameLevel> levels) {
        this.levels = new ArrayList<GameLevel>();
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
