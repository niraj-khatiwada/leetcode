package SearchInRotatedSortedArray33;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        var first = 0;
        var last = nums.length - 1;
        var second = -1;
        var third = -1;

        var slow = 0;
        var fast = 1;

        while (slow != fast) {
            if (nums[slow] == target) {
                return slow;
            }
            if (nums[fast] == target) {
                return fast;
            }
            if ((nums[fast] - nums[slow]) < 0) {
                for (var i = fast; i > slow; i--) {
                    if (nums[i] == target) {
                        return i;
                    }
                    if ((nums[i] - nums[i - 1]) < 0) {
                        second = i - 1;
                        third = i;
                    }
                }
                break;
            }
            if (fast == (nums.length - 1)) {
                break;
            }
            slow++;
            fast++;
            if (fast != (nums.length - 1)) {
                fast++;
            }
        }

        if (second == -1 && third == -1) {
            return this._binarySearch(nums, first, last, target);
        }

        if (target >= nums[first] && target <= nums[second]) {
            return this._binarySearch(nums, first, second, target);
        } else if (target >= nums[third] && target <= nums[last]) {
            return this._binarySearch(nums, third, last, target);
        }
        return -1;
    }

    private int _binarySearch(int[] array, int l, int r, int target) {
        while (r >= l) {
            var m = (r + l) / 2;
            if (array[m] == target) {
                return m;
            } else if (array[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
