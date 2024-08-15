package HappyNumber202;

import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {
        var set = new HashSet<Integer>();
        while (n != 0) {
            var sum = this.sumOfDigits(n);
            if (sum == 1) {
                return true;
            } else if (set.contains(sum)) {
                return false;
            }
            set.add(n);
            n = sum;
        }
        return false;
    }

    public int sumOfDigits(int num) {
        var sum = 0;
        while (num != 0) {
            sum += (int) Math.pow(num % 10, 2);
            num = num / 10;
        }
        return sum;
    }
}
