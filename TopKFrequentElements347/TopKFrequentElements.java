package TopKFrequentElements347;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// MEDIUM

/*
 * K most frequent elements = k most repeated elements = for eg: 2 most repeated elements in [1, 2, 2] is [2, 1]. Order does not matter.
 */
public class TopKFrequentElements {
    // O(n)
    public int[] topKFrequent(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();

        var maxOccurrenceCount = 0;
        // O(n) n = length of array
        for (var num : nums) {
            var value = map.get(num);
            var nextCount = (value == null ? 0 : value) + 1;
            map.put(num, nextCount);
            if (nextCount > maxOccurrenceCount) {
                maxOccurrenceCount = nextCount;
            }
        }

        Set<Integer>[] array = new HashSet[maxOccurrenceCount + 1];
        // O(m) m = entries in map
        for (var entry : map.entrySet()) {
            var num = entry.getKey();
            var index = entry.getValue();
            var list = array[index] == null ? new HashSet<Integer>() : array[index];
            list.add(num);
            array[index] = list;
        }

        var result = new int[k];
        var currentIndex = 0;
        // O(o * k) ~ O(o) o = maxOccurrenceCount
        // If all values within the array is same, the maxOccurrence count = (n + 1).
        // For example, in [1,1,1,1] maxOccurrence = 4
        // So O(n + 1) ~ O(n)
        for (var i = (array.length - 1); i >= 0; i--) {
            if (array[i] != null) {
                for (var val : array[i]) {
                    if (currentIndex >= k) {
                        return result;
                    }
                    result[currentIndex] = val;
                    currentIndex++;
                }
            }
        }

        return result;
    }
}
