package bst;

/**
 * Name: NGUYEN QUANG SANG
 * Student ID: ITDSIU21113
 * Team Member: 1 - individual 
 * Short description of the program/exercise:
 * This class represents a node in a Binary Search Tree (BST).
 * Each node contains an integer value (data) and references to its
 * left and right child nodes. It provides methods to get and set
 * the data value, as well as access and modify the left and right
 * child nodes.
*/

public class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}