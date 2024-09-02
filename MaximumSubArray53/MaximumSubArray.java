package MaximumSubArray53;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        var prefix = nums[0];
        var max = nums[0];
        for (var i = 1; i < nums.length; i++) {
            if (prefix < 0) {
                prefix = 0;
            }
            prefix += nums[i];
            max = Math.max(max, prefix);
        }
        return max;
    }
}
