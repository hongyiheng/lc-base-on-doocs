class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        k %= (m * n);
        List<List<Integer>> ans = new ArrayList<>();
        int cur = k == 0 ? 0 : m * n - k;
        while (ans.size() < m) {
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = cur / n, y = cur % n;
                row.add(grid[x][y]);
                if (++cur == m * n) {
                    cur = 0;
                }
            }
            ans.add(row);
        }
        return ans;
    }
}