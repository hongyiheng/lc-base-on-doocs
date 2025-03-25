class Solution {

    int[][] grid;
    int[][] ans;
    int m, n;

    public Set<Integer> dfs(int x, int y, Set<Integer> pre) {
        if (x == m - 1 || y == n - 1) {
            ans[x][y] = pre.size();
            Set<Integer> res = new HashSet<>();
            res.add(grid[x][y]);
            return res;
        }
        int tmp = pre.size();
        pre.add(grid[x][y]);
        Set<Integer> suf = dfs(x + 1, y + 1, pre);
        ans[x][y] = Math.abs(tmp - suf.size());
        suf.add(grid[x][y]);
        return suf;
    }

    public int[][] differenceOfDistinctValues(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, new HashSet<>());
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, new HashSet<>());
        }
        return ans;
    }
}