package ValidateBST98;

public class ValidateBST {
    private class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node root;

    public boolean isValidBST(Node root) {
        if (root == null) {
            return true;
        }
        return this._isValidBST(root, -Double.MAX_VALUE, Double.MAX_VALUE);
    }

    private boolean _isValidBST(Node node, double min, double max) {
        if (node == null) {
            return true;
        }
        if (node.left != null && !(node.left.value > min && node.left.value < node.value)) {
            return false;
        }
        if (node.right != null && !(node.right.value > node.value && node.right.value < max)) {
            return false;
        }
        return _isValidBST(node.left, min, node.value) && _isValidBST(node.right, node.value, max);
    }
}
