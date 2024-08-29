import java.util.*;

import MostStonesRemoved947.MostStonesRemoved;

public class Main {
        public static void main(String[] args) {
                var ds = new MostStonesRemoved();
                System.out.println(ds.removeStones(
                                new int[][] { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 2, 2 } }));
        }

}
