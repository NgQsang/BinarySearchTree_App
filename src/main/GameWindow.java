package main;

import javax.swing.JFrame;

public class GameWindow {
    public static void main(String[] args) {
        // define the attributes for the window
        int boardWidth = 800;
        int boardHeight = 800;

        JFrame frame = new JFrame("Snake Game"); // create a new window
        frame.setVisible(true); // make the frame visible
        frame.setSize(boardWidth, boardHeight); // set the size of the frame
        frame.setLocationRelativeTo(null); // set the window at the center of the screen
        frame.setResizable(false); // make the window non-resizable
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // terminate the program when the window is closed
}
}
