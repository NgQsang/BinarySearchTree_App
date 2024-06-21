package gui;

/**
 * Name: NGUYEN QUANG SANG
 * Student ID: ITDSIU21113
 * Team Member: 1 - individual 
 * Short description of the program/exercise:
 * This class represents the main window of a Binary Search Tree (BST) visualization application.
 * It provides a graphical user interface (GUI) using Swing components to interact with a BST,
 * allowing users to insert and remove nodes, perform traversals, find minimum and maximum nodes,
 * generate random BSTs, find specific nodes, and exit the application. The visualization of the BST
 * is displayed using a DrawingPanel, where nodes are drawn and can be highlighted based on user actions.
 */

import bst.BinarySearchTree;
import bst.Node;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainWindow extends JFrame {

    private BinarySearchTree bst;
    private DrawingPanel drawingPanel;

    public MainWindow() {
        super("Binary Search Tree Visualization");
        bst = new BinarySearchTree();
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        JPanel buttonPanel = new JPanel();
        JButton insertButton = new JButton("Insert Node");
        JButton removeButton = new JButton("Remove Node");
        JButton inOrderButton = new JButton("In-Order Traversal");
        JButton preOrderButton = new JButton("Pre-Order Traversal");
        JButton postOrderButton = new JButton("Post-Order Traversal");
        JButton minButton = new JButton("Find Smallest Node");
        JButton maxButton = new JButton("Find Largest Node");
        JButton generateButton = new JButton("Generate Random BST");
        JButton findNodeButton = new JButton("Find Node");
        JButton exitButton = new JButton("Exit");

        buttonPanel.add(insertButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(inOrderButton);
        buttonPanel.add(preOrderButton);
        buttonPanel.add(postOrderButton);
        buttonPanel.add(minButton);
        buttonPanel.add(maxButton);
        buttonPanel.add(generateButton);
        buttonPanel.add(findNodeButton);
        buttonPanel.add(exitButton);

        drawingPanel = new DrawingPanel(bst);
        JScrollPane scrollPane = new JScrollPane(drawingPanel);

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter value to insert:");
                try {
                    int value = Integer.parseInt(input);
                    bst.insert(value);
                    drawingPanel.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter value to remove:");
                try {
                    int value = Integer.parseInt(input);
                    bst.remove(value);
                    drawingPanel.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
                }
            }
        });

        inOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "In-Order Traversal:\n" + bst.inOrderTraversal());
            }
        });

        preOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Pre-Order Traversal:\n" + bst.preOrderTraversal());
            }
        });

        postOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Post-Order Traversal:\n" + bst.postOrderTraversal());
            }
        });

        minButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Node minNode = bst.findMinNode();
                if (minNode != null) {
                    drawingPanel.highlightNode(minNode);
                } else {
                    JOptionPane.showMessageDialog(null, "Tree is empty.");
                }
            }
        });

        maxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Node maxNode = bst.findMaxNode();
                if (maxNode != null) {
                    drawingPanel.highlightNode(maxNode);
                } else {
                    JOptionPane.showMessageDialog(null, "Tree is empty.");
                }
            }
        });

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateRandomBinarySearchTree();
            }
        });

        findNodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter the value to find:");
                try {
                    int value = Integer.parseInt(input);
                    Node foundNode = bst.search(value);
                    if (foundNode != null) {
                        drawingPanel.highlightNode(foundNode);
                    } else {
                        JOptionPane.showMessageDialog(null, "Value " + value + " does not exist in the tree.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer.");
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

     private void generateRandomBinarySearchTree() {
        bst.clear(); // Clear existing tree

        Random rand = new Random();
        int nodeCount = rand.nextInt(10) + 1; // Random node count between 1 and 10

        for (int i = 0; i < nodeCount; i++) {
            int value = rand.nextInt(100) + 1; // Random value between 1 and 100
            bst.insert(value); // Insert into BST
        }

        drawingPanel.repaint(); // Redraw the tree

        JOptionPane.showMessageDialog(null, "Random Binary Search Tree Generated with " + nodeCount + " nodes.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }
}
