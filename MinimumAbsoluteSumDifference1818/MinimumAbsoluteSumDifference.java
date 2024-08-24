package MinimumAbsoluteSumDifference1818;

import java.util.Arrays;

public class MinimumAbsoluteSumDifference {
    class Solution {
        private static final int MOD = (int) 1e9 + 7;

        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            var nums1Copy = new int[nums1.length];
            // Space: O(n)
            for (var i = 0; i < nums1.length; i++) {
                nums1Copy[i] = nums1[i];
            }
            // n(log(n))
            Arrays.sort(nums1Copy);
            var sum = 0;
            var lastDelta = Integer.MAX_VALUE;
            // n(log(n))
            for (var i = 0; i < nums1.length; i++) {
                var abs = Math.abs(nums1[i] - nums2[i]);
                if (abs != 0) {
                    var closest = _findClosest(nums1Copy, nums2[i]);
                    var newAbs = Math.abs(closest - nums2[i]);
                    if (newAbs < abs) {
                        var newDelta = Math.abs(newAbs - abs);
                        if (newDelta > lastDelta) {
                            sum = (sum + lastDelta) % MOD;
                            lastDelta = newDelta;
                            sum = (sum + newAbs) % MOD;
                        } else {
                            if (lastDelta == Integer.MAX_VALUE) {
                                lastDelta = newDelta;
                                sum = (sum + newAbs) % MOD;
                            } else {
                                sum = (sum + abs) % MOD;
                            }
                        }
                    } else {
                        sum = (sum + abs) % MOD;
                    }
                }
            }
            return sum;
        }

        // log(n)
        private static int _findClosest(int[] nums, int t) {
            var l = 0;
            var r = nums.length - 1;
            var closest = nums[0];
            while (l <= r) {
                var m = (l + r) / 2;
                var itm = nums[m];
                if (itm == t) {
                    return t;
                } else if (t < itm) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
                if (Math.abs(itm - t) < Math.abs(closest - t)) {
                    closest = itm;
                }
            }
            return closest;
        }
    }

}
