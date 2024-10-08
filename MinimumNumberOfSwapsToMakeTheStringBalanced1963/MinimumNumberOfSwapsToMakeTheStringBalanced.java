package MinimumNumberOfSwapsToMakeTheStringBalanced1963;

public class MinimumNumberOfSwapsToMakeTheStringBalanced {
    public int minSwaps(String s) {
        var open = 0;
        var closed = 0;
        var swaps = 0;
        var i = 0;
        var j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == '[') {
                open++;
            } else {
                closed++;
            }
            if (closed > open) {
                while (j > i) {
                    if (s.charAt(j) == '[') {
                        open++;
                        closed--;
                        j--;
                        swaps++;
                        break;
                    }
                    j--;
                }
            }
            i++;
        }
        return swaps;
    }
}
