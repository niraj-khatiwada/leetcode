package LongestConsequitiveSequence128;

import java.util.HashSet;

// Medium - Hard
public class LongestConsecutiveSequence {

    // This logic tells to just go forward to find consecutive
    // O(n)
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        var set = new HashSet<Integer>();
        for (var n : nums) {
            set.add(n);
        }

        var cc = 1;
        var maxCC = 1;
        for (var num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            // Consecutive starts;
            var current = num;
            while (true) {
                if (set.contains(current + 1)) {
                    cc++;
                    current++;
                } else {
                    break;
                }
            }
            if (cc > maxCC) {
                maxCC = cc;
            }
            cc = 1;
            if (maxCC > nums.length / 2) {
                break;
            }
        }
        return maxCC;

    }

    // This logic goes backward and forward to find consecutives
    // O(n)
    // So the logic here is, we take the number and see if (n - 1) exists or not.
    // If yes, we go down the subtraction way until the number does not exist.
    // After that, we come back to original value and start the (n + 1) way and keep
    // going until the number exist.
    // We track the consecutive count number and return the max count value.
    // This approach is a little bit difficult to understand and requires extra
    // `used` set to keep track of used value.
    public int longestConsecutiveMethod2(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        var set = new HashSet<Integer>();
        var used = new HashSet<Integer>();

        for (var n : nums) {
            set.add(n);
        }

        var currentIndex = 0;
        var current = nums[currentIndex];
        var cc = 1;
        var maxCC = 1;
        Integer parent = null;
        while (currentIndex < nums.length) {
            used.add(current);
            if (set.contains(current - 1) && !used.contains(current - 1)) {
                if (parent == null) {
                    parent = current;
                }
                current -= 1;
                cc++;
                continue;
            }

            if (parent != null) {
                current = parent;
                parent = null;
            }

            if (set.contains(current + 1) && !used.contains(current + 1)) {
                current += 1;
                cc++;
                continue;
            }

            currentIndex++;
            if (currentIndex > (nums.length - 1)) {
                break;
            }
            current = nums[currentIndex];
            if (cc > maxCC) {
                maxCC = cc;
            }
            cc = 1;
            // If the max count is already greater than half of the array, there's no point
            // is checking other consecutive since this will be the highest length anyway.
            if (maxCC > (nums.length / 2)) {
                break;
            }
        }
        return maxCC;
    }
}
