package FindMissingObservations2028;

public class FindMissingObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        var mSum = 0;
        for (var roll : rolls) {
            mSum += roll;
        }
        var nSum = (mean * (rolls.length + n)) - mSum;
        if (n > nSum || (n * 6) < nSum) {
            return new int[0];
        }
        var rs = new int[n];
        var c = 0;
        while (n > 0 && ((nSum / n) <= 6)) {
            for (var i = 6; i >= 0; i--) {
                if ((nSum - i) >= (n - 1)) {
                    rs[c] = i;
                    c++;
                    nSum -= i;
                    n--;
                    break;
                }
            }
            if (n == 0 && nSum == 0) {
                return rs;
            }
        }
        return new int[0];
    }
}