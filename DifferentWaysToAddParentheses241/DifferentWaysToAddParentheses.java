package DifferentWaysToAddParentheses241;

import java.util.*;

public class DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String expression) {
        var rs = new ArrayList<Integer>();
        for (var i = 0; i < expression.length(); i++) {
            var val = expression.substring(i, i + 1);
            if (val.equals("*") || val.equals("+") || val.equals("-")) {
                var left = diffWaysToCompute(expression.substring(0, i));
                var right = diffWaysToCompute(expression.substring(i + 1));
                System.out.printf("%s %s\n", left, right);
                for (var li : left) {
                    for (var ri : right) {
                        if (val.equals("*")) {
                            rs.add(li * ri);
                        } else if (val.equals("+")) {
                            rs.add(li + ri);
                        } else {
                            rs.add(li - ri);
                        }
                    }
                }
            }
        }
        if (rs.size() == 0 && expression.length() != 0) {
            rs.add(Integer.parseInt(expression));
        }
        return rs;
    }
}