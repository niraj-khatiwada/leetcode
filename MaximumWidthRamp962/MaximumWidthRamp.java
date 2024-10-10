package MaximumWidthRamp962;

public class MaximumWidthRamp {
    public int maxWidthRamp(int[] nums) {
        var maxRight = new int[nums.length];
        maxRight[nums.length - 1] = nums[nums.length - 1];
        for (var i = nums.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(nums[i], maxRight[i + 1]);
        }
        var max = 0;
        var l = 0;
        var r = 1;
        while (l <= r && r < nums.length) {
            if (maxRight[r] >= nums[l]) {
                max = Math.max(max, r - l);
                r++;
            } else {
                l++;
            }
        }
        return max;
    }
}
