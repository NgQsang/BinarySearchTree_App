package main;

import bst.BinarySearchTree;

import java.util.*;

public class Program {
    private static List<Integer> insertedValues = new ArrayList<>();

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\033[H\033[2J"); // Clear console
            System.out.flush();

            System.out.println("MAIN MENU");
            System.out.println("1. Manually Insert Nodes");
            System.out.println("2. Remove Node(s)");
            System.out.println("3. Display Manual Tree");
            System.out.println("4. Generate a Random Binary Tree");
            System.out.println("5. Display Tree Traversal");
            System.out.println("6. Find a Node value");
            System.out.println("7. Find a Smallest Node");
            System.out.println("8. Find a Largest Node");
            System.out.println("9. Exit");
            System.out.print("\nPlease choose an option between 1 and 9: ");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        manuallyInsertNodes(bst, scanner);
                        break;
                    case 2:
                        removeNodes(bst, scanner);
                        break;
                    case 3:
                        displayManualTree(bst);
                        break;
                    case 4:
                        generateRandomTree(bst, scanner);
                        break;
                    case 5:
                        displayTreeTraversal(bst, scanner);
                        break;
                    case 6:
                        findNodeValue(bst, scanner);
                        break;
                    case 7:
                        findSmallestNode(bst);
                        break;
                    case 8:
                        findLargestNode(bst);
                        break;
                    case 9:
                        System.out.println("\nExiting the Program.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please enter a valid option between 1 and 9.");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid option between 1 and 9.");
                scanner.next(); // Consume invalid input
            }

            System.out.println();
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
        }
    }

    private static void manuallyInsertNodes(BinarySearchTree bst, Scanner scanner) {
        boolean continueInserting = true;
        while (continueInserting) {
            System.out.print("\nEnter a value to insert: ");
            if (scanner.hasNextInt()) {
                int valueToInsert = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                bst.insert(valueToInsert);
                trackInsertedValues(valueToInsert);

                System.out.println("\nValue " + valueToInsert + " has been inserted into the tree.");

                System.out.println("\nCurrent Tree Values:");
                listTreeValues();
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume invalid input
            }

            System.out.print("\nInsert another? (Y/N): ");
            String response = scanner.nextLine();
            continueInserting = response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("Yes");
        }
    }

    private static void removeNodes(BinarySearchTree bst, Scanner scanner) {
        boolean continueRemoving = true;
        while (continueRemoving) {
            System.out.println("Current Tree Values:");
            listTreeValues();

            System.out.print("\nEnter a value to remove: ");
            if (scanner.hasNextInt()) {
                int valueToRemove = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                bst.remove(valueToRemove);
                trackRemovedValues(valueToRemove);

                System.out.println("\nCurrent Tree Values:");
                listTreeValues();
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume invalid input
            }

            System.out.print("\nRemove another? (Y/N): ");
            String response = scanner.nextLine();
            continueRemoving = response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("Yes");
        }
    }

    private static void displayManualTree(BinarySearchTree bst) {
        System.out.println("\nNode Values in the order that they were inserted:");
        listTreeValues();

        System.out.println("\nIn-Order Traversal of the BST:");
        bst.inOrderTraversal();
        System.out.println();

        System.out.println("\nTree Structure:");
        bst.printTree();
    }

    private static void generateRandomTree(BinarySearchTree bst, Scanner scanner) {
        System.out.print("\nEnter the number of nodes to generate: ");
        if (scanner.hasNextInt()) {
            int nodeCount = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            boolean printExcessive = false;
            Random rand = new Random();
            Set<Integer> existingValues = new HashSet<>();
            int rangeMax = nodeCount * 2; // Ensuring the range is twice the node count

            while (existingValues.size() < nodeCount) {
                int newValue = rand.nextInt(rangeMax) + 1; // Adjust the range here
                if (existingValues.add(newValue)) { // Ensures only unique values are added
                    bst.insert(newValue);
                    trackInsertedValues(newValue); // Assuming you want to track these as well
                }
            }

            System.out.println("\nRandom Tree Generated with Unique Values:");
            if (nodeCount <= 50) {
                System.out.println("\nNode Values in the order that they were inserted:");
                listTreeValues();

                System.out.println("\nIn-Order Traversal of the BST:");
                bst.inOrderTraversal();
                System.out.println();

                bst.printTree();
            } else {
                System.out.println("\n**Excessive Node Count(" + nodeCount + ") Detected**");
                System.out.println("\nWould you like to print the values anyway? (May impact PC performance).");
                System.out.print("\nMy PC is a BEAST (Y) / Never Mind (N): ");
                String response = scanner.nextLine();
                printExcessive = response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("Yes");

                if (printExcessive) {
                    System.out.println("\nNode Values in the order that they were inserted:");
                    listTreeValues();
                }
            }
        } else {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next(); // Consume invalid input
        }
    }

    private static void displayTreeTraversal(BinarySearchTree bst, Scanner scanner) {
        System.out.println("TRAVERSAL METHODS:");
        System.out.println("1. In Order Traversal");
        System.out.println("2. Pre Order Traversal");
        System.out.println("3. Post Order Traversal");
        System.out.print("\nPlease choose 1, 2 or 3: ");

        int traversalChoice;
        if (scanner.hasNextInt()) {
            traversalChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (traversalChoice) {
                case 1:
                    System.out.println("\nIn Order Traversal (Left -> Root -> Right):");
                    bst.inOrderTraversal();
                    break;
                case 2:
                    System.out.println("\nPre Order Traversal (Root -> Left -> Right):");
                    bst.preOrderTraversal();
                    break;
                case 3:
                    System.out.println("\nPost Order Traversal (Left -> Right -> Root):");
                    bst.postOrderTraversal();
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1, 2 or 3.");
                    break;
            }
            System.out.println();
        } else {
            System.out.println("Invalid input. Please choose 1, 2 or 3.");
            scanner.next(); // Consume invalid input
        }
    }

    private static void findNodeValue(BinarySearchTree bst, Scanner scanner) {
        System.out.print("\nEnter the value to find: ");
        if (scanner.hasNextInt()) {
            int valueToFind = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            boolean found = bst.contains(valueToFind);
            if (found) {
                System.out.println("\nValue " + valueToFind + " exists in the tree.");
            } else {
                System.out.println("\nValue " + valueToFind + " does not exist in the tree.");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next(); // Consume invalid input
        }
    }

    private static void findSmallestNode(BinarySearchTree bst) {
        Integer minValue = bst.findMinValue();
        if (minValue != null) {
            System.out.println("\nThe smallest value in the tree is: " + minValue);
        } else {
            System.out.println("\nThe tree is empty.");
        }
    }

    private static void findLargestNode(BinarySearchTree bst) {
        Integer maxValue = bst.findMaxValue();
        if (maxValue != null) {
            System.out.println("\nThe largest value in the tree is: " + maxValue);
        } else {
            System.out.println("\nThe tree is empty.");
        }
    }

    private static void trackRemovedValues(int newValue) {
        if (insertedValues.remove(Integer.valueOf(newValue))) {
            System.out.println("\nNode: " + newValue + " has been removed from the tree.");
        } else {
            System.out.println("\nSpecified value does not exist in the current tree.");
        }
    }

    private static void listTreeValues() {
        for (int value : insertedValues) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private static void trackInsertedValues(int newValue) {
        if (!insertedValues.contains(newValue)) {
            insertedValues.add(newValue);
        }
    }
}
