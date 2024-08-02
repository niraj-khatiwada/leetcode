package ReverseBits190;

public class ReverseBits {
    // 00000000000000000000000000010101
    public int reverseBits(int n) {
        var reversed = 0;
        for (var i = 0; i < 32; i++) {
            var bit = ((n & 1) == 0) ? 0 : 1;
            reversed = (reversed << 1) | bit;
            n = n >> 1;
        }
        return reversed;
    }
}
