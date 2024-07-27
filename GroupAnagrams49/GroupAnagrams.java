package GroupAnagrams49;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

// MEDIUM
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        List<List<String>> list = new ArrayList<>();

        if (strs.length <= 1) {
            var l = new ArrayList<String>();
            if (strs.length == 1) {
                l.add(strs[0]);
                list.add(l);
            }
            return list;

        }
        for (var str : strs) {
            var array = new char[26];
            for (var ch : str.toCharArray()) {
                array[ch - 'a']++;
            }
            String hash = new String(array);

            var value = map.get(hash);
            var _list = value == null ? new ArrayList<String>() : value;
            _list.add(str);
            map.put(hash, _list);
        }
        for (var entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }

}
