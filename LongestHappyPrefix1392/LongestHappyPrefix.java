package LongestHappyPrefix1392;

public class LongestHappyPrefix {
    public String longestPrefix(String s) {
        var lps = this._lps(s);
        return s.substring(0, lps);
    }

    private int _lps(String str) {
        var lps = new int[str.length()];
        int prevLPS = 0, i = 1;
        while (prevLPS < str.length() && i < str.length()) {
            if (str.charAt(i) == str.charAt(prevLPS)) {
                lps[i] = prevLPS + 1;
                prevLPS++;
                i++;
            } else {
                if (prevLPS == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    prevLPS = lps[prevLPS - 1];
                }
            }
        }
        return lps[str.length() - 1];
    }
}
