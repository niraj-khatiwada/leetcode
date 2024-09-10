package LinkedListCycleII142;

import java.util.HashSet;

public class LinkedListCycleII {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        var slow = head;
        var fast = head.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                break;
            }
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        var loop = new HashSet<ListNode>();
        var current = slow;
        while (!loop.contains(current)) {
            loop.add(current);
            current = current.next;
        }
        current = head;
        while (current != null) {
            if (loop.contains(current)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}