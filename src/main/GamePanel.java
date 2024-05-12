package main;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; // storing segments of the snake body
import java.util.Random; // random x and y coordinates for the food
import javax.swing.*;
import main.SnakeGame; // Add this import statement
import static main.SnakeGame.GAME_HEIGHT;
import static main.SnakeGame.GAME_WIDTH;

public class GamePanel extends JPanel {
    private SnakeGame game;

    // Constructor
    public GamePanel(SnakeGame game) {
        this.game = game;
        setPanelSize();
    }

    private void setPanelSize() {
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        this.setBackground(Color.WHITE);
    }
}
