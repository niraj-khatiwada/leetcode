package DefuseTheBomb1652;

public class DefuseTheBomb {
    // O(n)
    public int[] decrypt(int[] code, int k) {
        var rs = new int[code.length];
        if (k > 0) {
            for (var i = 0; i < code.length; i++) {
                var sum = 0;
                for (var j = 1; j <= k; j++) {
                    sum += code[(i + j) % code.length];
                }
                rs[i] = sum;
            }
        } else if (k < 0) {
            for (var i = 0; i < code.length; i++) {
                var sum = 0;
                for (var j = 1; j <= (k * -1); j++) {
                    sum += code[(i - j) < 0 ? (code.length + (i - j)) : (i - j)];
                }
                rs[i] = sum;
            }
        }
        return rs;
    }
}
