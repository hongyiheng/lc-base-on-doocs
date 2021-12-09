class Solution {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0;
        int oCount = 0;
        int[][] matrix = new int[3][3];
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char c = board[i].charAt(j);
                if (c == 'X') {
                    xCount++;
                    matrix[i][j] = 1;
                } else if (c == 'O') {
                    oCount++;
                    matrix[i][j] = 2;
                }
            }
        }
        if (oCount > xCount) {
            return false;
        }
        Set<Integer> win = getWin(matrix);
        if (win.contains(1) && win.contains(2)) {
            return false;
        } else if (win.contains(2)) {
            return xCount == oCount;
        } else if (win.contains(1)) {
            return xCount - oCount == 1;
        }
        return xCount - oCount <= 1;
    }

    public Set<Integer> getWin(int[][] matrix) {
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] == matrix[i][1] && matrix[i][0] == matrix[i][2]) {
                if (matrix[i][0] != 0) {
                    res.add(matrix[i][0]);
                }
            }
            if (matrix[0][i] == matrix[1][i] && matrix[0][i] == matrix[2][i]) {
                if (matrix[0][i] != 0) {
                    res.add(matrix[0][i]);
                }
            }
        }
        if (matrix[0][0] == matrix[1][1] && matrix[0][0] == matrix[2][2]) {
            if (matrix[0][0] != 0) {
                res.add(matrix[0][0]);
            }
        }
        if (matrix[0][2] == matrix[1][1] && matrix[0][2] == matrix[2][0]) {
            if (matrix[0][2] != 0) {
                res.add(matrix[0][2]);
            }
        }
        return res;
    }
}