package InsertGreatestCommonDivisorsInLinkedList2807;

public class InsertGreatestCommonDivisorsInLinkedList {
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

    // O(n * min(n, n+1))
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        var current = head;
        while (current != null) {
            if (current.next != null) {
                var gcd = this._gcd(current.val, current.next.val);
                var ref = current.next;
                current.next = new ListNode(gcd, ref);
                current = ref;
            } else {
                break;
            }
        }
        return head;
    }

    // Euclid'd GCD Algorithm
    private int _gcd(int a, int b) {
        while (b != 0) {
            var rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
}