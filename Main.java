import java.util.*;

import FindMissingObservations2028.FindMissingObservations;

public class Main {
        public static void main(String[] args) {
                var missing = new FindMissingObservations();
                for (var i : missing.missingRolls(new int[] { 1, 3, 6, 4, 1, 2, 1, 5, 5, 4 }, 20, 10)) {
                        System.out.println(i);
                }
        }

}
