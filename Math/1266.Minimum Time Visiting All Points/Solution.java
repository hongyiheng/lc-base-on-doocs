class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        int x = points[0][0], y = points[0][1];
        for (int[] p : points) {
            ans += Math.max(Math.abs(p[0] - x), Math.abs(p[1] - y));
            x = p[0];
            y = p[1];
        }
        return ans;
    }
}