package TwoSum1;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] list = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(list, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (map.containsKey(value)) {
                result[0] = map.get(value);
                result[1] = i;
                break;
            }
            map.put(target - value, i);
        }
        return result;
    }

}