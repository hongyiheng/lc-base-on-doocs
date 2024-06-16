class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        int n = points.length;
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = points[i][0];
        }
        Arrays.sort(q);
        int ans = 0, cur = -1;
        for (int v : q) {
            if (cur < v) {
                cur = v + w;
                ans++;
            }
        }
        return ans;
    }
}