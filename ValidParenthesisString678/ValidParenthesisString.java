package ValidParenthesisString678;

public class ValidParenthesisString {
    // TC: O(n)
    // SC: O(n)
    public boolean checkValidString(String s) {
        var open = 0;
        var asterik = 0;
        var balance = 0;

        for (var ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
                balance++;
            } else if (ch == '*') {
                asterik++;
                if (balance > 0) {
                    balance--;
                }
            } else {
                if (balance > 0) {
                    balance--;
                }
                if (open > 0) {
                    open--;
                } else if (asterik > 0) {
                    asterik--;
                } else {
                    return false;
                }
            }

        }
        return balance == 0 && open <= asterik;

    }
}
