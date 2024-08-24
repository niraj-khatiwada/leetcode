package MaximumUnitsOnTruck1710;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnitsOnTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(x -> x[1]));
        var max = 0;
        for (var i = boxTypes.length - 1; i >= 0; i--) {
            var item = boxTypes[i];
            if (truckSize >= item[0]) {
                max += item[0] * item[1];
                truckSize -= item[0];
            } else {
                max += truckSize * item[1];
                truckSize = 0;
                break;
            }
        }
        return max;
    }
}
