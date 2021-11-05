class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    infect(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void infect(char[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1 || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 'L';
        infect(grid, i + 1, j);
        infect(grid, i - 1, j);
        infect(grid, i, j + 1);
        infect(grid, i, j - 1);
    }

}