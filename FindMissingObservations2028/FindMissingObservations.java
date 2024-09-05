package FindMissingObservations2028;

public class FindMissingObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        var mSum = 0;
        for (var roll : rolls) {
            mSum += roll;
        }
        var nSum = (mean * (rolls.length + n)) - mSum;
        if (nSum < n || ((double) nSum / n) > 6.0) {
            return new int[0];
        }
        var rs = new int[n];
        var c = 0;
        while (n > 0 && ((nSum / n) <= 6)) {
            for (var i = 6; i >= 0; i--) {
                int maxRoll = nSum / n;
                if (i <= maxRoll) {
                    rs[c] = i;
                    c++;
                    nSum -= i;
                    n--;
                    if (n == 0 && nSum == 0) {
                        return rs;
                    }
                    break;
                }
            }
        }
        return new int[0];
    }
}