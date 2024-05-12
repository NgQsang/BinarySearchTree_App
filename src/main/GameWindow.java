package main;

import javax.swing.JFrame;

public class GameWindow {
    private JFrame jframe;

    public GameWindow(GamePanel gamePanel) {

        jframe = new JFrame("Snake Game"); // create a new window

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // terminate the program when the window is closed
        jframe.add(gamePanel);
        jframe.setResizable(false); // make the window non-resizable
        jframe.pack(); // set the window to the preferred size
        jframe.setLocationRelativeTo(null); // set the window at the center of the screen
        jframe.setVisible(true); // make the frame visible
    }
}
