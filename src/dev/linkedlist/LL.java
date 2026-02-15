package dev.linkedlist;

public class LL {
    Node head;
    int size;
    LL() {
        this.size = 0;
    }

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;

    }

    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty ");
            return;
        }

        head = head.next;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty ");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node secondNode = head;
        Node lastNode = head.next;

        while (lastNode.next != null) {
            secondNode = secondNode.next;
            lastNode = lastNode.next;
        }

        secondNode.next = null;
    }

    public void deleteNodeFromLast(int n) {
        if (head == null) {
            System.out.println("List is empty ");
            return;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        Node first = dummy;
        Node second = dummy;

        // Move first n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            if (first == null) {
                System.out.println("Index out of bounds");
                return;
            }
            first = first.next;
        }

        // Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Delete the nth node from end
        if (second.next != null) {
            second.next = second.next.next;
        }

        head = dummy.next; // Update head in case the first node was deleted
    }


    public void printList() {

        if (head == null) {
            System.out.println("List is empty ");
            return;
        }

        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.print("NULL");
    }

    public int getIndex(int data) {
        Node currNode = head;
        int index = 0;
        while (currNode != null) {
            if (currNode.data == data) {
                return index;
            }
            currNode = currNode.next;
            index++;
        }
        return -1; // not found
    }

    public void reverseIterate() {
        if (head == null || head.next == null) {
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;

        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            //update
            prevNode = currNode;
            currNode = nextNode;

        }

        head.next = null;
        head = prevNode;
    }

    public Node reverseRecursive(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node newNode = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newNode;
    }


    public static void main(String[] args) {

        LL list = new LL();
        list.addLast(1);
        list.addLast(2);
        // list.printList();
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.printList();
        System.out.println();
      //  list.head =  list.reverseRecursive(list.head);
        list.deleteNodeFromLast(2);
        list.printList();

//        list.addLast(8);
//        list.addLast(6);
//        list.addLast(10);
//        list.printList();

//        list.reverseIterate();
   //     list.printList();
   //     System.out.println();
//        System.out.println("Index of 7 : " + list.getIndex(7));
//        list.deleteFirst();
//        list.printList();
//        list.deleteLast();
//        System.out.println();

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a number b/w 1 to 50");
//        int n = sc.nextInt();
//        for (int i = 0; i < n; i++) {
//            int num = sc.nextInt();
//            list.addLast(num);
//        }
//        list.printList();
//        System.out.println();
//        System.out.println("Deleting all nodes above 25");
//        list.deleteNode();
//        list.printList();

    }


}
