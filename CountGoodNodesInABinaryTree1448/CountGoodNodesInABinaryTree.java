package CountGoodNodesInABinaryTree1448;

public class CountGoodNodesInABinaryTree {
    private class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node root;

    public int goodNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int[] rs = new int[] { 1 };
        this._goodNodes(root.left, rs, root.value);
        this._goodNodes(root.right, rs, root.value);
        return rs[0];
    }

    private void _goodNodes(Node node, int[] rs, int max) {
        if (node == null) {
            return;
        }
        if (node.value >= max) {
            rs[0]++;
            max = node.value;
        }
        _goodNodes(node.left, rs, max);
        _goodNodes(node.right, rs, max);

    }
}