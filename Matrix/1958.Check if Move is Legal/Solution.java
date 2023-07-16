class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int m = board.length, n = board[0].length;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        for (int[] d : dirs) {
            int nx = rMove + d[0], ny = cMove + d[1];
            boolean mid = false;
            while (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (board[nx][ny] == '.') {
                    break;
                }
                if (board[nx][ny] == color) {
                    if (mid) {
                        return true;
                    }
                    break;
                } else {
                    mid = true;
                }
                nx += d[0];
                ny += d[1];
            }
        }
        return false;
    }
}