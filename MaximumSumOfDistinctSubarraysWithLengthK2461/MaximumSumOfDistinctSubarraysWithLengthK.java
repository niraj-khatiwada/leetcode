package MaximumSumOfDistinctSubarraysWithLengthK2461;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MaximumSumOfDistinctSubarraysWithLengthK {
    // O(n)
    public long maximumSubarraySum(int[] nums, int k) {
        var l = 0;
        var r = 0;
        var map = new HashMap<Integer, List<Integer>>();
        for (var i = 0; i < nums.length; i++) {
            var indices = map.get(nums[i]);
            if (indices == null) {
                indices = new ArrayList<Integer>();
                map.put(nums[i], indices);
            }
            indices.add(i);
        }
        var used = new HashSet<Integer>();
        used.add(nums[l]);
        long sum = nums[l];
        long max = 0;
        while (r < nums.length && (nums.length - l) >= k) {
            if ((r - l) == (k - 1)) {
                max = Math.max(max, sum);
                used.remove(nums[l]);
                sum -= nums[l];
                l++;
            } else {
                if ((r + 1) < nums.length && used.contains(nums[r + 1])) {
                    for (var index : map.get(nums[r + 1])) {
                        if (index >= l && index <= r) {
                            for (var i = l; i <= index; i++) {
                                used.remove(nums[i]);
                                sum -= nums[i];
                            }
                            l = index + 1;
                            break;
                        }
                    }
                }
                r++;
                if (r < nums.length) {
                    used.add(nums[r]);
                    sum += nums[r];
                }
            }

        }
        return max;
    }
}
