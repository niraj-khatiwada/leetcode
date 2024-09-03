package SumOfDigitsOfStringAfterConvert1945;

public class SumOfDigitsOfStringAfterConvert {
    public int getLucky(String s, int k) {
        var str = new StringBuilder();
        for (var ch : s.toCharArray()) {
            str.append((ch - 'a' + 1) + "");
        }
        var sum = 0;
        for (var i = 0; i < k; i++) {
            sum = 0;
            for (var ch : str.toString().toCharArray()) {
                sum += (ch - 48);
            }
            str = new StringBuilder(sum + "");
        }
        return sum;
    }
}