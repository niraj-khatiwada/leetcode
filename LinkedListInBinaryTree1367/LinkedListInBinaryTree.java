package LinkedListInBinaryTree1367;

public class LinkedListInBinaryTree {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        return this._dfs(root, head);
    }

    private boolean _dfs(TreeNode node, ListNode head) {
        if (node == null) {
            return false;
        }
        if (node.val == head.val) {
            if (this._match(node, head)) {
                return true;
            }
        }
        if (_dfs(node.left, head) || _dfs(node.right, head)) {
            return true;
        }
        return false;
    }

    private boolean _match(TreeNode node, ListNode head) {
        if (node == null || head == null || node.val != head.val) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        if (_match(node.left, head.next) || _match(node.right, head.next)) {
            return true;
        }
        return false;
    }
}
