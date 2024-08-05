package ConvertSortedListToBST109;

import java.util.*;

public class ConvertSortedListToBST {
    private class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node root;

    public Node sortedListToBST() {
        Node root = null;
        List<Integer> list = Arrays.asList(-10, -3, 0, 5, 9);
        root = _sortedListToBST(list);
        return root;
    }

    private Node _sortedListToBST(List<Integer> list) {
        var size = list.size();
        if (size == 0) {
            return null;
        }
        int mid = size / 2;
        var root = new Node(list.get(mid));
        if (mid != 0) {
            var l = list.subList(0, mid);
            System.out.printf("%s L\n", l);
            if (l.size() > 0) {
                root.left = _sortedListToBST(l);
            }

            var r = list.subList(mid + 1, size);
            System.out.printf("%s R\n", r);
            if (r.size() > 0) {
                root.right = _sortedListToBST(r);
            }
        }
        return root;
    }

    public void bfsUsingQueue(Node root) {
        var queue = new ArrayDeque<Node>();
        // But required O(n) extra space
        queue.add(root);
        while (!queue.isEmpty()) {
            var n = queue.remove();
            System.out.println(n.value);
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
        }
    }

}
