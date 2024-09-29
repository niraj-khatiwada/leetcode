package AllOOneDataStructure432;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// NOTE: All operations run in O(log(n)) not in O(1)
public class AllOOneDataStructure {
    public TreeMap<Integer, Set<String>> sortedMap = new TreeMap<>();
    public Map<String, Integer> map = new HashMap<>();

    public void inc(String key) {
        var count = map.getOrDefault(key, 0) + 1;
        map.put(key, count);
        var set = sortedMap.get(count);
        if (set == null) {
            set = new HashSet<String>();
            sortedMap.put(count, set);
        }
        set.add(key);
        if (count > 1) {
            var prevSet = sortedMap.get(count - 1);
            if (prevSet.size() == 1) {
                sortedMap.remove(count - 1);
            } else {
                prevSet.remove(key);
            }
        }
    }

    public void dec(String key) {
        var count = map.get(key);
        if (count == 1) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
        }
        if (count > 1) {
            var set = sortedMap.get(count - 1);
            if (set == null) {
                set = new HashSet<String>();
                sortedMap.put(count - 1, set);
            }
            set.add(key);
        }
        var prevSet = sortedMap.get(count);
        if (prevSet.size() == 1) {
            sortedMap.remove(count);
        } else {
            prevSet.remove(key);
        }
    }

    public String getMaxKey() {
        var max = sortedMap.lastEntry();
        if (max == null) {
            return "";
        }
        var it = max.getValue().iterator();
        return it.next();
    }

    public String getMinKey() {
        var min = sortedMap.firstEntry();
        if (min == null) {
            return "";
        }
        var it = min.getValue().iterator();
        return it.next();
    }
}
