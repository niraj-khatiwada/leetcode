package FloodFill733;

public class FloodFill {
    // O(image.length - image[0].length)
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        var originalColor = image[sr][sc];
        if (originalColor == color) {
            return image;
        }
        this._dfs(image, sr, sc, originalColor, color);
        return image;
    }

    private void _dfs(int[][] image, int sr, int sc, int originalColor, int color) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != originalColor) {
            return;
        }
        image[sr][sc] = color;
        var dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (var d : dir) {
            this._dfs(image, sr + d[0], sc + d[1], originalColor, color);
        }
    }
}
