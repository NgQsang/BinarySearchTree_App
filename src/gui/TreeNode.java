package gui;

/**
 * Name: NGUYEN QUANG SANG
 * Student ID: ITDSIU21113
 * Team Member: 1 - individual 
 * Short description of the program/exercise:
 * This class represents a graphical node in the visualization of a Binary Search Tree (BST).
 * Each TreeNode object encapsulates data, coordinates for drawing on a graphical interface,
 * and a state indicating whether it is highlighted. It provides methods to draw itself using
 * Java's Graphics class, allowing for visual representation of BST nodes with optional highlighting.
 */

import java.awt.*;

public class TreeNode {

    private static final int DIAMETER = 50;
    private int data;
    private int x, y;
    private boolean highlighted;

    public TreeNode(int data, int x, int y) {
        this.data = data;
        this.x = x;
        this.y = y;
        this.highlighted = false;
    }

    public void draw(Graphics g) {
        if (highlighted) {
            g.setColor(Color.GREEN);
        } else {
            g.setColor(Color.BLACK);
        }
        g.fillOval(x - DIAMETER / 2, y - DIAMETER / 2, DIAMETER, DIAMETER);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(data), x - 5, y + 5);
    }

    public int getData() {
        return data;
    }

    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
    }

    public boolean isHighlighted() {
        return highlighted;
    }
}
