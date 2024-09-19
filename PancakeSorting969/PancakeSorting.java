package PancakeSorting969;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
    public List<Integer> pancakeSort(int[] arr) {
        var val = arr.length;
        var flips = new ArrayList<Integer>();
        while (val > 0) {
            for (var i = 0; i < arr.length; i++) {
                if (arr[i] == val) {
                    if (i != (val - 1)) {
                        this._reverse(arr, i);
                        flips.add(i + 1);
                        this._reverse(arr, val - 1);
                        flips.add(val);
                    }
                    val--;
                }
            }
        }
        return flips;
    }

    private void _reverse(int[] array, int i) {
        var l = 0;
        var r = i;
        while (l < r) {
            var ref = array[r];
            array[r] = array[l];
            array[l] = ref;
            l++;
            r--;
        }
    }
}
