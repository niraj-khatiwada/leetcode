package LinkedListCycle151;

public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Floyd's cycle finding algorithm
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        var slow = head;
        var fast = head.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                break;
            }
        }
        return false;
    }
}