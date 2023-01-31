class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == j || i == n - j - 1) && grid[i][j] == 0) {
                    return false;
                }
                if ((i != j && i != n - j - 1) && grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
