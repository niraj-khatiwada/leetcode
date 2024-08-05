package ValidParenthesis20;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        var stack = new Stack<Character>();

        for (var ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.add(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                var p = stack.pop();
                if ((ch == ')' && p != '(') || (ch == '}' && p != '{') || (ch == ']' && p != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }
}