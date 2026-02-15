package dev.linkedlist;

import java.util.Stack;

public class LinkedListTutorial {

    ListNode head;
    int size;

    public LinkedListTutorial() {
        this.size = 0;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int data) {
            this.val = data;
            this.next = null;
            size++;
        }

    }

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode prevNode = head;
        ListNode currentNode = head.next;

        while(currentNode != null){
            ListNode nextNode = head.next.next;
            currentNode.next = prevNode;

            prevNode = currentNode;
            currentNode = nextNode;
        }

        head.next = null;
        head = prevNode;

        return head;
    }

    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow;
        return  middle;
    }

    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {

        if(head1 == null) return head2;
        if(head2 == null) return head1;

        if(head1.val <= head2.val){
            head1.next = mergeTwoLists(head1.next,head2);
            return head1;
        } else {
            head2.next = mergeTwoLists(head2.next, head1);
            return head2;
        }


    }

    public boolean isPalindrome(ListNode head) {
       if(head == null || head.next == null){
           return true;
       }
       ListNode curr  = head;
        Stack<Integer> stack = new Stack<>();
        while(curr != null){
            stack.push(head.val);
            head = head.next;
        }

        while (head != null){
            int c = stack.pop();
            if(c != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while ( slow != null && fast != null){
            if(fast.val == slow.val){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
     return false;
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while(fast != null && fast.next != null){
            if(slow.val == fast.val){
                hasCycle = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        if(!hasCycle){
            return null;
        }
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
