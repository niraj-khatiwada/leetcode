package SubTreeOfAnotherTree572;

import java.util.ArrayList;
import java.util.List;

public class SubTreeOfAnotherTree {
    private class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node root;

    public boolean isSubtree(Node root, Node subRoot) {
        List<Node> rs = new ArrayList<Node>();
        this._findSubTreeRootNode(root, subRoot.value, rs);
        for (var l : rs) {
            if (_isSubtree(l, subRoot)) {
                return true;
            }
        }
        return false;
    }

    private boolean _isSubtree(Node p, Node q) {
        if (p == null) {
            return q == null;
        }
        if (q == null) {
            return p == null;
        }
        if (p.value != q.value) {
            return false;
        }
        return _isSubtree(p.left, q.left) && _isSubtree(p.right, q.right);
    }

    private void _findSubTreeRootNode(Node node, int target, List<Node> rs) {
        if (node == null) {
            return;
        }
        if (node.value == target) {
            rs.add(node);
        }
        _findSubTreeRootNode(node.left, target, rs);
        _findSubTreeRootNode(node.right, target, rs);

    }
}
