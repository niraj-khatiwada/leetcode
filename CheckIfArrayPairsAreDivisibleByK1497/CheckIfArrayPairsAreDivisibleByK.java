package CheckIfArrayPairsAreDivisibleByK1497;

import java.util.*;

public class CheckIfArrayPairsAreDivisibleByK {
    public boolean canArrange(int[] arr, int k) {
        int[] remFreq = new int[k];

        for (int num : arr) {
            int rem = ((num % k) + k) % k;
            remFreq[rem]++;
        }

        if (remFreq[0] % 2 != 0) {
            return false;
        }

        for (int i = 1; i < k; i++) {
            if (remFreq[i] != remFreq[k - i]) {
                return false;
            }
        }
        return true;
    }

}