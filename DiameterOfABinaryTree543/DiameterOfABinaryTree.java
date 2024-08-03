package DiameterOfABinaryTree543;

import java.util.ArrayDeque;

public class DiameterOfABinaryTree {
    private class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node root;

    public int diameterOfBinaryTree(Node root) {
        if (root == null) {
            return 0;
        }
        int[] rs = new int[] { 0 };
        this._diameterOfBinaryTree(root, rs);
        return rs[0];

    }

    private int _diameterOfBinaryTree(Node node, int[] rs) {
        if (node == null) {
            return -1;
        }
        var l = _diameterOfBinaryTree(node.left, rs);
        var r = _diameterOfBinaryTree(node.right, rs);

        rs[0] = Math.max(rs[0], l + r + 2);
        return 1 + Math.max(l, r);
    }

    // BFS using Queue.
    // This method will be slower
    // O(n^2)
    public int diameterOfBinaryTreeSlowMethod(Node root) {
        if (root == null) {
            return 0;
        }
        var queue = new ArrayDeque<Node>();
        queue.add(root);
        var d = 0;
        while (!queue.isEmpty()) {
            var node = queue.remove();
            var l = this._height(node.left);
            var r = this._height(node.right);
            var nd = l + r + 2;
            if (nd > d) {
                d = nd;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return d;
    }

    private int _height(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(_height(node.left), _height(node.right));
    }
}
