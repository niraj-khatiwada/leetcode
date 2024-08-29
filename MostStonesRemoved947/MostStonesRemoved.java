package MostStonesRemoved947;

import java.util.*;

public class MostStonesRemoved {
    public class DisjointSet {
        public int[] parent;
        public int[] rank;

        public DisjointSet(int size) {
            this.parent = new int[size + 1];
            this.rank = new int[size + 1];
            for (var i = 0; i <= size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int n) {
            var p = parent[n];
            if (n == parent[n]) {
                return n;
            }
            return find(p);
        }

        public int union(int a, int b) {
            var parentA = find(a);
            var parentB = find(b);

            var rankA = rank[a];
            var rankB = rank[b];

            if (rankA >= rankB) {
                parent[parentB] = parentA;
                if (rankA == rankB) {
                    rank[parentA]++;
                }
                return parentA;
            }
            parent[parentA] = parentB;
            return parentB;
        }

    }

    public int removeStones(int[][] stones) {
        var maxRow = -1;
        var maxCol = -1;
        for (var i = 0; i < stones.length; i++) {
            maxRow = Math.max(stones[i][0], maxRow);
            maxCol = Math.max(stones[i][1], maxCol);
        }
        var ds = new DisjointSet(maxRow + maxCol + 1);
        for (var i = 0; i < stones.length; i++) {
            var stone = stones[i];
            ds.union(stone[0], stone[1] + maxRow + 1);
        }
        var nodes = new int[ds.parent.length];
        for (var i = 0; i < nodes.length; i++) {
            var f = ds.find(i);
            nodes[f]++;
        }
        var count = 0;
        for (var i = 0; i < nodes.length; i++) {
            if (nodes[i] > 1) {
                count++;
            }
        }

        return stones.length - count;
    }
}