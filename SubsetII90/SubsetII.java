package SubsetII90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        Arrays.sort(nums);
        this._subsetsWithDup(nums, 0, new ArrayList<Integer>(), rs);
        return new ArrayList<>(rs);
    }

    public void _subsetsWithDup(int[] nums, int i, List<Integer> path, List<List<Integer>> rs) {
        if (i > nums.length) {
            return;
        }

        if (i == (nums.length)) {
            rs.add(path);
            return;
        }
        var c1 = new ArrayList<Integer>(path);
        c1.add(nums[i]);
        var c2 = new ArrayList<Integer>(path);
        _subsetsWithDup(nums, i + 1, c1, rs);
        while (i < (nums.length - 1) && nums[i + 1] == nums[i]) {
            i++;
        }
        _subsetsWithDup(nums, i + 1, c2, rs);
    }
}
