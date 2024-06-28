class Solution {
    public int numRookCaptures(char[][] board) {
        int m = board.length, n = board[0].length;
        int x = 0, y = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        int ans = 0;
        for (int[] d : new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}) {
            int nx = x + d[0], ny = y + d[1];
            while (0 <= nx && nx < m && 0 <= ny && ny < n) {
                if (board[nx][ny] != '.') {
                    if (board[nx][ny] == 'p') {
                        ans++;
                    }
                    break;
                }
                nx += d[0];
                ny += d[1];
            }
        }
        return ans;
    }
}