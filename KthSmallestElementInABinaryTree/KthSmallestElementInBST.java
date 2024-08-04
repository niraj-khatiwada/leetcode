package KthSmallestElementInABinaryTree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {
    private class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node root;

    public int kthSmallest(Node root, int k) {
        var list = new ArrayList<Integer>();
        this._inOrder(root, list);
        return list.get(k - 1);

    }

    private void _inOrder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        _inOrder(node.left, list);
        list.add(node.value);
        _inOrder(node.right, list);
    }
}
