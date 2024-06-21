package main;

import java.util.*;
import bst.BinarySearchTree;

public class Program {
    private static List<Integer> insertedValues = new ArrayList<>();

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\033[H\033[2J"); // Clear console
            System.out.flush();

            System.out.println("Create A BST:");
            System.out.println("1. Manually Insert Nodes");
            System.out.println("2. Remove Node(s)");
            System.out.println("3. Display Manual Tree");
            System.out.println("4. Generate a Random Tree");
            System.out.println("5. Exit");
            System.out.print("\nChoose 1, 2, 3, 4 or 5: ");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
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

                            System.out.print("\nInsert another? (y/n): ");
                            String response = scanner.nextLine();
                            continueInserting = response.equalsIgnoreCase("y") || response.equalsIgnoreCase("Yes");
                        }
                        break;
                    case 2:
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

                            System.out.print("\nRemove another? (y/n): ");
                            String response = scanner.nextLine();
                            continueRemoving = response.equalsIgnoreCase("y") || response.equalsIgnoreCase("Yes");
                        }
                        break;
                    case 3:
                        System.out.println("\nNode Values in the order that they were inserted:");
                        listTreeValues();

                        System.out.println("\nIn-Order Traversal of the BST:");
                        bst.inOrderTraversal();
                        System.out.println();

                        System.out.println("\nTree Structure:");
                        bst.printTree();
                        break;
                    case 4:
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
                                System.out.print("\nMy PC is a BEAST (y) / Never Mind (n): ");
                                String response = scanner.nextLine();
                                printExcessive = response.equalsIgnoreCase("y") || response.equalsIgnoreCase("Yes");

                                if (printExcessive) {
                                    System.out.println("\nNode Values in the order that they were inserted:");
                                    listTreeValues();
                                }
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a valid integer.");
                            scanner.next(); // Consume invalid input
                        }
                        break;
                    case 5:
                        System.out.println("\nExiting the Program.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please enter a valid option (1, 2, 3, or 4).");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid option (1, 2, 3, or 4).");
                scanner.next(); // Consume invalid input
            }

            System.out.println();
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
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
