package AnagramGrouping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[] anagrams = {"eat", "tea", "tan", "ate", "nat", "bat", "eat"};
        System.out.println(groupAnagrams(anagrams));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        if (strs.length <= 1) {
            result.add(List.of(strs));
            return result;
        }
        HashMap<String, List<String>> map = new HashMap<>();

        for (var word : strs) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            var key = new String(charArray);
            var list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();
            list.add(word);
            map.put(key, list);
        }
        for (var entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}


