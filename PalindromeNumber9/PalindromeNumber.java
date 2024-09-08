package PalindromeNumber9;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        var rev = 0;
        var current = x;
        while (current != 0) {
            var rem = current % 10;
            rev = rev * 10 + rem;
            current = current / 10;
        }
        return rev == x;
    }
}
