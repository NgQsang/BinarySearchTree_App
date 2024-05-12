package main;

public class SnakeGame implements Runnable{
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;

    public final static int GAME_HEIGHT= 800;
    public final static int  GAME_WIDTH = 800;

    public SnakeGame() {
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        startGameLoop();

    }
    
    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        
    }
}
