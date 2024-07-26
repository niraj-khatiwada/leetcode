package ValidAnagram242;

import java.util.HashMap;

public class ValidAnagram {
    // Using HashMap
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        var map = new HashMap<Character, Integer>();

        for (var character : s.toCharArray()) {
            var count = map.get(character);
            map.put(character, (count == null ? 0 : count) + 1);
        }

        for (var character : t.toCharArray()) {
            var count = map.get(character);
            if (count == null) {
                return false;
            }
            var newCount = count - 1;
            if (newCount == 0) {
                map.remove(character);
            } else {
                map.put(character, newCount);
            }
        }

        return map.size() == 0;
    }

    // Using array index
    // Only supports Unicode
    public boolean isAnagramUsingArrayIndex(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        var array = new int[255];

        for (var character : s.toCharArray()) {
            int unicodeInt = character - 0;
            array[unicodeInt]++;
        }

        for (var character : t.toCharArray()) {
            int unicodeInt = character - 0;
            array[unicodeInt]--;
        }

        for (var item : array) {
            if (item != 0) {
                return false;
            }
        }

        return true;
    }

}
