class Solution {
    public long maxSpending(int[][] values) {
        int m = values.length, n = values[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < m; i++) {
            q.add(new int[]{values[i][n - 1], i, n - 1});
        }
        long ans = 0;
        for (int i = 0; i < m * n; i++) {
            int[] item = q.poll();
            int v = item[0], j = item[1], idx = item[2];
            ans += (long)(i + 1) * v;
            if (idx > 0) {
                q.add(new int[]{values[j][idx - 1], j, idx - 1});
            }
        }
        return ans;
    }
}