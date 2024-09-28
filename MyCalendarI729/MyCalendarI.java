package MyCalendarI729;

import java.util.TreeMap;

public class MyCalendarI {
    private class Node {
        public int start;
        public int end;
        public Node left;
        public Node right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public Node root;

    // log(n)
    public boolean book(int start, int end) {
        if (root == null) {
            this.root = new Node(start, end);
            return true;
        }
        var current = root;
        while (current != null) {
            if (!(end <= current.start || current.end <= start)) {
                return false;
            }
            if (start < current.start) {
                if (current.left == null) {
                    current.left = new Node(start, end);
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node(start, end);
                    break;
                }
                current = current.right;
            }

        }
        return true;
    }

    public TreeMap<Integer, Integer> map = new TreeMap<>();

    // Using upper bound technique
    // o(log(n))
    public boolean bookMethod2(int start, int end) {
        var ub = map.higherKey(start); // O(log(n))
        if (ub != null && end > map.get(ub)) {
            return false;
        }
        map.put(end, start);
        return true;
    }
}