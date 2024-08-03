package InvertABinaryTree226;

import java.util.ArrayDeque;

public class InvertABinaryTree {
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
    // This is a BFS Method
    public Node invertTree(Node root) {
        if (root == null) {
            return root;
        }
        var queue = new ArrayDeque<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var popped = queue.remove();
            var right = popped.right;
            popped.right = popped.left;
            popped.left = right;
            if (popped.left != null) {
                queue.add(popped.left);
            }
            if (popped.right != null) {
                queue.add(popped.right);
            }
        }
        return root;
    }

    public Node invertTreeUsingRecursion(Node root) {
        if (root == null) {
            return root;
        }
        this._invertTree(root);
        return root;
    }

    private void _invertTree(Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }

        _invertTree(node.left);
        _invertTree(node.right);

        var right = node.right;
        node.right = node.left;
        node.left = right;

    }

}
