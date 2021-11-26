class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] matrix = new int[8][8];
        for (int[] queen : queens) {
            matrix[queen[0]][queen[1]] = 1;
        }
        int[][] direct = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        for (int i = 0; i < direct.length; i++) {
            int x = king[0] + direct[i][0];
            int y = king[1] + direct[i][1];
            while (x >= 0 && y >= 0 && x < 8 && y < 8) {
                if (matrix[x][y] == 1) {
                    res.add(Arrays.asList(x, y));
                    x = 100;
                }
                x += direct[i][0];
                y += direct[i][1];
            }
        }
        return res;
    }


}