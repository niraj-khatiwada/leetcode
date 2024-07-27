
import java.util.ArrayList;
import java.util.Arrays;

import TopKFrequentElements347.TopKFrequentElements;

public class Main {
    public static void main(String[] args) {

        var a = new TopKFrequentElements();

        var result = a.topKFrequent(new int[] { 1, 2 }, 2);

        System.out.println(Arrays.toString(result));

    }

}
