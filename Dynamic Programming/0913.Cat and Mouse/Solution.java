class Solution {
    int N = 51;
    int[][][] f = new int[2 * N][N][N];
    int n;
    int[][] graph;
    public int catMouseGame(int[][] graph) {
        this.graph = graph;
        n = graph.length;
        for (int k = 0; k <= 2 * n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    f[k][i][j] = -1;
                }
            }
        }
        return dfs(0, 1, 2);
    }

    public int dfs(int k, int mouse, int cat) {
        int ans = f[k][mouse][cat];
        if (ans != -1) {
            return ans;
        }
        if (mouse == 0) {
            f[k][mouse][cat] = 1;
            return 1;
        } else if (mouse == cat) {
            f[k][mouse][cat] = 2;
            return 2;
        } else if (k >= 2 * n) {
            f[k][mouse][cat] = 0;
            return 0;
        }
        if (k % 2 == 0) {
            boolean win = false, draw = false;
            for (int cur : graph[mouse]) {
                int t = dfs(k + 1, cur, cat);
                if (t == 1) {
                    win = true;
                    break;
                }
                if (t == 0) {
                    draw = true;
                }
            }
            if (win) {
                ans = 1;
            } else if (draw) {
                ans = 0;
            } else {
                ans = 2;
            }
        } else {
            boolean win = false, draw = false;
            for (int cur : graph[cat]) {
                if (cur == 0) {
                    continue;
                }
                int t = dfs(k + 1, mouse, cur);
                if (t == 2) {
                    win = true;
                    break;
                }
                if (t == 0) {
                    draw = true;
                }
            }
            if (win) {
                ans = 2;
            } else if (draw) {
                ans = 0;
            } else {
                ans = 1;
            }
        }
        f[k][mouse][cat] = ans;
        return ans;
    }
}