package HouseRobber198;

public class HouseRobber {
    public int rob(int[] nums) {
        int i1 = 0, i2 = 0;
        for (var i = 0; i < nums.length; i++) {
            var include = nums[i] + i1;
            var exclude = i2;
            var max = Math.max(include, exclude);
            i1 = i2;
            i2 = max;
        }
        return i2;
    }
}