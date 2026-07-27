package patternbased.LinkedList;

public class ListNode {

    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
            // save the next node
            ListNode next = curr.next;

            // Reverse
            curr.next = prev;

            // update
            prev = curr;

            curr = next;
        }
        return prev;
    }

    public ListNode mergeTwoLists(ListNode list1 , ListNode list2){
        ListNode dummy = new ListNode(-1);

        ListNode tail = dummy;

        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }

        if(list1 != null){
            tail.next =  list1;
        }

        if(list2 != null){
            tail.next = list2;
        }

        return dummy.next;
    }

    public boolean hasCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
