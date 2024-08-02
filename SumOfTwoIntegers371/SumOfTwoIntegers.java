package SumOfTwoIntegers371;

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        var r = 0;
        var sum = 0;
        for (var i = 0; i < 32; i++) {
            var bitA = a & 1;
            var bitB = b & 1;
            var bit = 0;
            if ((bitA ^ bitB) == 1) {
                if (r == 1) {
                    bit = 0;
                    r = 1;
                } else {
                    bit = 1;
                    r = 0;
                }
            } else {
                bit = 0;
                if (bitA == 1) {
                    if (r == 1) {
                        bit = 1;
                    }
                    r = 1;
                }
                if (bitA == 0) {
                    if (r == 1) {
                        bit = 1;
                    }
                    r = 0;
                }
            }
            if (bit == 1) {
                sum |= (1 << i);
            }
            a = a >> 1;
            b = b >> 1;
        }
        return sum;
    }
}
