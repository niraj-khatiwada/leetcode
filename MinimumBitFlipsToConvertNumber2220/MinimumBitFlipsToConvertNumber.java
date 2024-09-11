package MinimumBitFlipsToConvertNumber2220;

public class MinimumBitFlipsToConvertNumber {
    public int minBitFlips(int start, int goal) {
        var min = 0;
        var xor = start ^ goal;
        while (xor != 0) {
            if ((xor & 1) != 0) {
                min++;
            }
            xor >>= 1;
        }
        return min;
    }
}