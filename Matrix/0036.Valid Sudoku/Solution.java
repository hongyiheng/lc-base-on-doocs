class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][][] box = new int[3][3][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ('.' == board[i][j]) {
                    continue;
                }
                int v = board[i][j] - '0';
                if (row[i][v]++ > 0) {
                    return false;
                }
                if (col[j][v]++ > 0) {
                    return false;
                }
                if (box[i / 3][j / 3][v]++ > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}