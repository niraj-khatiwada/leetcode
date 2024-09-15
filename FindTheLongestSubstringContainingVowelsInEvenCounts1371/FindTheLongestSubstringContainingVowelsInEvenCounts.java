package FindTheLongestSubstringContainingVowelsInEvenCounts1371;

import java.util.Arrays;

public class FindTheLongestSubstringContainingVowelsInEvenCounts {
    public int findTheLongestSubstring(String s) {
        var maxLen = 0;
        var mask = 0;
        var first = new int[32];
        Arrays.fill(first, -2);
        first[0] = -1;
        for (var i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                mask ^= _findMask(ch);
            }
            if (first[mask] != -2) {
                maxLen = Math.max(maxLen, i - first[mask]);
            } else {
                first[mask] = i;
            }
        }
        return maxLen;
    }

    private int _findMask(char ch) {
        if (ch == 'a') {
            return 1;
        } else if (ch == 'e') {
            return 2;
        } else if (ch == 'i') {
            return 4;
        } else if (ch == 'o') {
            return 8;
        } else {
            return 16;
        }
    }
}
