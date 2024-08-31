class Solution {
    public boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int cnt = grid[i][j] == 'W' ? 1 : 0;
                cnt += grid[i + 1][j] == 'W' ? 1 : 0;
                cnt += grid[i][j + 1] == 'W'  ? 1 : 0;
                cnt += grid[i + 1][j + 1] == 'W' ? 1 : 0;
                if (cnt >= 3 || cnt <= 1) {
                    return true;
                }
            }
        }
        return false;
    }
}