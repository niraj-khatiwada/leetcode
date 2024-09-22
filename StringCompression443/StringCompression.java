package StringCompression443;

public class StringCompression {
    public int compress(char[] chars) {
        var rs = new StringBuilder();
        var last = '.';
        var count = 0;
        for (var ch : chars) {
            if (ch == last) {
                if (count > 1) {
                    var c = count;
                    while (c != 0) {
                        rs.deleteCharAt(rs.length() - 1);
                        c = c / 10;
                    }
                }
                rs.append((count + 1) + "");
                count++;
            } else {
                rs.append(ch);
                count = 1;
            }
            last = ch;
        }
        for (var i = 0; i < rs.length(); i++) {
            chars[i] = rs.charAt(i);
        }
        return rs.length();
    }
}
