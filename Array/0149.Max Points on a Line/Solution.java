class Solution {
    public int maxPoints(int[][] points) {
        int ans = 1, n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double rate = getRate(points[i], points[j]);
                int cnt = 2;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    if (getRate(points[i], points[k]) == rate) {
                        cnt++;
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }

    public double getRate(int[] p1, int[] p2) {
        return p2[0] - p1[0] == 0 ? 0x3f3f3f3f : (double) (p2[1] - p1[1]) / (p2[0] - p1[0]);
    }
}
