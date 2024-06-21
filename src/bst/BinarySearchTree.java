package bst;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
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

        if (data < root.getData()) {
            root.setLeft(insertRec(root.getLeft(), data));
        } else if (data > root.getData()) {
            root.setRight(insertRec(root.getRight(), data));
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

        if (data < root.getData()) {
            root.setLeft(removeRec(root.getLeft(), data));
        } else if (data > root.getData()) {
            root.setRight(removeRec(root.getRight(), data));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }

            root.setData(minValue(root.getRight()));
            root.setRight(removeRec(root.getRight(), root.getData()));
        }

        return root;
    }

    private int minValue(Node root) {
        int minValue = root.getData();
        while (root.getLeft() != null) {
            root = root.getLeft();
            minValue = root.getData();
        }
        return minValue;
    }

    private int maxValue(Node root) {
        int maxValue = root.getData();
        while (root.getRight() != null) {
            root = root.getRight();
            maxValue = root.getData();
        }
        return maxValue;
    }

    public boolean contains(int data) {
        return contains(root, data);
    }

    private boolean contains(Node root, int data) {
        if (root == null) {
            return false;
        }

        if (data == root.getData()) {
            return true;
        }

        if (data < root.getData()) {
            return contains(root.getLeft(), data);
        } else {
            return contains(root.getRight(), data);
        }
    }

    public String inOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        inOrderTraversal(root, sb);
        return sb.toString();
    }

    private void inOrderTraversal(Node root, StringBuilder sb) {
        if (root != null) {
            inOrderTraversal(root.getLeft(), sb);
            sb.append(root.getData()).append(" ");
            inOrderTraversal(root.getRight(), sb);
        }
    }

    public String preOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        preOrderTraversal(root, sb);
        return sb.toString();
    }

    private void preOrderTraversal(Node root, StringBuilder sb) {
        if (root != null) {
            sb.append(root.getData()).append(" ");
            preOrderTraversal(root.getLeft(), sb);
            preOrderTraversal(root.getRight(), sb);
        }
    }

    public String postOrderTraversal() {
        StringBuilder sb = new StringBuilder();
        postOrderTraversal(root, sb);
        return sb.toString();
    }

    private void postOrderTraversal(Node root, StringBuilder sb) {
        if (root != null) {
            postOrderTraversal(root.getLeft(), sb);
            postOrderTraversal(root.getRight(), sb);
            sb.append(root.getData()).append(" ");
        }
    }

    public Integer findMinValue() {
        if (root == null) {
            return null;
        }
        return minValue(root);
    }

    public Integer findMaxValue() {
        if (root == null) {
            return null;
        }
        return maxValue(root);
    }

    public String printTree() {
        StringBuilder sb = new StringBuilder();
        printTree(root, 0, sb);
        return sb.toString();
    }

    private void printTree(Node root, int level, StringBuilder sb) {
        if (root != null) {
            printTree(root.getRight(), level + 1, sb);
            sb.append("   ".repeat(level)).append(root.getData()).append("\n");
            printTree(root.getLeft(), level + 1, sb);
        }
    }
}