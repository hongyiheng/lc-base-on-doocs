class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        for (int j = 0; j < n; j++) {
            boolean win = true;
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == 1) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return j;
            }
        }
        return 0;
    }
}