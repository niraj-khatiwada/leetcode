package ReverseLinkedList206;

public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        var previous = head;
        var current = head.next;
        while (current != null) {
            var nextRef = current.next;
            current.next = previous;
            if (previous == head) {
                previous.next = null;
            }
            previous = current;
            current = nextRef;
        }
        return previous;
    }
}