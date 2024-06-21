package gui;

/**
 * Name: NGUYEN QUANG SANG
 * Student ID: ITDSIU21113
 * Team Member: 1 - individual 
 * Short description of the program/exercise:
 * This class represents a panel for drawing a Binary Search Tree (BST).
 * It extends JPanel and provides functionality to visually represent
 * the BST structure using graphics. Nodes of the BST are represented as
 * TreeNode objects, and the panel supports highlighting a specific node
 * based on user interaction or program logic.
 */

import bst.BinarySearchTree;
import bst.Node;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class DrawingPanel extends JPanel {

    private BinarySearchTree bst;
    private Map<Integer, TreeNode> nodes;
    private TreeNode highlightedNode;

    public DrawingPanel(BinarySearchTree bst) {
        this.bst = bst;
        this.nodes = new HashMap<>();
        this.highlightedNode = null;
        setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Node root = bst.getRoot();
        if (root != null) {
            nodes.clear();
            int startX = getWidth() / 2;
            int startY = 50;
            drawTree(g, root, startX, startY);
        }
    }

    private void drawTree(Graphics g, Node root, int x, int y) {
        if (root != null) {
            TreeNode treeNode = new TreeNode(root.getData(), x, y);
            nodes.put(root.getData(), treeNode);

            if (highlightedNode != null && root.getData() == highlightedNode.getData()) {
                treeNode.setHighlighted(true);
            } else {
                treeNode.setHighlighted(false);
            }

            treeNode.draw(g);

            g.setColor(Color.BLACK);
            if (root.getLeft() != null) {
                int leftX = x - 100;
                int leftY = y + 100;
                drawTree(g, root.getLeft(), leftX, leftY);
                g.drawLine(x, y, leftX, leftY);
            }
            if (root.getRight() != null) {
                int rightX = x + 100;
                int rightY = y + 100;
                drawTree(g, root.getRight(), rightX, rightY);
                g.drawLine(x, y, rightX, rightY);
            }
        }
    }

    public void highlightNode(Node node) {
        if (highlightedNode != null) {
            highlightedNode.setHighlighted(false);
        }
        if (node != null) {
            highlightedNode = nodes.get(node.getData());
            if (highlightedNode != null) {
                highlightedNode.setHighlighted(true);
            }
        }
        repaint();
    }
}