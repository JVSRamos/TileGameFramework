import Controllers.BoardController;

public class GameLevel {

    private GameState gameState;

    public GameLevel(BoardController controller) {
        this.gameState = new GameState(controller);
    }

    public void run() {
        gameState.run();
    }


}
