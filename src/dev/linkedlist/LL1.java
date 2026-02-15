//package dev.linkedlist;
//
//public class LL1 {
//
//    Node head;
//
//    private int size;
//
//    LL1(){
//        size = 0;
//    }
//
//    public class Node {
//        int data;
//
//        Node next;
//
//        Node (int data){
//            this.data = data;
//            this.next = null;
//            size++;
//        }
//    }
//
//    public void addFirst(int data){
//        Node newNode = new Node(data);
//        if(head == null){
//            head = newNode;
//            return;
//        }
//
//        newNode.next = head;
//        head = newNode;
//    }
//
//    public  void addLast(int data){
//        Node newNode = new Node(data);
//        if(head == null){
//            head = newNode;
//            return;
//        }
//
//        Node currNode = head;
//        while (currNode.next!=null){
//            currNode = currNode.next;
//        }
//
//        currNode.next = newNode;
//
//    }
//
//    public void printList() {
//
//        if(head == null){
//            System.out.print("List is empty");
//            return;
//        }
//
//        Node currNode = head;
//        while (currNode!=null){
//            System.out.print(currNode.data + " -> ");
//            currNode = currNode.next;
//        }
//        System.out.print("Null");
//    }
//
//    public void removeFirst(){
//        if(head == null){
//            System.out.print("List is empty");
//            return;
//        }
//
//        head = head.next;
//
//    }
//
//    public void removeLast(){
//        if(head == null){
//            System.out.print("List is empty");
//            return;
//        }
//        if(head.next ==null){
//            head = null;
//        }
//
//        Node secondLast = head;
//        Node lastNode = head.next;
//
//        while(lastNode.next!=null){
//           lastNode = lastNode.next;
//           secondLast = secondLast.next;
//
//        }
//
//        secondLast.next = null;
//
//    }
//
//
//    public static void main(String[] args) {
//        LL1 list = new LL1();
//        list.addLast(1);
//        list.addLast(2);
//        list.addLast(3);
//        list.addLast(4);
//        list.addLast(5);
//        list.removeLast();
//        list.removeFirst();
//
//        list.printList();
//    }
//
//
//}
