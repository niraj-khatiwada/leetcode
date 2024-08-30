package NumberOfProvinces547;

import java.util.Arrays;

public class NumberOfProvinces {
    public class DisjointSet {
        public int[] parent;

        public DisjointSet(int size) {
            this.parent = new int[size];
            Arrays.fill(this.parent, -1);
        }

        public int find(int n) {
            var p = parent[n];
            if (p < 0) {
                return n;
            }
            return parent[n] = find(p);
        }

        public int union(int a, int b) {
            var pA = find(a);
            var pB = find(b);

            System.out.printf("%s | %s\n", pA, pB);

            if (pA == pB) {
                return pA;
            }

            var sA = -1 * parent[pA];
            var sB = -1 * parent[pB];

            if (sA >= sB) {
                parent[pB] = pA;
                parent[pA]--;
                return pA;
            }
            parent[pA] = pB;
            parent[pB]--;
            return pB;
        }

    }

    public int findCircleNum(int[][] isConnected) {
        var ds = new DisjointSet(isConnected.length);
        for (var i = 0; i < isConnected.length; i++) {
            for (var j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    System.out.printf("%s %s\n", i, j);
                    ds.union(i, j);
                }
            }
        }
        var count = 0;
        for (var i = 0; i < isConnected.length; i++) {
            if (ds.parent[i] < 0) {
                count++;
            }
        }
        System.out.println(Arrays.toString(ds.parent));
        return count;
    }
}