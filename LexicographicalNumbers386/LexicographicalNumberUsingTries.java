package LexicographicalNumbers386;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumberUsingTries {
    private class Node {
        public int value;
        public Node[] children;
        public boolean isEnd;
        public Node parent;
        public int childrenCount;

        public Node(int value) {
            this.value = value;
            this.children = new Node[10];
        }

        public Node() {
            this.children = new Node[10];
        }
    }

    Node root = new Node();

    private void _add(int n) {
        var current = root;
        var nstr = n + "";
        for (var i = 0; i < nstr.length(); i++) {
            var d = nstr.charAt(i) - 48;
            if (current.children[d] == null) {
                var node = new Node(current.value * 10 + d);
                node.parent = current;
                current.children[d] = node;
            }
            current.childrenCount++;
            current = current.children[d];
        }
        current.isEnd = true;
    }

    public List<Integer> lexicalOrder(int n) {
        var rs = new ArrayList<Integer>();
        for (var i = 1; i <= n; i++) {
            this._add(i);
        }
        this._dfs(root, rs);
        return rs;
    }

    private void _dfs(Node node, List<Integer> rs) {
        if (node == null) {
            return;
        }
        if (node.value != 0) {
            rs.add(node.value);
        }
        for (var i = 0; i < 10; i++) {
            if (node.value == 0 && i == 0) {
                continue;
            }
            _dfs(node.children[i], rs);
        }
    }
}
