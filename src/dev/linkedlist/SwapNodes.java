// File: src/dev/linkedlist/SwapNodes.java
package dev.linkedlist;

public class SwapNodes {
    Node head;

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Swaps every two adjacent nodes and returns new head
    public Node swapPairs(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            Node first = prev.next;
            Node second = first.next;

            // Swapping
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move prev to next pair
            prev = first;
        }

        return dummy.next;
    }

    // Utility method to add node at end
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // Utility method to print list
    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        SwapNodes list = new SwapNodes();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
//        list.addLast(5);
        System.out.print("Original list: ");
        list.printList();

        list.head = list.swapPairs(list.head);
        System.out.print("After swapping pairs: ");
        list.printList();
    }
}