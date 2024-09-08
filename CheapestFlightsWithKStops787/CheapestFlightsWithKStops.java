package CheapestFlightsWithKStops787;

import java.util.*;

public class CheapestFlightsWithKStops {
    private class NodeEntry {
        public int node;
        public int price;
        public int stops;

        public NodeEntry(int node, int price, int stops) {
            this.node = node;
            this.price = price;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        var prices = new int[n];
        for (var i = 0; i < n; i++) {
            if (i != src) {
                prices[i] = Integer.MAX_VALUE;
            }
        }
        var stops = new int[n];
        for (var i = 0; i < n; i++) {
            if (i != src) {
                stops[i] = Integer.MAX_VALUE;
            }
        }
        List<int[]>[] edges = new ArrayList[n];
        for (var i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (var flight : flights) {
            edges[flight[0]].add(new int[] { flight[1], flight[2] });
        }
        var queue = new PriorityQueue<NodeEntry>(Comparator.comparingInt(x -> x.price));
        queue.add(new NodeEntry(src, 0, 0));
        while (!queue.isEmpty()) {
            var current = queue.poll();
            if (current.node == dst) {
                return current.price;
            }
            if (current.stops == (k + 1)) {
                continue;
            }
            for (var edge : edges[current.node]) {
                var nextNode = edge[0];
                var nextPrice = current.price + edge[1];
                var nextStops = current.stops + 1;
                if ((nextPrice < prices[nextNode] && nextStops <= (k + 1)) || nextStops < stops[nextNode]) {
                    prices[nextNode] = nextPrice;
                    stops[nextNode] = nextStops;
                    queue.offer(new NodeEntry(nextNode, nextPrice, nextStops));
                }
            }

        }
        return -1;
    }

}
