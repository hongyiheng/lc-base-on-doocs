class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < m; i++) {
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();
            for (int j = 0; j < n; j++) {
                s1.append(matrix[i][j]);
                s2.append(matrix[i][j] ^ 1);
            }
            mp.put(s1.toString(), mp.getOrDefault(s1.toString(), 0) + 1);
            mp.put(s2.toString(), mp.getOrDefault(s2.toString(), 0) + 1);
        }
        int ans = 0;
        for (int v : mp.values()) {
            ans = Math.max(ans, v);
        }
        return ans;
    }
}
