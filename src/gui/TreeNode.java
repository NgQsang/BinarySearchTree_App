package gui;

import java.awt.*;

public class TreeNode {

    private static final int DIAMETER = 30;
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
