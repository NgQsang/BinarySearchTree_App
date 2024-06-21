package gui;

import bst.BinarySearchTree;
import bst.Node;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class DrawingPanel extends JPanel {

    private BinarySearchTree bst;
    private Map<Integer, TreeNode> nodes;

    public DrawingPanel(BinarySearchTree bst) {
        this.bst = bst;
        this.nodes = new HashMap<>();
        setPreferredSize(new Dimension(800, 600)); // Set panel size as needed
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Node root = bst.getRoot();
        if (root != null) {
            // Clear previous nodes and lines
            nodes.clear();

            // Draw the tree recursively starting from the root
            int startX = getWidth() / 2;
            int startY = 50;
            drawTree(g, root, startX, startY);
        }
    }

    private void drawTree(Graphics g, Node root, int x, int y) {
        if (root != null) {
            // Draw current node
            TreeNode treeNode = new TreeNode(root.getData(), x, y);
            nodes.put(root.getData(), treeNode);
            treeNode.draw(g);

            // Set edge color to black
            g.setColor(Color.BLACK);

            // Recursively draw left and right children
            if (root.getLeft() != null) {
                int leftX = x - 100; // Adjust x position for left child
                int leftY = y + 100; // Adjust y position for left child
                drawTree(g, root.getLeft(), leftX, leftY);

                // Draw line to left child
                g.drawLine(x, y, leftX, leftY);
            }
            if (root.getRight() != null) {
                int rightX = x + 100; // Adjust x position for right child
                int rightY = y + 100; // Adjust y position for right child
                drawTree(g, root.getRight(), rightX, rightY);

                // Draw line to right child
                g.drawLine(x, y, rightX, rightY);
            }
        }
    }
}