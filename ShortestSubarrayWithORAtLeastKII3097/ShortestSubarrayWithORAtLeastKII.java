package ShortestSubarrayWithORAtLeastKII3097;

public class ShortestSubarrayWithORAtLeastKII {
    public int minimumSubarrayLength(int[] nums, int k) {
        var min = Integer.MAX_VALUE;
        var bits = new int[32];
        int l = 0, r = 0;
        var sum = 0;
        while (r < nums.length) {
            sum = this._storeBits(bits, nums[r], false);
            if (sum >= k) {
                min = Math.min(min, r - l + 1);
                if (min == 1) {
                    return min;
                }
                // compression
                while (l <= r && this._storeBits(bits, nums[l], true) >= k) {
                    l++;
                    min = Math.min(min, r - l + 1);
                    if (min == 1) {
                        return min;
                    }
                }
                if (l <= r) {
                    this._storeBits(bits, nums[l], false); // rollback
                }
            }
            r++;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int _storeBits(int[] bits, int num, boolean remove) {
        var n = (int) (Math.log(num) / Math.log(2)) + 1;
        var i = 1;
        while (i <= n) {
            bits[32 - i] = bits[32 - i] + (remove ? -1 : 1) * (num & 1);
            num >>= 1;
            i++;
        }
        var rs = 0;
        for (var j = 31; j >= 0; j--) {
            if (bits[j] > 0) {
                rs |= (1 << (31 - j));
            }
        }
        return rs;
    }
}
