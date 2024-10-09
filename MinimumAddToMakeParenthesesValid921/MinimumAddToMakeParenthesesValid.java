package MinimumAddToMakeParenthesesValid921;

public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        var open = 0;
        var closed = 0;
        var i = 0;
        var inserted = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                closed++;
            }
            if (closed > open) {
                inserted++;
                open++;
            }
            i++;
        }
        return inserted + (open - closed);

    }
}