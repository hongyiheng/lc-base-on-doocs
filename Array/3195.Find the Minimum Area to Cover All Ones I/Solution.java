class Solution {
    public int minimumArea(int[][] grid) {
        int t = 1010, l = 1010;
        int b = 0, r = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j  = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                t = Math.min(t, i);
                l = Math.min(l, j);
                b = Math.max(b, i);
                r = Math.max(r, j);
            }
        }
        return (b - t + 1) * (r - l + 1);
    }
}