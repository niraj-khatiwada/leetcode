package CloneGraph133;

import java.util.*;

public class CloneGraph133 {
    private class NodeEntry {
        public Node node;
        public Node ref;

        public NodeEntry(Node node, Node ref) {
            this.node = node;
            this.ref = ref;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        var map = new HashMap<Integer, Node>();
        var queue = new ArrayDeque<NodeEntry>();
        queue.add(new NodeEntry(new Node(node.val), node));
        while (!queue.isEmpty()) {
            var entry = queue.poll();
            for (var n : entry.ref.neighbors) {
                var newNode = map.get(n.val) == null ? new Node(n.val) : map.get(n.val);
                entry.node.neighbors.add(newNode);
                if (!map.containsKey(n.val)) {
                    queue.add(new NodeEntry(newNode, n));
                }
            }
            map.put(entry.node.val, entry.node);
        }
        return map.get(node.val);
    }
}
