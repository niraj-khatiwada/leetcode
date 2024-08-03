package MaximumDepthOfABinaryTree104;

public class MaximumDepthOfABinaryTree {
    private class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node root;

    // O(n)
    public int maxDepth(Node root) {
        return 1 + this._maxDepth(root);
    }

    private int _maxDepth(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(_maxDepth(node.left), _maxDepth(node.right));
    }
}
