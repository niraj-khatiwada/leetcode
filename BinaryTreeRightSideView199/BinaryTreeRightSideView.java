package BinaryTreeRightSideView199;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    private class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node root;

    public List<Integer> rightSideView(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        var queue = new ArrayDeque<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var last = 0;
            var qSize = queue.size();
            for (var i = 0; i < qSize; i++) {
                var v = queue.remove();
                last = v.value;
                if (v.left != null) {
                    queue.add(v.left);
                }
                if (v.right != null) {
                    queue.add(v.right);
                }
            }
            list.add(last);
        }
        return list;
    }
}
