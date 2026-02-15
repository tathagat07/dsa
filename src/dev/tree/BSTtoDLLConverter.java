package dev.tree;

// Definition for a Binary Search Tree node, which will also serve as a Doubly Linked List node.
class TreeNode {
    int val;
    TreeNode left;  // In DLL, this will be the 'prev' pointer
    TreeNode right; // In DLL, this will be the 'next' pointer

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BSTtoDLLConverter {

    // These instance variables will keep track of the head of the DLL
    // and the previously visited node during in-order traversal.
    private TreeNode head; // Head of the resulting Doubly Linked List
    private TreeNode prev; // Previously visited node during in-order traversal

    /**
     * Converts a Binary Search Tree to a Doubly Linked List.
     * The 'left' pointer of TreeNode is used as 'prev' and 'right' as 'next'.
     *
     * @param root The root of the BST.
     * @return The head of the converted Doubly Linked List.
     */
    public TreeNode convertToDLL(TreeNode root) {
        // Reset head and prev for a new conversion
        head = null;
        prev = null;

        // Start the in-order traversal and linking process
        inOrderTraversalAndLink(root);

        return head;
    }

    /**
     * Recursive helper method to perform in-order traversal and link nodes.
     *
     * @param node The current node being visited.
     */
    private void inOrderTraversalAndLink(TreeNode node) {
        if (node == null) {
            return;
        }

        // 1. Recursively traverse the left subtree
        inOrderTraversalAndLink(node.left);

        // 2. Process the current node (link it to the DLL)
        if (prev == null) {
            // If prev is null, this is the first node visited in in-order traversal.
            // It becomes the head of the DLL.
            head = node;
        } else {
            // Link the previous node to the current node
            node.left = prev;   // Current node's 'prev' points to the actual previous node
            prev.right = node;  // Previous node's 'next' points to the current node
        }
        // Update prev to the current node for the next iteration
        prev = node;

        // 3. Recursively traverse the right subtree
        inOrderTraversalAndLink(node.right);
    }

    /**
     * Helper method to build a sample BST for testing.
     */
    public TreeNode buildSampleBST() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        /*
              4
             / \
            2   5
           / \
          1   3
        */
        return root;
    }

    /**
     * Helper method to print the Doubly Linked List (forward and backward).
     *
     * @param dllHead The head of the DLL.
     */
    public void printDLL(TreeNode dllHead) {
        if (dllHead == null) {
            System.out.println("Doubly Linked List is empty.");
            return;
        }

        // Print forward
        System.out.print("DLL (forward): ");
        TreeNode current = dllHead;
        while (current != null) {
            System.out.print(current.val + " <-> ");
            current = current.right;
        }
        System.out.println("null");

        // Print backward (using the 'prev' instance variable which holds the tail after conversion)
        System.out.print("DLL (backward): ");
        current = this.prev; // 'this.prev' holds the tail of the DLL after conversion
        while (current != null) {
            System.out.print(current.val + " <-> ");
            current = current.left;
        }
        System.out.println("null");
    }

    /**
     * Helper method to print the BST using in-order traversal for verification.
     *
     * @param node The current node in BST traversal.
     */
    public void printBSTInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printBSTInOrder(node.left);
        System.out.print(node.val + " ");
        printBSTInOrder(node.right);
    }

    public static void main(String[] args) {
        BSTtoDLLConverter converter = new BSTtoDLLConverter();

        // Build a sample BST
        TreeNode bstRoot = converter.buildSampleBST();

        System.out.println("Original BST (in-order traversal for reference):");
        converter.printBSTInOrder(bstRoot);
        System.out.println("\n");

        // Convert BST to DLL
        TreeNode dllHead = converter.convertToDLL(bstRoot);

        // Print the converted Doubly Linked List
        System.out.println("Converted Doubly Linked List:");
        converter.printDLL(dllHead);

        // Test with an empty BST
        System.out.println("\n--- Testing with an empty BST ---");
        TreeNode emptyBSTRoot = null;
        TreeNode emptyDLLHead = converter.convertToDLL(emptyBSTRoot);
        converter.printDLL(emptyDLLHead);

        // Test with a single-node BST
        System.out.println("\n--- Testing with a single-node BST ---");
        TreeNode singleNodeBSTRoot = new TreeNode(10);
        System.out.println("Original BST (in-order traversal for reference):");
        converter.printBSTInOrder(singleNodeBSTRoot);
        System.out.println("\n");
        TreeNode singleNodeDLLHead = converter.convertToDLL(singleNodeBSTRoot);
        converter.printDLL(singleNodeDLLHead);
    }
}
