class Solution {
    String word;
    char[][] board;
    boolean[][] vis;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.board = board;
        vis = new boolean[board.length][board[0].length];
        char root = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == root) {
                    vis[i][j] = true;
                    if (dfs(new int[]{i, j}, 0)) {
                        return true;
                    }
                    vis[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean dfs(int[] cur, int nextIndex) {
        char c = word.charAt(nextIndex);
        if (board[cur[0]][cur[1]] != c) {
            return false;
        }
        if (nextIndex == word.length() - 1) {
            return true;
        }
        for (int[] d : dirs) {
            int nx = cur[0] + d[0], ny = cur[1] + d[1];
            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
                continue;
            }
            if (vis[nx][ny]) {
                continue;
            }
            vis[nx][ny] = true;
            if (dfs(new int[]{nx, ny}, nextIndex + 1)) {
                return true;
            }
            vis[nx][ny] = false;
        }
        return false;
    }
}