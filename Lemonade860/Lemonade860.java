package Lemonade860;

public class Lemonade860 {
    public boolean lemonadeChange(int[] bills) {
        var bill5 = 0;
        var bill10 = 0;
        var bill20 = 0;
        for (var bill : bills) {
            if (bill == 5) {
                bill5++;
            } else if (bill == 10) {
                if (bill5 == 0) {
                    return false;
                }
                bill5--;
                bill10++;
            } else {
                if (bill10 == 0) {
                    if (bill5 < 3) {
                        return false;
                    } else {
                        bill5 -= 3;
                    }
                } else {
                    if (bill5 == 0) {
                        return false;
                    }
                    bill5--;
                    bill10--;
                }
                bill20++;
            }
        }
        return true;
    }
}
