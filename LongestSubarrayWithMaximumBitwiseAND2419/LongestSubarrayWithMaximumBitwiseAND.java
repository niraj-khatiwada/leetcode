package LongestSubarrayWithMaximumBitwiseAND2419;

public class LongestSubarrayWithMaximumBitwiseAND {
    // O(n)
    public int longestSubarray(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        var maxVal = nums[0];
        var maxLen = 1;
        var len = 1;
        for (var i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                if (nums[i] == maxVal) {
                    len++;
                    if (len > maxLen) {
                        maxLen = len;
                    }
                }
            } else {
                if (nums[i] >= maxVal) {
                    if (nums[i] > maxVal) {
                        maxVal = nums[i];
                        maxLen = 1;
                    }
                    len = 1;
                }
            }
        }
        return maxLen;
    }
}