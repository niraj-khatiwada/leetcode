package HammingWeight191;

// Hamming Weight means count the number of set bits
// log(n)
public class HammingWeight {
    public int hammingWeight(int n) {
        var count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
