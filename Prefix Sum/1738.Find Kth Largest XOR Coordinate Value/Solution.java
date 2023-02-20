class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] f = new int[m + 1][n + 1];
        List<Integer> q = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = matrix[i][j];
                if (i > 0) {
                    v ^= f[i - 1][j];
                }
                if (j > 0) {
                    v ^= f[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    v ^= f[i - 1][j - 1];
                }
                f[i][j] = v;
                q.add(v);
            }
        }
        Collections.sort(q, Comparator.reverseOrder());
        return q.get(k - 1);
    }
}
