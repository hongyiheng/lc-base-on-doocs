class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int ans = 0, t = -1;
        for (int[] p : points) {
            int x = p[0];
            if (t < x) {
                t = x + w;
                ans++;
            }
        }
        return ans;
    }
}