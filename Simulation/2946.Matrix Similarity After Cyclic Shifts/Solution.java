class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        k %= n;
        if (k == 0) {
            return true;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int t = i % 2 == 0 ? (j - k + n) % n : (j + k) % n;
                if (mat[i][j] != mat[i][t]) {
                    return false;
                }
            }
        }
        return true;
    }
}