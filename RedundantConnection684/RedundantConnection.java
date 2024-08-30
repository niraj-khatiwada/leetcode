package RedundantConnection684;

import java.util.Arrays;

public class RedundantConnection {
    public class DS {
        public int[] parent;

        public DS(int size) {
            this.parent = new int[size];
            Arrays.fill(parent, -1);
        }

        public int find(int i) {
            var p = parent[i];
            if (p < 0) {
                return i;
            }
            return parent[i] = find(p);
        }

        public boolean union(int a, int b) {
            var pA = find(a);
            var pB = find(b);

            if (pA == pB) {
                return true;
            }

            var sA = -1 * parent[pA];
            var sB = -1 * parent[pB];

            if (sA >= sB) {
                parent[pB] = pA;
                parent[pA]--;
                return false;
            }
            parent[pA] = pB;
            parent[pB]--;
            return false;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        var rs = new int[2];
        var max = Integer.MIN_VALUE;
        for (var i = 0; i < edges.length; i++) {
            max = Math.max(max, Math.max(edges[i][0], edges[i][1]));
        }
        var ds = new DS(max + 1);
        for (var i = 0; i < edges.length; i++) {
            var edge = edges[i];
            if (ds.union(edge[0], edge[1])) {
                rs = new int[] { edge[0], edge[1] };
            }
        }
        return rs;
    }
}
