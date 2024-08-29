import java.util.*;

import MaximumProfitInJobScheduling1235.MaximumProfitInJobScheduling;

public class Main {
        public static void main(String[] args) {
                var job = new MaximumProfitInJobScheduling();
                System.out.println(job.jobScheduling(new int[] { 1, 2, 3, 3 }, new int[] { 3, 4, 5, 6 },
                                new int[] { 50, 10, 40, 70 }));
        }

}
