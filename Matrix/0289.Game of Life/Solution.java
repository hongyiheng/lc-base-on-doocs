class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] temp = new int[m + 2][n + 2];
        for (int i = 0; i < m + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                if (i == 0 || i == m + 1 || j == 0 || j == n + 1) {
                    temp[i][j] = 0;
                } else {
                    temp[i][j] = board[i - 1][j - 1];
                }
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int live = 0;
                live += temp[i - 1][j - 1] + temp[i - 1][j] + temp[i - 1][j + 1]
                        + temp[i][j - 1] + temp[i][j + 1]
                        + temp[i + 1][j - 1] + temp[i + 1][j] + temp[i + 1][j + 1];
                if (live < 2 || live > 3) {
                    board[i - 1][j - 1] = 0;
                }
                if (live == 3) {
                    board[i - 1][j - 1] = 1;
                }
            }
        }
    }
}