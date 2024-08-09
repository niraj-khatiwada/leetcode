package BinarySearch704;

public class BinarySearch {
    // log(n)
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = (r + l) / 2;
            var v = nums[m];
            if (v == target) {
                return m;
            }
            if (target > v) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
