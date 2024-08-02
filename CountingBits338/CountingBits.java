package CountingBits338;

import java.util.ArrayList;
import java.util.List;

public class CountingBits {
    // nlog(n)
    // TODO: There's a way to compute this in O(n). But we need to know DP first for
    // that. See NeetCode solution.
    public int[] countBits(int n) {
        List<Integer> cl = new ArrayList<>();
        // nlog(n)
        for (var i = 0; i <= n; i++) {
            var c = 0;
            var j = i;
            // log(n)
            while (j != 0) {
                if ((j & 1) != 0) {
                    c++;
                }
                j = j >> 1;
            }
            cl.add(c);
        }
        int[] l = new int[cl.size()];
        for (var i = 0; i < l.length; i++) {
            l[i] = cl.get(i);
        }
        return l;
    }
}
