import java.util.*;

import CountSquaresSubmatricesWithAllOnes1277.CountSquaresSubmatricesWithAllOnes;

public class Main {
        public static void main(String[] args) {

                var c = new CountSquaresSubmatricesWithAllOnes();
                // c.countSquares(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 1, 1, 1
                // }, { 1, 1, 0 } });
                c.countSquares(new int[][] { { 0, 1, 1, 1 },
                                { 1, 1, 1, 1 },
                                { 0, 1, 1, 1 } });

        }

}
