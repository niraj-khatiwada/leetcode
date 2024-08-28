import java.util.*;

import MaximumProfitInJobScheduling1235.MaximumProfitInJobScheduling;

public class Main {
        public static void main(String[] args) {
                var job = new MaximumProfitInJobScheduling();
                System.out.println(job.jobScheduling(new int[] { 4, 2, 4, 8, 2 }, new int[] { 5, 5, 5, 10, 8 },
                                new int[] { 1, 2, 8, 10, 4 }));
        }

}
