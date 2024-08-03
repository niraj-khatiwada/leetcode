package IsSameTree100;

public class IsSameTree {
    private class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node root;

    public boolean isSameTree(Node p, Node q) {
        return this._isSameTree(p, q);

    }

    private boolean _isSameTree(Node p, Node q) {
        if (p == null) {
            return q == null;
        }
        if (q == null) {
            return p == null;
        }
        if (p.value != q.value) {
            return false;
        }

        return _isSameTree(p.left, q.left) && _isSameTree(p.right, q.right);
    }
}
