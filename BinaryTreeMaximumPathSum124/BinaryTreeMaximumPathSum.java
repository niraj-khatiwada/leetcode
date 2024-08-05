package BinaryTreeMaximumPathSum124;

public class BinaryTreeMaximumPathSum {
    private class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node root;

    public int maxPathSum(Node root) {
        var rs = new int[] { Integer.MIN_VALUE };
        this._maxPathSum(root, rs);
        return rs[0];
    }

    private int _maxPathSum(Node node, int[] rs) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        var lmax = _maxPathSum(node.left, rs);
        var rmax = _maxPathSum(node.right, rs);

        var loffset = lmax == Integer.MIN_VALUE ? 0 : lmax;
        var roffset = rmax == Integer.MIN_VALUE ? 0 : rmax;

        var lrmax = Math.max(node.value, Math.max(loffset + node.value, roffset + node.value));
        var l = new int[] { lmax, rmax, lrmax, loffset + roffset + node.value };
        for (var v : l) {
            rs[0] = Math.max(rs[0], v);
        }
        return lrmax;
    }
}
