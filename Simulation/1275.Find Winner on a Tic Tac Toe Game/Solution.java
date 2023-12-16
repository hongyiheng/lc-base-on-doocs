class Solution {
    public String tictactoe(int[][] moves) {
        String[][] g = new String[3][3];
        for (int i = 0; i < moves.length; i++) {
            int x = moves[i][0], y = moves[i][1];
            g[x][y] = i % 2 == 0 ? "A" : "B";
        }
        for (int i = 0; i < 3; i++) {
            if (g[i][0] != null && g[i][0] == g[i][1] && g[i][1] == g[i][2]) {
                return g[i][0];
            }
            if (g[0][i] != null && g[0][i] == g[1][i] && g[1][i] == g[2][i]) {
                return g[0][i];
            }
        }
        if (g[0][0] != null && g[0][0] == g[1][1] && g[1][1] == g[2][2]) {
            return g[0][0];
        }
        if (g[0][2] != null && g[0][2] == g[1][1] && g[1][1] == g[2][0]) {
            return g[0][2];
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}