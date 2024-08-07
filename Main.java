import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[][] rs = new int[2][2];
        rs[0] = new int[] { 1, 2 };
        rs[1] = new int[] { 1, 3 };

        Arrays.sort(rs, (a, b) -> calculateDistance(a) - calculateDistance(b));

        for (var p : rs) {
            System.out.println(Arrays.toString(p));

        }
    }

    private static int calculateDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

}
