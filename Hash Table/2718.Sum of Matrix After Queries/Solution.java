class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        Set<Integer> row = new HashSet<>(), col = new HashSet<>();
        long ans = 0;
        for (int i = queries.length - 1; i > -1; i--) {
            int t = queries[i][0], idx = queries[i][1], val = queries[i][2];
            if (t == 0) {
                if (row.add(idx)) {
                    ans += 1L * val * (n - col.size());
                }
            } else {
                if (col.add(idx)) {
                    ans += 1L * val * (n - row.size());
                }
            }
        }
        return ans;
    }
}
