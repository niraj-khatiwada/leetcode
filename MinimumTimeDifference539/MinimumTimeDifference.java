package MinimumTimeDifference539;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
    // O(nlog(n))
    public int findMinDifference(List<String> timePoints) {
        var minutes = new int[timePoints.size()];
        for (var i = 0; i < timePoints.size(); i++) {
            String[] splitted = timePoints.get(i).split(":");
            minutes[i] = Integer.parseInt(splitted[0]) * 60 + Integer.parseInt(splitted[1]);
        }
        Arrays.sort(minutes);
        var min = Integer.MAX_VALUE;
        for (var i = 0; i < minutes.length; i++) {
            if ((i + 1) < minutes.length) {
                var minDiff = Math.min(Math.abs(minutes[i + 1] - minutes[i]),
                        Math.abs(minutes[i + 1] - (minutes[i] + 24 * 60)));
                min = Math.min(min, minDiff);
                if (min == 0) {
                    return 0;
                }
            }
            if ((i + 1) < minutes.length && (i + 1) != (minutes.length - 1)) {
                var minDiff = Math.min(Math.abs(minutes[minutes.length - 1] - minutes[i]),
                        Math.abs(minutes[minutes.length - 1] - (minutes[i] + 24 * 60)));
                min = Math.min(min, minDiff);
                if (min == 0) {
                    return 0;
                }
            }
        }
        return min;
    }
}