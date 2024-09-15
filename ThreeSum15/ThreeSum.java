package ThreeSum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        var used = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for (var i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            var target = nums[i] * -1;
            var l = i + 1;
            var r = nums.length - 1;
            while (l < r) {
                var sum = nums[l] + nums[r];
                if (sum == target) {
                    var list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    used.add(list);
                    l++;
                    r--;
                } else if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for (var itm : used) {
            list.add(itm);
        }
        return list;
    }
}
