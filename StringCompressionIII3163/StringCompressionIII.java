package StringCompressionIII3163;

public class StringCompressionIII {
    public String compressedString(String word) {
        var rs = new StringBuilder();
        var last = word.charAt(0);
        var count = 0;
        var i = 0;
        while (i < word.length()) {
            var ch = word.charAt(i);
            if (ch == last) {
                i++;
                count++;
                if (count > 9) {
                    rs.append(9 + "" + ch);
                    count = 1;
                }
            } else {
                rs.append(count + "" + last);
                count = 0;
            }
            last = ch;
        }
        rs.append(count + "" + last);
        return rs.toString();
    }
}
