package dev.tree;


class Node {
  int val;
  Node left;
  Node right;

  Node(int val){
      this.val = val;
      left = null;
      right = null;
  }
}

public class BSTtoDoublyLinkedList {
    private Node prev = null;
    private Node head = null;

    public Node convertBSTtoDLL(Node root) {

        if (root == null) {
            return null;
        }

        convertBSTtoDLL(root.left);

        if (prev == null) {
            head = root; // First node becomes the head of the DLL
        } else {
            prev.right = root; // Link previous node's right to current node
            root.left = prev;  // Link current node's left to previous node
        }

        prev = root; // Update prev to current node
        convertBSTtoDLL(root.right);
        return head;
    }

    public void printDLL(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(6);
        root.right = new Node(14);
        root.left.left = new Node(4);
        root.left.right =  new Node(8);
        root.right.left = new Node(12);
        root.right.right = new Node(16);

        BSTtoDoublyLinkedList converter = new BSTtoDoublyLinkedList();
        Node dllHead = converter.convertBSTtoDLL(root);

        // Print the Doubly Linked List
        System.out.println("Doubly Linked List (In-order):");
        converter.printDLL(dllHead);
    }

}
