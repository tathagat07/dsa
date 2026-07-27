package revision;

public class ReverseList {

    Node head;
    int size;

    public ReverseList() {
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

    public void addFirst(int data){

        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        newNode = head;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }

        Node currNode = head;
        while (currNode.next != null){
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    public void printList(){
        if(head == null){
            System.out.println("List is empty");
        }
        Node currNode = head;
        while (currNode != null){
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.print("NULL");
    }

    public Node reverseList() {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public void reverseLinkedList(){

        if (head == null || head.next == null) {
            return;
        }
        Node prevNode = head;

        Node current = head.next;

        while(current != null){
            Node next = current.next;
            current.next = prevNode;

            prevNode  = current;
            current = next;
        }

        head.next = null;
        head = prevNode;

    }

    public static void main(String[] args) {
        ReverseList list = new ReverseList();
        list.addLast(1);
        list.addLast(2);
        // list.printList();
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.printList();
        System.out.println();
        list.reverseLinkedList();
        list.printList();
    }
}
