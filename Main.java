
import GroupAnagrams49.GroupAnagrams;

public class Main {
    public static void main(String[] args) {
        var count = new int[26];
        count[25]++;
        count[0]++;
        System.out.println(count.toString());
        var d = new GroupAnagrams();

        d.groupAnagrams(new String[] { "act", "pots", "tops", "cat", "stop", "hat" });

    }

}

// [I@7344699f