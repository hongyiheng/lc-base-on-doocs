class Solution {

    int[] p;

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public void union(int a, int b) {
        p[find(a)] = find(b);
    }

    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        p = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 'X') {
                    continue;
                }
                if (i > 0 && board[i - 1][j] == 'X') {
                    union(i * n + j, (i - 1) * n + j);
                }
                if (j > 0 && board[i][j - 1] == 'X') {
                    union(i * n + j, i * n + j - 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' && p[i * n + j] == i * n + j) {
                    ans++;
                }
            }
        }
        return ans;
    }
}