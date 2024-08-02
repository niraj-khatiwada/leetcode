package FindSingleNumber136;

// EASY
public class FindSingleNumber {
    // If you do XOR of a number with same number, it will be 0.
    // If you do XOR of a number with 0, it will be the same number
    public int singleNumber(int[] nums) {
        var single = 0;
        for (var n : nums) {
            single = single ^ n;
        }
        return single;
    }
}