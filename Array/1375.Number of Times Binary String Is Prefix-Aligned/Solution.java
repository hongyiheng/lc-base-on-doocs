class Solution {
    public int numTimesAllBlue(int[] flips) {
        int ans = 0, mx = 0, n = flips.length;
        for (int i = 0; i < n; i++) {
            mx = Math.max(flips[i], mx);
            if (mx == i + 1) {
                ans++;
            }
        }
        return ans;
    }
}
