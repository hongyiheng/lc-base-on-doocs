class Solution {
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][][] cell = new boolean[3][3][9];
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int t = boarclass Solution {
                                    boolean[][] row = new boolean[9][9];
                                    boolean[][] col = new boolean[9][9];
                                    boolean[][][] cell = new boolean[3][3][9];
                                    public void solveSudoku(char[][] board) {
                                        for (int i = 0; i < 9; i++) {
                                            for (int j = 0; j < 9; j++) {
                                                if (board[i][j] != '.') {
                                                    int t = board[i][j] - '1';
                                                    row[i][t] = col[j][t] = cell[i / 3][j / 3][t] = true;
                                                }
                                            }
                                        }
                                        dfs(board, 0, 0);
                                    }

                                    public boolean dfs(char[][] board, int x, int y) {
                                        if (y == 9) {
                                            return dfs(board, x + 1, 0);
                                        }
                                        if (x == 9) {
                                            return true;
                                        }
                                        if (board[x][y] != '.') {
                                            return dfs(board, x, y + 1);
                                        }
                                        for (int i = 0; i < board[x].length; i++) {
                                            if (!row[x][i] && !col[y][i] && !cell[x / 3][y / 3][i]) {
                                                board[x][y] = (char)(i + '1');
                                                row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = true;
                                                if (dfs(board, x, y + 1)) {
                                                    break;
                                                } else {
                                                    board[x][y] = '.';
                                                    row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = false;
                                                }
                                            }

                                        }
                                        return board[x][y] != '.';
                                    }
                                }d[i][j] - '1';
                    row[i][t] = col[j][t] = cell[i / 3][j / 3][t] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }

    public boolean dfs(char[][] board, int x, int y) {
        if (y == 9) {
            return dfs(board, x + 1, 0);
        }
        if (x == 9) {
            return true;
        }
        if (board[x][y] != '.') {
            return dfs(board, x, y + 1);
        }
        for (int i = 0; i < board[x].length; i++) {
            if (!row[x][i] && !col[y][i] && !cell[x / 3][y / 3][i]) {
                board[x][y] = (char)(i + '1');
                row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = true;
                if (dfs(board, x, y + 1)) {
                    break;
                } else {
                    board[x][y] = '.';
                    row[x][i] = col[y][i] = cell[x / 3][y / 3][i] = false;
                }
            }

        }
        return board[x][y] != '.';
    }
}