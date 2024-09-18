package LargestNumber179;

import java.util.ArrayList;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        var list = new ArrayList<Integer>();
        for (var num : nums) {
            list.add(num);
        }
        list.sort((a, b) -> (b + "" + a).compareTo(a + "" + b));
        var rs = new StringBuilder();
        for (var l : list) {
            rs.append(l);
        }
        while (rs.length() > 1 && rs.charAt(0) == '0') {
            rs.deleteCharAt(0);
        }
        return rs.toString();
    }
}