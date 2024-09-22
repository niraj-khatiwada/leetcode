package KthSmallestInLexicographicalOrder440;

public class KthSmallestInLexicographicalOrder {
    public long countOfNumbers(long first, long second, int n) {
        long steps = 0;

        while (first <= n) {
            steps = steps + (Math.min(n + 1, second) - first);
            first = first * 10;
            second = second * 10;
        }

        return steps;
    }

    public int findKthNumber(int n, int k) {
        int currentNumber = 1;
        k = k - 1;

        while (k > 0) {
            int steps = (int) countOfNumbers(currentNumber, currentNumber + 1, n);

            if (k < steps) {
                currentNumber = currentNumber * 10;
                k = k - 1;
            } else {
                currentNumber = currentNumber + 1;
                k = k - steps;
            }
        }

        return currentNumber;
    }
}
