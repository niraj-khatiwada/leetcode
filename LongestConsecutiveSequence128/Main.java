package LongestConsecutiveSequence128;


import java.util.HashSet;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        int[] list = {1};
        System.out.println(longestConsecutive(list));

    }

    // O(n) | 22ms
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (var n : nums) set.add(n);
        int maxLength = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 1;
                while (set.contains(num + count)) {
                    count++;
                }
                maxLength = Math.max(maxLength, count);
            }
            if (maxLength > nums.length / 2)
                break; // If the maxLength is already greater than half the array, we don't need to check the rest since it is never going to be greater than maxLength.

        }
        return maxLength;


        // The priority method I did.
        // O(n) | 96ms
//        Set<Integer> set = new HashSet<>();
//        Queue<Integer> queue = new PriorityQueue<>();
//        for (var num : nums) {
//            if (!set.contains(num)) {
//                queue.add(num);
//                set.add(num);
//            }
//        }
//        int[] sorted = new int[queue.size()];
//        int size = queue.size();
//        for (int i = 0; i < size; i++) {
//            sorted[i] = queue.remove();
//        }
//        int maxLength = 0;
//        int count = 0;
//        for (int i = 0; i < sorted.length; i++) {
//            if (i == 0) {
//                count++;
//            } else {
//                var value = sorted[i];
//                if (value - sorted[i - 1] == 1) {
//                    count++;
//                } else {
//                    maxLength = Math.max(maxLength, count);
//                    count = 1;
//                }
//            }
//        }
//        maxLength = Math.max(maxLength, count);
//        return maxLength;
    }


}