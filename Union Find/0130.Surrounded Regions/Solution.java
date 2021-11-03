class Solution {
    int[] p;
    boolean[] border;
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        p = new int[m * n];
        border = new boolean[m * n];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 'O') {
                    continue;
                }
                int index = i * n + j;
                if (i < m - 1 && board[i + 1][j] == 'O') {
                    union(index, index + n);
                }
                if (j < n - 1 && board[i][j + 1] == 'O') {
                    union(index, index + 1);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    border[find(i * n + j)] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && border[find(i * n + j)] == false) {
                   board[i][j] = 'X';
                }
            }
        }
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private void union(int i1, int i2) {
        int r1 = find(i1);
        int r2 = find(i2);
        if (r1 != r2) {
            p[r1] = r2;
        }
    }
}