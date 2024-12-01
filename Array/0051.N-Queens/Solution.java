class Solution {

    List<List<String>> ans = new ArrayList<>();
    boolean[][] g;
    int n;

    boolean check(boolean[][] g, int x, int y) {
        for (int[] d : new int[][]{{-1, 0}, {-1, -1}, {-1, 1}}) {
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

    void dfs(boolean[][] g, int x) {
        if (x >= n) {
            List<String> t = new ArrayList<>();
            for (boolean[] r : g) {
                StringBuilder sb = new StringBuilder();
                for (boolean v : r) {
                    sb.append(v ? "Q" : ".");
                }
                t.add(sb.toString());
            }
            ans.add(t);
            return;
        }
        for (int y = 0; y < n; y++) {
            if (!check(g, x, y)) {
                continue;
            }
            g[x][y] = true;
            dfs(g, x + 1);
            g[x][y] = false;
        }
    }

    public List<List<String>> solveNQueens(int n) {
        g = new boolean[n][n];
        this.n = n;
        dfs(g, 0);
        return ans;
    }
}