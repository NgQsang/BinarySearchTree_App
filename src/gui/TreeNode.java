package gui;

import java.awt.*;

public class TreeNode {

    private static final int DIAMETER = 30;
    private int data;
    private int x, y;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data, int x, int y) {
        this.data = data;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(x - DIAMETER / 2, y - DIAMETER / 2, DIAMETER, DIAMETER);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(data), x - 5, y + 5);

        if (leftChild != null) {
            drawLine(g, leftChild);
            leftChild.draw(g);
        }
        if (rightChild != null) {
            drawLine(g, rightChild);
            rightChild.draw(g);
        }
    }

    private void drawLine(Graphics g, TreeNode child) {
        g.setColor(Color.BLACK);
        g.drawLine(x, y, child.x, child.y);
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}