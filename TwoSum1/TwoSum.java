package TwoSum1;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        var map = new HashMap<Integer, Integer>();
        for (var j = 0; j < nums.length; j++) {
            map.put(nums[j], j);
        }

        for (var i = 0; i < nums.length; i++) {
            var valueInMap = map.get((target - nums[i]));
            if (valueInMap != null && valueInMap != i) {
                return new int[] { i, valueInMap };
            }
        }

        return new int[] { -1, -1 };
    }
}
