import java.util.*;

import NumberOfProvinces547.NumberOfProvinces;

public class Main {
        public static void main(String[] args) {
                var ds = new NumberOfProvinces();
                System.out.println(ds.findCircleNum(
                                new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));
        }

}
