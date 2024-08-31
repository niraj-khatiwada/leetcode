import java.util.*;

import PathWithMaximumProbability1514.PathWithMaximumProbability;;

public class Main {
        public static void main(String[] args) {
                var ds = new PathWithMaximumProbability();
                System.out.println(ds.maxProbability(5, new int[][] { { 2, 3 }, { 1, 2 }, { 3, 4 }, { 1, 3 }, { 1, 4 },
                                { 0, 1 }, { 2, 4 }, { 0, 4 }, { 0, 2 } },
                                new double[] { 0.06, 0.26, 0.49, 0.25, 0.2, 0.64, 0.23, 0.21, 0.77 }, 0, 3));
        }

}
