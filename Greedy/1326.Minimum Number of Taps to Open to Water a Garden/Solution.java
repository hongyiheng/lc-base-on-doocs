class Solution {
    public int minTaps(int n, int[] ranges) {
        int M = n + 10;
        int[] rs = new int[M];
        for (int i = 0; i < ranges.length; i++) {
            int l = Math.max(0, i - ranges[i]), r = Math.min(n, i + ranges[i]);
            rs[l] = Math.max(rs[l], r);
        }
        int ans = 0, l = 0, r = 0;
        while (l < M && r < n) {
            if (r < l) {
                return -1;
            }
            int mx = r;
            for (int i = l; i <= r; i++) {
                mx = Math.max(mx, rs[i]);
            }
            l = r + 1;
            r = mx;
            ans++;
        }
        return ans;
    }
}
