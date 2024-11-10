import java.util.*;

import ShortestSubarrayWithSumAtLeastK862.ShortestSubarrayWithSumAtLeastK;

public class Main {
        public static void main(String[] args) {

                var s = new ShortestSubarrayWithSumAtLeastK();
                s.shortestSubarray((new int[] { 2, -1, 2 }), 3);

                var q = new ArrayDeque<Integer>();
                q.offer(1);
                q.offer(2);
                q.offer(3);
                System.out.println(q.peek());
        }

}
