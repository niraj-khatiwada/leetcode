import java.util.*;

import IslandsAndTreasures.IslandAndTreasures;

public class Main {
    public static void main(String[] args) {
        var island = new IslandAndTreasures();

        var grid = new int[][] {
                { 2147483647, 2147483647, 2147483647 },
                { 2147483647, -1, 2147483647 },
                { 0, 2147483647, 2147483647 },
        };

        island.islandsAndTreasure(grid);

        // for (var i = 0; i < grid.length; i++) {
        // System.out.println(Arrays.toString(grid[i]));
        // }
    }

}
