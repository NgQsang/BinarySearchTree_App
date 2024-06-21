// BinarySearchTree.java
package bst;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        if (!contains(root, data)) {
            root = insertRec(root, data);
        } else {
            System.out.println("\nValue " + data + " already exists in the tree. Duplicates are not allowed.");
        }
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public void remove(int data) {
        root = removeRec(root, data);
    }

    private Node removeRec(Node root, int data) {
        if (root == null) {
            return root;
        }

        if (data < root.data) {
            root.left = removeRec(root.left, data);
        } else if (data > root.data) {
            root.right = removeRec(root.right, data);
        } else {
            // Node with one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children
            root.data = minValue(root.right);

            // Delete the in-order successor
            root.right = removeRec(root.right, root.data);
        }

        return root;
    }

    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    private boolean contains(Node root, int data) {
        if (root == null) {
            return false;
        }

        if (data == root.data) {
            return true;
        }

        if (data < root.data) {
            return contains(root.left, data);
        } else {
            return contains(root.right, data);
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(Node root, int level) {
        if (root != null) {
            printTree(root.right, level + 1);
            System.out.println("   ".repeat(level) + root.data);
            printTree(root.left, level + 1);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("In-order traversal of the given tree");
        bst.inOrderTraversal();

        System.out.println("\n\nTree after removing 20");
        bst.remove(20);
        bst.inOrderTraversal();

        System.out.println("\n\nTree after removing 30");
        bst.remove(30);
        bst.inOrderTraversal();

        System.out.println("\n\nTree after removing 50");
        bst.remove(50);
        bst.inOrderTraversal();
    }
}
