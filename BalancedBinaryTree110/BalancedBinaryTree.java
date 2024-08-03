package BalancedBinaryTree110;

public class BalancedBinaryTree {
    private class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node root;

    public boolean isBalanced(Node root) {
        boolean[] rs = new boolean[] { true };
        this._isBalanced(root, rs);
        return rs[0];
    }

    private int _isBalanced(Node root, boolean[] rs) {
        if (root == null) {
            return -1;
        }

        var l = _isBalanced(root.left, rs);
        var r = _isBalanced(root.right, rs);

        if (Math.abs(l - r) > 1) {
            rs[0] = false;
        }

        return 1 + Math.max(l, r);
    }
}
