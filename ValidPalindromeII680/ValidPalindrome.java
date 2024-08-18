package ValidPalindromeII680;

public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        for (var i = 0; i < s.length(); i++) {
            var str = s.substring(0, i) + s.substring(i + 1);
            if (_isPalindrome(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean _isPalindrome(String str) {
        var l = 0;
        var r = str.length() - 1;
        var chars = str.toCharArray();
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}