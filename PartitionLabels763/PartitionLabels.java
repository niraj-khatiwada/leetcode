package PartitionLabels763;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        var rs = new ArrayList<Integer>();
        var used = new HashSet<Character>();
        var count = new int[26];
        for (var ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        var rem = 0;
        var size = 0;
        for (var ch : s.toCharArray()) {
            size++;
            if (used.contains(ch)) {
                rem--;
            } else {
                used.add(ch);
                rem += count[ch - 'a'] - 1;
            }
            if (rem == 0) {
                rs.add(size);
                size = 0;
            }
        }
        return rs;
    }
}
