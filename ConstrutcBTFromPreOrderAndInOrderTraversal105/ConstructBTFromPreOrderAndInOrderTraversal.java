package ConstrutcBTFromPreOrderAndInOrderTraversal105;

public class ConstructBTFromPreOrderAndInOrderTraversal {
    private class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node root;

    public Node buildTree(int[] preorder, int[] inorder) {
        return this._buildTree(preorder, inorder);
    }

    private Node _buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        var root = preorder[0];
        var pindex = -1;
        for (var i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                pindex = i;
            }
        }
        if (pindex == -1) {
            return null;
        }
        var node = new Node(root);
        var left = new int[pindex];
        var right = new int[inorder.length - pindex - 1];
        if (left.length == 0 && right.length == 0) {
            return node;
        }
        for (var i = 0; i < inorder.length; i++) {
            if (i == pindex) {
                continue;
            }
            if (i < left.length) {
                left[i] = inorder[i];
            } else {
                right[i - (left.length + 1)] = inorder[i];
            }
        }
        var newpreorderlen = preorder.length - 1;
        var newleftpreorder = new int[newpreorderlen - right.length];
        var newrightpreorder = new int[newpreorderlen - left.length];
        for (var i = 1; i < preorder.length; i++) {
            var ai = i - 1;
            if (ai < newleftpreorder.length) {
                newleftpreorder[ai] = preorder[i];
            } else {
                newrightpreorder[ai - newleftpreorder.length] = preorder[i];
            }
        }
        node.left = _buildTree(newleftpreorder, left);
        node.right = _buildTree(newrightpreorder, right);

        return node;
    }
}
