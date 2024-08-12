import java.util.*;

import RottingOranges994.RottingOranges994;

public class Main {
    public static void main(String[] args) {
        var s1 = new HashSet<Integer>();
        var s2 = new HashSet<Integer>();
        s1.add(1);
        s1.add(2);

        s2.add(2);
        s2.add(3);

        System.out.println(s2.retainAll(s1));
    }

}
