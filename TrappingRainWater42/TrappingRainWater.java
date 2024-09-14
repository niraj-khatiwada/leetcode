package TrappingRainWater42;

public class TrappingRainWater {
    public int trap(int[] height) {
        var n = height.length;
        var boundaryLeft = new int[n];
        var boundaryRight = new int[n];

        for (var i = 0; i < n; i++) {
            boundaryLeft[i] = Math.max(i > 0 ? boundaryLeft[i - 1] : 0, height[i]);
        }

        for (var i = n - 1; i >= 0; i--) {
            boundaryRight[i] = Math.max(i < (n - 1) ? boundaryRight[i + 1] : 0, height[i]);
        }

        var trapped = 0;
        for (var i = 0; i < n; i++) {
            trapped += Math.min(boundaryLeft[i], boundaryRight[i]) - height[i];
        }
        return trapped;
    }
}