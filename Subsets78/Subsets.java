package Subsets78;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        this._subsets(nums, 0, new ArrayList<Integer>(), rs);
        return rs;
    }

    private void _subsets(int[] nums, int i, List<Integer> store, List<List<Integer>> rs) {
        if (i >= nums.length) {
            rs.add(store);
            return;
        }

        var storeCopy1 = new ArrayList<Integer>(store);
        var storeCopy2 = new ArrayList<Integer>(store);
        storeCopy1.add(nums[i]);
        _subsets(nums, i + 1, storeCopy1, rs);
        _subsets(nums, i + 1, storeCopy2, rs);
    }
}
