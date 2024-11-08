package MaximumXORForEachQuery1829;

public class MaximumXORForEachQuery {
    // O(n)
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        var xor = new int[nums.length];
        xor[0] = nums[0];
        for (var i = 1; i < nums.length; i++) {
            xor[i] = xor[i - 1] ^ nums[i];
        }
        var maxBit = 1;
        for (var i = 0; i < (maximumBit - 1); i++) {
            maxBit = (maxBit << 1) | 1;
        }
        for (var i = nums.length - 1; i >= 0; i--) {
            nums[nums.length - i - 1] = maxBit ^ xor[i];
        }
        return nums;
    }
}