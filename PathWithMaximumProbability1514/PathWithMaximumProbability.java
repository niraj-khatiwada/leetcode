package PathWithMaximumProbability1514;

import java.util.*;

public class PathWithMaximumProbability {
    private class Entry {
        public Node node;
        public double prob;

        public Entry(Node node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    private class Edge {
        public Node from;
        public Node to;
        public double prob;

        public Edge(Node from, Node to, double prob) {
            this.from = from;
            this.to = to;
            this.prob = prob;
        }
    }

    private class Node {
        public int value;
        public List<Edge> edges;

        public Node(int value) {
            this.value = value;
            this.edges = new ArrayList<>();
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, Node> nodes = new HashMap<>();
        var pq = new PriorityQueue<Entry>(Comparator.comparingDouble(x -> -(x.prob)));
        Node startNode = null;
        for (var i = 0; i < edges.length; i++) {
            var edge = edges[i];
            var from = nodes.get(edge[0]);
            if (from == null) {
                var node = new Node(edge[0]);
                nodes.put(edge[0], node);
                from = node;
            }

            var to = nodes.get(edge[1]);
            if (to == null) {
                var node = new Node(edge[1]);
                nodes.put(edge[1], node);
                to = node;
            }
            var fromTo = new Edge(from, to, succProb[i]);
            var toFrom = new Edge(to, from, succProb[i]);
            from.edges.add(fromTo);
            to.edges.add(toFrom);

            if (edge[0] == start_node) {
                startNode = from;
            }
            if (edge[1] == start_node) {
                startNode = to;
            }
        }
        if (startNode == null) {
            return 0;
        }
        pq.add(new Entry(startNode, 1));
        var visited = new HashSet<Integer>();
        while (!pq.isEmpty()) {
            var popped = pq.poll();
            if (popped.node.value == end_node) {
                return popped.prob;
            }
            visited.add(popped.node.value);
            for (var edge : popped.node.edges) {
                if (edge.to != null && !visited.contains(edge.to.value)) {
                    pq.offer(new Entry(edge.to, popped.prob * edge.prob));
                }
            }
        }
        return 0;
    }
}
