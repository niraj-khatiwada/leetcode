package FindTheStudentThatWillReplaceTheChalk1894;

public class ChalkReplacer {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (var i = 0; i < chalk.length; i++) {
            sum = (sum + chalk[i]);
        }
        k = (int) (k % sum);
        var p = 0;
        while (true) {
            if (k < chalk[p]) {
                return p;
            }
            k -= chalk[p];
            p++;
            if (p >= chalk.length) {
                p = 0;
            }
        }
    }
}