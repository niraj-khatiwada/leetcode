public class PlusOne {
    public int[] plusOne(int[] digits) {
        var rem = 0;
        for (var i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                rem = 1;
            } else {
                if (i == (digits.length - 1)) {
                    digits[i] = digits[i] + 1;
                    return digits;
                } else {
                    if (rem != 0) {
                        digits[i] = digits[i] + rem;
                        rem = 0;
                        return digits;
                    }
                }
            }
        }
        var array = new int[digits.length + 1];
        array[0] = 1;
        return array;

    }
}