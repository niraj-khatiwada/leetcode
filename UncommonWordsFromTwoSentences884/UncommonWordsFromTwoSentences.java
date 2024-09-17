package UncommonWordsFromTwoSentences884;

import java.util.HashSet;

public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        var first = new HashSet<String>();
        var rs = new HashSet<String>();
        for (var word : s1.split(" ")) {
            if (first.contains(word)) {
                rs.remove(word);
            } else {
                rs.add(word);
            }
            first.add(word);
        }
        var second = new HashSet<String>();
        for (var word : s2.split(" ")) {
            if (first.contains(word)) {
                rs.remove(word);
            } else {
                if (second.contains(word)) {
                    rs.remove(word);
                } else {
                    rs.add(word);
                }
            }
            second.add(word);
        }
        var uncommon = new String[rs.size()];
        var i = 0;
        for (var s : rs) {
            uncommon[i] = s;
            i++;
        }
        return uncommon;
    }
}