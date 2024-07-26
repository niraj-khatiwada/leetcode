package ContainsDuplicate217;

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        var set = new HashSet<Integer>();

        for (var num : nums) {
            var isNew = set.add(num);
            if (!isNew) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}
