package MinimumSizeSubarraySum209;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        var sum = 0;
        var min = Integer.MAX_VALUE;
        int l = 0, r = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= target) {
                min = Math.min(r - l + 1, min);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
