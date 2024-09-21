package ShortestPalindrome214;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (j >= 0) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
            j--;
        }
        if (i == s.length()) {
            return s;
        }
        return new StringBuilder(s.substring(i)).reverse().toString() + shortestPalindrome(s.substring(0, i))
                + s.substring(i);
    }
}
