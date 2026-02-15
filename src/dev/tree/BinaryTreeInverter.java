package dev.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeInverter {

    /**
     * Inverts a binary tree (swaps left and right children of every node).
     * This is a recursive approach.
     *
     * @param root The root of the binary tree to invert.
     * @return The root of the inverted binary tree.
     */
    public TreeNode invertTree(TreeNode root) {
        // Base case: if the node is null, there's nothing to do.
        if (root == null) {
            return null;
        }

        // Recursively invert the left and right subtrees
        TreeNode leftInverted = invertTree(root.left);
        TreeNode rightInverted = invertTree(root.right);

        // Swap the left and right children of the current node
        root.left = rightInverted;
        root.right = leftInverted;

        // Return the current node (which is now the root of the inverted subtree)
        return root;
    }

    // --- Helper methods for testing ---

    /**
     * Inserts a value into a Binary Search Tree (for building a test tree).
     * Note: This method builds a BST, but the invertTree method works for any binary tree.
     *
     * @param root The current root of the BST.
     * @param val The value to insert.
     * @return The updated root of the BST.
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else if (val > root.val) { // Handle values greater than current node
            root.right = insertIntoBST(root.right, val);
        }
        // If val == root.val, we typically do nothing or handle duplicates based on requirements.
        return root;
    }

    /**
     * Prints the tree using Pre-order traversal (Root, Left, Right).
     * Useful for visualizing the structure.
     *
     * @param node The current node to print.
     */
    public void printPreOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    /**
     * Prints the tree using Level-order traversal (BFS).
     * Useful for visualizing the tree level by level.
     *
     * @param root The root of the tree to print.
     */
    public void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    System.out.print(node.val + " ");
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    System.out.print("null "); // Represent null children for clarity
                }
            }
            System.out.println(); // New line for each level
        }
    }


    public static void main(String[] args) {
        BinaryTreeInverter inverter = new BinaryTreeInverter();
        TreeNode root = null;

        // Build a sample Binary Search Tree
        // Original Tree Structure:
        //        4
        //       / \
        //      2   7
        //     / \ / \
        //    1  3 6  9
        root = inverter.insertIntoBST(root, 4);
        root = inverter.insertIntoBST(root, 2);
        root = inverter.insertIntoBST(root, 7);
        root = inverter.insertIntoBST(root, 1);
        root = inverter.insertIntoBST(root, 3);
        root = inverter.insertIntoBST(root, 6);
        root = inverter.insertIntoBST(root, 9);

        System.out.println("--- Original Tree ---");
        System.out.print("Pre-order: ");
        inverter.printPreOrder(root); // Expected: 4 2 1 3 7 6 9
        System.out.println("\nLevel-order:");
        inverter.printLevelOrder(root);
        System.out.println("\n---------------------\n");

        // Invert the tree
        TreeNode invertedRoot = inverter.invertTree(root);

        System.out.println("--- Inverted Tree ---");
        System.out.print("Pre-order: ");
        inverter.printPreOrder(invertedRoot); // Expected: 4 7 9 6 2 3 1
        System.out.println("\nLevel-order:");
        inverter.printLevelOrder(invertedRoot);
        System.out.println("\n---------------------\n");

        // Inverted Tree Structure:
        //        4
        //       / \
        //      7   2
        //     / \ / \
        //    9  6 3  1
    }
}