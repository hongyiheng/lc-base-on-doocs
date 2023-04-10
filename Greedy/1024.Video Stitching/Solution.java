class Solution {
    public int videoStitching(int[][] clips, int time) {
        int[] t = new int[110];
        for (int[] c : clips) {
            t[c[0]] = Math.max(t[c[0]], c[1]);
        }
        int ans = 1, cur = t[0];
        while (cur < time) {
            int mx = 0;
            for (int i = cur; i > -1; i--) {
                mx = Math.max(mx, t[i]);
            }
            if (mx == cur) {
                return -1;
            }
            cur = mx;
            ans++;
        }
        return cur >= time ? ans : -1;
    }
}