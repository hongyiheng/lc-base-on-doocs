class Solution {
    List<List<String>> ans;
    int n;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        this.n = n;
        boolean[][] g = new boolean[n][n];
        dfs(g, 0);
        return ans;
    }

    public void dfs(boolean[][] g, int x) {
        if (x == n) {
            List<String> item = new ArrayList<>();
            for (boolean[] row : g) {
                StringBuilder sb = new StringBuilder();
                for (boolean b : row) {
                    sb.append(b ? "Q" : ".");
                }
                item.add(sb.toString());
            }
            ans.add(item);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isValid(g, x, j)) {
                g[x][j] = true;
                dfs(g, x + 1);
                g[x][j] = false;
            }
        }
    }

    public boolean isValid(boolean[][] g, int x, int y) {
        int[][] dir = new int[][]{{-1, 1}, {-1, -1}, {-1, 0}};
        for (int [] d : dir) {
            int nx = x + d[0], ny = y + d[1];
            while (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (g[nx][ny]) {
                    return false;
                }
                nx += d[0];
                ny += d[1];
            }
        }
        return true;
    }
}