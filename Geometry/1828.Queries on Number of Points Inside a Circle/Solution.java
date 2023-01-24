class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = queries[i][0], y = queries[i][1], r = queries[i][2];
            for (int[] p : points) {
                int dx = Math.abs(x - p[0]), dy = Math.abs(y - p[1]);
                double d = Math.sqrt(dx * dx + dy * dy);
                if (d <= r) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}