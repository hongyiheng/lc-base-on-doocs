class Solution {
    public int minimumOperations(int[][] grid) {
        int ans = 0;
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 1; i < grid.length; i++) {
                int pre = grid[i - 1][j], v = grid[i][j];
                if (pre >= v) {
                    ans += pre - v + 1;
                    grid[i][j] = pre + 1;
                }
            }
        }
        return ans;
    }
}