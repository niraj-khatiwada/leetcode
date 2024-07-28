package TwoSumII167;

// Medium
// Two Sum but without using O(1) extra space meaning no hasmap to store index beforehand like in Two Sum easy solution

// Time Complexity: O(n)
// Extra space: O(1).
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        var l = 0;
        var r = numbers.length - 1;
        while (true) {
            if ((numbers[l] + numbers[r]) == target) {
                return new int[] { l + 1, r + 1 };
            }
            if ((target - numbers[l]) > numbers[r]) {
                l++;
            }
            if ((target - numbers[r]) < numbers[l]) {
                r--;
            }
            if (l >= r) {
                break;
            }
        }
        return new int[] {};
    }
}
