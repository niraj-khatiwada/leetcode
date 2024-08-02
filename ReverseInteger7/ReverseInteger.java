package ReverseInteger7;

public class ReverseInteger {
    public int reverse(int x) {
        var r = 0;
        var sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        while (x != 0) {
            var rem = x % 10;
            // We need to check overflow before assigning
            if (r > (Integer.MAX_VALUE / 10) || (r > ((Integer.MAX_VALUE - rem) / 10))) {
                // Overflowed
                r = 0;
                break;
            }
            r = (r * 10) + rem;
            x /= 10;
        }
        return sign * r;
    }
}
