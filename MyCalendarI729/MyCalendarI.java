package MyCalendarI729;

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
}