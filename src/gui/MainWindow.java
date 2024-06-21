package gui;

import bst.BinarySearchTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        JButton printTreeButton = new JButton("Print Tree");

        buttonPanel.add(insertButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(inOrderButton);
        buttonPanel.add(preOrderButton);
        buttonPanel.add(postOrderButton);
        buttonPanel.add(minButton);
        buttonPanel.add(maxButton);
        buttonPanel.add(printTreeButton);

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
                Integer minValue = bst.findMinValue();
                if (minValue != null) {
                    JOptionPane.showMessageDialog(null, "Smallest Node:\n" + minValue);
                } else {
                    JOptionPane.showMessageDialog(null, "Tree is empty.");
                }
            }
        });

        maxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer maxValue = bst.findMaxValue();
                if (maxValue != null) {
                    JOptionPane.showMessageDialog(null, "Largest Node:\n" + maxValue);
                } else {
                    JOptionPane.showMessageDialog(null, "Tree is empty.");
                }
            }
        });

        printTreeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Tree Structure:\n" + bst.printTree());
            }
        });

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Additional modifications:
        pack(); // Adjusts the size of the JFrame to fit its contents
        setLocationRelativeTo(null); // Centers the JFrame on the screen
        setVisible(true); // Set the JFrame to be visible
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
