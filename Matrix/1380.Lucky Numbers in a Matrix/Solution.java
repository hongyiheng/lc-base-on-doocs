class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] row = new int[m], col = new int[n];
        Arrays.fill(row, Integer.MAX_VALUE);
        Arrays.fill(col, Integer.MIN_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = Math.min(row[i], matrix[i][j]);
                col[j] = Math.max(col[j], matrix[i][j]);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int v : row) {
            set.add(v);
        }
        List<Integer> ans = new ArrayList<>();
        for (int v : col) {
            if (set.contains(v)) {
                ans.add(v);
            }
        }
        return ans;
    }
}