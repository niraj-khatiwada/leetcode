package Permutations46;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        for (var i = 0; i < nums.length; i++) {
            this._permute(nums, i, 1, new ArrayList<Integer>(), rs);
        }
        ;
        return rs;
    }

    private void _permute(int[] nums, int i, int c, List<Integer> path, List<List<Integer>> rs) {
        if (i >= nums.length) {
            return;
        }

        path.add(nums[i]);
        if (c == nums.length) {
            rs.add(new ArrayList<>(path));
            return;
        }

        for (var j = 0; j < nums.length; j++) {
            if (!path.contains(nums[j])) {
                _permute(nums, j, c + 1, new ArrayList<>(path), rs);
            }
        }
    }
}
