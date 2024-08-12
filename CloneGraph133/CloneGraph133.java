package CloneGraph133;

import java.util.*;

public class CloneGraph133 {

    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        var map = new HashMap<Integer, Node>();
        return this._dfs(node, map);
    }

    private Node _dfs(Node node, Map<Integer, Node> map) {
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        var copy = new Node(node.val);
        map.put(node.val, copy);
        for (var n : node.neighbors) {
            copy.neighbors.add(_dfs(n, map));
        }
        return copy;
    }

}
