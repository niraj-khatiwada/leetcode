package MergeTwoSortedList22;

public class MergeTwoSortedList {

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode l = null;
        ListNode s = null;
        if (list1.val <= list2.val) {
            l = list1;
            s = list2;
        } else {
            l = list2;
            s = list1;
        }

        var p = l;
        while (p.next != null) {
            if (p.next.val > s.val) {
                var ref = p.next;
                p.next = null;
                var sref = s;
                s = s.next;
                sref.next = null;
                p.next = sref;
                p = p.next;
                p.next = ref;
            } else {
                p = p.next;
            }
            if (s == null) {
                break;
            }
        }

        if (s != null) {
            p.next = s;
        }

        return l;
    }
}
