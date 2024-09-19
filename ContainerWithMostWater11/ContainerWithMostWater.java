package ContainerWithMostWater11;

import java.util.Arrays;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        var matrix = new int[height.length][2];
        for (var i = 0; i < height.length; i++) {
            matrix[i][0] = i;
            matrix[i][1] = height[i];
        }
        Arrays.sort(matrix, (a, b) -> (b[0] - a[0]) * Math.min(a[1], b[1]));
        print(matrix);
        return (matrix[1][0] - matrix[0][0] * Math.min(matrix[1][1], matrix[0][1]));
    }

    public void print(int[][] board) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++)
                System.out.print(board[x][y] + " ");
            System.out.println();
        }
    }
}
