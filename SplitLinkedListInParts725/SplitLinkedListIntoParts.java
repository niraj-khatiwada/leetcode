package SplitLinkedListInParts725;

import java.util.Arrays;

public class SplitLinkedListIntoParts {
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

    public ListNode[] splitListToParts(ListNode head, int k) {

        var split = new ListNode[k];
        if (head == null) {
            return split;
        }
        var size = 0;
        var curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        var distribute = new int[k];
        var distributionSize = size / k;
        Arrays.fill(distribute, distributionSize);
        var rem = size % k;
        if (rem != 0) {
            for (var i = 0; i < k; i++) {
                distribute[i]++;
                rem--;
                if (rem == 0) {
                    break;
                }
            }
        }
        var current = head;
        while (current != null) {
            var headRef = current;
            for (var i = 0; i < k; i++) {
                for (var j = 0; j < (distribute[i] - 1); j++) {
                    current = current.next;
                    if (current == null) {
                        split[i] = headRef;
                        return split;
                    }
                }
                if (current != null) {
                    var nextHead = current.next;
                    current.next = null;
                    split[i] = headRef;
                    headRef = nextHead;
                    current = nextHead;
                }
            }
        }
        return split;
    }
}
