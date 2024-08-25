package MaximumLengthOfPairChain646;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfPairChain {
    // TC: O(n(log(n)))
    // SC: O(1);
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(x -> x[1]));
        var c = 1;
        var end = pairs[0][1];
        for (var i = 1; i < pairs.length; i++) {
            if (end < pairs[i][0]) {
                c++;
                end = pairs[i][1];
            }
        }
        return c;
    }
}
