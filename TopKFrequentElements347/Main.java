package TopKFrequentElements347;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        int[] l = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(topKFrequent(l, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (var num : nums) {
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }
        List<Integer>[] indexMapper = new ArrayList[nums.length + 1];
        for (var entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            var listAtIndex = indexMapper[value];
            if (listAtIndex != null) {
                listAtIndex.add(key);
                indexMapper[value] = listAtIndex;
            } else {
                List<Integer> newList = new ArrayList<>(Arrays.asList(key));
                indexMapper[value] = newList;
            }
        }

        int[] result = new int[k];
        int count = 0;
        for (int i = indexMapper.length - 1; i > 0; i--) {
            var listAtIndex = indexMapper[i];
            if (listAtIndex != null) {
                var listSize = listAtIndex.size();
                for (int j = 0; j < listSize; j++) {
                    result[count] = listAtIndex.get(j);
                    count++;
                    if (count >= k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }


}