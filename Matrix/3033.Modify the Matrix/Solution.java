class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] cols = new int[n];
        Arrays.fill(cols, -1);
        List<int[]> q = new ArrayList();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    q.add(new int[]{i, j});
                } else if (matrix[i][j] > cols[j]) {
                    cols[j] = matrix[i][j];
                }
            }
        }
        for (int[] e : q) {
            matrix[e[0]][e[1]] = cols[e[1]];
        }
        return matrix;
    }
}